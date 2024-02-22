package makemytrip.test;

import com.makemytrip.util.pages.DashBoardPage;
import makemytrip.util.NavigateTestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestMakeMyTrip {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    public void testDashboardPage() {
        DashBoardPage dashBoardPage = NavigateTestUtils.navigateToDashBoardPage(driver);
        driver.close();
    }

    @Test
    public void testDeparture() {
        DashBoardPage dashBoardPage = NavigateTestUtils.navigateToDashBoardPage(driver);
        dashBoardPage.selectDeparture();
        // Enter date in the below format
        String dateOfBooking = "Feb 15 2024";
        dashBoardPage.selectDate(dateOfBooking);
        driver.close();
    }

}
