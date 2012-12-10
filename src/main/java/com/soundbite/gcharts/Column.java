package com.soundbite.gcharts;

import org.apache.commons.lang.StringEscapeUtils;

import com.google.common.base.Strings;

/**
 * A DataTable column.
 * @author austin
 *
 */
class Column {
	private final ColumnType type;
	private final String label;
	
	public Column(ColumnType type) {
		this.type = type;
		this.label = "";
	}
	
	public Column(ColumnType type, String label) {
		this.type = type;
		this.label = label;
	}

	public ColumnType getType() {
		return type;
	}

	/**
	 * Javascript-escaped
	 * @return
	 */
	public String getLabel() {
		return StringEscapeUtils.escapeJavaScript(label);
	}

	public boolean hasLabel() {
		return !Strings.isNullOrEmpty(label);
	}

	
}
