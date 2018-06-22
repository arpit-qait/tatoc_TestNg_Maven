
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
public class Popup {
    WebDriver driver;
    
    
    
    
    public Popup(WebDriver driver){
        this.driver = driver;
    }
    public void checkPopupPageValidity(){
        String heading = driver.findElement(By.tagName("h1")).getText();
        assert(heading.contains("Popup Windows"));
}
    public PopupWindow openPopupWindow(){
        driver.findElement(By.linkText("Launch Popup Window")).click();
        
        return new PopupWindow(driver);
    }
    public Error notOpeningPopupWindowBeforeProceeding(){
//        driver.switchTo().window(parentwindow); 
        driver.findElement(By.linkText("Proceed")).click();
        
        return new Error(driver);
    }
}
