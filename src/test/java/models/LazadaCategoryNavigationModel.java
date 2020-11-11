package models;

import java.util.Arrays;

/**
 * LazadaCategoryNavigationModel
 */
public class LazadaCategoryNavigationModel {

	private String[] categoryNavigationPath;
	private String productTitle;
	private String[] breadcrumb;

	public LazadaCategoryNavigationModel(final String[] categoryNavigationPath, final String productTitle,
			final String[] breadcrumb) {
		this.categoryNavigationPath = categoryNavigationPath;
		this.productTitle = productTitle;
		this.breadcrumb = breadcrumb;
	}

	public String[] getCategoryNavigationPath() {
		return categoryNavigationPath;
	}

	public void setCategoryNavigationPath(final String[] categoryNavigationPath) {
		this.categoryNavigationPath = categoryNavigationPath;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(final String productTitle) {
		this.productTitle = productTitle;
	}

	public String[] getBreadcrumb() {
		return breadcrumb;
	}

	public void setBreadcrumb(final String[] breadcrumb) {
		this.breadcrumb = breadcrumb;
	}

	@Override
	public String toString() {
		return "LazadaCategoryNavigationModel [breadcrumb=" + Arrays.toString(breadcrumb) + ", categoryNavigationPath="
				+ Arrays.toString(categoryNavigationPath) + ", productTitle=" + productTitle + "]";
	}

}
