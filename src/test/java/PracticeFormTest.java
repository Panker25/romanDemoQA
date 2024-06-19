import com.demoqa.entities.PracticFormEntity;
import org.testng.annotations.Test;

public class PracticeFormTest extends BaseTest {
    @Test
    public void practiceFormTest(){
        driver.get("https://demoqa.com/automation-practice-form");

        PracticFormEntity practicFormEntity = randomeUtils.generateRandomPracticeFormEntity();

        practiceFormPage.fillPracticeForm(practicFormEntity);



    }
}





