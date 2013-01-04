google-charts-helper
====================

A Java library for generating JavaScript literal strings to be used for populating Google charts wtih data.

Syntax is described <a href="https://developers.google.com/chart/interactive/docs/reference#dataparam">here</a>

The main interface is LiteralBuilder:

  LiteralBuilder builder = new LiteralBuilder().addColumn(ColumnType.STRING).addColumn(ColumnType.NUMBER);
	builder.addRow(Cell.of("asdf"), Cell.of(3));
	builder.addRow(Cell.of("qwer"), Cell.of(5));
	System.out.println(b2.buildDataLiteral());

Produces:

  {cols:[{type: 'string'},{type: 'number'}], rows:[{c:[{v: 'asdf'},{v: 3.0}]},{c:[{v: 'qwer'},{v: 5.0}]}]}
