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

public class HintLetterTest {
	private HintLetter letter1;
	
	@Before
	public void setUp(){
		letter1 = new HintLetter('f');
	}
	
	@Test
	public void test_object_wordt_gemaakt(){
		HintLetter letter2 = new HintLetter('h');
		assertEquals('h', letter2.getLetter());
		assertFalse(letter2.isGeraden());
	}
	
	public void test_raad_geeft_false_bij_foute_waarde(){
		assertFalse(letter1.raad('a'));
	}
	
	@Test
	public void test_isGeraden_geeft_false_juiste_waarde_bij_juist_geraden(){
		assertFalse(letter1.isGeraden());
	}
	
	@Test
	public void test_raad_geeft_treu_bij_juist_geraden(){
		assertTrue(letter1.raad('f'));
	}
	
	@Test
	public void test_isGeraden_geeft_True_juiste_waarde_nadat_juiste_is_geraden(){
		HintLetter letter3 = new HintLetter('h');
		letter3.raad('h');
		assertTrue(letter3.isGeraden());
	}
	
	@Test
	public void test_getLetter_geeft_juiste_letter(){
		assertEquals('f', letter1.getLetter());
	}
	
	public void testtoChargeeftjuistechar(){
		assertEquals('f', letter1.toChar());
	}
}