package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test2 {
// This Test Is For Question#2 To list The Registered Vetranians 
		@Test
		void test() {
			JUnitPet test = new JUnitPet();
			test.invokeBrowser();
			String[] output = test.Vetranians();
			assertEquals("James Carter",output[1]);
			assertEquals("Helen Leary",output[2]);
			assertEquals("Linda Douglas",output[3]);
			assertEquals("Rafael Ortega",output[4]);
			assertEquals("Henry Stevens",output[5]);
			assertEquals("Sharon Jenkins",output[6]);
		}

}
