package com.soundbite.gcharts.jackson;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.soundbite.gcharts.Cell;
import com.soundbite.gcharts.Chart;
import com.soundbite.gcharts.Column;
import com.soundbite.gcharts.ColumnType;
import com.soundbite.gcharts.Row;

public class GChartsModule extends SimpleModule {

	private static final long serialVersionUID = 1L;

	public GChartsModule() {
		super("GChartsModule", new Version(0, 0, 1, null, "com.soundbite", "google-charts-helper"));
	}

	public void setupModule(SetupContext context) {
		context.setMixInAnnotations(Chart.class, ChartMixin.class);
		context.setMixInAnnotations(Column.class, ColumnMixin.class);
		context.setMixInAnnotations(ColumnType.class, ColumnTypeMixin.class);
		context.setMixInAnnotations(Row.class, RowMixin.class);
		context.setMixInAnnotations(Cell.class, CellMixin.class);
	}
}
