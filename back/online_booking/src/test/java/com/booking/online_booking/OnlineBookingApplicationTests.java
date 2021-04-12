package com.booking.online_booking;

import com.booking.online_booking.utils.NextPage;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OnlineBookingApplicationTests {

	@Test
	void contextLoads() {
		String a = "x+ --44 4-2 -x";
		a = a.replaceAll("[+\s-]", "");
		System.out.println("a...: " + a);
		
	}

}
