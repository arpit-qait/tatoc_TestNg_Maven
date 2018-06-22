
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
public class PopupWindow {
    WebDriver driver;
    String parentwindow;
    String popupwindow;
    
    public PopupWindow(WebDriver driver){
        this.driver = driver;
        parentwindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        //System.out.println(parentWindow);
        List<String> popups =new ArrayList<>(windows);
        popupwindow = popups.get(popups.size()-1);
    }
     public Boolean checkOpenedPopup(){
         driver.switchTo().window(popupwindow);
         System.out.println(driver.getTitle());
         String title = driver.getTitle();
         driver.switchTo().window(parentwindow);
         return title.contains("Popup");
     }
     public Cookie fillTextEntryByValidString(){
         
         driver.switchTo().window(popupwindow);
         
         driver.findElement(By.id("name")).sendKeys("Arpit");
         driver.findElement(By.id("submit")).click();
         return clickProceedAfterPopup();
     } 
     public Error fillTextEntryByInValidString(){
         driver.switchTo().window(popupwindow);
         driver.findElement(By.id("name")).sendKeys("");
         driver.findElement(By.id("submit")).click();
         return clickProceedDirectly();
     } 
     public Cookie clickProceedAfterPopup(){
         driver.switchTo().window(parentwindow);
         driver.findElement(By.linkText("Proceed")).click();
            return new Cookie(driver);
     }
     public Error clickProceedDirectly(){
         driver.switchTo().window(parentwindow);
         driver.findElement(By.linkText("Proceed")).click();
            return new Error(driver);
     }
    
}
