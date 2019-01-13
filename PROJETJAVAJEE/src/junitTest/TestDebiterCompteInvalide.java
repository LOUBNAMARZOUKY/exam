package junitTest;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestDebiterCompteInvalide {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testDebiterCompteInvalide() throws Exception {
    driver.get("http://localhost:14168/PROJETJAVAJEE/");
    driver.findElement(By.id("user")).click();
    driver.findElement(By.id("user")).clear();
    driver.findElement(By.id("user")).sendKeys("admin");
    driver.findElement(By.id("passe")).click();
    driver.findElement(By.id("passe")).clear();
    driver.findElement(By.id("passe")).sendKeys("admin");
    driver.findElement(By.name("Form1")).submit();
    driver.findElement(By.id("Image4")).click();
    driver.findElement(By.name("NumCp")).click();
    driver.findElement(By.name("NumCp")).clear();
    driver.findElement(By.name("NumCp")).sendKeys("16235");
    driver.findElement(By.id("form1")).submit();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Debiteur'])[1]/following::img[2]")).click();
    driver.findElement(By.id("radio2")).click();
    driver.findElement(By.name("LibelleOp")).click();
    driver.findElement(By.name("LibelleOp")).clear();
    driver.findElement(By.name("LibelleOp")).sendKeys("5");
    driver.findElement(By.name("MontantOp")).click();
    driver.findElement(By.name("MontantOp")).clear();
    driver.findElement(By.name("MontantOp")).sendKeys("50000");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.id("Image3")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
