
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
public class Error {
    WebDriver driver;
 
    public Error(WebDriver driver){
        this.driver = driver;
    }
    public Boolean errorMessageDisplayed(){
        String errMsg = driver.findElement(By.className("page")).getText();
        return errMsg.contains("Error");
    }
}
