package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test3 {
	// This Test Is For Question#3 To list The Owners Who Are Already On The Owners List 
	// I Will Only Test the First 10 Owners As They are always Visible	
			@Test
			void test() {
				JUnitPet test = new JUnitPet();
				test.invokeBrowser();
				String[] output = test.FindOwners();
				assertEquals("George Franklin",output[1]);
				assertEquals("Betty Davis",output[2]);
				assertEquals("Eduardo Rodriquez",output[3]);
				assertEquals("Harold Davis",output[4]);
				
				assertEquals("Peter McTavish",output[5]);
				assertEquals("Jean Coleman",output[6]);
				assertEquals("Jeff Black",output[7]);
				assertEquals("Maria Escobito",output[8]);
				
				assertEquals("David Schroeder",output[9]);
				assertEquals("Carlos Estaban",output[10]);
			}

}
