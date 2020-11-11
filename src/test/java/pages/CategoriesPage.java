package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Locator;
import util.PageUtil;

/**
 * CategoriesPage
 */
public class CategoriesPage implements PageUtil {
	private final WebDriver driver;

	@FindBy(xpath = "//span[.='Categories']/parent::a")
	private WebElement ddCategories;

	@FindBy(xpath = "//span[.='Categories']/parent::a/following-sibling::*[1]//div[contains(@class, 'nav-menu-dropdown')]")
	private WebElement eleCategoriesDDContainer;

	private final By commonActiveCategoryContainer = By.xpath(
			".//ul[contains(@class, 'site-menu-root') or (contains(@class, 'site-menu-') and contains(@class, '-active'))]");

	private final String dynamicCategoryItem = "./li//*[text()=\"%s\"]";

	public CategoriesPage(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Opens the category drop down by hovering over the element
	 */
	public void openCategory() {
		final var action = new Actions(driver);
		action.moveToElement(ddCategories).build().perform();
	}

	public void goToMenu(final String... menus) {

		final var action = new Actions(driver);
		var parent = eleCategoriesDDContainer;
		WebElement lastItem = null;

		for (final String category : menus) {

			parent = parent.findElement(commonActiveCategoryContainer);
			lastItem = parent.findElement(Locator.resolveByX(dynamicCategoryItem, category));

			action.moveToElement(lastItem).build().perform();

		}

		final var lastItemFinal = lastItem;

		getWait(driver).until(driver -> {
			lastItemFinal.click();
			return true;
		});

	}

	public void validateCategories(final String[] expecectedCategories, final String... categoryNavigation) {

		final var action = new Actions(driver);
		var parent = eleCategoriesDDContainer;
		WebElement lastItem = null;

		for (final String category : categoryNavigation) {

			parent = parent.findElement(commonActiveCategoryContainer);
			lastItem = parent.findElement(Locator.resolveByX(dynamicCategoryItem, category));

			action.moveToElement(lastItem).build().perform();

		}

		for (final String category : expecectedCategories) {

			final var results = parent.findElement(commonActiveCategoryContainer)
					.findElements(Locator.resolveByX(dynamicCategoryItem, category));

			results.stream().findFirst()
					.orElseThrow(() -> new AssertionError("expected [" + category + "] but not found"));

		}
	}
}
