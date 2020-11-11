package data_provider;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import org.s1n7ax.silenium.helper.data_providers.CSVDataProvider;
import org.testng.annotations.DataProvider;

import models.LazadaCategoryNavigationModel;

/**
 * CategoryNavigationDataProvider
 */
public class CategoryNavigationDataProvider extends CSVDataProvider {

	private final String FILE_PATH = "data/category-navigation.csv";

	@DataProvider(name = "category-navigation-data-provider")
	public Iterator<Object> getCategoryData() throws UnsupportedEncodingException {

		final var data = super.getData();

		return data.stream().map(strArr -> {
			final var categories = strArr[0].split(":");
			final var title = strArr[1];
			final var breadcrumb = strArr[2].split(":");

			return (Object) new LazadaCategoryNavigationModel(categories, title, breadcrumb);

		}).iterator();

	}

	@Override
	protected String getFilePath() {
		return FILE_PATH;
	}
}
