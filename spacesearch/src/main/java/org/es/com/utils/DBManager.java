package org.es.com.utils;//package com.kxtx.util;
//
//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientOptions;
//import com.mongodb.MongoClientOptions.Builder;
//import com.mongodb.DB;
//import com.mongodb.ReadPreference;
//import com.mongodb.ServerAddress;
//import com.mongodb.WriteConcern;
//
//public class DBManager {
//	
//	private static final String MONGO_IP = "127.0.0.1";
//
//	private static final int port = 30000;
//
//	private static final int DEFAULT_POOLSIZE = 3000;
//
//
//	public static DBManager getInstance() {
//		return InnerHolder.INSTANCE;
//	}
//
//	/**
//	 * Creates a new <code>DBManager</code> instance.
//	 * 
//	 */
//	private DBManager() {
//
//	}
//
//	private static class InnerHolder {
//		static final DBManager INSTANCE = new DBManager();
//	}
//
//	public DB getDB(String dbName) {
//		return mongo.getDB(dbName);
//	}
//
//	private MongoClient mongo;
//
//	public void init() throws java.net.UnknownHostException {
//		System.setProperty("MONGO.POOLSIZE", String.valueOf(DEFAULT_POOLSIZE));
//		if (mongo == null) {
//			Builder builder = MongoClientOptions.builder();
//			builder.socketKeepAlive(true);
//			builder.writeConcern(WriteConcern.ERRORS_IGNORED);
//			builder.connectionsPerHost(DEFAULT_POOLSIZE);
//			builder.threadsAllowedToBlockForConnectionMultiplier(5);
//			builder.readPreference(ReadPreference.SECONDARY);
//			mongo = new MongoClient(new ServerAddress(MONGO_IP, port), builder.build());
//		}
//	}
//	
//	
//}
