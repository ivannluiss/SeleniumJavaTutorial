package tests;

import helpers.WebDriverManager;
import org.testng.annotations.Test;
import pages.PageLogin;
import pages.PageReservation;

public class Reservas extends CondicionesComunes {
    @Test(description = "Reservación de vuelos",enabled = true)
    public void ReservationMercury(){
        WebDriverManager.setWindowSize(driver,"maximized");
        PageLogin pageLogin = new PageLogin(driver);
        PageReservation pageReservation = new PageReservation(driver);
        pageLogin.loginMercuryFlights("ivan","ivan");
        pageReservation.selectPassengers(2);
        pageReservation.selectFromPort(3);
        pageReservation.selectToPort("London");

    }
}
