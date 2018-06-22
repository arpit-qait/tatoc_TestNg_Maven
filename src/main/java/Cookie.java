
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
public Boolean checkCookiePageValidity(){
        String heading = driver.findElement(By.tagName("h1")).getText();
        return heading.contains("Cookie Handling");
}
}