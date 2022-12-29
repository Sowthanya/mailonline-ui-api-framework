package com.mailonline.utils;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Action {
	
	public static void scrollInToView(WebDriver driver,WebElement element )
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static boolean waitForNewWindow(WebDriver driver, int timeout){
        boolean flag = false;
        int counter = 0;
        while(!flag){
            try {
                Set<String> winId = driver.getWindowHandles();
                if(winId.size() > 1){
                    flag = true;
                    return flag;
                }
                Thread.sleep(1000);
                counter++;
                if(counter > timeout){
                    return flag;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        return flag;
    }

}
