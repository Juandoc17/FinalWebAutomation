package trip;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.SearchDeparturePage;
import pages.SearchReturnPage;
import pages.TripDetailsPage;
import pages.WhoIsTravelingPage;
import static org.testng.Assert.assertTrue;

public class SetTripTest extends BaseTest {

    @Test
    public void setFields(){
        homePage.clickFlights();
        homePage.clickLeavingFrom("LAS");
        homePage.clickGoingTo("LAX");
        homePage.setDates();
        SearchDeparturePage searchDeparturePage = homePage.clickSearchButton();
        assertTrue(searchDeparturePage.checkElementsSelect(), "Elements not found");
        assertTrue(searchDeparturePage.checkSelectButton(), "Elements not found");
        assertTrue(searchDeparturePage.checkFlightDuration(), "Elements not found");
        searchDeparturePage.sortByShortestDuration();
        assertTrue(searchDeparturePage.checkListOrder(), "Elements not organized");
        searchDeparturePage.waitForFlightsOptions();
        searchDeparturePage.clickOption(1);
        assertTrue(searchDeparturePage.checkDetailAndBaggage(), "Elements not found");
        SearchReturnPage searchReturnPage = searchDeparturePage.confirmFlight();
        searchReturnPage.clickOption(3);
        searchReturnPage.confirmFlight();
        TripDetailsPage tripDetailsPage = searchReturnPage.clickNoThanks();
        assertTrue(tripDetailsPage.getTotalPrice(), "Elements not found");
        assertTrue(tripDetailsPage.getGuaranteeText(), "Elements not found");
        assertTrue(tripDetailsPage.getReturnAndDepartureInfo(), "Elements not found");
        WhoIsTravelingPage whoIsTravelingPage = tripDetailsPage.clickCheckOut();
        assertTrue(whoIsTravelingPage.checkElemenstInPage(), "Elements not found");
    }

}
