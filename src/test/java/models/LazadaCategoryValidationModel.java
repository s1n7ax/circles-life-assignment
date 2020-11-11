package models;

import java.util.Arrays;

/**
 * LazadaCategoryValidationModel
 */
public class LazadaCategoryValidationModel {

	private String[] expecectedCategories;
	private String[] categoryNavigationPath;

	public LazadaCategoryValidationModel(final String[] expecectedCategories, final String[] categoryNavigationPath) {
		this.expecectedCategories = expecectedCategories;
		this.categoryNavigationPath = categoryNavigationPath;
	}

	public String[] getExpecectedCategories() {
		return expecectedCategories;
	}

	public void setExpecectedCategories(final String[] expecectedCategories) {
		this.expecectedCategories = expecectedCategories;
	}

	public String[] getCategoryNavigationPath() {
		return categoryNavigationPath;
	}

	public void setCategoryNavigationPath(final String[] categoryNavigationPath) {
		this.categoryNavigationPath = categoryNavigationPath;
	}

	@Override
	public String toString() {
		return "LazadaCategoryValidationModel [categoryNavigationPath=" + Arrays.toString(categoryNavigationPath)
				+ ", expecectedCategories=" + Arrays.toString(expecectedCategories) + "]";
	}

}
