package idv.heimlich.Kill.domain.service.impl;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import idv.heimlich.Kill.common.dao.RowMap;
import idv.heimlich.Kill.common.db.DBSessionManager;
import idv.heimlich.Kill.common.db.IDBSession;
import idv.heimlich.Kill.common.exception.ApBusinessException;
import idv.heimlich.Kill.common.utils.YYYYMMDDHHMMSSUtils;
import idv.heimlich.Kill.domain.bean.SyscodeDo;
import idv.heimlich.Kill.domain.cmd.JobCmd;
import idv.heimlich.Kill.domain.code.JobComs;
import idv.heimlich.Kill.domain.code.JobqueStatus;
import idv.heimlich.Kill.domain.dao.JobqueDAO;
import idv.heimlich.Kill.domain.dao.impl.JobqueDAOImpl;
import idv.heimlich.Kill.domain.dto.impl.JobqueDTO;
import idv.heimlich.Kill.domain.dto.impl.MailCreateDTO;
import idv.heimlich.Kill.domain.job.AbstactJob;
import idv.heimlich.Kill.domain.service.JobCmdService;
import idv.heimlich.Kill.domain.service.MailService;

/**
 * JOB CMD 服務
 */
public class JobCmdServiceImpl implements JobCmdService {

//	final Logger LOGGER = MyLoggerFactory.getLogger(Mylogs.clJobCmd);

	private final static JobCmdService INSTANCT = new JobCmdServiceImpl();

	private final JobqueDAO jobqueDAO = JobqueDAOImpl.INSTANCE;
	private final Map<String, Class<? extends AbstactJob>> jobMap = new HashMap<String, Class<? extends AbstactJob>>();
	private final MailService mailService = MailServiceImpl.get();

	public JobCmdServiceImpl() {

		final EnumSet<JobComs> JobComs = EnumSet.allOf(JobComs.class);
		for (final JobComs cmd : JobComs) {
			this.jobMap.put(cmd.name(), cmd.getJobClass());
		}
	}

	public static JobCmdService get() {
		return INSTANCT;
	}

	@Override
	public void cmd() {
		// 取得待處理JOB
		final IDBSession dbSession = DBSessionManager.getDBSession();
		final List<JobqueDTO> jobqueDTOs = this.jobqueDAO.quertyByStatus(dbSession, JobqueStatus.W);
//		this.LOGGER.info("wait to do job num:" + jobquePos.size());
		for (final JobqueDTO jobqueDTO : jobqueDTOs) {
			this.execute(jobqueDTO);
		}
	}

	//
	private void execute(final JobqueDTO jobqueDTO) {
		final IDBSession dbSession = DBSessionManager.getDBSession();
		AbstactJob job = null;
		try {
			jobqueDTO.setExecuteTime(YYYYMMDDHHMMSSUtils.getText());
			jobqueDTO.setMessage("");
			job = this.newJob(jobqueDTO.getJobId());
			job.setTransactionId(jobqueDTO.getTranactionId());

			job.execute();
			jobqueDTO.setStauts(JobqueStatus.S.name());
			jobqueDTO.setMessage(job.getMessage());
		} catch (final Exception e) {
			jobqueDTO.setStauts(JobqueStatus.E.name());
//			this.LOGGER.error("execute error:" + jobqueDTO, e);

		} finally {
			final RowMap rowMap = new RowMap();
			rowMap.setValue(JobqueDTO.COLUMNS.STAUTS.name(), jobqueDTO.getStauts());
			rowMap.setValue(JobqueDTO.COLUMNS.EXECUTE_TIME.name(), jobqueDTO.getExecuteTime());
			this.jobqueDAO.update(dbSession, jobqueDTO.getTranactionId(), rowMap);

			final MailCreateDTO mailCreateDTO = new MailCreateDTO();
			mailCreateDTO.setMailBcc(null);
			mailCreateDTO.setMailCc(null);
			mailCreateDTO.setMailTo(this.to());
			mailCreateDTO.setSubject("訊息通知 (" + jobqueDTO.getJobId() + ") ");
			mailCreateDTO.setMessage(this.getMailMessage(jobqueDTO));
			mailCreateDTO.setPgmId(JobCmd.class.getSimpleName());
			if (job != null) {
				mailCreateDTO.setFilePath(job.getFiles());
			}
			this.mailService.create(mailCreateDTO);

		}
	}

	private String getMailMessage(final JobqueDTO jobqueDTO) {
		final StringBuffer mailContext = new StringBuffer();
		mailContext.append("交易序號：{TRANACTION_ID}\n");
		mailContext.append("程式：{JOB_ID}\n");
		mailContext.append("建立日期：{CREATE_TIME}\n");
		mailContext.append("執行時間：{EXECUTE_TIME}\n");
		mailContext.append("狀態：{STAUTS}\n");
		mailContext.append("訊息：{MESSAGE}\n");
		return mailContext.toString().//
				replaceFirst("\\{TRANACTION_ID\\}", jobqueDTO.getTranactionId()).//
				replaceFirst("\\{JOB_ID\\}", jobqueDTO.getJobId()).//
				replaceFirst("\\{CREATE_TIME\\}", jobqueDTO.getCreateTime()).//
				replaceFirst("\\{EXECUTE_TIME\\}", jobqueDTO.getExecuteTime()).//
				replaceFirst("\\{STAUTS\\}", jobqueDTO.getStauts()).//
				replaceFirst("\\{MESSAGE\\}", jobqueDTO.getMessage())//
		;
	}

	public String to() {
//		final DoSqlWhere<SyscodeDo.COLUMNS> sqlWhere = new DoSqlWhere<SyscodeDo.COLUMNS>();
//		sqlWhere.add(SyscodeDo.COLUMNS.TYPE_ID, "MAIL");
//		sqlWhere.add(SyscodeDo.COLUMNS.CODE_ID, "A010");
//
//		final IDBSession dbSession = DBSessionManager.getDBSession();
//		final List<SyscodeDo> syscodeDos = dbSession.selectPo(SyscodeDo.class, sqlWhere);
//		return this.syscodes2String(syscodeDos);
		return null;
	}

	private String syscodes2String(final List<SyscodeDo> syscodeDos) {
		final List<String> list = new ArrayList<String>();
		for (final SyscodeDo syscodeDo : syscodeDos) {
			list.add(syscodeDo.getCodeData2());
		}
		final String mailsString = StringUtils.join(list, ",");
		return mailsString;
	}

	public AbstactJob newJob(final String jobid) {
		if (this.jobMap.containsKey(jobid)) {
			try {
				final AbstactJob job = this.jobMap.get(jobid).newInstance();
				return job;
			} catch (final Exception e) {
//				this.LOGGER.error("newJob error:" + jobid, e);
			}

		}
		throw new ApBusinessException("the jobid:" + jobid + " does not exist");
	}

}
