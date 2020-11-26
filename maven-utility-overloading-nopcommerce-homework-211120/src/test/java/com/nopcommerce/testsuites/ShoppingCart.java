package com.nopcommerce.testsuites;

import com.nopcommerce.testbase.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
// Shopping Cart Testing by adding couple of quantities in basket.
public class ShoppingCart extends TestBase {
    @Test
    public void shoppingCart() throws InterruptedException {

        //clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));

        String expectedMessage = "Electronics";
        String actualMessage = getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        Assert.assertEquals(expectedMessage, actualMessage);

        mouseHoverExample(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"),
                By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[1]/a[1]"));


        String expectedMsg = "Camera & photo";
        String actualMsg = getTextFromElement(By.xpath("//h1[contains(text(),'Camera & photo')]"));
        Assert.assertEquals(expectedMsg, actualMsg);

        scrollPageTopBottom();

        String expectedMsg1 = "Nikon D5500 DSLR";
        String actualMsg1 = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[2]/h2[1]"));
        Assert.assertEquals(expectedMsg1, actualMsg1);

        //explicitWait((By.xpath("//body/div[6]/div[3]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[2]/h2[1]")), 10,
                //(By.xpath("//body/div[6]/div[3]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]")));

        Thread.sleep(1000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]"));

Thread.sleep(1000);
        String expectedMsg2 = "In stock";
        String actualStockAvailableStatus = getTextFromElement(By.xpath("//span[@id='stock-availability-value-14']"));
        Assert.assertEquals(expectedMsg2, actualStockAvailableStatus);

        Thread.sleep(1000);

        WebElement quantity = driver.findElement(By.xpath("//input[@id='product_enteredQuantity_14']"));
        quantity.clear();

        Thread.sleep(1000);

        WebElement quantity1 = driver.findElement(By.xpath("//input[@id='product_enteredQuantity_14']"));
        quantity1.sendKeys("2");

       // explicitWait((By.xpath("//input[@id='product_enteredQuantity_14']")), 60
       // ,(By.xpath("//input[@id='add-to-cart-button-14']")));
        Thread.sleep(1000);

        clickOnElement(By.xpath("//input[@id='add-to-cart-button-14']"));

       // explicitWait((By.xpath("//input[@id='add-to-cart-button-14']")), 100
        //, (By.xpath("//li[@id='topcartlink']")));

        Thread.sleep(5000);
        mouseHoverExample(By.xpath("//li[@id='topcartlink']"), By.xpath("//body/div[6]/div[1]/div[1]/div[2]/div[2]/div[1]/div[4]/input[1]"));


        String expectedMsg3 = "Shopping cart";
        String shoppingCartPage = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals(expectedMsg3, shoppingCartPage);


        String expectedProductPrice = "$670.00";
        String productPrice = getTextFromElement(By.xpath("//tbody/tr[1]/td[5]/span[1]"));
        Assert.assertEquals(expectedProductPrice, productPrice);

        String expectedTotal = "$1,340.00";
        String total = getTextFromElement(By.xpath("//tbody/tr[1]/td[7]/span[1]"));
        Assert.assertEquals(expectedTotal, total);

        Thread.sleep(1000);

        String expectedCheckoutTotal = "$1,340.00";
        String checkoutTotal = getTextFromElement(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong[1]"));
        Assert.assertEquals(expectedCheckoutTotal, checkoutTotal);

        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        clickOnElement(By.xpath("//button[@id='checkout']"));

        Thread.sleep(1000);

        sendTextToElement(By.xpath("//input[@id='Email']"), "newpresidentjoe@gamil.com");

        sendTextToElement(By.xpath("//input[@id='Password']"), "you999");


    }
}
