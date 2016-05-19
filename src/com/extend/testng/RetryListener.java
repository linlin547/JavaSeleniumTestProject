package com.extend.testng;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by mac-li on 16/5/18.
 */
public class RetryListener implements IAnnotationTransformer {
    //失败后再次运行，运行次数由Retry类的maxRetryCount参数决定
    @Override
    public void transform(ITestAnnotation testannotation, Class testClass,
                          Constructor testConstructor, Method testMethod)	{
        IRetryAnalyzer retry = testannotation.getRetryAnalyzer();

        if (retry == null)	{
            testannotation.setRetryAnalyzer(Retry.class);
        }

    }

}
