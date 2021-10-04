package idv.heimlich.Kill.domain.service.impl;

import idv.heimlich.Kill.common.db.DBSessionManager;
import idv.heimlich.Kill.common.db.IDBSession;
import idv.heimlich.Kill.common.utils.YYYYMMDDHHMMSSUtils;
import idv.heimlich.Kill.domain.code.GetNumberType;
import idv.heimlich.Kill.domain.code.JobqueStatus;
import idv.heimlich.Kill.domain.dao.JobqueDAO;
import idv.heimlich.Kill.domain.dao.impl.JobqueDAOImpl;
import idv.heimlich.Kill.domain.dto.impl.JobqueDTO;
import idv.heimlich.Kill.domain.restful.response.QueryJobResponseVo;
import idv.heimlich.Kill.domain.service.GetNumberService;
import idv.heimlich.Kill.domain.service.JobService;

public class JobServiceImpl implements JobService {

	private transient JobqueDAO dao = JobqueDAOImpl.INSTANCE;
	private transient GetNumberService getNumberService = GetNumberServiceImpl.get();

	@Override
	public String sendNewJob(String jobid) {
		final IDBSession dbSession = DBSessionManager.getDBSession();
		final String transactionId = this.getNumberService.getCount(GetNumberType.YYYYMMDD12N);

		final JobqueDTO po = new JobqueDTO();
		po.setTranactionId(transactionId);
		po.setCreateTime(YYYYMMDDHHMMSSUtils.getText());
		po.setJobId(jobid);
		po.setMessage("");
		po.setStauts(JobqueStatus.W.name());
//		this.dao.insert(dbSession, po);
		return transactionId;
	}

	@Override
	public QueryJobResponseVo queryJob(String id) {
		final IDBSession dbseSession = DBSessionManager.getDBSession();
		final JobqueDTO jobqueDTO = this.dao.queryJobByTranactionId(dbseSession, id);
		final QueryJobResponseVo vo = new QueryJobResponseVo();
		if (jobqueDTO != null) {
			vo.setCreateTime(jobqueDTO.getCreateTime());
			vo.setExecuteTime(jobqueDTO.getExecuteTime());
			vo.setJobId(jobqueDTO.getJobId());
			vo.setMessage(jobqueDTO.getMessage());
			vo.setStauts(jobqueDTO.getStauts());
			vo.setTranactionId(jobqueDTO.getTranactionId());
		}
		return vo;
	}

}
