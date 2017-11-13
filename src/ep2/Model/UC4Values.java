package ep2.Model;

import java.util.ArrayList;
import java.util.List;

public class UC4Values {
	private double amplitudeTensao, anguloTensao, amplitudeCorrente, anguloCorrente, ordemHarmonicaCorrente, valorPotenciaLiquida, valorPotenciaDistorcao, fatorPotenciaVerdadeiro;
	private List<Double> formaDeOndaCorrente, formaDeOndaTensao, formaDeOndaPotHarmInst, t;
	
	public UC4Values() {
		double i = 0;
		amplitudeTensao = 0;
		amplitudeCorrente = 0;
		anguloCorrente = 0;
		ordemHarmonicaCorrente = 0;
		formaDeOndaCorrente = new ArrayList<>();
		formaDeOndaTensao = new ArrayList<>();
		formaDeOndaPotHarmInst = new ArrayList<>();
		t = new ArrayList<>();
		while(i <= 0.1) {
			t.add(i);
			i += 0.0005;
		}
	}

	public double getAmplitudeTensao() {
		return amplitudeTensao;
	}

	public void setAmplitudeTensao(double amplitudeTensao) {
		this.amplitudeTensao = amplitudeTensao;
	}

	public double getAnguloTensao() {
		return anguloTensao;
	}

	public void setAnguloTensao(double anguloTensao) {
		this.anguloTensao = anguloTensao;
	}

	public double getAmplitudeCorrente() {
		return amplitudeCorrente;
	}

	public void setAmplitudeCorrente(double amplitudeCorrente) {
		this.amplitudeCorrente = amplitudeCorrente;
	}

	public double getAnguloCorrente() {
		return anguloCorrente;
	}

	public void setAnguloCorrente(double anguloCorrente) {
		this.anguloCorrente = anguloCorrente;
	}

	public double getOrdemHarmonicaCorrente() {
		return ordemHarmonicaCorrente;
	}

	public void setOrdemHarmonicaCorrente(double ordemHarmonicaCorrente) {
		this.ordemHarmonicaCorrente = ordemHarmonicaCorrente;
	}

	public double getValorPotenciaLiquida() {
		return valorPotenciaLiquida;
	}

	public void setValorPotenciaLiquida(double valorPotenciaLiquida) {
		this.valorPotenciaLiquida = valorPotenciaLiquida;
	}

	public double getValorPotenciaDistorcao() {
		return valorPotenciaDistorcao;
	}

	public void setValorPotenciaDistorcao(double valorPotenciaDistorcao) {
		this.valorPotenciaDistorcao = valorPotenciaDistorcao;
	}

	public double getFatorPotenciaVerdadeiro() {
		return fatorPotenciaVerdadeiro;
	}

	public void setFatorPotenciaVerdadeiro(double fatorPotenciaVerdadeiro) {
		this.fatorPotenciaVerdadeiro = fatorPotenciaVerdadeiro;
	}

	public List<Double> getFormaDeOndaCorrente() {
		return formaDeOndaCorrente;
	}

	public void setFormaDeOndaCorrente(List<Double> formaDeOndaCorrente) {
		this.formaDeOndaCorrente = formaDeOndaCorrente;
	}

	public List<Double> getFormaDeOndaTensao() {
		return formaDeOndaTensao;
	}

	public void setFormaDeOndaTensao(List<Double> formaDeOndaTensao) {
		this.formaDeOndaTensao = formaDeOndaTensao;
	}

	public List<Double> getFormaDeOndaPotHarmInst() {
		return formaDeOndaPotHarmInst;
	}

	public void setFormaDeOndaPotHarmInst(List<Double> formaDeOndaPotHarmInst) {
		this.formaDeOndaPotHarmInst = formaDeOndaPotHarmInst;
	}

	public List<Double> getT() {
		return t;
	}

	public void setT(List<Double> t) {
		this.t = t;
	}
	
	
}
