package mantis.tests;

import mantis.pages.MantisSite;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

public class CreateAndDeleteIssueTest extends BaseTest {
    private MantisSite mantisSite;

    @Test
    public void createAndDeleteIssue() throws InterruptedException {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");
        mantisSite.getMainPage().goToReportIssuePage();

        SoftAssertions softAssert = new SoftAssertions();

        //Проверка нахождения на странице ReportIssue (по наличию заголовка "Enter Issue Details")
        softAssert.assertThat(mantisSite.getReportIssuePage().isEnterIssueDetailsHeaderIsDisplayed()).isEqualTo(true);

        String testSummary = "sum";
        String testDescription = "description";
        mantisSite.getReportIssuePage().createIssue(testSummary, testDescription);
        Thread.sleep(2000);
        String actualIssueSummary = mantisSite.getViewIssuesPage().getLatestIssueSummaryText();

        //Проверка, что новый issue появился на странице ViewIssues (по тексту описанию summary)
        softAssert.assertThat(testSummary).isEqualTo(actualIssueSummary);

        mantisSite.getViewIssuesPage().selectLatestIssue();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mantisSite.getViewIssuesPage().getDropUpField());
        mantisSite.getViewIssuesPage().selectDeleteValue();
        mantisSite.getViewIssuesPage().clickOkButton();
        Thread.sleep(2000);

        //Проверка нахождения на странице BugActionGroupPage (по наличию заголовка "Are you sure...")
        softAssert.assertThat(mantisSite.getBugActionGroupPage().isAreYouSureTitleIsDisplayed()).isEqualTo(true);

        mantisSite.getBugActionGroupPage().confirmDeleteIssues();
        Thread.sleep(2000);
        String currentSummaryAfterDelete = mantisSite.getViewIssuesPage().getLatestIssueSummaryText();

        //Проверка, что верхняя строчка на странице ViewIssues не содержит описания summary последнего удаленного issue
        softAssert.assertThat(currentSummaryAfterDelete).isNotEqualTo(testSummary);

        Thread.sleep(2000);
        softAssert.assertAll();
    }
}