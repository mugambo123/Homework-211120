package com.nopcommerce.testsuites;

import com.nopcommerce.testbase.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ISelect;
import org.testng.annotations.Test;
// Register by using random email, but failed to copy password and paste in to confirm password field.
public class Register extends TestBase {
    public void navigateToRegister() {
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));

        String expectedMessage = "Register";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void registerSuccessfully() {
        navigateToRegister();

        explicitWait((By.xpath("//input[@id='gender-male']")), 20, (By.xpath("//input[@id='FirstName']")));

        clickOnElement(By.xpath("//input[@id='gender-male']"));


        sendTextToElement(By.xpath("//input[@id='FirstName']"), "joe");


        sendTextToElement(By.xpath("//input[@id='LastName']"), "biden");


        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[1]/option[11]"));


        clickOnElement(By.xpath("//option[contains(text(),'October')]"));


        clickOnElement(By.xpath("//option[contains(text(),'1950')]"));


        sendTextToElement(By.xpath("//input[@id='Email']"), randomStringUpperCaseLowerCase(6) + randomIntZeroToNineThousand(9000) + "@gmail.com");


        sendTextToElement(By.xpath("//input[@id='Company']"), "white house");

        WebElement option = driver.findElement(By.xpath("//input[@id='Newsletter']"));
        option.isSelected();


        sendTextToElement(By.xpath("//input[@id='Password']"), "Abc123");

        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "Abc123");

        clickOnElement(By.xpath("//input[@id='register-button']"));

        String expectedSuccessfulRegisterMessage = "Your registration completed";
        String actualSuccessfulRegisterMessage = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals(expectedSuccessfulRegisterMessage, actualSuccessfulRegisterMessage);
    }
}
