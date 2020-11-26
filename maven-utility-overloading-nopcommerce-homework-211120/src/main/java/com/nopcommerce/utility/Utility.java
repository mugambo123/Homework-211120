package com.nopcommerce.utility;

import com.nopcommerce.basepage.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class Utility extends BasePage {

    // This method will click on elements
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    // Overloading method
    public void clickOnElement(WebElement element) {
        element.click();
    }

    // This method will send text to element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    // Overloading method
    public void sendTextToElement(WebElement element, String text) {
        element.sendKeys(text);
    }

    // This method will get text from element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();

    }

    //Overloading method
    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    // Drag And Drop method
    public void dragAndDrop(By drag, By drop) {
        WebElement draggable = driver.findElement(drag);
        WebElement droppable = driver.findElement(drop);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable).perform();
    }

    // Overloading method
    public void dragAndDrop(WebElement element, By drop) {
        WebElement draggable = element;
        WebElement droppable = driver.findElement(drop);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable).perform();
    }

    // How to press certain keys in Keyboard
    public void controlAPlusCPlusV(By copy, By paste) throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.findElement(copy).sendKeys(Keys.CONTROL + "a");
        Thread.sleep(2000);

        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();

        driver.findElement(paste).click();

        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
    }

    // Overloading method
    public void controlAPlusCPlusV(WebElement element, By paste) throws InterruptedException {
        Actions actions = new Actions(driver);
        element.sendKeys(Keys.CONTROL + "a");
        Thread.sleep(2000);

        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();

        driver.findElement(paste).click();

        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
    }

    // Mouse Hover and then Click on SubElement
    public void mouseHoverExample(By by, By subEle) throws InterruptedException {
        JavascriptExecutor jse;
        jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-1000)");

        WebElement mainElement = driver.findElement(by);

        Actions action = new Actions(driver);

        action.moveToElement(mainElement).perform();

        Thread.sleep(3000);
        WebElement subElement = driver.findElement(subEle);
        Thread.sleep(3000);
        action.moveToElement(subElement).click().perform();
    }


    // This method will scroll page
    public void scrollPageTopBottom() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0,500)");
    }

    //Overloading method
    public void scrollPageTopBottom(int i, short b) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0,b)");
    }

    // Overloading Method
    public void mouseHoverAndClickOnSubElement(WebElement element, By sub) throws InterruptedException {

        WebElement mainElement = element;

        Actions actions = new Actions(driver);

        actions.moveToElement(mainElement).perform();

        Thread.sleep(3000);
        WebElement subElement = driver.findElement(sub);

        actions.moveToElement(subElement).click().perform();
    }

    // This method Right Click
    public void rightClick(By by) {
        WebElement img = driver.findElement(by);

        Actions actions = new Actions(driver);
        actions.contextClick(img).perform();
    }

    // Overloading Method
    public void rightClick(WebElement element) {

        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    // This method to move Slider
    public void sliderExample(By by, By slide) {
        WebElement mainSlider = driver.findElement(by);

        int width = mainSlider.getSize().width;
        int halfWidth = width / 2;

        WebElement slider = driver.findElement(slide);
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, halfWidth, 0).perform();
    }

    // Overloading method
    public void sliderExample(WebElement element, By slide) {

        int width = element.getSize().width;
        int halfWidth = width / 2;

        WebElement slider = driver.findElement(slide);
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, halfWidth, 0);
    }

    // This method print alert message
    public void alertExample(By by) {

        clickOnElement(by);
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    // Overloading method
    public void alertExample(WebElement element) {
        clickOnElement(element);
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    //Method for Explicit wait
    public void explicitWait(By link, int waitingSeconds, By nextLink) {
        By firstElement = link;
        WebDriverWait wait = new WebDriverWait(driver, waitingSeconds);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(firstElement));
        element.click();

        WebElement secondElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nextLink));

    }

    // Overloading method
    public void explicitWait(WebElement element, int waitingSeconds, By nextLink) {
        WebDriverWait wait = new WebDriverWait(driver, waitingSeconds);

        wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
        element.click();

        WebElement secondElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nextLink));

    }

    // Method for Implicit Wait
    public void implicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    // Overloading method
    public void implicitWait(short seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    //Method for Fluent Wait
    public void fluentWait(int a, int b, By by) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(a, TimeUnit.SECONDS)
                .pollingEvery(b, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement clickSeleniumLink = wait.until(new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
    }

    // overloading Method
    public void fluentWait(int a, int b, WebElement element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(a, TimeUnit.SECONDS)
                .pollingEvery(b, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement clickSeleniumLink = wait.until(new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver driver) {
                return element;
            }
        });

    }

    // Select Class Method By Visible Text
    public void selectDropDownByVisibleText(By by, String text) {
        WebElement dropDown = driver.findElement(by);

        Select select = new Select(dropDown);

        select.selectByVisibleText(text);
    }

    //Overloading Method
    public void selectDropDownByVisibleText(WebElement element, String text) {
        WebElement dropDown = element;

        Select select = new Select(dropDown);

        select.selectByVisibleText(text);
    }

    // Select Class Method By Index
    public void selectDropDownByIndex(By by, int a) {
        WebElement dropDown = driver.findElement(by);

        Select select = new Select(dropDown);
        select.selectByIndex(a);
    }

    // Overloading Method
    public void selectDropDownByIndex(WebElement element, int a) {
        WebElement dropDown = element;

        Select select = new Select(dropDown);
        select.selectByIndex(a);
    }

    // Select Class Method By Value
    public void selectDropDownByValue(By by, String text) {
        WebElement dropDown = driver.findElement(by);

        Select select = new Select(dropDown);
        select.selectByValue(text);
    }

    //Overloading Method
    public void selectDropDownByValue(WebElement element, String text) {
        WebElement dropDown = element;

        Select select = new Select(dropDown);
        select.selectByValue(text);
    }

    // Java program generate a Random String
    public String randomStringUpperCaseLowerCase(int n) {
        String alphabetsInUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetsInLowerCase = "abcdefghijklmnopqrstuvwxyz";
        // create a super set of all characters
        String allCharacters = alphabetsInLowerCase + alphabetsInUpperCase;
        // initialize a string to hold result
        StringBuffer randomString = new StringBuffer();

        // loop for 10 times
        for (int i = 0; i < n; i++) {
            // generate a random number between 0 and length of all characters
            int randomIndex = (int) (Math.random() * allCharacters.length());
            // retrieve character at index and add it to result
            randomString.append(allCharacters.charAt(randomIndex));
        }
        return randomString.toString();
    }

    // Overloading Method
    public String randomStringUpperCaseLowerCase(short n) {
        String alphabetsInUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetsInLowerCase = "abcdefghijklmnopqrstuvwxyz";
        // create a super set of all characters
        String allCharacters = alphabetsInLowerCase + alphabetsInUpperCase;
        // initialize a string to hold result
        StringBuffer randomString = new StringBuffer();

        // loop for 10 times
        for (int i = 0; i < n; i++) {
            // generate a random number between 0 and length of all characters
            int randomIndex = (int) (Math.random() * allCharacters.length());
            // retrieve character at index and add it to result
            randomString.append(allCharacters.charAt(randomIndex));
        }
        return randomString.toString();
    }

    // Method to generate Random number
    public CharSequence randomIntZeroToNineThousand(int n) {
        Random random = new Random();
        int randomNum = (int) (Math.random() * (n) + 1);
        String str = String.valueOf(randomNum);
        //System.out.println(str);

        return str.toString();

    }

    // Overloading Method
    public CharSequence randomIntZeroToNineThousand(short n) {
        Random random = new Random();
        int randomNum = (int) (Math.random() * (n) + 1);
        String str = String.valueOf(randomNum);
        //System.out.println(str);

        return str.toString();
    }
}


































