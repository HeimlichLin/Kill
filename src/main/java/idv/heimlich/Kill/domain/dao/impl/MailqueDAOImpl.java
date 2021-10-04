package idv.heimlich.Kill.domain.dao.impl;

import java.util.List;

import idv.heimlich.Kill.common.dao.GeneralDAOImpl;
import idv.heimlich.Kill.common.dao.IConverter;
import idv.heimlich.Kill.common.db.IDBSession;
import idv.heimlich.Kill.common.db.sql.SqlWhere;
import idv.heimlich.Kill.domain.code.MailqueStatus;
import idv.heimlich.Kill.domain.dao.MailqueDAO;
import idv.heimlich.Kill.domain.dto.impl.MailqueDTO;

//系統Mail傳送記錄
public class MailqueDAOImpl extends GeneralDAOImpl<MailqueDTO> implements MailqueDAO {

	public static final MailqueDAOImpl INSTANCE = new MailqueDAOImpl();

	public MailqueDAOImpl() {
		super("MAILQUE");
	}

	@Override
	public IConverter<MailqueDTO> getConverter() {
		return MailqueDTO.CONVERTER;
	}

	@Override
	public SqlWhere getPkSqlWhere(final MailqueDTO po) {
		final SqlWhere sqlWhere = new SqlWhere();
		sqlWhere.add(MailqueDTO.COLUMNS.MAIL_ID.name(), po.getPgmId());
		return sqlWhere;
	}

	@Override
	public List<MailqueDTO> queryMails(final IDBSession dbSession) {

//		final SqlWhere sqlWhere = new SqlWhere(SqlWhere.OR);
//		sqlWhere.add(MailqueDTO.COLUMNS.STATUS.name(), MailqueStatus.W.name());
//		sqlWhere.add(MailqueDTO.COLUMNS.STATUS.name(), MailqueStatus.R.name());
//		return dbSession.selectPo(MailqueDTO.class, sqlWhere);
		return null;
	}

	@Override
	public void update(final IDBSession dbSession, final String id, final MailqueStatus status) {
//		final DoSqlWhere<MailquePo.COLUMNS> sqlWhere = new DoSqlWhere<>();
//		sqlWhere.add(MailquePo.COLUMNS.MAIL_ID, id);
//		final DataObject dataObject = new DataObject();
//		dataObject.setValue(MailquePo.COLUMNS.STATUS.name(), status.name());
//		dataObject.setValue(MailquePo.COLUMNS.SEND_DATE.name(), YYYYMMDDHHMMSSUtils.getText());
//		try {
//			final int updateCnt = xdaoSession.update("Mailque", dataObject, sqlWhere);
//			if (updateCnt == 0) {
//			}
//		} catch (final XdaoException e) {
//		}
	}

}
