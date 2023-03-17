package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportIssuePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ReportIssuePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#summary")
    private WebElement issueSummaryInput;

    @FindBy(css = "#description")
    private WebElement issueDescriptionInput;

    @FindBy(css = "[type='submit']")
    private WebElement submitIssueButton;

    @FindBy(css = ".widget-title")
    private WebElement enterIssueDetailsHeader;

    public void createIssue(String summary, String description) {
        issueSummaryInput.sendKeys(summary);
        issueDescriptionInput.sendKeys(description);
        submitIssueButton.click();
    }

    public boolean isEnterIssueDetailsHeaderIsDisplayed() {
        return enterIssueDetailsHeader.isDisplayed();
    }
}