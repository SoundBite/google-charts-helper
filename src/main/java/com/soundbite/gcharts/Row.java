package com.soundbite.gcharts;

import java.util.List;

/**
 * DataTable row
 * @author austin
 *
 */
class Row {

	final List<Cell> cells;
	
	public Row(List<Cell> cells) {
		this.cells = cells;
	}
	
	public List<Cell> getCells() {
		return cells;
	}
}
