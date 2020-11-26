package com.nopcommerce.testbase;

import com.nopcommerce.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase extends Utility {
    String browser = "chrome";


    @BeforeMethod
    public  void setUp(){
        selectBrowser("chrome");
    }
    @AfterMethod
    public void tearDown(){
        closeBrowser();
    }
}
