package ep2.Controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculosUC2tTest {
	CalculosUC2 calc;
	@Test
	void testSetVrms() {
		calc = new CalculosUC2();
		double vrms;
		vrms = 1;
		calc.setVrms(vrms);
		assertEquals(calc.getVrms(), vrms,10e-5);	
	}
	@Test
	void testInvalidSetVrms() {
		calc = new CalculosUC2();
		double vrms;
		vrms = -1;
		calc.setVrms(vrms);
		assertEquals(calc.getVrms(), vrms,10e-5);	
	}
	@Test
	void testSetIrms() {
		calc = new CalculosUC2();
		double irms;
		irms = 1;
		calc.setIrms(irms);
		assertEquals(calc.getIrms(), irms,10e-5);	
	}
	@Test
	void testInvalidSetIrms() {
		calc = new CalculosUC2();
		double irms;
		irms = 30000;
		calc.setIrms(irms);
		assertEquals(calc.getIrms(), irms,10e-5);	
	}
	@Test
	void testSetAngV() {
		calc = new CalculosUC2();
		double angV;
		angV = 1;
		calc.setAngV(angV);
		assertEquals(calc.getAngV(), angV,10e-5);	
	}
	@Test
	void testInvalidSetAngV() {
		calc = new CalculosUC2();
		double angV;
		angV = -184;
		calc.setAngV(angV);
		assertEquals(calc.getAngV(), angV,10e-5);	
	}
	@Test
	void testSetAngI() {
		calc = new CalculosUC2();
		double angI;
		angI = 1;
		calc.setAngI(angI);
		assertEquals(calc.getAngI(), angI,10e-5);	
	}
	@Test
	void testInvalidSetAngI() {
		calc = new CalculosUC2();
		double angI;
		angI = -184;
		calc.setAngI(angI);
		assertEquals(calc.getAngI(), angI,10e-5);	
	}

	@Test
	void testGets() {
		double I = 39, V = 220, aI = 35, aV = 0;
		double pA = 7028, pR = -4921, pAp = 8580, FP = 0.82;
		calc = new CalculosUC2();
		calc.setAngI(aI);
		calc.setAngV(aV);
		calc.setVrms(V);
		calc.setIrms(I);
		calc.calcular();
		assertEquals(calc.getValorDoFatorDePotencia(), FP,1.f); //utiliza margem de erro de 1.f pois o método retorna double com ponto flutuante e os valores do plano de verificação do sistema não!	
		assertEquals(calc.getValorPotenciaAparente(), pAp,1.f);	
		assertEquals(calc.getValorPotenciaAtiva(), pA,1.f);	
		assertEquals(calc.getValorPotenciaReativa(), pR,1.f);	
	}

}
