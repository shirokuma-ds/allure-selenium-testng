package org.shirokuma.steps

import io.qameta.allure.Step
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalToIgnoringCase
import org.shirokuma.pages.wikipedia.WikipediaPage

class WikipediaSteps {

    private val wikipediaPage = WikipediaPage()

    @Step("User open website {url}")
    fun openWebsite(url: String) {
        wikipediaPage.driver().get(url)
    }

    @Step("User search for {fruit}")
    fun searchFruit(fruit: String) {
        wikipediaPage.searchBox.sendKeys(fruit)
        wikipediaPage.searchBtn.click()
    }

    @Step("User verify page title is {title}")
    fun verifyPageTitle(title: String) {
        assertThat("Page Title is incorrect", title, equalToIgnoringCase(wikipediaPage.pageTitle.text()))
    }

}