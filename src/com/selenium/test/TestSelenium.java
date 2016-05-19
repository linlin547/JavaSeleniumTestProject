package com.selenium.test;

import com.analysis.data.ReturnDatabase;
import org.openqa.selenium.WebDriver;
import selenium.pack.construct.MethodConstruct;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class TestSelenium {

    private Map<String, Object> maps;
    private MethodConstruct methodConstruct;
    private String YamlPath;
    private String filapath = "Dbase/login.yaml";

    public TestSelenium(String name) throws IOException {
        //返回driver对象
        this.methodConstruct = new MethodConstruct(name);
        //拼接数据文件路径
        String courseFile = new File("").getCanonicalPath();
        this.YamlPath = courseFile + File.separator + filapath;
        //数据源解析yaml
        ReturnDatabase returnDatabase = new ReturnDatabase(this.YamlPath);
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

    public static void main(String[] args) throws IOException {
        // 参数为空
        String course = new File("").getCanonicalPath();
        System.out.println(course);
    }
}

