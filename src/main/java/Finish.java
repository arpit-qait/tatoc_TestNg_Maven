
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
public class Finish {
    WebDriver driver;
    
    public Finish(WebDriver driver){
        this.driver = driver;
    }
    public void CheckEndPage(){
        assert(driver.findElement(By.tagName("h1")).getText().contains("End"));
    }
    
}
