package com.vytrack.pages;

import com.vytrack.utilities.Utilities;
import com.vytrack.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.rmi.CORBA.Util;
import java.util.List;

public class CalendarEventsPage extends PageBase {

    @FindBy(css = "[title='Create Calendar event']")
    private WebElement createCalendarEvent;

    @FindBy(className = "select2-chosen")
    private WebElement owner;


    @FindBy(css= "[id^='date_selector_oro_calendar_event_form_start']")
    private WebElement startDate;

    @FindBy(css= "[id^='time_selector_oro_calendar_event_form_start']")
    private WebElement startTime;

    @FindBy(css= "[id^='time_selector_oro_calendar_event_form_end']")
    private WebElement endTime;

    @FindBy(className = "grid-header-cell__label")
    private List<WebElement> columnNames;

    @FindBy(css = "iframe[id^='oro_calendar_event_form_description-uid']")
    private WebElement descriptionFrame;

    @FindBy(css = "[id^='oro_calendar_event_form_title-uid']")
    private WebElement title;

    @FindBy(id = "tinymce")
    private WebElement descriptionTextArea;

    @FindBy(css = "[class='btn-group pull-right'] > button")
    private WebElement saveAndClose;

    @FindBy(xpath = "(//div[@class='control-label'])[1]")
    private WebElement generalInfoTitle;

    @FindBy(xpath = "//label[text()='Description']/following-sibling::div//div")
    private WebElement generalInfoDescription;


    @FindBy(xpath = "//*[contains(text(),'View per page:')]/following-sibling::*//a")
    private List<WebElement> viewPerPageElements;

    @FindBy(css = "button[class*='btn dropdown-toggle']")
    private WebElement viewPerPageToggle;

    public List<String> getViewPerPageOptions() {
        Utilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title='Create Calendar event']")));
        viewPerPageToggle.click();
        Utilities.wait(2);
        return Utilities.getTextFromWebElements(viewPerPageElements);
    }




    public void enterCalendarEventTitle(String titleValue) {
        Utilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(title)).sendKeys(titleValue);
    }

    public void enterCalendarEventDescription(String description) {
        //wait until frame is available and switch to it
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(descriptionFrame));
        descriptionTextArea.sendKeys(description);
        driver.switchTo().defaultContent();//exit from the frame
    }

    public void clickOnSaveAndClose() {
        Utilities.wait(7);
        wait.until(ExpectedConditions.elementToBeClickable(saveAndClose)).click();
    }

    public String getGeneralInfoTitleText() {
        Utilities.waitForPageToLoad(20);
        return generalInfoTitle.getText();
    }

    public String getGeneralInfoDescriptionText() {
        Utilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Description']/following-sibling::div//div")));
        return generalInfoDescription.getText();
    }


    public List<String> getColumnNames() {
        Utilities.waitForPageToLoad(20);
        return Utilities.getTextFromWebElements(columnNames);
    }

    public String getStartTime(){

        Utilities.waitForPageToLoad(20);
        return startTime.getAttribute("value");
    }

    public String getEndTime(){
        Utilities.waitForPageToLoad(20);
        return endTime.getAttribute("value");
    }



    public String getOwner(){
        Utilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("select2-chosen")));
        wait.until(ExpectedConditions.visibilityOf(owner));
        return  owner.getText().trim();
    }

    public  void clickToCreateCalendarEvent(){
        Utilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();
    }
    public String getStartDate(){
        Utilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(startDate));
        Utilities.scrollTo(startDate);
        return startDate.getAttribute("value");
    }
}
