package com.soundbite.gcharts;

public enum ColumnType {
	STRING("string"),
	NUMBER("number"),
	DATE("date");
	// TODO
	//	BOOLEAN("boolean"),
	//	DATE_TIME("datetime"),
	//	TIME_OF_DAY("timeofday");

	private final String string_value;

	private ColumnType(String s) {
		string_value = s;
	}

	@Override
	public String toString() {
		return string_value;
	}
}
