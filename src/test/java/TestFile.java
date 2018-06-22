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
    Popup popup;
    PopupWindow popupWindow;
    Cookie cookie;
    Finish finish;
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
        grid.checkGridPageValidity();
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
        pageErr.errorMessageDisplayed();
    }
    @Test(dependsOnMethods = {"SelectGreenBox"})
    public void CheckMatchPage(){
        match.checkMatchboxValidity();
    }
    @Test(dependsOnMethods = {"CheckMatchPage"},priority = 2)
    public void BoxesMatched(){
        
        driver.navigate().back();        
        drag = match.matchBoxColor();
        
        
    }
    @Test(dependsOnMethods = {"CheckMatchPage"}, priority = 1)
    public void BoxNonMatched(){
        
        pageErr = match.notMatchBoxColor();
        pageErr.errorMessageDisplayed();
    }
    @Test(dependsOnMethods = {"BoxesMatched"})
    public void CheckDragPage(){
       drag.checkDragPageValidity();
    }
    @Test(dependsOnMethods = {"CheckDragPage"},priority = 2)
    public void SuccessfulDrag(){
        driver.navigate().back();
        popup = drag.successfullDragDone();
    }
    @Test(dependsOnMethods = {"CheckDragPage"},priority = 1)
    public void UnsuccessfulDrag(){
        pageErr = drag.unsuccessfulDragDone();
    }
    @Test(dependsOnMethods = {"SuccessfulDrag"})
    public void CheckPopupPageValidity(){
        popup.checkPopupPageValidity();
    }
    @Test(dependsOnMethods = {"CheckPopupPageValidity"},priority = 2)
    public void OpenPopupSuccessfully(){
        driver.navigate().back();
        popupWindow = popup.openPopupWindow();
        
    }
    @Test(dependsOnMethods = {"CheckPopupPageValidity"},priority = 1)
    public void ProceedNextDirectlyFromPopupPage(){
        pageErr = popup.notOpeningPopupWindowBeforeProceeding();
    }
    @Test(dependsOnMethods = {"OpenPopupSuccessfully"})
    public void CheckPopupWindowValidity(){
        popupWindow.checkOpenedPopup();
    }
    @Test(dependsOnMethods = {"CheckPopupWindowValidity"},priority = 1)
    public void EmptyStringPassed(){
        
        pageErr = popupWindow.fillTextEntryByInValidString();
    }
    @Test(dependsOnMethods = {"CheckPopupWindowValidity"},priority = 2)
    public void ValidStringPassed(){
        driver.navigate().back();
        popupWindow = popup.openPopupWindow();
        cookie = popupWindow.fillTextEntryByValidString();
    }
    @Test(dependsOnMethods = {"ValidStringPassed"})
    public void CheckCookiePageValidity(){
       cookie.checkCookiePageValidity();
    }
    @Test(dependsOnMethods = {"CheckCookiePageValidity"},priority = 1)
    public void InvalidToken(){
     pageErr = cookie.InvalidTokenValue();
    
    
    }
    @Test(dependsOnMethods = {"CheckCookiePageValidity"},priority = 2)
    public void ValidToken(){
        driver.navigate().back();
        finish = cookie.ValidTokenValue();
    }
    @Test(dependsOnMethods = {"ValidToken"})
    public void CheckEndPageValidity(){
        finish.CheckEndPage();
    }
}
