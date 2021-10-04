package idv.heimlich.Kill.domain.service.impl;

import java.math.BigDecimal;

import idv.heimlich.Kill.common.db.DBSessionManager;
import idv.heimlich.Kill.common.db.IDBSession;
import idv.heimlich.Kill.domain.code.GetNumberType;
import idv.heimlich.Kill.domain.dao.GetNumberDAO;
import idv.heimlich.Kill.domain.dao.impl.GetNumberDAOImpl;
import idv.heimlich.Kill.domain.service.GetNumberService;

/**
 * 取號服務
 */
public class GetNumberServiceImpl implements GetNumberService {

	private static GetNumberService INSTANCT = new GetNumberServiceImpl();

	private final GetNumberDAO getNumberDAO = GetNumberDAOImpl.INSTANCE;

	protected GetNumberServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public static GetNumberService get() {
		return INSTANCT;
	}

	@Override
	public String getCount(final GetNumberType getNumberType, final String... codes) {
		final String[] codesArray = getNumberType.codes(codes);
		final IDBSession dbSession = DBSessionManager.getDBSession();
		final BigDecimal bigDecimal = this.getNumberDAO.getSerialNo(dbSession, getNumberType.name(), codesArray);
		return getNumberType.getId(codesArray[0], codesArray[1], codesArray[2], bigDecimal);
	}

}
