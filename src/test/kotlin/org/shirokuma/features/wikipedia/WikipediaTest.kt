package org.shirokuma.features.wikipedia

import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.shirokuma.actors.Actor
import org.shirokuma.drivers.DriverManager
import org.testng.annotations.AfterTest
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@Feature("Wikipedia Search Test")
class WikipediaTest {

    private val actorA by lazy { Actor() }
    private val actorB by lazy { Actor() }

    @DataProvider(name = "fruits")
    fun provideFruits() : Iterator<String> {
        val data = listOf("apple", "banana", "kiwi")
        return data.iterator()
    }

    @DataProvider(name = "animals")
    fun provideAnimals() : Iterator<String> {
        val data = listOf("dog", "cat", "bird")
        return data.iterator()
    }

    @Test(dataProvider = "fruits", groups = ["sanity"])
    @Story("User search a fruit")
    fun searchFruit(fruit: String) {
        actorA.switch()
        actorA.wikipediaSteps.openWebsite("https://www.wikipedia.org")
        actorB.switch()
        actorB.wikipediaSteps.openWebsite("https://www.wikipedia.org")
        actorA.switch()
        actorA.wikipediaSteps.searchFruit(fruit)
        actorB.switch()
        actorB.wikipediaSteps.searchFruit(fruit)
        actorA.switch()
        actorA.wikipediaSteps.verifyPageTitle(fruit)
        actorB.switch()
        actorB.wikipediaSteps.verifyPageTitle(fruit)

    }

    @Test(dataProvider = "animals", groups = ["sanity"])
    @Story("User search an animal")
    fun searchAnimal(animal: String) {
        actorB.wikipediaSteps.openWebsite("https://www.wikipedia.org")
        actorB.wikipediaSteps.searchFruit(animal)
        actorB.wikipediaSteps.verifyPageTitle(animal)
    }

    @AfterTest(alwaysRun = true)
    fun cleanUp() {
        actorA.switch()
        DriverManager.driver().quit()
        actorB.switch()
        DriverManager.driver().quit()
    }

}