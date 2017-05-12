package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class TekeningHangManTest {
	private TekeningHangMan tekening = new TekeningHangMan();
	private Vorm bla = new Rechthoek(new Punt(10, 350), 300, 40);

	private Vorm galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);
	private Vorm galgstaaf = new LijnStuk(new Punt(160, 350), new Punt(160, 50));
	private Vorm hangbar = new LijnStuk(new Punt(160, 50), new Punt(280, 50));
	private Vorm koord = new LijnStuk(new Punt(280, 50), new Punt(280, 100));
	private Vorm hoofd = new Cirkel(new Punt(280, 125), 25);
	private Vorm oogLinks = new Cirkel(new Punt(270, 118), 2);
	private Vorm oogRechts = new Cirkel(new Punt(290, 118), 2);
	private Vorm neus = new Cirkel(new Punt(280, 128), 2);
	private Vorm mond = new LijnStuk(new Punt(270, 138), new Punt(290, 138));
	private Vorm lijf = new LijnStuk(new Punt(280, 150), new Punt(280, 250));
	private Vorm beenLinks = new LijnStuk(new Punt(280, 250), new Punt(240, 310));
	private Vorm beenRechts = new LijnStuk(new Punt(280, 250), new Punt(320, 310));
	private Vorm voetLinks = new Cirkel(new Punt(240, 310), 5);
	private Vorm voetRechts = new Cirkel(new Punt(320, 310), 5);
	private Vorm armLinks = new LijnStuk(new Punt(280, 200), new Punt(230, 170));
	private Vorm armRechts = new LijnStuk(new Punt(280, 200), new Punt(330, 170));
	private Vorm handLinks = new Cirkel(new Punt(230, 170), 5);
	private Vorm handRechts = new Cirkel(new Punt(330, 170), 5);

	@Before
	public void setUp() {
		tekening.voegVormToe(galgBodem);
		tekening.voegVormToe(galgstaaf);
		tekening.voegVormToe(hangbar);
		tekening.voegVormToe(koord);
		tekening.voegVormToe(hoofd);
		hoofd.setZichtbaarheid(false);
		tekening.voegVormToe(oogLinks);
		oogLinks.setZichtbaarheid(false);
		tekening.voegVormToe(oogRechts);
		oogRechts.setZichtbaarheid(false);
		tekening.voegVormToe(neus);
		neus.setZichtbaarheid(false);
		tekening.voegVormToe(mond);
		mond.setZichtbaarheid(false);
		tekening.voegVormToe(lijf);
		lijf.setZichtbaarheid(false);
		tekening.voegVormToe(beenLinks);
		beenLinks.setZichtbaarheid(false);
		tekening.voegVormToe(beenRechts);
		beenRechts.setZichtbaarheid(false);
		tekening.voegVormToe(voetLinks);
		voetLinks.setZichtbaarheid(false);
		tekening.voegVormToe(voetRechts);
		voetRechts.setZichtbaarheid(false);
		tekening.voegVormToe(armLinks);
		armLinks.setZichtbaarheid(false);
		tekening.voegVormToe(armRechts);
		armRechts.setZichtbaarheid(false);
		tekening.voegVormToe(handLinks);
		handLinks.setZichtbaarheid(false);
		tekening.voegVormToe(handRechts);
		handRechts.setZichtbaarheid(false);
	}

	@Test
	public void test_Maakt_18_vormen_aan() {
		assertEquals(18, tekening.getGrootte());
		assertEquals(4, tekening.getAantalZichtbare().size());
	}
	@Test
	public void test_zetVolgendeZichtbaar_maakt_eerstvolgende_onzichtbaar_zichtbaar() {
		tekening.zetVolgendeZichtbaar();
		assertEquals(tekening.getVorm(4).isZichtbaar(), true );
	}
	@Test (expected = DomainException.class)
	public void test_gooit_exception_als_alles_zichtbaar() {
		hoofd.setZichtbaarheid(true);
		oogLinks.setZichtbaarheid(true);
		oogRechts.setZichtbaarheid(true);
		neus.setZichtbaarheid(true);
		mond.setZichtbaarheid(true);
		lijf.setZichtbaarheid(true);
		beenLinks.setZichtbaarheid(true);
		beenRechts.setZichtbaarheid(true);
		voetLinks.setZichtbaarheid(true);
		voetRechts.setZichtbaarheid(true);
		armLinks.setZichtbaarheid(true);
		armRechts.setZichtbaarheid(true);
		handLinks.setZichtbaarheid(true);
		handRechts.setZichtbaarheid(true);
		tekening.zetVolgendeZichtbaar();	
	}
	public void reset_moet_alle_vormen_buiten_galg_onzichtbaar_maken(){
		tekening.reset();
		boolean temp = true;
		for(int i = 3 ; i < tekening.getGrootte(); i++ ){
			if(tekening.getVorm(i).isZichtbaar() == false){
				temp = true;
			}
			else {
				temp = false;
				break;
			}
		}
		assertTrue(temp);
	}
	@Test (expected = DomainException.class)
	public void voegToe_gooit_exception_als_vorm_niet_bestaat(){
		tekening.voegVormToe(null);
	}
	@Test (expected = DomainException.class)
	public void verwijder_gooit_exception_als_vorm_niet_bestaat(){
		tekening.verwijder(bla);
	}

}
