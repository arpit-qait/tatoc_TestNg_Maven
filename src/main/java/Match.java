
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
public class Match {
    WebDriver driver;
   
    public Match(WebDriver driver){
        this.driver = driver;
    }
    public Boolean checkMatchboxValidity(){
        String heading = driver.findElement(By.tagName("h1")).getText();
        return heading.contains("Frame Dungeon");
    }
    private String getFirstBoxAttribute(){
        driver.switchTo().frame(0);
        return driver.findElement(By.tagName("div")).getAttribute("class");
    }
    private String getSecondBoxAttribute(){
        driver.switchTo().frame(0);
        return driver.findElement(By.tagName("div")).getAttribute("class");
        
      }
    
    public Drag matchBoxColor(){
        String box1_Color = getFirstBoxAttribute();
        String box2_Color = getSecondBoxAttribute();
        while(!box1_Color.equals(box2_Color)){
            driver.switchTo().parentFrame();
            driver.findElement(By.linkText("Repaint Box 2")).click();
//            driver.switchTo().frame(0);
            box2_Color = getSecondBoxAttribute();
        }
        driver.switchTo().parentFrame();
        driver.findElement(By.linkText("Proceed")).click();
        return new Drag(driver);
    }
    public Error notMatchBoxColor(){
        String box1_Color = getFirstBoxAttribute();
        String box2_Color = getSecondBoxAttribute();
        while(box1_Color.equals(box2_Color)){
            driver.switchTo().parentFrame();
            driver.findElement(By.linkText("Repaint BOx 2")).click();
            box2_Color = getSecondBoxAttribute();
                    
        }
        driver.switchTo().parentFrame();
        driver.findElement(By.linkText("Proceed")).click();
        return new Error(driver);
    }
    }


