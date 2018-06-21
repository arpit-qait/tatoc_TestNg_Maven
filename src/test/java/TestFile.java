/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.openqa.selenium.By;
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
    Open open ;
    Grid grid;
    Error pageErr;
    Match match;
    Drag drag;
    
    public TestFile() {
    }
    @BeforeClass
    public void OpenCourseWebSite(){
        System.setProperty("webdriver.chrome.driver", "E:\\My Practice\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://10.0.1.86/tatoc");
        open = new Open(driver);
    }
    @Test
    public void CourseSelect(){
        grid = open.SelectCourse("Basic Course");
        
        
    }
    @Test(dependsOnMethods = {"CourseSelect"})
    public void CheckGridPage(){
        assertTrue(grid.checkGridPageValidity());
    }
    
    @Test(dependsOnMethods = {"CheckGridPage"},priority = 1)
    public void SelectRedBox(){
        
         pageErr = grid.RedBoxSelection();
        
    }
    
    @Test(dependsOnMethods = {"CheckGridPage"}, priority = 2)
    public void SelectGreenBox(){
        driver.navigate().back();
         match = grid.GreenBoxSelection();
    }
    @Test(dependsOnMethods = {"SelectRedBox"})
    public void CheckErrorPage(){
        assertTrue(pageErr.errorMessageDisplayed());
    }
    @Test(dependsOnMethods = {"SelectGreenBox"})
    public void CheckMatchPage(){
        assertTrue(match.checkMatchboxValidity());
    }
    @Test(dependsOnMethods = {"CheckMatchPage"},priority = 2)
    public void BoxesMatched(){
        
        driver.navigate().back();        
        drag = match.matchBoxColor();
        
        
    }
    @Test(dependsOnMethods = {"CheckMatchPage"}, priority = 1)
    public void BoxNonMatched(){
        
        pageErr = match.notMatchBoxColor();
        assertTrue(pageErr.errorMessageDisplayed());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    
}
