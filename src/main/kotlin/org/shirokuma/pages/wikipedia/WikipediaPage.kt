package org.shirokuma.pages.wikipedia

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.shirokuma.elements.WebElementFacade
import org.shirokuma.pages.BasePage

class WikipediaPage : BasePage() {

    val searchBox = WebElementFacade(By.id("searchInput"))

    val pageTitle = WebElementFacade(By.xpath("//*[@id='firstHeading']/span"))

    val searchBtn = WebElementFacade(By.xpath("//button[@type='submit']"))

}