package com.analysis.data;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/*
* 解析yaml文件，返回Map类型数据
 */

public class ReturnDatabase {
    private static String YamlPath;

    public ReturnDatabase(String dataPath) {
        this.YamlPath = dataPath;
        System.out.println(YamlPath);
    }

//    public ReturnDatabase() throws IOException {
//        // 初始化文件路径
//        String courseFile = new File("").getCanonicalPath();
//        this.YamlPath = courseFile + File.separator + Yamlpathfile;
//    }

    public Map<String, Object> getYaml() throws IOException {
        Yaml yaml = new Yaml();
        InputStream inputStream = new FileInputStream(YamlPath);
        Map<String, Object> map = (Map<String, Object>) yaml.load(inputStream);
        inputStream.close();

        return map;
    }



}
