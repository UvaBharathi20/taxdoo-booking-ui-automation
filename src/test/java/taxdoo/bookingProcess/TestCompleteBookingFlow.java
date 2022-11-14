package taxdoo.bookingProcess;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import taxdoo.commonUtils.Utils;

import static taxdoo.pageobject.Cookies.acceptCookies;
import static taxdoo.pageobject.bookingPersonalDetailsPage.BookingPersonalDetails.completeBooking;
import static taxdoo.pageobject.bookingPersonalDetailsPage.BookingPersonalDetails.enterPersonalDetails;
import static taxdoo.pageobject.bookingPriceSelectionPage.BookingPriceSelection.selectSalaryRangeLessThan1000;

public class TestCompleteBookingFlow {
    @BeforeMethod
    public void setUp() throws InterruptedException {
        Utils.setProperty();
        Utils.startChromeSession();
        Utils.openTaxdooApp();
    }

    @AfterMethod
    public void tearDown() {
        //Utils.quitDriver();
    }

    @DataProvider(name = "user-details-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{ "Valentinskamp 70, 20355 Hamburg","DE123456789", "testmail@gmail.com", "10293847588" }};
    }


    @Test(dataProvider = "user-details-provider")
    public void booking(String address,String vat, String mail, String phoneNumber) throws InterruptedException {
        acceptCookies();
        selectSalaryRangeLessThan1000();
        enterPersonalDetails(address, vat, mail, phoneNumber);
        completeBooking();
    }
}
