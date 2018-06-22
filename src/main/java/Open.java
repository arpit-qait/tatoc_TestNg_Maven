
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arpitagarwal
 */
public class Open {
    WebDriver driver;
    
    public Open(WebDriver driver){
        this.driver = driver;
        
    }
    public Grid SelectCourse(String courseName){
        driver.findElement(By.linkText(courseName)).click();
//        System.out.println(driver.findElement(By.tagName("h1")).getText());
        return new Grid(driver);
        
    }
    
}
