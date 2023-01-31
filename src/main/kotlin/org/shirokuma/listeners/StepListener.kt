package org.shirokuma.listeners

import io.qameta.allure.Allure
import io.qameta.allure.listener.StepLifecycleListener
import io.qameta.allure.model.StepResult
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.shirokuma.drivers.DriverManager
import java.io.ByteArrayInputStream

class StepListener : StepLifecycleListener {

    override fun afterStepUpdate(result: StepResult?) {
        val takesScreenshot = DriverManager.driver() as TakesScreenshot
        Allure.addAttachment(result?.name, ByteArrayInputStream(takesScreenshot.getScreenshotAs(OutputType.BYTES)))
    }

}