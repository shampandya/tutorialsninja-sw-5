package com.tutorialsninja.demo.browserfactory;

import com.tutorialsninja.demo.propertyreader.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class ManageBrowser {
    public static WebDriver driver;
    private String baseUrl = PropertyReader.getInstance().getProperty("baseUrl");
    private int implicitlyWait = Integer.parseInt(PropertyReader.getInstance().getProperty("implicitlyWait"));

    public ManageBrowser(){
        PageFactory.initElements(driver,this);
    }

    public void selectBrowser(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }else {
            System.out.println("invalid browser name entered");
        }
        driver.get(baseUrl);
        driver.manage().window().maximize();

    }
    public void closeBrowser(){
        if(driver!=null)
        driver.quit();
    }
}
