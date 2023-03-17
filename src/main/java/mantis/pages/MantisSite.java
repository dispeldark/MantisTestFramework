package mantis.pages;

import org.openqa.selenium.WebDriver;

public class MantisSite {
    private final WebDriver driver;
    private LoginPage loginPage;
    private PasswordPage passwordPage;
    private MainPage mainPage;
    private ReportIssuePage reportIssuePage;
    private ViewIssuesPage viewIssuesPage;
    private BugActionGroupPage bugActionGroupPage;

    public MantisSite(WebDriver driver) {
        this.driver = driver;

        loginPage = new LoginPage(driver);
        passwordPage = new PasswordPage(driver);
        mainPage = new MainPage(driver);
        reportIssuePage = new ReportIssuePage(driver);
        viewIssuesPage = new ViewIssuesPage(driver);
        bugActionGroupPage = new BugActionGroupPage(driver);
    }

    public void login(String login, String password) {
        loginPage.login(login);
        passwordPage.login(password);
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public PasswordPage getPasswordPage() {
        return passwordPage;
    }

    public MainPage getMainPage() {
        return mainPage;
    }

    public ReportIssuePage getReportIssuePage() {
        return reportIssuePage;
    }

    public ViewIssuesPage getViewIssuesPage() {
        return viewIssuesPage;
    }

    public BugActionGroupPage getBugActionGroupPage() {
        return bugActionGroupPage;
    }
}