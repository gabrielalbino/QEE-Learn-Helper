package ep2.Controller;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import ep2.Model.UC4Values;

public class CalculosUC4 implements Calcular {

	private final double w = 2*Math.PI*60;
	
	UC4Values vars;
	
	public CalculosUC4() {
		vars = new UC4Values();
	}
	
	@Override
	public void calcular() {
		setFormaDeOndaCorrente();
		setFormaDeOndaTensao();
		setFormaDeOndaPotHarmInst();
		setValorPotenciaLiquida();
		setValorPotenciaDistorcao();
		setFatorPotenciaVerdadeiro();
	}


	public double getAmplitudeTensao() {
		return vars.getAmplitudeTensao();
	}


	public void setAmplitudeTensao(double amplitudeTensao) throws InvalidParameterException {
		if(amplitudeTensao >= 0 && amplitudeTensao <= 220)
			vars.setAmplitudeTensao(amplitudeTensao);
		else{
			throw new InvalidParameterException("O valor da amplitude da tensão deve estar entre 0 e 220!");
		}
	}


	public double getAnguloTensao() {
		return vars.getAnguloTensao();
	}


	public void setAnguloTensao(double anguloTensao) throws InvalidParameterException {
		if(anguloTensao >= -180 && anguloTensao <= 180 )
			vars.setAnguloTensao(anguloTensao);
		else
			throw new InvalidParameterException("O angulo da tensão deve estar entre -180º e 180º!");
	}


	public double getAmplitudeCorrente() {
		return vars.getAmplitudeCorrente();
	}


	public void setAmplitudeCorrente(double amplitudeCorrente) throws InvalidParameterException {
		if(amplitudeCorrente >= 0&& amplitudeCorrente <= 100)
			vars.setAmplitudeCorrente(amplitudeCorrente);
		else
			throw new InvalidParameterException("O valor da amplitude da corrente deve estar entre 0 e 100!");
	}


	public double getAnguloCorrente() {
		return vars.getAnguloCorrente();
	}


	public void setAnguloCorrente(double anguloCorrente) throws InvalidParameterException {
		if(anguloCorrente >= -180 && anguloCorrente <= 180 )
			vars.setAnguloCorrente(anguloCorrente);
		else
			throw new InvalidParameterException("O angulo da corrente deve estar entre -180º e 180º!");
	}


	public double getOrdemHarmonicaCorrente() {
		return vars.getOrdemHarmonicaCorrente();
	}


	public void setOrdemHarmonicaCorrente(double ordemHarmonicaCorrente) throws InvalidParameterException{
		if(ordemHarmonicaCorrente >= 0 && ordemHarmonicaCorrente <= 15)
			vars.setOrdemHarmonicaCorrente(ordemHarmonicaCorrente);
		else
			throw new InvalidParameterException("O valor da Ordem Harmônica da corrente deve estar entre 0 e 15");
	}


	public List<Double> getFormaDeOndaCorrente() {
		return vars.getFormaDeOndaCorrente();
	}


	private void setFormaDeOndaCorrente() {
		double valor;
		List<Double> formaDeOndaCorrente = new ArrayList<>();
		formaDeOndaCorrente .clear();
		List<Double> t = vars.getT();
		for(int i = 0; i < t .size(); i++) {
			valor = vars.getAmplitudeCorrente()*Math.cos(vars.getOrdemHarmonicaCorrente()*w*t.get(i)+Math.toRadians(vars.getAnguloCorrente()));
			formaDeOndaCorrente.add(valor);
		}
		vars.setFormaDeOndaCorrente(formaDeOndaCorrente);
	}


	public List<Double> getFormaDeOndaTensao() {
		return vars.getFormaDeOndaTensao();
	}


	private void setFormaDeOndaTensao() {
		double valor;
		List<Double> formaDeOndaTensao = new ArrayList<>();
		formaDeOndaTensao .clear();
		List<Double> t = vars.getT();
		for(int i = 0; i < t .size(); i++) {
			valor = vars.getAmplitudeTensao()*Math.cos(w*t.get(i)+Math.toRadians(vars.getAnguloTensao()));
			formaDeOndaTensao.add(valor);
		}
		vars.setFormaDeOndaTensao(formaDeOndaTensao);
	}

	public List<Double> getFormaDeOndaPotHarmInst() {
		return vars.getFormaDeOndaPotHarmInst();
	}

	private void setFormaDeOndaPotHarmInst() {
		double valor;
		List<Double> formaDeOndaPotHarmInst = new ArrayList<>();
		formaDeOndaPotHarmInst .clear();
		for(int i = 0; i < vars.getFormaDeOndaTensao().size(); i++) {
			if( vars.getFormaDeOndaTensao().size() > i && vars.getFormaDeOndaCorrente().size() > i) {
				valor = vars.getFormaDeOndaTensao().get(i)*vars.getFormaDeOndaCorrente().get(i);
				formaDeOndaPotHarmInst.add(valor);
			}
		}
		vars.setFormaDeOndaPotHarmInst(formaDeOndaPotHarmInst);
	}

	public double getValorPotenciaLiquida() {
		return vars.getValorPotenciaLiquida();
	}

	private void setValorPotenciaLiquida() {
		vars.setValorPotenciaLiquida(0.0);
	}

	public double getValorPotenciaDistorcao() {
		return vars.getValorPotenciaDistorcao();
	}

	private void setValorPotenciaDistorcao() {
		vars.setValorPotenciaDistorcao(vars.getAmplitudeTensao()*vars.getAmplitudeCorrente());
	}

	public double getFatorPotenciaVerdadeiro() {
		return vars.getFatorPotenciaVerdadeiro();
	}

	private void setFatorPotenciaVerdadeiro() {
		vars.setFatorPotenciaVerdadeiro((vars.getAmplitudeTensao()*vars.getAmplitudeCorrente()*Math.cos(Math.toRadians(vars.getAnguloCorrente()+Math.toRadians(vars.getAnguloTensao()))))/vars.getAmplitudeTensao()*vars.getAmplitudeCorrente());
	}

}
