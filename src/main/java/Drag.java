
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arpitagarwal
 */
public class Drag {
    WebDriver driver;
    
    public Drag(WebDriver driver){
        this.driver = driver;
        
    }
    public Boolean checkDragPageValidity(){
        String heading = driver.findElement(By.tagName("h1")).getText();
        return heading.contains("Drag Around");
    }
    public Popup successfullDragDone(){
        WebElement point =  driver.findElement(By.id("dropbox"));
        
        WebElement point1 =  driver.findElement(By.id("dragbox"));
        Actions act = new Actions(driver);
        act.dragAndDrop(point1, point).build().perform();
//        while()
        driver.findElement(By.linkText("Proceed")).click();
        return new Popup(driver);
        
    }
    public Error unsuccessfulDragDone(){
        driver.findElement(By.linkText("Proceed")).click();
        return new Error(driver);
    }
}
