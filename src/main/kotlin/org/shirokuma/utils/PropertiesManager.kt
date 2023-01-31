package org.shirokuma.utils

import java.io.FileNotFoundException
import java.io.IOException
import java.util.*

class PropertiesManager {


    companion object {
        private var appProperties: Properties? = null

        fun appProperties(): Properties? {
            if (appProperties == null) {
                try {
                    PropertiesManager::class.java.classLoader.getResourceAsStream("application.properties")
                        .use { input ->
                            if (input == null) {
                                throw FileNotFoundException("Unable to load application.properties file from the resources directory")
                            }
                            appProperties = Properties()
                            appProperties!!.load(input)
                        }
                } catch (ex: IOException) {
                    ex.printStackTrace()
                }
            }
            return appProperties
        }
    }

}