import org.testng.annotations.Test;

public class AlertTest extends BaseTest {


    @Test
    void alertTest() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        webElementActions.click(alertPage.confirmAlertBtn);
        Thread.sleep(3000);
        alertHelper.acceptAlert();
        Thread.sleep(3000);

    }


}
