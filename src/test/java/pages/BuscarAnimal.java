package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BuscarAnimal {

    ChromeDriver chromeDriver;
    String url;
    String animal;
    WebElement searchBar;
    WebElement result;

    @BeforeTest
    public void SetUp()
    {
        url = "https://www.google.com/";
        System.setProperty("webdriver.chrome.driver", "driverNavegador/chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get(url);
    }

    @AfterTest
    public void CloseTest()
    {
        chromeDriver.close();
    }


    @Test
    public void BuscaAnimal()
    {
        animal = "Gato";
        searchBar = chromeDriver.findElement(By.name("q"));
        searchBar.sendKeys(animal);
        searchBar.submit();
        chromeDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        result = chromeDriver.findElements(By.className("rc")).get(0).findElement(By.tagName("h3"));
        System.out.println(result.getText().strip());

    }


}
