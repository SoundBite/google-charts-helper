google-charts-helper
====================

*Copyright 2013 SoundBite Communications*

A Java library for generating JavaScript literal strings to be used for populating Google charts wtih data.

js syntax is described in <a href="https://developers.google.com/chart/interactive/docs/reference#dataparam">Google's documentation</a>.

Example
-------

The main interface is LiteralBuilder:

    LiteralBuilder builder = new LiteralBuilder().addColumn(ColumnType.STRING).addColumn(ColumnType.NUMBER);
    builder.addRow(Cell.of("asdf"), Cell.of(3));
    builder.addRow(Cell.of("qwer"), Cell.of(5));
    System.out.println(builder.buildDataLiteral());

Produces:

    {cols:[{type: 'string'},{type: 'number'}], rows:[{c:[{v: 'asdf'},{v: 3.0}]},{c:[{v: 'qwer'},{v: 5.0}]}]}

Usage
-----

The library can be used via Maven:

```xml
<dependency>
    <groupId>com.soundbite</groupId>
    <artifactId>google-charts-helper</artifactId>
    <version>0.0.4</version>
</dependency>
```
