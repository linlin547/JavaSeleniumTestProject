package com.analysis.data;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by mac-li on 16/5/17.
 * ————————————————
 * 所有提供数据方法 必须为 static方法，否则无法调用
 * 未使用构造函数初始化数据，因为TestNG在调用数据提供函数的时候，直接使用的方式应该为:类名.方法名，不会初始化构造函数－－至少我试了结果是这样，可能不正确
 * ——————————————
 */
public class DataProviderCon {

    private static String dataFilePath = "Dbase/loginData.yaml";
    private static Map<String, Object> mapHistory;

    public static void DataPro() throws IOException {
        //拼接数据文件路径
        String courseFile = new File("").getCanonicalPath();
        String DataYamlPath = courseFile + File.separator + dataFilePath;
        ReturnDatabase returnDatabase = new ReturnDatabase(DataYamlPath);
        mapHistory = returnDatabase.getYaml();
        /*
        * 原始返回数据
        *{LoginData={login_case1={name=benbenxi, pwd=1394311111, expect=benbenxi},login_case2={name=benbenxi, pwd=1394311111, expect=benbenxi}},
            SearchData={search_case1={case1=aa, case2=bb}}}
         */
    }

    @DataProvider(name = "loginDataObject")
    public static Object[][] loginDataOb() throws IOException {
        /*
        * 返回其他类对象
        */
        DataPro();
        return new Object[][] {{new AnalysisMethod(mapHistory)}};
    }

    @DataProvider(name = "logindata")
    public static Object[][] loginData() throws IOException {
        /*
        * 返回解析好的二维数组Object[][Map<?,?>]
         */
        DataPro();
        Map<String, Map<?, ?>> mapLogin = (Map<String, Map<?, ?>>) mapHistory.get("LoginData");
        //logincase的List集合 方便循环取值
        List<String> loginSet = new ArrayList<>(mapLogin.keySet());
        //声明返回二维数组
        Object[][] DataBase = new Object[loginSet.size()][];

        for (int i = 0; i < loginSet.size(); i++) {
            DataBase[i] = new Object[]{mapLogin.get(loginSet.get(i))};
        }
        return DataBase;
    }

}
