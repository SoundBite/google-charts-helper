package com.soundbite.gcharts;

class StringCell extends Cell {

	private final String value;
	
	public StringCell(String value) {
		this.value = value;
	}

	@Override
	String literalValue() {
		return "'"+value+"'";
	}

}
