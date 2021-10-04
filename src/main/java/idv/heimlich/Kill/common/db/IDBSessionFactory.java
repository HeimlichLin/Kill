package idv.heimlich.Kill.common.db;

public interface IDBSessionFactory {

	IDBSession getXdaoSession(String conn);

}
