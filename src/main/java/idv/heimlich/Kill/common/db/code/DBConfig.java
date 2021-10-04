package idv.heimlich.Kill.common.db.code;

import idv.heimlich.Kill.common.db.AbstractDBSessionManager;
import idv.heimlich.Kill.common.db.DBSessionFTZBManager;
import idv.heimlich.Kill.common.db.DBSessionManager;
import idv.heimlich.Kill.common.db.IDBSession;


public enum DBConfig {
	
	PFTZBPool {
		@Override
		public AbstractDBSessionManager getDBSessionManager() {
			return new DBSessionFTZBManager();
		}
		
	},
	PCLMSPool {
		@Override
		public AbstractDBSessionManager getDBSessionManager() {
			return new DBSessionManager();
		}
	
	},

	;
	final String connid;

	private DBConfig() {
		this.connid = name();
	}

	 public abstract AbstractDBSessionManager getDBSessionManager();
	 
	 public IDBSession getXdaoSession(){
		 return this.getDBSessionManager().getDBSession();
	 }

}
