package testing;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test4_5 {
	// This Test Is For Question#4&#5 To create an owner and add pet to him then verify if the data is correct! 
	// if the data was not sent correctly the assertion would be false hence we will get an error!
	@Test
	void test() {
		JUnitPet test = new JUnitPet();
		test.invokeBrowser();
		String[] output = test.OwnerPet();
		assertEquals("Abdallah Alabed",output[0]);
		assertEquals("SportCity",output[1]);
		assertEquals("Amman",output[2]);
		assertEquals("0790001112",output[3]);
		assertEquals("BESO",output[4]);
		assertEquals("2021-12-21",output[5]);
		assertEquals("snake",output[6]);
	}
}
