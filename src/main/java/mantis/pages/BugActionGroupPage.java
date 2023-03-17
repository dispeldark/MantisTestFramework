package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BugActionGroupPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public BugActionGroupPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[value='Delete Issues']")
    WebElement deleteIssuesButton;

    @FindBy(css = "h4.widget-title")
    WebElement areYouSureToDeleteIssueTitle;

    public boolean isAreYouSureTitleIsDisplayed() {
        return areYouSureToDeleteIssueTitle.isDisplayed();
    }

    public void confirmDeleteIssues() {
        deleteIssuesButton.click();
    }
}