package org.shirokuma.elements

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.shirokuma.drivers.DriverManager

class WebElementFacade(private val by: By) {

    fun toElement() : WebElement {
        return DriverManager.driver().findElement(by)
    }

    fun click() {
        toElement().click()
    }

    fun sendKeys(string: String) {
        toElement().sendKeys(string)
    }

    fun text(): String {
        return toElement().text
    }

}