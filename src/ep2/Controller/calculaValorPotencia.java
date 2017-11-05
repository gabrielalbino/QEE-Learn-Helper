package ep2.Controller;

public class calculaValorPotencia extends Calculos {
	private double 	Vrms, Irms, angV, angI, angVRad, angIRad;

	@Override
	public double calculaA() {
		return Vrms*Irms*Math.cos(angVRad-angIRad);
	}
	
	@Override
	public double calculaR() {
		return Vrms*Irms*Math.sin(angVRad-angIRad);
	}
	
	public double calculaPotAp() {
		return Vrms*Irms;
	}
	
	public double calculaFatPot() {
		return Math.cos(angVRad-angIRad);
	}
	
	public double getVrms() {
		return Vrms;
	}

	public void setVrms(double vrms) {
		Vrms = vrms;
	}

	public double getIrms() {
		return Irms;
	}

	public void setIrms(double irms) {
		Irms = irms;
	}

	public double getAngV() {
		return angV;
	}

	public void setAngV(double angV) {
		this.angV = angV;
		angVRad = angV*Math.PI/180.f;
	}

	public double getAngI() {
		return angI;
	}

	public void setAngI(double angI) {
		this.angI = angI;
		angIRad = angI*Math.PI/180.f;
	}
	
	
}
