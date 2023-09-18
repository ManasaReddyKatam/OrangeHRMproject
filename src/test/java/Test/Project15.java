package Test;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class Project15 extends BaseTest {

    @Test
    public void AddNationalities() throws IOException, InterruptedException {
        String excelFilePath = "C:\\Users\\Srikanth\\IdeaProjects\\OrangeHRMproject\\src\\test\\resources\\OrangeHRMdata.xlsx";

        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(1);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String nationality = row.getCell(1).getStringCellValue();
            Page page = new Page(driver);
            page.ClickOnAdmin.click();
            page.ClickOnNationalities.click();
            page.AddNationalities.click();
            page.NationalitiesName.sendKeys(nationality);
            page.SaveNationalities.click();
            boolean displayed = page.VerifySaveNationalitiy.isDisplayed();
            Assert.assertEquals(displayed, true);
        }
    }
    @Test
    public void EditNationalities() throws IOException, InterruptedException {
        String excelFilePath = "C:\\Users\\Srikanth\\IdeaProjects\\OrangeHRM\\src\\test\\resources\\OrangeHRMdata.xlsx";

        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(1);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String EditNationalities = row.getCell(2).getStringCellValue();
            Page page = new Page(driver);
            page.ClickOnAdmin.click();
            page.ClickOnNationalities.click();
            page.EditNationalities.click();
            page.EditNationalitiesName.sendKeys(Keys.CONTROL + "a");
            page.EditNationalitiesName.sendKeys(Keys.DELETE);
            page.EditNationalitiesName.sendKeys(EditNationalities);
            page.SaveEditNationalities.click();
            boolean displayed = page.VerifyEditNationalities.isDisplayed();
            Assert.assertEquals(displayed,true);
        }
    }
    @Test
    public void DeleteNationalities() throws IOException, InterruptedException {
        Page page = new Page(driver);
        page.ClickOnAdmin.click();
        page.ClickOnNationalities.click();
        page.SelectDeleteNationality.click();
        page.ClickOnDelete.click();
        page.ClickOnDeleteYes.click();
        boolean displayed = page.VerifyDelete.isDisplayed();
        Assert.assertEquals(displayed,true);
    }
    @Test
    public void VerifyReqFieldsAddNationalities() throws IOException, InterruptedException {
        Page page = new Page(driver);
        page.ClickOnAdmin.click();
        page.ClickOnNationalities.click();
        page.AddNationalities.click();
        page.SaveNationalities.click();
        boolean displayed = page.VerifyREqFields.isDisplayed();
        Assert.assertEquals(displayed,true);

    }
    @Test
    public void SelectAllFunctionality() throws InterruptedException {
        Page page = new Page(driver);
        page.ClickOnAdmin.click();
        page.ClickOnNationalities.click();
        page.SelectAllNationality.click();
        boolean enalbled = page.VerifySelectAllNationality.isEnabled();
        Assert.assertEquals(enalbled, true);
    }

    @Test
    public void DeleteAllFunctionality() throws InterruptedException {
        Page page = new Page(driver);
        page.ClickOnAdmin.click();
        page.ClickOnNationalities.click();
        page.SelectAllNationality.click();
        page.ClickOnDelete.click();
        page.ClickOnDeleteYes.click();
        boolean displayed = page.VerifyDelete.isDisplayed();
        Assert.assertEquals(displayed, true);
    }

    @Test
    public void NationalityPageVerify() throws InterruptedException {
        Page page = new Page(driver);
        page.ClickOnAdmin.click();
        page.ClickOnNationalities.click();
        String displayed = page.VerifyNationalityPage.getText();
        Assert.assertEquals(displayed, "Nationalities");
    }
}