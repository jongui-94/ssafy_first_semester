package com.ssafy.school.subject;

public class Database extends Subject {
	public String databaseName;

	public Database() {}
	
	public Database(String name, int level, String databaseName) {
		super(name, level);
		setDatabaseName(databaseName);
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	@Override
	public String toString() {
		return "Database [databaseName=" + databaseName + "]";
	}
}