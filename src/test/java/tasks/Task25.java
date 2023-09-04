package tasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.net.CookieStore;
import java.nio.file.Watchable;
import java.util.Set;

public class Task25 extends BaseTest {
    /*
Go to URL: https://kitchen.applitools.com/ingredients/cookie
Get Cookie.
Find the total number of cookies.
Print all the cookies.
Add Cookie.
Edit Cookie.
Delete Cookie.
Delete All Cookies
     */
    @Test
    public void cookies() {

        driver.get("https://kitchen.applitools.com/ingredients/cookie");
        Cookie cookie = driver.manage().getCookieNamed("vegetable");
        Assert.assertEquals("broccoli", cookie.getValue());
        Set<Cookie> list = driver.manage().getCookies();
        int sizeCookies = list.size();
        System.out.println("CookiesSize  " + sizeCookies);

        for (Cookie each : list) {
            System.out.println("Cookies:  " + each);
            System.out.println("Cookies Name:  " + each.getName());
            System.out.println("Cookies Value:  " + each.getValue());
        }

        Cookie cookie1 = new Cookie("fruit", "Orange");
        driver.manage().addCookie(cookie1);
        list = driver.manage().getCookies();
        System.out.println("New List " + list);
        System.out.println("New List Size " + list.size());

        Cookie editedCookie = new Cookie(cookie1.getName(), "mango");
        driver.manage().addCookie(editedCookie);
        list = driver.manage().getCookies();
        System.out.println("EditedList " + list);
        System.out.println("EditedListSize " + list.size());

    }

    @Test
    public void deleteCookies() {
        driver.get("https://kitchen.applitools.com/ingredients/cookie");
        Set<Cookie> allCookies = driver.manage().getCookies();
        int numOfCookies = allCookies.size();
        System.out.println("numOfCookies = " + numOfCookies);

        Cookie addedCookie = new Cookie("drinks", "ayran");
        driver.manage().addCookie(addedCookie);
        allCookies = driver.manage().getCookies();
        System.out.println("allCookies = " + allCookies.size());

        System.out.println("delete cookies");
        driver.manage().deleteCookie(addedCookie);
        Assert.assertNull("cookie halen var", driver.manage().getCookieNamed(addedCookie.getName()));
        allCookies = driver.manage().getCookies();
        System.out.println("allCookies = " + allCookies.size());

        driver.manage().deleteAllCookies();
        allCookies = driver.manage().getCookies();
        System.out.println("allCookies = " + allCookies.size());

    }

    @Test
    public void allowCookies() throws InterruptedException {

        driver.get("https://www.cookiebot.com/");
        WebElement allowButton = driver.findElement(By.cssSelector("#CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
        allowButton.click();
        Thread.sleep(6000);
        WebElement freeTria = driver.findElement(By.cssSelector("#signUp > span"));
        freeTria.click();
        Thread.sleep(6000);

    }

}
