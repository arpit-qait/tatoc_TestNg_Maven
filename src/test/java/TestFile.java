/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Arpitagarwal
 */
public class TestFile {
    WebDriver driver;
    Open page1 ;
    Grid page2;
    Error pageErr;
    Match page3;
    
    
    public TestFile() {
    }
    @BeforeClass
    public void OpenCourseWebSite(){
        System.setProperty("webdriver.chrome.driver", "E:\\My Practice\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://10.0.1.86/tatoc");
        page1 = new Open(driver);
    }
    @Test
    public void CourseSelect(){
        page2 = page1.SelectCourse("Basic Course");
        
        
    }
    @Test(dependsOnMethods = {"CourseSelect"})
    public void CheckGridPage(){
        assertTrue(page2.checkGridPageValidity());
    }
    
    @Test(dependsOnMethods = {"CheckGridPage"},priority = 1)
    public void SelectRedBox(){
        
         pageErr = page2.RedBoxSelection();
        
    }
    
    @Test(dependsOnMethods = {"CheckGridPage"}, priority = 2)
    public void SelectGreenBox(){
        driver.navigate().back();
         page3 = page2.GreenBoxSelection();
    }
    @Test(dependsOnMethods = {"SelectRedBox"})
    public void CheckErrorPage(){
        assertTrue(pageErr.errorMessageDisplayed());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    
}
