package idv.heimlich.Kill.common.dao;

import java.util.List;

import idv.heimlich.Kill.common.db.IDBSession;
import idv.heimlich.Kill.common.db.sql.SqlWhere;

public interface GeneralDAO<PO> {

	int insert(IDBSession var1, PO var2);

	int delete(IDBSession var1, PO var2);

	int update(IDBSession var1, PO var2);

	List<PO> select(IDBSession var1, SqlWhere var2);

	List<PO> select(IConverter<PO> var1, IDBSession var2, SqlWhere var3);

	int delete(IDBSession var1, SqlWhere var2);

	void saveOrUpdate(IDBSession var1, PO var2);

	List<PO> select(IDBSession var1, PO var2);

}
