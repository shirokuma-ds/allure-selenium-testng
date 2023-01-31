package org.shirokuma.pages

import org.openqa.selenium.WebDriver
import org.shirokuma.drivers.DriverManager
import javax.inject.Inject

open class BasePage {

    fun driver() = DriverManager.driver()

}