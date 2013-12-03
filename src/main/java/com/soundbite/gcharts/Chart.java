package com.soundbite.gcharts;

import java.util.List;

public class Chart {

	public final List<Column> cols;
	public final List<Row> rows;

	public Chart( List<Column> cols, List<Row> rows) {
		this.rows = rows;
		this.cols = cols;
	}

	public List<Column> getCols() {
		return cols;
	}
	
	public List<Row> getRows() {
		return rows;
	}
}
