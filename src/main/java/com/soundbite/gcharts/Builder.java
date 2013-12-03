package com.soundbite.gcharts;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicates;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

public class Builder {

	private final static Joiner commaJoiner = Joiner.on(",").skipNulls();

	private final List<Column> columns = Lists.newLinkedList();
	private final List<Row> rows = Lists.newLinkedList();

    private final static Function<Column, String> columnToStringFn = new Function<Column, String>() {
        @Override
        public String apply(Column column) {
            String col = "{type: '"+column.getType()+"'";
            if (column.hasLabel()) {
                return col+", label: '"+column.getLabel()+"'}";
            }
            return col+"}";
        }
    };

    private final static Function<Row, String> rowToStringFn = new Function<Row, String>() {
        @Override
        public String apply(Row row) {
            StringBuilder sb = new StringBuilder();
            sb.append("{c:[");

            commaJoiner.appendTo(sb,
                    FluentIterable.from(row.getCells())
                            .filter(Predicates.notNull())
                            .transform(cellToStringFN)
            );

            sb.append("]}");
            return sb.toString();
        }
    };

    private final static Function<Cell<?>, String> cellToStringFN = new Function<Cell<?>, String>() {
        @Override
        public String apply(Cell<?> cell) {
            return "{v: "+cell.literalValue()+"}";
        }
    };

	/**
	 *
	 * @param type The data type of the values of the column.
	 * @return
	 */
	public Builder addColumn(ColumnType type) {
		columns.add(new Column(type));
		return this;
	}

	/**
	 *
	 * @param type The data type of the values of the column.
	 * @param label A string with the label of the column. The column label is typically displayed as part of the visualization, for example as a column header in a table, or as a legend label in a pie chart. If no value is specified, an empty string is assigned.
	 * @return
	 */
	public Builder addColumn(ColumnType type, String label) {
		columns.add(new Column(type, label));
		return this;
	}

	public Builder addRow(Cell<?>...cells ) {
		rows.add(new Row(Arrays.asList(cells)));
		return this;
	}

	/**
	 * Builds the data js literal.
	 * @return
	 * @throws IOException 
	 */
	public String build() throws IOException {
		StringWriter writer = new StringWriter();
		build(writer);
		return writer.toString();
	}

	public void build(Writer out) throws IOException {
		// column definitions
		out.append("{cols:[");

		commaJoiner.appendTo(out,
			FluentIterable.from(columns)
				.transform(columnToStringFn)
        );

		out.append("], rows:[");

		commaJoiner.appendTo(out,
			FluentIterable.from(rows)
				.transform(rowToStringFn)
        );

		out.append("]}");
	}

	public Chart buildChart() {
		return new Chart(columns, rows);
	}
}
