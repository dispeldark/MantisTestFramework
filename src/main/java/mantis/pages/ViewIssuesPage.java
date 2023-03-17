package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewIssuesPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ViewIssuesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60, 5000);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*//tr[1]/td[1]//*[@class='lbl']")
    private WebElement latestIssueCheckbox;

    @FindBy(xpath = "//*[@name='action']")
    private WebElement selectedIssuesDropUpField;

    @FindBy(xpath = "//*[@value='DELETE']")
    private WebElement deleteSelectedIssue;

    @FindBy(xpath = "//*[@value='OK']")
    private WebElement okButton;

    @FindBy(xpath = "//*[@id='buglist']/tbody/tr[1]/td[11]")
    private WebElement lastIssueSummary;


    public void selectLatestIssue() {
        latestIssueCheckbox.click();
    }

    public void clickOkButton() {
        okButton.click();
    }

    public String checkLastIssueSummary() {
        return lastIssueSummary.getText();
    }

    public WebElement getDropUpField() {
        return selectedIssuesDropUpField;
    }

    public void selectDeleteValue() {
        Select selectDropUpField = new Select(selectedIssuesDropUpField);
        selectDropUpField.selectByValue("DELETE");
    }
}