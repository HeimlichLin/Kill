package idv.heimlich.Kill.common.dao;

import java.util.List;

import idv.heimlich.Kill.common.db.IDBSession;
import idv.heimlich.Kill.common.db.sql.SqlWhere;

public abstract class GeneralDAOImpl<PO> implements GeneralDAO<PO> {

	final String tableName;

	public GeneralDAOImpl(String tableName) {
		this.tableName = tableName;
	}

	public abstract IConverter<PO> getConverter();

	public abstract SqlWhere getPkSqlWhere(PO arg0);

	public final RowMap getRowMap(PO po) {
		return this.getConverter().toRowMap(po);
	}

	public String getTableName() {
		return this.tableName;
	}

	@Override
	public int insert(IDBSession var1, PO var2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(IDBSession var1, PO var2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(IDBSession var1, PO var2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PO> select(IDBSession var1, SqlWhere var2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PO> select(IConverter<PO> var1, IDBSession var2, SqlWhere var3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(IDBSession var1, SqlWhere var2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void saveOrUpdate(IDBSession var1, PO var2) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PO> select(IDBSession var1, PO var2) {
		// TODO Auto-generated method stub
		return null;
	}

}
