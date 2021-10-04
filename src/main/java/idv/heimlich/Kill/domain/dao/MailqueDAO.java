package idv.heimlich.Kill.domain.dao;

import java.util.List;

import idv.heimlich.Kill.common.db.IDBSession;
import idv.heimlich.Kill.domain.code.MailqueStatus;
import idv.heimlich.Kill.domain.dto.impl.MailqueDTO;

public interface MailqueDAO {

	/**
	 * 取得袋寄信信件資訊
	 * 
	 * @return
	 */
	public List<MailqueDTO> queryMails(IDBSession dbSession);

	/**
	 * 更新信件狀態
	 * 
	 * @param id
	 * @param status
	 */
	public void update(IDBSession dbSession, String id, MailqueStatus status);

}
