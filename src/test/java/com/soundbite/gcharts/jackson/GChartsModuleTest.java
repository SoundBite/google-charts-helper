package com.soundbite.gcharts.jackson;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soundbite.gcharts.Builder;
import com.soundbite.gcharts.Cell;
import com.soundbite.gcharts.ColumnType;

public class GChartsModuleTest {

	ObjectMapper mapper;
	
	public String readFile(String filename) throws IOException {
		InputStream in = getClass().getResourceAsStream(filename);
		if (in == null)
			throw new FileNotFoundException("Unable to load " + filename);
		return IOUtils.toString(in, "UTF-8");
	}

	@Before
	public void setup() {
		mapper = new ObjectMapper();
		mapper.registerModule( new GChartsModule() );
	}

	public String writeValue(Object o) throws JsonGenerationException, JsonMappingException, IOException {
		StringWriter out = new StringWriter();
		mapper.writeValue(out, o);
		return out.toString();
	}
	
	@Test
	public void testBasic() throws JsonGenerationException, JsonMappingException, IOException, JSONException {

		Builder builder = new Builder();
		builder.addColumn(ColumnType.STRING, "label1").addColumn(ColumnType.NUMBER, "label2");
		builder.addRow(Cell.of("asdf"), Cell.of(3));
		builder.addRow(Cell.of("qwer"), Cell.of(5));

		String actual = writeValue(builder.buildChart());
		String expected = readFile("/test1.json");
		JSONAssert.assertEquals(expected, actual, true);
	}

	@Test
	public void testDate() throws JsonGenerationException, JsonMappingException, IOException, JSONException {

		Builder builder = new Builder();
		builder.addColumn(ColumnType.DATE, "label1").addColumn(ColumnType.NUMBER, "label2");
		builder.addRow(Cell.of(new Date(1386037530000L)), Cell.of(3));
		builder.addRow(Cell.of(new Date(1386037572000L)), Cell.of(5));

		String actual = writeValue(builder.buildChart());
		String expected = readFile("/test2.json");
		
		System.out.println(actual);
		
		JSONAssert.assertEquals(expected, actual, true);

	}
}
