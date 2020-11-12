package org.s1n7ax.silenium.core.impl;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.firefox.GeckoDriverService;
import org.s1n7ax.silenium.core.NoSuchDriverException;
import org.s1n7ax.silenium.core.WebDriverManager;

/**
 * DefaultFirefoxDriverManager
 */
public class DefaultGeckoDriverManager implements WebDriverManager {

	private GeckoDriverService service;

	@Override
	public void startService() {

		if (service == null)
			service = new GeckoDriverService.Builder().usingDriverExecutable(getDriverFile()).usingAnyFreePort()
					.build();

		if (service.isRunning())
			return;

		try {
			service.start();
		} catch (final IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void stopService() {
		if (service != null && !service.isRunning())
			service.stop();
	}

	private File getDriverFile() {
		final var os = System.getProperty("os.name").toLowerCase();
		final var classloader = Thread.currentThread().getContextClassLoader();

		String filePath;

		if (os.contains("linux"))
			filePath = "drivers/linux/geckodriver";
		else if (os.contains("windows"))
			filePath = "drivers/windows/geckodriver.exe";
		else
			throw new NoSuchDriverException("web driver is not available for current os :: " + os);

		try {
			final var file = new File(classloader.getResource(filePath).getFile());
			/**
			 * @TODO - on windows, GeckoDriverService can't find driver unless you set the
			 *       particular environment variable This need to be checked
			 */
			System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
			return file;
		} catch (final NullPointerException e) {
			e.printStackTrace();
			throw new NoSuchDriverException("web driver is not available in path :: " + filePath);
		}
	}

}
