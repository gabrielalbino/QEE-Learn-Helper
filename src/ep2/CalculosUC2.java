package ep2;

import java.lang.Math;

public class CalculosUC2 {
	private final double freqAng = 2*Math.PI*60;
	private int ampTensao, ampCorrente, angTensao, angCorrente;
	private double[] x;
	private double[] formaDeOndaTensao;
	private double[] formaDeOndaCorrente;
	private double[] formaDeOndaPotInst;
	private double valorPotAtiva;
	private double valorPotReativa;
	private double valorPotAparente;
	private double valorFatPotencia;
	
	public CalculosUC2(){
		double xTemp = 0;
		x = new double[101];
		formaDeOndaTensao = new double[101];
		formaDeOndaCorrente = new double[101];
		formaDeOndaPotInst = new double[101];
		for(int i = 0; i < 101; i++) {
			x[i] = xTemp;
			xTemp+=0.1;
		}
	}
	
	public double[] getFormaDeOndaTensao() {
		for(int i = 0; i < 101; i++) {
			formaDeOndaTensao[i] = ampTensao*Math.cos(freqAng*x[i]+angTensao);
		}
		return formaDeOndaTensao;
	}
	public double[] getFormaDeOndaCorrente() {
		for(int i = 0; i < 101; i++) {
			formaDeOndaCorrente[i] = ampCorrente*Math.cos(freqAng*x[i]+angCorrente);
		}
		return formaDeOndaCorrente;
	}
	public double[] getFormaDeOndaPotInst() {
		for(int i = 0; i < 101; i++) {
			formaDeOndaPotInst[i] = formaDeOndaTensao[i] * formaDeOndaCorrente[i];
		}
		return formaDeOndaPotInst;
	}
	public double getValorPotAtiva() {
		valorPotAtiva = ampTensao*ampCorrente*Math.cos(angTensao-angCorrente);
		return valorPotAtiva;
	}
	public double getValorPotReativa() {
		valorPotReativa = ampTensao*ampCorrente*Math.sin(angTensao-angCorrente);
		return valorPotReativa;
	}
	public double getValorPotAparente() {
		valorPotAparente = ampCorrente*ampTensao;
		return valorPotAparente;
	}
	public double getValorFatPotencia() {
		valorFatPotencia = Math.cos(angTensao-angCorrente);
		return valorFatPotencia;
	}
	public int getAmpTensao() {
		return ampTensao;
	}	
	public void setAmpTensao(int ampTensao) {
		if(ampTensao >= 0 && ampTensao <= 220)
			this.ampTensao = ampTensao;
		else
			throw new IllegalArgumentException();
	}
	public int getAmpCorrente() {
		return ampCorrente;
	}
	public void setAmpCorrente(int ampCorrente) {
		if(ampCorrente >= 0 && ampCorrente <= 100)
			this.ampCorrente = ampCorrente;
		else{
			throw new IllegalArgumentException();
		}
	}
	public int getAngTensao() {
		return angTensao;
	}
	public void setAngTensao(int angTensao) {
		if(angTensao >= -180 && angTensao <= 180)
			this.angTensao = angTensao;
		else
			throw new IllegalArgumentException();
	}
	public int getAngCorrente() {
		return angCorrente;
	}
	public void setAngCorrente(int angCorrente) {
		if(angCorrente >= -180 && angCorrente <= 180)
			this.angCorrente = angCorrente;
		else
			throw new IllegalArgumentException();
	}
	public void reCalcula() {
		
	}
	
}
