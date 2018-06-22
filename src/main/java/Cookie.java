
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arpitagarwal
 */
public class Cookie {
WebDriver driver;
public Cookie(WebDriver driver){
    this.driver = driver;
}
public void checkCookiePageValidity(){
        String heading = driver.findElement(By.tagName("h1")).getText();
        assert(heading.contains("Cookie Handling"));
}
public Error InvalidTokenValue(){
        driver.manage().addCookie(new org.openqa.selenium.Cookie("Token", "INVALID TOKEN"));
        driver.findElement(By.linkText("Proceed")).click();
        return new Error(driver);

}
public Finish ValidTokenValue(){
        driver.findElement(By.linkText("Generate Token")).click();
        String token = driver.findElement((By.id("token"))).getText();

        driver.manage().addCookie(new org.openqa.selenium.Cookie("Token", token.substring(7)));
        driver.findElement(By.linkText("Proceed")).click();
        return new Finish(driver);

}
}