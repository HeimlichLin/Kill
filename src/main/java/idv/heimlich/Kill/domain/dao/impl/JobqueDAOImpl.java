package idv.heimlich.Kill.domain.dao.impl;

import java.util.List;

import idv.heimlich.Kill.common.dao.GeneralDAOImpl;
import idv.heimlich.Kill.common.dao.IConverter;
import idv.heimlich.Kill.common.dao.RowMap;
import idv.heimlich.Kill.common.db.IDBSession;
import idv.heimlich.Kill.common.db.sql.SqlWhere;
import idv.heimlich.Kill.domain.code.JobqueStatus;
import idv.heimlich.Kill.domain.dao.JobqueDAO;
import idv.heimlich.Kill.domain.dto.impl.JobqueDTO;

//Job隊伍
public class JobqueDAOImpl extends GeneralDAOImpl<JobqueDTO> implements JobqueDAO {

	public static final JobqueDAOImpl INSTANCE = new JobqueDAOImpl();

	protected static final String TABLE = "JOBQUE";

	public JobqueDAOImpl() {
		super(TABLE);
	}

	@Override
	public IConverter<JobqueDTO> getConverter() {
		return JobqueDTO.CONVERTER;
	}

	@Override
	public SqlWhere getPkSqlWhere(JobqueDTO po) {
		final SqlWhere sqlWhere = new SqlWhere();
		sqlWhere.add(JobqueDTO.COLUMNS.TRANACTION_ID.name(), po.getTranactionId());
		return sqlWhere;
	}

	@Override
	public List<JobqueDTO> quertyByStatus(IDBSession dbSession, JobqueStatus jobqueStatus) {
//		final SqlWhere sqlWhere = new SqlWhere();
//		sqlWhere.add(JobqueDTO.COLUMNS.STAUTS.name(), jobqueStatus.name());
//
//		final SelectBuilder selectBuilder = new SelectBuilder();
//		selectBuilder.from(TABLE).where(sqlWhere).orderBy(JobqueDTO.COLUMNS.CREATE_TIME.name());
//		return selectBuilder.list(JobqueDTO.CONVERTER, doXdaoSession);
		return null;
	}

	@Override
	public void updateStatus(IDBSession dbSession, String tranactionId, JobqueStatus jobqueStatus) {
//		final SqlWhere sqlWhere = new SqlWhere();
//		sqlWhere.add(JobqueDTO.COLUMNS.TRANACTION_ID.name(), tranactionId);
//
//		final UpdateBuilder builder = new UpdateBuilder(TABLE);
//		builder.set(JobqueDTO.COLUMNS.STAUTS.name(), jobqueStatus.name());
//		builder.set(JobqueDTO.COLUMNS.EXECUTE_TIME.name(), YYYYMMDDHHMMSSUtils.getText());
//		builder.where(sqlWhere);
//
//		builder.update(doXdaoSession);
	}

	@Override
	public JobqueDTO queryJobByTranactionId(IDBSession dbSession, String tranactionId) {
//		final SqlWhere sqlWhere = new SqlWhere();
//		sqlWhere.add(JobqueDTO.COLUMNS.TRANACTION_ID.name(), tranactionId);
//		final SelectBuilder selectBuilder = new SelectBuilder();
//		selectBuilder.from(TABLE).where(sqlWhere).orderBy(JobqueDTO.COLUMNS.CREATE_TIME.name());
//		final List<JobqueDTO> jobs = selectBuilder.list(JobqueDTO.CONVERTER, doXdaoSession);
//		if (CollectionUtils.isNotEmpty(jobs)) {
//			return jobs.get(0);
//		}
		return null;

	}

	@Override
	public void update(IDBSession dbSession, String tranactionId, RowMap rowMap) {
//		final SqlWhere sqlWhere = new SqlWhere();
//		sqlWhere.add(JobqueDTO.COLUMNS.TRANACTION_ID.name(), tranactionId);
//
//		try {
//			dbSession.update(TABLE, rowMap, sqlWhere);
//		} catch (final XdaoException e) {
//			e.printStackTrace();
//		}
	}

}
