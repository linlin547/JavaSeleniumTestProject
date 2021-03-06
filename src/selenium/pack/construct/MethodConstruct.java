package selenium.pack.construct;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by mac-li on 16/5/16.
 */
public class MethodConstruct {
    private WebDriver webDriver;

    public MethodConstruct(String name) {
        //获取driver对象
        MethodDriver methodDriver = new MethodDriver();
        methodDriver.setWebDriver(name);
        this.webDriver = MethodDriver.getWebDriver();

        //设置10秒 ,全局所有元素都会在未找到元素前等待默认超时时间
        try {
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getUrl(String url) {
        webDriver.get(url);
    }

    public Object exeJS(String JSstr) {
        //执行js
        Object strValue = ((JavascriptExecutor) webDriver).executeScript(JSstr);
        return strValue;
    }

    public boolean pagestatus() {
        //判断页面结构是否加载完成
        Object data = exeJS("return document.readyState");
        if (String.valueOf(data).equals("complete")) {
            return true;
        } else {
            return false;
        }
    }

    public void forward() {
        //导航向前
        webDriver.navigate().forward();
    }

    public void back() {
        //导航向后
        webDriver.navigate().back();
    }

    public void upDown(int he) {
        //heigth >0 向上移动 反之向下移动
        exeJS(String.format("return $(\"body\").scrollTop(%d)", he));
    }

    public void leftRight(int lf) {
        //lf >0 向右移动 反之向左移动
        exeJS(String.format("return $(\"body\").scrollTop(%d)", lf));
    }

    public void dragDrop(WebElement element, WebElement target) {
        /*
        * 拖拽element 到 target
        * WebElement element = driver.findElement(By.name("source"));
        * WebElement target = driver.findElement(By.name("target"));
        * (new Actions(webDriver)).dragAndDrop(element, target).perform();
        */
        (new Actions(webDriver)).dragAndDrop(element, target).perform();
    }

    public void snapshot(String filename){
        String currentPath = System.getProperty("user.dir"); //get current work folder
        System.out.println(currentPath);
        File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        try {
            System.out.println("save snapshot path is:"+currentPath+"/"+filename);
            FileUtils.copyFile(scrFile, new File(currentPath + File.separator + filename));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Can't save screenshot");
            e.printStackTrace();
        }
        finally
        {

            System.out.println("screen shot finished");
        }
    }
    public WebElement css(String cssvalue) {
        //css 定位
        return webDriver.findElement(By.cssSelector(cssvalue));
    }

    public void close() {
        webDriver.close();
    }

    public void quit() {
        webDriver.quit();
    }

    public static void main(String[] args) {
        String currentPath = System.getProperty("user.dir"); //get current work folder
        System.out.println(currentPath);
    }
}
