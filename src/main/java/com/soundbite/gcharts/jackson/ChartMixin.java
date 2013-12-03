package com.soundbite.gcharts.jackson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.soundbite.gcharts.Column;
import com.soundbite.gcharts.Row;

public interface ChartMixin {
	@JsonProperty("cols") List<Column> getCols();
	@JsonProperty("rows") List<Row> getRows();
}
