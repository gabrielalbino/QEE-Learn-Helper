package ep2.Controller;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class CalculosUC4 implements Calcular {
	private double amplitudeTensao, anguloTensao, amplitudeCorrente, anguloCorrente, ordemHarmonicaCorrente;
	private List<Double> formaDeOndaCorrente, formaDeOndaTensao, formaDeOndaPotHarmInst, t;
	
	private final double w = 2*Math.PI*60;
	
	public CalculosUC4() {
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
	
	@Override
	public void calcular() {
		setFormaDeOndaCorrente();
		setFormaDeOndaTensao();
		setFormaDeOndaPotHarmInst();
	}


	public double getAmplitudeTensao() {
		return amplitudeTensao;
	}


	public void setAmplitudeTensao(double amplitudeTensao) throws InvalidParameterException {
		if(amplitudeTensao >= 0 && amplitudeTensao <= 220)
			this.amplitudeTensao = amplitudeTensao;
		else{
			throw new InvalidParameterException("O valor da amplitude da tensão deve estar entre 0 e 220!");
		}
	}


	public double getAnguloTensao() {
		return anguloTensao;
	}


	public void setAnguloTensao(double anguloTensao) throws InvalidParameterException {
		if(anguloTensao >= -180 && anguloTensao <= 180 )
			this.anguloTensao = anguloTensao;
		else
			throw new InvalidParameterException("O angulo da tensão deve estar entre -180º e 180º!");
	}


	public double getAmplitudeCorrente() {
		return amplitudeCorrente;
	}


	public void setAmplitudeCorrente(double amplitudeCorrente) throws InvalidParameterException {
		if(amplitudeCorrente >= 0&& amplitudeCorrente <= 100)
			this.amplitudeCorrente = amplitudeCorrente;
		else
			throw new InvalidParameterException("O valor da amplitude da corrente deve estar entre 0 e 100!");
	}


	public double getAnguloCorrente() {
		return anguloCorrente;
	}


	public void setAnguloCorrente(double anguloCorrente) throws InvalidParameterException {
		if(anguloCorrente >= -180 && anguloCorrente <= 180 )
			this.anguloCorrente = anguloCorrente;
		else
			throw new InvalidParameterException("O angulo da corrente deve estar entre -180º e 180º!");
	}


	public double getOrdemHarmonicaCorrente() {
		return ordemHarmonicaCorrente;
	}


	public void setOrdemHarmonicaCorrente(double ordemHarmonicaCorrente) throws InvalidParameterException{
		if(ordemHarmonicaCorrente >= 0 && ordemHarmonicaCorrente <= 15)
			this.ordemHarmonicaCorrente = ordemHarmonicaCorrente;
		else
			throw new InvalidParameterException("O valor da Ordem Harmônica da corrente deve estar entre 0 e 15");
	}


	public List<Double> getFormaDeOndaCorrente() {
		return formaDeOndaCorrente;
	}


	private void setFormaDeOndaCorrente() {
		double valor;
		formaDeOndaCorrente.clear();
		for(int i = 0; i < t.size(); i++) {
			valor = amplitudeCorrente*Math.cos(ordemHarmonicaCorrente*w*t.get(i)+Math.toRadians(anguloCorrente));
			formaDeOndaCorrente.add(valor);
		}
	}


	public List<Double> getFormaDeOndaTensao() {
		return formaDeOndaTensao;
	}


	private void setFormaDeOndaTensao() {
		double valor;
		formaDeOndaTensao.clear();
		for(int i = 0; i < t.size(); i++) {
			valor = amplitudeTensao*Math.cos(w*t.get(i)+Math.toRadians(anguloTensao));
			formaDeOndaTensao.add(valor);
		}
	}

	public List<Double> getFormaDeOndaPotHarmInst() {
		return formaDeOndaPotHarmInst;
	}

	private void setFormaDeOndaPotHarmInst() {
		double valor;
		formaDeOndaPotHarmInst.clear();
		for(int i = 0; i < formaDeOndaTensao.size(); i++) {
			if(formaDeOndaTensao.size() > i && formaDeOndaCorrente.size() > i) {
				valor = formaDeOndaTensao.get(i)*formaDeOndaCorrente.get(i);
				formaDeOndaPotHarmInst.add(valor);
			}
		}
	}

}
