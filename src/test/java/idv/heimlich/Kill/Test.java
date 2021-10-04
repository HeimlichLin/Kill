package idv.heimlich.Kill;

import org.slf4j.Logger;

import idv.heimlich.Kill.common.db.IDBSession;
import idv.heimlich.Kill.common.db.IDBSessionFactory;
import idv.heimlich.Kill.common.db.impl.DBSessionFactoryImpl;
import idv.heimlich.Kill.common.log.LogFactory;

public class Test {
	
	private static Logger LOGGER = LogFactory.getInstance();
	
	public static void main(String[] args) {
		LOGGER.debug("Test Start");
		IDBSessionFactory sessionFactory = new DBSessionFactoryImpl();
		IDBSession session = sessionFactory.getXdaoSession("");
		
	}

}
