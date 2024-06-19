import org.openqa.selenium.By;
import org.testng.annotations.Test;

import javax.sound.midi.Track;

public class BrowserHelperTest extends BaseTest{

    @Test
    void test123() throws InterruptedException {
        browserHelper.open("https://demoqa.com/browser-windows");
        Thread.sleep(1000);
        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(1000);
        browserHelper.switchToWindow(0);
        Thread.sleep(1000);
        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(1000);
        browserHelper.switchToWindow(0);
        Thread.sleep(1000);
        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(1000);
        browserHelper.switchToWindow(1);
        Thread.sleep(6000);

        browserHelper.switchToParentWithChildClose();
        Thread.sleep(6000);


    }
}
