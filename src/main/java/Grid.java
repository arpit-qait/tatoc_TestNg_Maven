
import java.util.List;
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
public class Grid {
    WebDriver driver;
    
    public Grid(WebDriver driver){
        this.driver = driver;
    }
    public void checkGridPageValidity(){
        
       String heading = driver.findElement(By.tagName("h1")).getText();
       assert(heading.contains("Grid Gate"));
        
    }
    public Error RedBoxSelection(){
        List<WebElement> list = driver.findElements(By.className("redbox"));
//        System.out.println(list.toString());
        list.get(0).click();
        return new Error(driver);
        
        
    }
    public Match GreenBoxSelection(){
        driver.findElement(By.className("greenbox")).click();
        return new Match(driver);
}
}
