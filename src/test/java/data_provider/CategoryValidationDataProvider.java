package data_provider;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import org.s1n7ax.silenium.helper.data_providers.CSVDataProvider;
import org.testng.annotations.DataProvider;

import models.LazadaCategoryValidationModel;

/**
 * CategoryValidationDataProvider
 */
public class CategoryValidationDataProvider extends CSVDataProvider {

	private final String FILE_PATH = "data/category-validation.csv";

	@DataProvider(name = "categories-validation-data-provider")
	public Iterator<Object> getCategoryValidationData() throws UnsupportedEncodingException {

		final var data = super.getData();
		return data.stream().map(strArr -> {

			final var expected = strArr[0].split(":");

			String[] navigationPath;

			if (strArr.length < 2)
				navigationPath = new String[] {};
			else
				navigationPath = strArr[1].split(":");

			return (Object) new LazadaCategoryValidationModel(expected, navigationPath);

		}).iterator();

	}

	@Override
	protected String getFilePath() {
		return FILE_PATH;
	}
}
