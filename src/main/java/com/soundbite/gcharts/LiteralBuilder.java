package com.soundbite.gcharts;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicates;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

public class LiteralBuilder {

	private List<Column> columns = Lists.newLinkedList();
	private List<Row> rows = Lists.newLinkedList();
    private Joiner commaJoiner = Joiner.on(",").skipNulls();

    private Function<Column, String> columnToStringFn = new Function<Column, String>() {
        @Override
        public String apply(Column column) {
            String col = "{type: '"+column.getType()+"'";
            if (column.hasLabel()) {
                return col+", label: '"+column.getLabel()+"'}";
            }
            return col+"}";
        }
    };

    private Function<Row, String> rowToStringFn = new Function<Row, String>() {
        @Override
        public String apply(Row row) {
            StringBuilder sb = new StringBuilder();
            sb.append("{c:[");

            sb.append(commaJoiner.join(
                    FluentIterable.from(row.getCells())
                            .filter(Predicates.notNull())
                            .transform(cellToStringFN)
            ));

            sb.append("]}");
            return sb.toString();
        }
    };

    private Function<Cell, String> cellToStringFN = new Function<Cell, String>() {
        @Override
        public String apply(Cell cell) {
            return "{v: "+cell.literalValue()+"}";
        }
    };

	/**
	 *
	 * @param type The data type of the values of the column.
	 * @return
	 */
	public LiteralBuilder addColumn(ColumnType type) {
		columns.add(new Column(type));
		return this;
	}

	/**
	 *
	 * @param type The data type of the values of the column.
	 * @param label A string with the label of the column. The column label is typically displayed as part of the visualization, for example as a column header in a table, or as a legend label in a pie chart. If no value is specified, an empty string is assigned.
	 * @return
	 */
	public LiteralBuilder addColumn(ColumnType type, String label) {
		columns.add(new Column(type, label));
		return this;
	}

	public LiteralBuilder addRow(Cell...cells ) {
		rows.add(new Row(Arrays.asList(cells)));
		return this;
	}

	/**
	 * Builds the data js literal.
	 * @return
	 */
	public String buildDataLiteral() {
		StringBuilder sb = new StringBuilder();

		// column definitions
		sb.append("{cols:[");

        sb.append(commaJoiner.join(
                FluentIterable.from(columns)
                        .filter(Predicates.notNull())
                        .transform(columnToStringFn)
        ));

		sb.append("], rows:[");

        sb.append(commaJoiner.join(
                FluentIterable.from(rows)
                        .filter(Predicates.notNull())
                        .transform(rowToStringFn)
        ));

		sb.append("]}");
		return sb.toString();
	}
}
