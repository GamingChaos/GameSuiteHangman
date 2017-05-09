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
	
	@Before
	public void setUp() {
		cirkel1 = new Cirkel(15, 20, 20);
		cirkel2 = new Cirkel(20, 20, 20);
		cirkel3 = new Cirkel(20, 20, 20);
		cirkel7 = new Cirkel(20, 20, 30);
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
	public void Test_equals_geeft_true_bij_dezelfde_straal_en_middelpunt(){
		assertTrue(cirkel2.equals(cirkel3));
	}
	
	@Test
	public void Test_equals_geeft_false_bij_dezelfde_straal_en_verschillend_middelpunt(){
		assertFalse(cirkel1.equals(cirkel3));
	}
	
	@Test
	public void Test_equals_geeft_false_bij_verschillend_straal_en_hetzelfde_middelpunt(){
		assertFalse(cirkel7.equals(cirkel3));
	}
}