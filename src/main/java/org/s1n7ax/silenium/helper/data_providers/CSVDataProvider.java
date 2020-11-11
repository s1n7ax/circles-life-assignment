package org.s1n7ax.silenium.helper.data_providers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

import org.testng.annotations.DataProvider;

public class CSVDataProvider {
	private final String FILE_PATH = "data/data.csv";

	@DataProvider(name = "csv-data-provider")
	public List<String[]> getData() throws UnsupportedEncodingException {

		List<String[]> data = new LinkedList<>();

		var classloader = Thread.currentThread().getContextClassLoader();
		var is = classloader.getResourceAsStream(getFilePath());
		var bf = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		bf.lines().forEach((str) -> {
			String[] values = str.split(",");
			data.add(values);
		});

		return data;

	}

	protected String getFilePath() {
		return FILE_PATH;
	}
}
