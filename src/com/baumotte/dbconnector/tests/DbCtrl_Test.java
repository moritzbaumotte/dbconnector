package com.baumotte.dbconnector.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.baumotte.dbconnector.controller.DbCtrl;
import com.baumotte.dbconnector.entities.Ticket;

class DbCtrl_Test {

	@Test
	void test_getTickets() {
		DbCtrl dbCtrl = new DbCtrl();
		
		try {
			for(Ticket t : dbCtrl.getTickets("moritz@baumotte.com")) {
				System.out.println(t.getUserEmail() + " - " + t.getTitle() + " - " + t.getDescription());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		assertTrue(true);
	}
	
	@Test
	void test_submitTicket() {
		DbCtrl dbCtrl = new DbCtrl();
		
		try {
			int result = dbCtrl.submitTicket("moritz@baumotte.com", "test ticket", "this is a test description");
			System.out.println("result id: " + result);
		} catch (SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		assertTrue(true);
	}

}
