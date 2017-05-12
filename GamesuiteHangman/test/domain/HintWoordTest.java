/**
* Hangmang Game Test
* *
* @author  JanRomo
* @author  bramdeman1
* @author  Kenzo1997
* @author  GamingChaos
* @author  CyllosBE
* *
* @version Pre-alfa
* @since   2017-05-08
* 
*/

package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HintWoordTest {
	public HintWoord woord1;
	
	@Before
	public void setUp() throws Exception {
		woord1 = new HintWoord("kubbe");
	}
	
	@Test (expected = DomainException.class)
	public void test_Hintwoord_geeft_exception_bij_null_invoer() throws Exception{
		HintWoord woord2 = new HintWoord(null);
	}
	
	@Test
	public void test_raad_geeft_true_bij_juiste_letter(){
		assertTrue(woord1.raad('u'));
	}
	
	@Test 
	public void test_raad_geeft_false_bij_foute_letter(){
		assertFalse(woord1.raad('a'));
	}
	
	@Test
	public void test_isGeraden_geeft_false_wanneer_woord_nog_niet_geraden_is(){
		assertFalse(woord1.isGeraden());
	}
	
	@Test
	public void test_isGeraden_geeft_true_wanneer_woord_juist_is_geraden(){
		HintWoord woord3 = null;
		try {
			woord3 = new HintWoord("banaan");
		} 
		catch (Exception e){
			fail(e.getMessage());
		}
		woord3.raad('b');
		woord3.raad('a');
		woord3.raad('n');
		assertTrue(woord3.isGeraden());
	}
	
	public void test_get_Woord_geeft_juiste_woord(){
		assertEquals("kubbe", woord1.getWoord());
	}
}
