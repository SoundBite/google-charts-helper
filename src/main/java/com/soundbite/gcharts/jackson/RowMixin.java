package com.soundbite.gcharts.jackson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.soundbite.gcharts.Cell;

interface RowMixin {
	@JsonProperty("c") List<Cell<?>> getCells();
}
