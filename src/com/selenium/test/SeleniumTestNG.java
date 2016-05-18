package com.selenium.test;

import com.analysis.data.DataProviderCon;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

/**
 * Created by mac-li on 16/5/17.
 */

public class SeleniumTestNG {
    private TestSelenium testSelenium;

    @BeforeMethod
    public void beforeMethod() throws IOException {

        long id = Thread.currentThread().getId();
        System.out.println("Before test-method. Thread id is: " + id);
        this.testSelenium = new TestSelenium("Chrome");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        long id = Thread.currentThread().getId();
        System.out.println("After test-method. Thread id is: " + id);
        testSelenium.closeSelenium();
    }

    @Test(dataProvider = "logindata", dataProviderClass = DataProviderCon.class)
    public void login(Map<?, ?> map) throws InterruptedException, IOException {
        String expectData = testSelenium.login(String.valueOf(map.get("name")), String.valueOf(map.get("pwd")));

        Assert.assertEquals(expectData, String.valueOf(map.get("expect")));

    }
}
