package org.shirokuma.actors

import org.openqa.selenium.WebDriver
import org.shirokuma.drivers.DriverManager
import org.shirokuma.steps.WikipediaSteps

class Actor {

    private var driver: WebDriver = DriverManager.createDriver()

    val wikipediaSteps by lazy { WikipediaSteps() }

    fun switch() {
        if (driver.toString().contains("null"))
            this.driver = DriverManager.createDriver()
        DriverManager.setDriver(driver)
    }

}