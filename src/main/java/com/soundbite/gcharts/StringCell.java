package com.soundbite.gcharts;

import org.apache.commons.lang.StringEscapeUtils;

class StringCell extends Cell<String> {

	private final String value;

	public StringCell(String value) {
		this.value = value;
	}

	@Override
	String literalValue() {
		return "'"+StringEscapeUtils.escapeJavaScript(value)+"'";
	}

	@Override
	String rawValue() {
		return value;
	}

}
