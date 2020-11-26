package com.nopcommerce.testsuites;

import com.nopcommerce.testbase.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* This Program can verify Top menu of home page and can verify to go in to those sections
Computers", "Electronics", "Apparel", "Digital downloads", "Books", "Jewelry", "Gift Cards" etc.*/
public class TopMenu extends TestBase {

    @Test
    public void storeMenuList() throws InterruptedException {

        List<WebElement> list = driver.findElements(By.xpath("//ul[@ class = 'top-menu notmobile']/child::li"));
        List<String> menu = new ArrayList<String>();
        int size = list.size();

        for (int i = 0; i < list.size(); i++) {
            menu.add(list.get(i).getText());
            System.out.println(menu);
            //List<String> list1 = Arrays.asList("Computers", "Electronics", "Apparel", "Digital downloads","Books","Jewelry","Gift Cards");
            //Assert.assertEquals(list1, menu);
        }
        for (int j = 0; j < menu.size(); j++) {
            if (menu.contains("Computers") == true) {
                List<String> list1 = Arrays.asList("Computers", "Electronics", "Apparel", "Digital downloads", "Books", "Jewelry", "Gift Cards");
                Assert.assertEquals(list1, menu);
                clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));

                String expectedMessage = "Computers";
                String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Computers')]"));
                Assert.assertEquals(expectedMessage, actualMessage);

                Thread.sleep(1000);

                clickOnElement(By.xpath("//body/div[6]/div[3]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]"));

                String expectedMsg = "Desktops";
                String actualMsg = getTextFromElement(By.xpath("//h1[contains(text(),'Desktops')]"));
                Assert.assertEquals(expectedMsg, actualMsg);
            }
            if (menu.contains("Electronics") == true) {
                clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));

                String expectedMsg1 = "Electronics";
                String actualMsg1 = getTextFromElement(By.xpath("//h1[contains(text(),'Electronics')]"));
                Assert.assertEquals(expectedMsg1, actualMsg1);
            }

            if (menu.contains("Apparel") == true) {
                clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));

                String expectedMsg2 = "Apparel";
                String actualMsg2 = getTextFromElement(By.xpath("//h1[contains(text(),'Apparel')]"));
                Assert.assertEquals(expectedMsg2, actualMsg2);
            }
            if (menu.contains("Digital downloads") == true) {
                clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[4]/a[1]"));

                String expectedMsg3 = "Digital downloads";
                String actualMsg3 = getTextFromElement(By.xpath("//h1[contains(text(),'Digital downloads')]"));
                Assert.assertEquals(expectedMsg3, actualMsg3);
            }
            if (menu.contains("Books") == true) {
                clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[5]/a[1]"));

                String expectedMsg4 = "Books";
                String actualMsg4 = getTextFromElement(By.xpath("//h1[contains(text(),'Books')]"));
                Assert.assertEquals(expectedMsg4, actualMsg4);
            }
            if (menu.contains("Jewelry") == true) {
                clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[6]/a[1]"));

                String expectedMsg5 = "Jewelry";
                String actualMsg5 = getTextFromElement(By.xpath("//h1[contains(text(),'Jewelry')]"));
                Assert.assertEquals(expectedMsg5, actualMsg5);
            }
            if (menu.contains("Gift Cards") == true) {
                clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[7]/a[1]"));

                String expectedMsg6 = "Gift Cards";
                String actualMsg6 = getTextFromElement(By.xpath("//h1[contains(text(),'Gift Cards')]"));
                Assert.assertEquals(expectedMsg6, actualMsg6);
                break;

            } else {
                System.out.println("https://demo.nopcommerce.com Web Test is FAILED");
            }

        }
    }
}

