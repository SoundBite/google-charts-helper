package com.soundbite.gcharts.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface CellMixin<T> {
	@JsonProperty("v") T rawValue();
}
