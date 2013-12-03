package com.soundbite.gcharts.jackson;

import com.fasterxml.jackson.annotation.JsonValue;

public interface ColumnTypeMixin {
	@JsonValue String getValue();
}
