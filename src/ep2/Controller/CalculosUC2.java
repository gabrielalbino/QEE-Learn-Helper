package ep2.Controller;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import ep2.Model.UC2Values;

public class CalculosUC2 implements Calcular {
	UC2Values vars;	
	private final double w = 2*Math.PI*60;
	
	public CalculosUC2(){
		vars = new UC2Values();
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
		return vars.getVrms();
	}
	public void setVrms(double vrms) throws InvalidParameterException{
		if(vrms >= 0 && vrms <= 220)
			vars.setVrms(vrms);
		else
			throw new InvalidParameterException("O valor da amplitude da Tensão deve estar entre 0 e 220!");
	}
	public double getIrms() {
		return vars.getIrms();
	}
	public void setIrms(double irms) throws InvalidParameterException{
		if(irms >= 0 && irms <= 100)
			vars.setIrms(irms);
		else
			throw new InvalidParameterException("O valor da amplitude da corrente deve estar entre 0 e 100!");
	}
	public double getAngV() {
		return vars.getAngV();
	}
	public void setAngV(double angV)  throws InvalidParameterException{
		if(angV >= -180 && angV <= 180)
			vars.setAngV(angV);
		else
			throw new InvalidParameterException("O valor do angulo da corrente deve estar entre -180� e 180�!");
	}
	public double getAngI() {
		return vars.getAngI();
	}
	public void setAngI(double angI)  throws InvalidParameterException{
		if(angI >= -180 && angI <= 180)
			vars.setAngI(angI);
		else
			throw new InvalidParameterException("O valor do angulo da tens�o deve estar entre -180� e 180�!");
	}
	
	public double getValorPotenciaAtiva() {
		return vars.getValorPotenciaAtiva();
	}
	public double getValorPotenciaReativa() {
		return vars.getValorPotenciaReativa();
	}
	public double getValorPotenciaAparente() {
		return vars.getValorPotenciaAparente();
	}
	public double getValorDoFatorDePotencia() {
		return vars.getValorDoFatorDePotencia();
	}
	public List<Double> getFormaDeOndaPotenciaInstantanea() {
		return vars.getFormaDeOndaPotenciaInstantanea();
	}
	public List<Double> getFormaDeOndaCorrente() {
		return vars.getFormaDeOndaCorrente();
	}
	public List<Double> getFormaDeOndaTensao() {
		return vars.getFormaDeOndaTensao();
	}
	
	
	private void setValorPotenciaAtiva() {
		vars.setValorPotenciaAtiva(vars.getVrms()*vars.getIrms()*Math.cos(Math.toRadians(vars.getAngV())-Math.toRadians(vars.getAngI())));
	}
	private void setValorPotenciaReativa() {
		vars.setValorPotenciaReativa(vars.getVrms()*vars.getIrms()*Math.sin(Math.toRadians(vars.getAngV())-Math.toRadians(vars.getAngI())));
	}
	private void setValorPotenciaAparente() {
		vars.setValorPotenciaAparente(vars.getVrms()*vars.getIrms());
	}
	private void setValorDoFatorDePotencia() {
		vars.setValorDoFatorDePotencia(Math.cos(Math.toRadians(vars.getAngV())-Math.toRadians(vars.getAngI())));
	}
	private void setFormaDeOndaTensao() {
		double valor;
		List<Double> FormaDeOndaTensao = new ArrayList<>();
		FormaDeOndaTensao .clear();
		List<Double> t = vars.getT();
		for(int i = 0; i < t.size(); i++) {
			valor = vars.getVrms()*Math.cos(w*t.get(i)+Math.toRadians(vars.getAngV()));
			FormaDeOndaTensao.add(valor);
		}
		vars.setFormaDeOndaTensao(FormaDeOndaTensao);
	}
	private void setFormaDeOndaCorrente() {
		double valor;
		List<Double> FormaDeOndaCorrente = new ArrayList<>();
		FormaDeOndaCorrente.clear();
		List<Double> t = vars.getT();
		for(int i = 0; i < t .size(); i++) {
			valor = vars.getIrms()*Math.cos(w*t.get(i)+Math.toRadians(vars.getAngI()));
			FormaDeOndaCorrente.add(valor);
		}
		vars.setFormaDeOndaCorrente(FormaDeOndaCorrente);
	}
	private void setFormaDeOndaPotenciaInstantanea() {
		double valor;
		List<Double> FormaDeOndaPotenciaInstantanea = new ArrayList<>();
		FormaDeOndaPotenciaInstantanea .clear();
		for(int i = 0; i < vars.getFormaDeOndaCorrente().size(); i++) {
			valor = vars.getFormaDeOndaCorrente().get(i)*vars.getFormaDeOndaTensao().get(i);
			FormaDeOndaPotenciaInstantanea.add(valor);
		}
		vars.setFormaDeOndaPotenciaInstantanea(FormaDeOndaPotenciaInstantanea);
	}
	

}
