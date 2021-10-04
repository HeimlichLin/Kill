package idv.heimlich.Kill.domain.dao;

import java.math.BigDecimal;

import idv.heimlich.Kill.common.db.IDBSession;

public interface GetNumberDAO {

	public BigDecimal getSerialNo(IDBSession dbSession, String pgmId, String... syscode);

}
