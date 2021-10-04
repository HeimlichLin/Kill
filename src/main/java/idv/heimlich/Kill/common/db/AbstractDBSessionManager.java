package idv.heimlich.Kill.common.db;

import idv.heimlich.Kill.common.db.impl.DBSessionImpl;

public abstract class AbstractDBSessionManager {

	private static IDBSession dbSession;

	public static IDBSession getDBSession() {
		if (dbSession == null) {
			dbSession = new DBSessionImpl();
		}
		return dbSession;
	}

	protected abstract String getConnId();

}
