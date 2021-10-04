package idv.heimlich.Kill.domain.dao;

import java.util.List;

import idv.heimlich.Kill.common.dao.RowMap;
import idv.heimlich.Kill.common.db.IDBSession;
import idv.heimlich.Kill.domain.code.JobqueStatus;
import idv.heimlich.Kill.domain.dto.impl.JobqueDTO;

public interface JobqueDAO {

	/**
	 * 取得清單透過狀態
	 * 
	 * @param jobqueStatus
	 * @return
	 */
	public List<JobqueDTO> quertyByStatus(IDBSession dbSession, JobqueStatus jobqueStatus);

	/**
	 * 更新狀態
	 * 
	 * @param tranactionId
	 * @param jobqueStatus
	 * @return
	 */
	public void updateStatus(IDBSession dbSession, String tranactionId, JobqueStatus jobqueStatus);

	/**
	 * 取得Job 狀態
	 * 
	 * @param tranactionId
	 * @return
	 */
	public JobqueDTO queryJobByTranactionId(IDBSession dbSession, String tranactionId);

	/**
	 * 更新狀態
	 * 
	 * @param tranactionId
	 * @param jobqueStatus
	 * @return
	 */
	public void update(IDBSession dbSession, String tranactionId, RowMap dataObject);

}
