package com.soundbite.gcharts;

import java.util.Date;

/**
 * DataTable Row Cell. Various types of cells are create via the static contructor Cell.of(...)
 * @author austin
 *
 */
public abstract class Cell {
	
	public static Cell of(String value) {
		return new StringCell(value);
	}
	
	public static Cell of(Date date) {
		return new DateCell(date);
	}
	
	public static Cell of(Number num) {
		return new NumberCell(num);
	}

	abstract String literalValue();
}
