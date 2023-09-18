package Test;

import utilities.DriverManager;
import utilities.QaEnvPropReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseTest {
    WebDriver driver;
    @BeforeClass
    public void setup() throws IOException {
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        String excelFilePath = "C:\\Users\\Srikanth\\IdeaProjects\\OrangeHRMproject\\src\\test\\resources\\OrangeHRMdata.xlsx";
        String url = QaEnvPropReader.getproperty("url");
        driver.get(url);
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String username1 = row.getCell(1).getStringCellValue();
            String password1 = row.getCell(2).getStringCellValue();
            Page page = new Page(driver);
            page.Login(username1,password1);

        }
    }

    @AfterClass
    public void teardown(){

//        driver.quit();
    }

}