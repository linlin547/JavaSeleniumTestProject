package com.selenium.test;

import com.analysis.data.ReturnDatabase;
import selenium.pack.construct.MethodConstruct;

import java.io.IOException;
import java.util.Map;

public class TestSelenium {

    private Map<String, Object> maps;
    private MethodConstruct methodConstruct;
    private  String filapath = "/Users/mac-li/Documents/Java_project/JavaSeleniumTestProject/Dbase/login.yaml";

    public TestSelenium(String name) throws IOException {
        //切换driver
//        this.webDriver = switchDriver(name);
        this.methodConstruct = new MethodConstruct(name);
        //数据源解析yaml
        ReturnDatabase returnDatabase = new ReturnDatabase(filapath);
        this.maps = returnDatabase.getYaml();

    }

    public String login(String name, String pwd) throws InterruptedException {
        String expectTexts = "";
        String UrlInfo = ((Map<String, String>) maps.get("URL")).get("confirm");
        Map<String, String> LoginInfo = (Map<String, String>) maps.get("login");
        methodConstruct.getUrl(UrlInfo);
        Thread.sleep(1000);
        try {
            methodConstruct.css(LoginInfo.get("name")).sendKeys(name);
            methodConstruct.css(LoginInfo.get("pwd")).sendKeys(pwd);
            methodConstruct.css(LoginInfo.get("button")).click();
            while (true) {
                if (methodConstruct.pagestatus()) {
                    expectTexts = methodConstruct.css(LoginInfo.get("expect")).getText();
                    break;
                } else {
                    Thread.sleep(2000);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return expectTexts;
    }

    public void closeSelenium() throws InterruptedException {
        Thread.sleep(1000);
        methodConstruct.quit();
        System.out.println("quit ok");
    }

}

