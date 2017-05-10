/**
* Hangmang Game
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

public class CirkelTest {
	private Cirkel cirkel1;
	private Cirkel cirkel2;
	private Cirkel cirkel3;
	private Cirkel cirkel4;
	private Cirkel cirkel5;
	private Cirkel cirkel6;
	private Cirkel cirkel7;
	private Cirkel cirkel8;
	
	@Before
	public void setUp() {
		this.cirkel1 = new Cirkel(15, 20, 20);
		this.cirkel2 = new Cirkel(20, 20, 20);
		this.cirkel3 = new Cirkel(20, 20, 20);
		this.cirkel7 = new Cirkel(20, 20, 30);
	}
	
	@Test (expected = DomainException.class)
	public void Test_Cirkel_met_straal_0_geeft_exception(){
		cirkel4 = new Cirkel(10, 20, 0);
	}
	
	@Test (expected = DomainException.class)
	public void Test_Cirkel_met_negatieve_straal_geeft_exception(){
		cirkel5 = new Cirkel(10, 20, -30);
	}
	
	@Test (expected = DomainException.class)
	public void Test_Cirkel_met_null_middelpunt_geeft_exception(){
		cirkel6 = new Cirkel(null, 30);
	}
	
	@Test
	public void Test_Cirkel_wordt_tegoei_gemaakt(){
		cirkel8 = new Cirkel(5, 20, 8);
		assertEquals(8, cirkel8.getRadius());
		assertEquals(5, cirkel8.getMiddelpunt().getX());
		assertEquals(20, cirkel8.getMiddelpunt().getY());
	}
	
	@Test
	public void Test_equals_geeft_true_bij_dezelfde_straal_en_middelpunt(){
		assertTrue(this.cirkel2.equals(cirkel3));
	}
	
	@Test
	public void Test_equals_geeft_false_bij_dezelfde_straal_en_verschillend_middelpunt(){
		assertFalse(this.cirkel1.equals(cirkel3));
	}
	
	@Test
	public void Test_equals_geeft_false_bij_verschillend_straal_en_hetzelfde_middelpunt(){
		assertFalse(this.cirkel7.equals(cirkel3));
	}
	
	@Test
	public void Cirkel_geeft_true_als_omhullende_juist_is(){
		Omhullende c1 = new Omhullende(new Punt(-5,0), 40, 40);
		assertTrue( c1.equals(cirkel1.getOmhullende()));
	}
}