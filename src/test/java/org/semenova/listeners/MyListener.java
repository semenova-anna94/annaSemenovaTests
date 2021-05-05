package org.semenova.listeners;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.semenova.constants.Constants;
import org.semenova.driver.WebDriverHolder;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class MyListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        if(!iTestResult.isSuccess()){
            File screenShot = ((TakesScreenshot) WebDriverHolder.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
            File dest = new File(Constants.SCREENSHOT_FOLDER, iTestResult.getName() + " " + new Date().getTime() + ".png");
            try {
                FileUtils.copyFile(screenShot, dest);
            } catch (IOException e){
                e.printStackTrace();
            }
            try {
                saveScreenshot(iTestResult);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(ITestResult iTestResult) throws IOException {
        File fileForCopy = new File(iTestResult.getName() + ".jpg");
        File screenshotFile = ((TakesScreenshot) WebDriverHolder.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, fileForCopy);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FileUtils.readFileToByteArray(fileForCopy);
    }
}
