package org.shirokuma.drivers

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.Browser
import org.openqa.selenium.safari.SafariDriver
import org.openqa.selenium.support.PageFactory
import org.shirokuma.utils.PropertiesManager

class DriverManager {

    companion object {
        private var driverThread: ThreadLocal<WebDriver> = ThreadLocal()
        private lateinit var driver: WebDriver

        fun createDriver(): WebDriver {
            val browser: String = PropertiesManager.appProperties()?.get("driver.browser").toString().trim()
            val tempDriver = if (browser.equals(Browser.FIREFOX.browserName(), ignoreCase = true)) {
                WebDriverManager.firefoxdriver().setup()
                FirefoxDriver()
            } else if (browser.equals(Browser.OPERA.browserName(), ignoreCase = true)) {
                WebDriverManager.operadriver().setup()
                ChromeDriver()
            } else if (browser.equals(Browser.SAFARI.browserName(), ignoreCase = true)) {
                WebDriverManager.safaridriver().setup()
                SafariDriver()
            } else if (browser.equals(Browser.EDGE.browserName(), ignoreCase = true)) {
                WebDriverManager.edgedriver().setup()
                EdgeDriver()
            } else {
                WebDriverManager.chromedriver().setup()
                ChromeDriver()
            }
            driverThread.set(tempDriver)
            driver = driverThread.get()
            return driverThread.get()
        }

        fun driver(): WebDriver = driver

        fun setDriver(webDriver: WebDriver) {
            this.driver = webDriver
        }
    }

}