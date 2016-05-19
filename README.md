# JavaSeleniumTestProject
----
* 项目描述：</br>
  * 登陆163邮箱登陆为例，断言登陆成功展示用户名与预期用户名一致，完成一次小的测试流程</br>

  * TestNG已添加失败重试方法，测试结果去除(重试)方法，失败自动截图方法；</br>

  * 文件描述：</br>

    * 1.页面控件数据源 Dbase/login.yaml</br>
    * 2.测试数据源 Dbase/loginData.yaml</br>
    * 3.Selenium方法二次封装类 selenium.pack.construct.MethodDriver && selenium.pack.construct.MethodConstruct</br>
    * 4.页面封装 com.selenium.test.TestSelenium</br>
    * 5.数据预解析类 com.analysis.data.ReturnDatabase</br>
    * 6.TestNG数据驱动类 com.analysis.data.AnalysisMethod && com.analysis.data.DataProviderCon</br>
    * 7.TestNG测试方法类 com.selenium.test.SeleniumTestNG</br>
    * 8.TestNG失败重试类 com.extend.testng.Retry && com.extend.testng.RetryListener</br>
    * 9.TestNG测试结果去除(重试)方法类 com.extend.testng.TestListener</br>
    * 10.TestNG失败自动截图类 com.extend.testng.TestListener</br>
    * 11.testng配置文件 testng.xml</br>
    * 12.ScreenImage－－截图保存目录</br>
----
* TestNG扩展方法使用:</br>

  * 1.TestNG失败重试,结果去重，截图类需要在testng.xml文件中用listeners声明</br>
----
* 唠叨:</br>

  * 折腾完这些多少有点耗时，毕竟是人家的东西，需要好好熟悉才能使用,</br>
  主要为熟悉Java练手，不过细想一下TestNG还是有很多便捷之处，值得很多测试小伙伴这么痴迷～</br>
  回头想想用Python完成这些工作的时候真的好心累，都要自己去实现.....那时好苦</br>
  Java和Python对测试而言各有优势，测试还是需要多掌握一些技能才能更好的胜任日常工作～</br>

