package com.booking.online_booking;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class OnlineBookingApplicationTests {

	@Test
	void contextLoads() {
		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		System.out.println("pass......" + b.encode("Testtest0")); 
	}

}
