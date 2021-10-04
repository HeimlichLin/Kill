package idv.heimlich.Kill.domain.dao.impl;

import java.math.BigDecimal;

import idv.heimlich.Kill.common.dao.GeneralDAOImpl;
import idv.heimlich.Kill.common.dao.IConverter;
import idv.heimlich.Kill.common.db.IDBSession;
import idv.heimlich.Kill.common.db.sql.SqlWhere;
import idv.heimlich.Kill.domain.dao.GetNumberDAO;
import idv.heimlich.Kill.domain.dto.impl.GetNumberDTO;

//取號檔案
public class GetNumberDAOImpl extends GeneralDAOImpl<GetNumberDTO> implements GetNumberDAO {

	public static final GetNumberDAOImpl INSTANCE = new GetNumberDAOImpl();

	private static final Byte[] LOCK = new Byte[] {};

	public GetNumberDAOImpl() {
		super("GET_NUMBER");
	}

	@Override
	public IConverter<GetNumberDTO> getConverter() {
		return GetNumberDTO.CONVERTER;
	}

	@Override
	public SqlWhere getPkSqlWhere(final GetNumberDTO po) {
		final SqlWhere sqlWhere = new SqlWhere();
		sqlWhere.add(GetNumberDTO.COLUMNS.PGM_ID.name(), po.getPgmId());
		sqlWhere.add(GetNumberDTO.COLUMNS.SYSCODE1.name(), po.getSyscode1());
		sqlWhere.add(GetNumberDTO.COLUMNS.SYSCODE2.name(), po.getSyscode2());
		sqlWhere.add(GetNumberDTO.COLUMNS.SYSCODE3.name(), po.getSyscode3());
		return sqlWhere;
	}

	@Override
	public BigDecimal getSerialNo(final IDBSession dbSession, final String pgmId, final String... syscode) {
//		if (syscode.length < 3) {
//			throw new IllegalArgumentException("syscode argum must equal 3 ");
//		}
//
//		synchronized (LOCK) {
//
//			final String sys1 = StringUtils.defaultString(syscode[0], "N");
//			final String sys2 = StringUtils.defaultString(syscode[1], "N");
//			final String sys3 = StringUtils.defaultString(syscode[2], "N");
//
//			final SqlWhere sqlWhere = new SqlWhere();
//			sqlWhere.add(GetNumberDTO.COLUMNS.PGM_ID.name(), pgmId);
//			sqlWhere.add(GetNumberDTO.COLUMNS.SYSCODE1.name(), sys1);
//			sqlWhere.add(GetNumberDTO.COLUMNS.SYSCODE2.name(), sys2);
//			sqlWhere.add(GetNumberDTO.COLUMNS.SYSCODE3.name(), sys3);
//
//			BigDecimal count = BigDecimal.ONE;
//			final List<GetNumberDTO> getNumberPos = dbSession.selectPo(GetNumberDTO.class, sqlWhere);
//			if (CollectionUtils.isEmpty(getNumberPos)) {
//				final GetNumberDTO insertPo = new GetNumberDTO();
//				insertPo.setCount(count);
//				insertPo.setPgmId(pgmId);
//				insertPo.setSyscode1(sys1);
//				insertPo.setSyscode2(sys2);
//				insertPo.setSyscode3(sys3);
//				dbSession.insertPo(insertPo);
//			} else {
//				count = getNumberPos.get(0).getCount().add(BigDecimal.ONE);
//				final RowMap modfyObj = new RowMap();
//				modfyObj.setValue(GetNumberDTO.COLUMNS.COUNT.name(), count);
//
//				try {
//					dbSession.update("GET_NUMBER", modfyObj, sqlWhere);
//				} catch (final XdaoException e) {
//					throw new ApBusinessException("更新異常  modfiy obj:" + modfyObj, e);
//				}
//			}
//			return count;
//		}
		return null;
	}

}
