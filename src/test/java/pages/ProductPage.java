package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * ProductPage
 */
public class ProductPage {

	@FindBy(xpath = "//ul[contains(@class, 'breadcrumb')]")
	private WebElement eleBreadcrumb;

	@FindBy(tagName = "h1")
	private WebElement lblHeader;

	public ProductPage(final WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	public String getProductTitle() {

		return lblHeader.getText();

	}

	public String[] getBreadcrumb() {

		return eleBreadcrumb.findElements(By.tagName("li")).stream().map(ele -> ele.getText()).toArray(String[]::new);

	}

	public void validateTitle(final String expected) {

		final var title = getProductTitle();
		Assert.assertEquals(title, expected);

	}

	public void validateBreadcrumb(final String... expected) {

		final var breadcrumb = getBreadcrumb();
		Assert.assertEquals(breadcrumb, expected);

	}
}
