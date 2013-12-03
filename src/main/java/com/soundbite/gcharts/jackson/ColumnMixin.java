package com.soundbite.gcharts.jackson;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.soundbite.gcharts.ColumnType;

public interface ColumnMixin {
	@JsonProperty("type") ColumnType getType();
	@JsonProperty("label") String getRawLabel();
	@JsonIgnore String getLabel();
}
