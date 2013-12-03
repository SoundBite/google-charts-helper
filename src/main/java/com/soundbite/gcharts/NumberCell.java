package com.soundbite.gcharts;

public class NumberCell extends Cell<Number> {

	private final Number num;
	
	public NumberCell(Number num) {
		this.num = num;
	}

	@Override
	String literalValue() {
		return Float.toString(num.floatValue());
	}

	@Override
	Number rawValue() {
		return num;
	}

}
