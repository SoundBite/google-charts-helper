google-charts-helper
====================

A Java library for generating JavaScript literal strings to be used for populating Google charts wtih data.

js syntax is described in <a href="https://developers.google.com/chart/interactive/docs/reference#dataparam">Google's documentation</a>.

The main interface is LiteralBuilder:

    LiteralBuilder builder = new LiteralBuilder().addColumn(ColumnType.STRING).addColumn(ColumnType.NUMBER);
    builder.addRow(Cell.of("asdf"), Cell.of(3));
    builder.addRow(Cell.of("qwer"), Cell.of(5));
    System.out.println(builder.buildDataLiteral());

Produces:

    {cols:[{type: 'string'},{type: 'number'}], rows:[{c:[{v: 'asdf'},{v: 3.0}]},{c:[{v: 'qwer'},{v: 5.0}]}]}
