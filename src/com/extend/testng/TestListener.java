package com.extend.testng;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import selenium.pack.construct.MethodDriver;

import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * Created by mac-li on 16/5/18.
 */
public class TestListener implements ITestListener {
    WebDriver driver=null;
    //截图路径暂时写死......
    String filePath = "/Users/mac-li/Documents/Java_project/JavaSeleniumTestProject/ScreenImage/";
    //因重试导致最终测试结果展示运行方法数量增加，此方法可以做剔除处理，即重复的次数都展示在Skips中
    //例如：Tests run: 2, Failures: 1, Skips: 1 -- 一次重试已记录在Skips中
    @Override
    public void onFinish(ITestContext context) {
        Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
        for (ITestResult temp : failedTests) {
            ITestNGMethod method = temp.getMethod();
            if (context.getFailedTests().getResults(method).size() > 1) {
                failedTests.remove(temp);
            } else {
                if (context.getPassedTests().getResults(method).size() > 0) {
                    failedTests.remove(temp);
                }
            }
        }
    }
    //失败截图
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("***** Error "+result.getName()+" test has failed *****");
        String methodName=result.getName().toString().trim();
        takeScreenShot(methodName);

    }
    public void takeScreenShot(String methodName) {
        driver= MethodDriver.getWebDriver();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //The below method will save the screen shot in d drive with test method name
        try {
            FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
            System.out.println("***Placed screen shot in "+filePath+" ***");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

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


}
