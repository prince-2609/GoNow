package goNow;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class GoNowFlight_Hotel {
	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("goNowFlight+Hotel", "Sheet2");
	}

	@Test(dataProvider = "getexceldata")

	public static void v12stagingforhotel(String UserType, String Source, String URL, String Username, String Password,
			String Trip, String OriginCityCode, String OriginLocation, String DestinationCityCode,
			String DestinationLocation, String DepartureDate, String ReturnDate, String Rooms, String Adult,
			String Child, String ChildAge, String Infant, String InfantAge, String MoreOptions, String Nationality,
			String Currency, String Class, String ShowDirectFlight, String MyHotelDiffenrentDate, String ChangeCheckIn,
			String ChangeCheckOut, String ApplyFilter, String StarRating, String PropertyType, String RateType,
			String ChooseAnotherFlight, String FlightFilter, String FareType, String AirLine, String Emailid,
			String AdultTitle, String AdultName, String Phone, String AdultDOBdate, String AdultRoomSelection,
			String AdultPassportNumber, String AdultPassportcountry, String AdultExpiryDate, String AdultNationality,
			String ChildTitle, String ChildName, String ChildDOBdate, String ChildRoomSelection,
			String ChildPassportNumber, String ChildPassportcountry, String ChildPassportDate, String ChildNationality,
			String InfantTitle, String InfantName, String InfantDOBdate, String InfantTravellingwith,
			String InfantPassportNumber, String InfantPassportcountry, String InfantPassportDate,
			String InfantNationality, String Cardtype, String CardNumber, String CardName, String CardDate, String CVV,
			String BillingTitle, String BillingUserName, String BillingAddress, String BillingCountry,
			String BillingCity) throws Exception {
		TestBase.Companycode(Source, URL);
		QaRobot.impliwait(30);

		QaExtentReport.test = QaExtentReport.report.createTest("Test on Booking For Flight + Hotel");

		if (UserType.equalsIgnoreCase("LogIn")) {
			QaRobot.ClickOnElement("LogIn");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on SignIn</i></b>");

			QaRobot.PassValue("User_name", Username);
			QaExtentReport.test.log(Status.INFO, "<b><i>Write Username</i></b>");

			QaRobot.PassValue("Password", Password);
			QaExtentReport.test.log(Status.INFO, "<b><i>Write Password</i></b>");

			QaRobot.ClickOnElement("Submit");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Submit</i></b>");

			QaRobot.ClickOnElement("Flight_Hotel");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Flight+Hotel</i></b>");

			GoNowTripType.flight_HotelTrip(Trip, OriginCityCode, OriginLocation, DestinationCityCode,
					DestinationLocation, DepartureDate, ReturnDate, Rooms, Adult, Child, ChildAge, Infant, InfantAge,
					MoreOptions, Nationality, Currency, Class, ShowDirectFlight, MyHotelDiffenrentDate, ChangeCheckIn,
					ChangeCheckOut);

			GoNowResultPage.ResultPageForFlight_Hotel(ApplyFilter, StarRating, PropertyType, RateType,
					ChooseAnotherFlight, FlightFilter, FareType, AirLine);
		}

		else if (UserType.equalsIgnoreCase("Guest")) {
			QaRobot.ClickOnElement("Flight_Hotel");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Flight+Hotel</i></b>");
			Thread.sleep(3000);
			QaRobot.ClickOnElement("SkipForNow");

			GoNowTripType.flight_HotelTrip(Trip, OriginCityCode, OriginLocation, DestinationCityCode,
					DestinationLocation, DepartureDate, ReturnDate, Rooms, Adult, Child, ChildAge, Infant, InfantAge,
					MoreOptions, Nationality, Currency, Class, ShowDirectFlight, MyHotelDiffenrentDate, ChangeCheckIn,
					ChangeCheckOut);

//			GoNowResultPage.ResultPageForFlight_Hotel(ApplyFilter, StarRating, PropertyType, RateType,
//					ChooseAnotherFlight, FlightFilter, FareType, AirLine);
//
//			GoNowCheckoutPage.GuestDetailsCheckoutFlight_Hotel();
//
//			GoNowCheckoutPage.GuestAdultCheckoutForFlight_Hotel(Adult, Trip, Emailid, AdultTitle, AdultName, Phone,
//					AdultDOBdate, AdultRoomSelection, AdultPassportNumber, AdultPassportcountry, AdultExpiryDate,
//					AdultNationality);
//
//			GoNowCheckoutPage.GuestChildCheckoutFlight_Hotel(Child, Trip, ChildTitle, ChildName, ChildDOBdate,
//					ChildRoomSelection, ChildPassportNumber, ChildPassportcountry, ChildPassportDate, ChildNationality);
//
//			GoNowCheckoutPage.GuestInfantCheckoutFlight_Hotel(Infant, Trip, InfantTitle, InfantName, InfantDOBdate,
//					InfantTravellingwith, InfantPassportNumber, InfantPassportcountry, InfantPassportDate,
//					InfantNationality);
//
//			GoNowPaymentPage.cardPaymentFlight_Hotel(Cardtype, CardNumber, CardName, CardDate, CVV);
//
//			GoNowCheckoutPage.GuestBillingDetailsCheckoutFlight_Hotel(BillingTitle, BillingUserName, BillingAddress,
//					BillingCountry, BillingCity);
//
//			GoNowConfirmPage.confirmpageFlight_Hotel();
		}
	}

	@AfterMethod
	public static void afterMetod() {
		QaExtentReport.test.getExtent().flush();
	}
}
