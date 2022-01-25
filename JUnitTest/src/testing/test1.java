package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test1 {
// This Test Is For Question#1 To Validate The Image In The Homepage
	@Test
	void test() {
		JUnitPet test = new JUnitPet();
		test.invokeBrowser();
		String output = test.VerifyImage();
		assertEquals("https://petclincqpros.herokuapp.com/resources/images/pets.png",output);
	}

}
