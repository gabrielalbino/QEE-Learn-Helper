package ep2.Model;

import java.util.ArrayList;
import java.util.List;

public class UC2Values {
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
	
	public UC2Values() {
		double i = 0;
		FormaDeOndaTensao = new ArrayList<>();
		FormaDeOndaCorrente = new ArrayList<>();
		FormaDeOndaPotenciaInstantanea = new ArrayList<>();
		t = new ArrayList<>();
		while(i <= 0.1) {
			t.add(i);
			i += 0.0005;
		}
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
	}
	public double getAngI() {
		return angI;
	}
	public void setAngI(double angI) {
		this.angI = angI;
	}
	public double getValorPotenciaAtiva() {
		return valorPotenciaAtiva;
	}
	public void setValorPotenciaAtiva(double valorPotenciaAtiva) {
		this.valorPotenciaAtiva = valorPotenciaAtiva;
	}
	public double getValorPotenciaReativa() {
		return valorPotenciaReativa;
	}
	public void setValorPotenciaReativa(double valorPotenciaReativa) {
		this.valorPotenciaReativa = valorPotenciaReativa;
	}
	public double getValorPotenciaAparente() {
		return valorPotenciaAparente;
	}
	public void setValorPotenciaAparente(double valorPotenciaAparente) {
		this.valorPotenciaAparente = valorPotenciaAparente;
	}
	public double getValorDoFatorDePotencia() {
		return valorDoFatorDePotencia;
	}
	public void setValorDoFatorDePotencia(double valorDoFatorDePotencia) {
		this.valorDoFatorDePotencia = valorDoFatorDePotencia;
	}
	public List<Double> getFormaDeOndaTensao() {
		return FormaDeOndaTensao;
	}
	public void setFormaDeOndaTensao(List<Double> formaDeOndaTensao) {
		FormaDeOndaTensao = formaDeOndaTensao;
	}
	public List<Double> getFormaDeOndaCorrente() {
		return FormaDeOndaCorrente;
	}
	public void setFormaDeOndaCorrente(List<Double> formaDeOndaCorrente) {
		FormaDeOndaCorrente = formaDeOndaCorrente;
	}
	public List<Double> getFormaDeOndaPotenciaInstantanea() {
		return FormaDeOndaPotenciaInstantanea;
	}
	public void setFormaDeOndaPotenciaInstantanea(List<Double> formaDeOndaPotenciaInstantanea) {
		FormaDeOndaPotenciaInstantanea = formaDeOndaPotenciaInstantanea;
	}
	public List<Double> getT() {
		return t;
	}
	public void setT(List<Double> t) {
		this.t = t;
	}
	
}
