import com.demoqa.drivers.DriverManager;
import com.demoqa.helper.AlertHelper;
import com.demoqa.helper.BrowserHelper;
import com.demoqa.helper.WebElementActions;
import com.demoqa.pages.*;
import com.demoqa.utils.RandomeUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;
    protected TextBoxPage textBoxPage;
    protected RandomeUtils randomeUtils;
    protected AlertPage alertPage;
    protected WebElementActions webElementActions;
    protected AlertHelper alertHelper;
    protected BrowserHelper browserHelper;

    protected ProgressBarPage progressBar;
    protected PracticeFormPage practiceFormPage;
    protected DemoQAPages demoQAPages;
    protected WebTablesPage webTablesPage;
    protected  OrangePage orangePage;


    @BeforeClass(alwaysRun = true)
    public void setUp(){
        driver = DriverManager.getDriver();
        textBoxPage = new TextBoxPage();
        randomeUtils = new RandomeUtils();
        alertPage = new AlertPage();
        webElementActions = new WebElementActions();
        alertHelper =new AlertHelper(driver);
        browserHelper =new BrowserHelper(driver);
        progressBar = new ProgressBarPage();
        practiceFormPage = new PracticeFormPage();
        demoQAPages = new DemoQAPages();
        demoQAPages.setUp();
        orangePage = new OrangePage();

       // webTablesPage = new WebTablesPage();


    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        DriverManager.closeDriwer();
    }
}
