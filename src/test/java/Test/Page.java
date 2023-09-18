package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {
    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@name='username']")
    public WebElement Username;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement Password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement LoginClick;
    @FindBy(xpath = "//a[contains(@href, 'admin')]")
    public WebElement ClickOnAdmin;
    @FindBy(xpath = "//a[contains(text(),'Nationalities')]")
    public WebElement ClickOnNationalities;
    @FindBy(xpath = "(//button[contains(@class,'oxd-button')])")
    public WebElement AddNationalities;
    @FindBy(xpath = "(//input[contains(@class,'oxd-input')])[2]")
    public WebElement NationalitiesName;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement SaveNationalities;
    @FindBy(xpath = "(//p[contains(@class, 'oxd-text')])[5]")
    public WebElement VerifySaveNationalitiy;

    @FindBy(xpath = "(//i[contains(@class, 'pencil')])[1]")
    public WebElement EditNationalities;
    @FindBy(xpath = "(//input[contains(@class, 'oxd-input')])[2]")
    public WebElement EditNationalitiesName;
    @FindBy(xpath = "(//button[contains(@class, 'oxd-button')])[2]")
    public WebElement SaveEditNationalities;
    @FindBy(xpath = "(//p[contains(@class, 'oxd-text')])[5]")
    public WebElement  VerifyEditNationalities;
    @FindBy(xpath = "(//i[contains(@class, 'oxd-icon')])[13]")
    public WebElement  SelectDeleteNationality;
    @FindBy(xpath = "//button[contains(@class, 'danger ')]")
    public WebElement  ClickOnDelete;
    @FindBy(xpath = "(//button[contains(@class, 'danger ')])[2]")
    public WebElement  ClickOnDeleteYes;
    @FindBy(xpath = "(//p[contains(@class, 'oxd-text')])[3]")
    public WebElement  VerifyDelete;
    @FindBy(xpath = "(//span[contains(@class, 'oxd-text')])[13]")
    public WebElement  VerifyREqFields;
    @FindBy(xpath = "(//i[contains(@class, 'oxd-icon')])[12]")
    public WebElement SelectAllNationality;
    @FindBy(xpath = "//button[contains(@class, 'danger ')]")
    public WebElement VerifySelectAllNationality;
    @FindBy(xpath = "(//h6[contains(@class,'oxd-text')])[2]")
    public WebElement  VerifyNationalityPage;
    public void Login(String username, String password) {
        Username.sendKeys(username);
        Password.sendKeys(password);
        LoginClick.click();
    }
}