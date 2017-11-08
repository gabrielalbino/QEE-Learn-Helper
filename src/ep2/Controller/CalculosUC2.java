package ep2.Controller;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class CalculosUC2 implements Calcular {
	private double Vrms;
	private double Irms;
	private double angV;
	private double angI;
	private double valorPotenciaAtiva;
	private double valorPotenciaReativa;
	private double valorPotenciaAparente;
	private double valorDoFatorDePotencia;
	private List<Double> FormaDeOndaTensao; 
	private List<Double> FormaDeOndaCorrente;
	private List<Double> FormaDeOndaPotenciaInstantanea;
	private List<Double> t;
	
	private final double w = 2*Math.PI*60;
	
	public CalculosUC2(){
		double i = 0;
		FormaDeOndaTensao = new ArrayList<>();
		FormaDeOndaCorrente = new ArrayList<>();
		FormaDeOndaPotenciaInstantanea = new ArrayList<>();
		t = new ArrayList<>();
		while(i <= 10.f) {
			t.add(i);
			i += 0.1;
		}
	}
	@Override
	public void calcular() {
		setValorPotenciaAtiva();
		setValorPotenciaReativa();
		setValorPotenciaAparente();
		setValorDoFatorDePotencia();
		setFormaDeOndaTensao();
		setFormaDeOndaCorrente();
		setFormaDeOndaPotenciaInstantanea();
	}
	public double getVrms() {
		return Vrms;
	}
	public void setVrms(double vrms) throws InvalidParameterException{
		if(vrms >= 0 && vrms <= 220)
			Vrms = vrms;
		else
			throw new InvalidParameterException("O valor da amplitude da Tensão deve estar entre 0 e 220!");
	}
	public double getIrms() {
		return Irms;
	}
	public void setIrms(double irms) throws InvalidParameterException{
		if(irms >= 0 && irms <= 100)
			Irms = irms;
		else
			throw new InvalidParameterException("O valor da amplitude da corrente deve estar entre 0 e 100!");
	}
	public double getAngV() {
		return angV;
	}
	public void setAngV(double angV)  throws InvalidParameterException{
		if(angV >= -180 && angV <= 180)
			this.angV = angV;
		else
			throw new InvalidParameterException("O valor do angulo da corrente deve estar entre -180� e 180�!");
	}
	public double getAngI() {
		return angI;
	}
	public void setAngI(double angI)  throws InvalidParameterException{
		if(angI >= -180 && angI <= 180)
			this.angI = angI;
		else
			throw new InvalidParameterException("O valor do angulo da tens�o deve estar entre -180� e 180�!");
	}
	
	public double getValorPotenciaAtiva() {
		return valorPotenciaAtiva;
	}
	public double getValorPotenciaReativa() {
		return valorPotenciaReativa;
	}
	public double getValorPotenciaAparente() {
		return valorPotenciaAparente;
	}
	public double getValorDoFatorDePotencia() {
		return valorDoFatorDePotencia;
	}
	public List<Double> getFormaDeOndaPotenciaInstantanea() {
		return FormaDeOndaPotenciaInstantanea;
	}
	public List<Double> getFormaDeOndaCorrente() {
		return FormaDeOndaCorrente;
	}
	public List<Double> getFormaDeOndaTensao() {
		return FormaDeOndaTensao;
	}
	
	
	private void setValorPotenciaAtiva() {
		valorPotenciaAtiva = Vrms*Irms*Math.cos(Math.toRadians(angV)-Math.toRadians(angI));
	}
	private void setValorPotenciaReativa() {
		valorPotenciaReativa = Vrms*Irms*Math.sin(Math.toRadians(angV)-Math.toRadians(angI));
	}
	private void setValorPotenciaAparente() {
		valorPotenciaAparente = Vrms*Irms;
	}
	private void setValorDoFatorDePotencia() {
		valorDoFatorDePotencia = Math.cos(Math.toRadians(angV)-Math.toRadians(angI));
	}
	private void setFormaDeOndaTensao() {
		double valor;
		FormaDeOndaTensao.clear();
		for(int i = 0; i < t.size(); i++) {
			valor = Vrms*Math.cos(w*t.get(i)*Math.toRadians(angV));
			FormaDeOndaTensao.add(valor);
		}
	}
	private void setFormaDeOndaCorrente() {
		double valor;
		FormaDeOndaCorrente.clear();
		for(int i = 0; i < t.size(); i++) {
			valor = Irms*Math.cos(w*t.get(i)*Math.toRadians(angI));
			FormaDeOndaCorrente.add(valor);
		}
	}
	private void setFormaDeOndaPotenciaInstantanea() {
		double valor;
		FormaDeOndaPotenciaInstantanea.clear();
		for(int i = 0; i < FormaDeOndaCorrente.size(); i++) {
			valor = FormaDeOndaCorrente.get(i)*FormaDeOndaTensao.get(i);
			FormaDeOndaPotenciaInstantanea.add(valor);
		}
	}
	

}
