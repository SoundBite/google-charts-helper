package com.soundbite.gcharts;

import java.util.Date;

class DateCell extends Cell<Date> {

	private final Date date;

	DateCell(Date date) {
		this.date = date;
	}

	@Override
	String literalValue() {
		return "new Date("+date.getTime()+")";
	}

	@Override
	Date rawValue() {
		return date;
	}

}
