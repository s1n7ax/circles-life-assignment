package tests;

import org.s1n7ax.silenium.core.WebAutomationBase;
import org.s1n7ax.silenium.core.annotations.TestMeta;
import org.testng.annotations.Test;

import data_provider.CategoryNavigationDataProvider;
import data_provider.CategoryValidationDataProvider;
import models.LazadaCategoryNavigationModel;
import models.LazadaCategoryValidationModel;
import pages.CategoriesPage;
import pages.ProductPage;

@TestMeta(browser = "chrome", baseURL = "https://www.lazada.sg/", pageloadTimeout = 30000, implicitTimeout = 10000)
public class LazadaProductTests extends WebAutomationBase {

	@Test(dataProvider = "category-navigation-data-provider", dataProviderClass = CategoryNavigationDataProvider.class)
	public void verifyCategoryNavigation(final LazadaCategoryNavigationModel data) {

		final var driver = getDriver();

		// pages
		final var categoriesPage = new CategoriesPage(driver);
		final var productPage = new ProductPage(driver);

		categoriesPage.goToMenu(data.getCategoryNavigationPath());
		productPage.validateTitle(data.getProductTitle());
		productPage.validateBreadcrumb(data.getBreadcrumb());
	}

	@Test(dataProvider = "categories-validation-data-provider", dataProviderClass = CategoryValidationDataProvider.class)
	public void verifyCategories(final LazadaCategoryValidationModel data) {

		final var driver = getDriver();

		// pages
		final var categoriesPage = new CategoriesPage(driver);

		categoriesPage.validateCategories(data.getExpecectedCategories(), data.getCategoryNavigationPath());

	}
}
