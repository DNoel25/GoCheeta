package com.codewithnoel.gocheetaweb.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.codewithnoel.gocheetaweb.model.Booking;

class BookingSvcsTest {

	@Test
	@DisplayName("Test add booking")
	void testAddBooking() throws ClassNotFoundException, SQLException {
		BookingSvcs bookingRec = BookingSvcs.getInstanceUserManage();

		Booking booking = new Booking();

		booking.setCustomerCNo("N077384783");
		booking.setDriverName("NNoel");
		booking.setDriverCNo("N088287822");
		booking.setVehicleCategory("Nluxury");

		boolean expected = true;
		boolean actual = bookingRec.addBooking(booking);

		assertEquals(expected, actual, "this must add the patient");
	}

	
//	 @Test void testGetAllAppointment() throws ClassNotFoundException,SQLException {
//	 
//	 BookingSvcs bookings = BookingSvcs.getInstanceUserManage();
//	 
//	 
//	 Assertions.assertNotNull(bookings.getAllBooking());
//	 
//	 }
	 

	/*
	 * @Test void testGetCustomerAppointment() { fail("Not yet implemented"); }
	 */

}
