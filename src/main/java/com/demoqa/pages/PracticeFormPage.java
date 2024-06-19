package com.demoqa.pages;
import com.demoqa.entities.PracticFormEntity;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Random;

public class PracticeFormPage extends BasePage {

    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "userEmail")
    public WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")
    public WebElement genderInput;

    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[2]/label")
    public WebElement genderInput2;

    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[3]/label")
    public WebElement genderInput3;

    @FindBy(id = "userNumber")
    public WebElement mobileNumberInput;

    @FindBy(id = "subjectsContainer")
    public WebElement subjectInput;

    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]")
    public WebElement hobbiesInput;

    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]")
    public WebElement hobbiesInput2;

    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]")
    public WebElement honniesInput3;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressInput;

    @FindBy(id = "state")
    public WebElement stateInput;

    @FindBy(xpath = "//*[@id=\"state\"]/div/div[1]/div[1]")
    public WebElement stateButton;

    @FindBy(xpath = "//*[@id=\"state\"]/div/div[2]")
    public WebElement cityInput;

    @FindBy(xpath = "//*[@id=\"stateCity-wrapper\"]/div[3]")//*[@id="stateCity-wrapper"]/div[3]
    public WebElement cityInput1;

    @FindBy(id = "submit")
    public WebElement submitButton;

    public final Random random = new Random();

    public final List<WebElement> genderOptions = List.of(genderInput, genderInput2, genderInput3);
    public List<WebElement> hobbiesOption = List.of(hobbiesInput,hobbiesInput2,honniesInput3);
    public final List<WebElement> addressOptions = List.of(cityInput, cityInput1);

    public    List <WebElement>  city1 = List.of(cityInput);

    private WebElement randomGender;
    private WebElement randomHobbies;
    private WebElement randomAddress;
    private WebElement randomCity;

    public PracticeFormPage() {
        this.randomGender = genderOptions.get(random.nextInt(genderOptions.size()));
        this.randomHobbies = hobbiesOption.get(random.nextInt(hobbiesOption.size()));
        this.randomAddress = addressOptions.get(random.nextInt(addressOptions.size()));
        this.randomCity = city1.get(random.nextInt(city1.size()));
    }

    //  public  List<WebElement>

    public PracticeFormPage fillPracticeForm(PracticFormEntity practiceFormEntity) {
        webElementActions.sendKeys(firstNameInput, practiceFormEntity.getFullName())
                .sendKeys(lastNameInput, practiceFormEntity.getLastName())
                .sendKeys(emailInput, practiceFormEntity.getEmail())
                .click(randomGender)
                .sendKeys(mobileNumberInput, String.valueOf(practiceFormEntity.getMobileNumber()))
                .click(randomHobbies)
                .sendKeys(currentAddressInput, practiceFormEntity.getCurrentAddress())
                .click(randomAddress)
                .click(randomCity)
                .click(submitButton);
        return this;
    }
}