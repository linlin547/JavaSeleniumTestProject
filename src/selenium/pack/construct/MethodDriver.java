package selenium.pack.construct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by mac-li on 16/5/19.
 */
public class MethodDriver {
    //应该好好想一下为什么要设置成静态
    private static WebDriver webDriver;

    public void setWebDriver(String drivername){
        //driver 初始化
        switch (drivername.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver",
                        "/Users/mac-li/Documents/Java_Lib/Selenium_lib/chromedriver");
                webDriver = new ChromeDriver();
                break;
            case "firefox":
                webDriver = new FirefoxDriver();
                break;
            case "ie":
                webDriver = new InternetExplorerDriver();
                break;
            default:
                break;
        }
    }
    //此处这么写主要供重写TestNG的onTestFailure方法的截图使用
    public static WebDriver getWebDriver(){
        return webDriver;
    }
}
