import com.demoqa.enums.Orange;
import com.demoqa.enums.TopBarMenuEnums;
import com.demoqa.utils.ConfigReader;
import org.testng.annotations.Test;

public class OrangeTest extends BaseTest{
    @Test
   public void orangeTest() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        orangePage.fillupRegistration();
        Thread.sleep(5000);
        orangePage.fillupPanelMenu(Orange.ADMIN);
        Thread.sleep(5000);
        orangePage.fillupBarMenuItem(TopBarMenuEnums.JOB);
        Thread.sleep(5000);
        orangePage.fillupSubMenuItem("Job Titl");

    }

}
