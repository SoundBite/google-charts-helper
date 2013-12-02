package com.soundbite.gcharts.test;

import java.util.Calendar;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.soundbite.gcharts.Cell;
import com.soundbite.gcharts.ColumnType;
import com.soundbite.gcharts.Builder;

public class TestLiteralBuilder {

	@Test
	public void test() {
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		
		Builder builder = new Builder().addColumn(ColumnType.DATE, "my label").addColumn(ColumnType.NUMBER, "value"); 
		Assert.assertNotNull(builder.build());
		
		builder.addRow(Cell.of(new Date()), Cell.of(4))
			.addRow(Cell.of(cal.getTime()), Cell.of(2));
		
		System.out.println(builder.build());
		
		
		Builder b2 = new Builder();
		b2.addColumn(ColumnType.STRING).addColumn(ColumnType.NUMBER);
		b2.addRow(Cell.of("asdf"), Cell.of(3));
		b2.addRow(Cell.of("qwer"), Cell.of(5));
		System.out.println(b2.build());

                System.out.println("No rows example");
                Builder b3 = new Builder();
                b3.addColumn(ColumnType.STRING,"stringcol").addColumn(ColumnType.NUMBER, "numberCol");
                System.out.println(b3.build());
	}
}
