package ep2.Controller;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import ep2.Model.UC3Values;

public class CalculosUC3 implements Calcular{

	UC3Values vars;
	
	private final double w = 2*Math.PI*60;
	
	public CalculosUC3() {
		vars = new UC3Values();
	}
	
	@Override
	public void calcular() {
		setFormaDeOndaDaFundamental();
		setFormaDeOndaDaOrdemHarmonicaH1();
		setFormaDeOndaDaOrdemHarmonicaH2();
		setFormaDeOndaDaOrdemHarmonicaH3();
		setFormaDeOndaDaOrdemHarmonicaH4();
		setFormaDeOndaDaOrdemHarmonicaH5();
		setFormaDeOndaDaOrdemHarmonicaH6();
		setFormaDeOndaDistorcidaResultante();
	}

	public int getNroHarmonicos() {
		return vars.getNroHarmonicos();
	}

	public void setNroHarmonicos(int nroHarmonicos) {
		if(nroHarmonicos>= 0 && nroHarmonicos <= 6)
			vars.setNroHarmonicos(nroHarmonicos);
		else
			throw new InvalidParameterException("O número de harmonicos deve estar entre 0 e 6");
	}
	
	public double getVrms() {
		return vars.getVrms();
	}

	public void setVrms(double vrms) throws InvalidParameterException{
		if(vrms >= 0 && vrms <= 220)
			vars.setVrms(vrms);
		else
			throw new InvalidParameterException("A amplitude deve estar entre 0 e 220!");
	}

	public double getAngV() {
		return vars.getAngV();
	}

	public void setAngV(double angV) throws InvalidParameterException{
		if(angV >= -180 && angV <= 180)
			vars.setAngV(angV);
		else
			throw new InvalidParameterException("O ângulo deve estar entre -180º e 180º!");
	}

	public List<Double> getFormaDeOndaDaFundamental() {
		return vars.getFormaDeOndaDaFundamental();
	}

	private void setFormaDeOndaDaFundamental() {
		List<Double> FormaDeOndaDaFundamental = new ArrayList<>();
		FormaDeOndaDaFundamental .clear();
		List<Double> t = vars.getT();
		for(int i = 0; i < t .size(); i++)
			FormaDeOndaDaFundamental.add(vars.getVrms()*Math.cos(w*t.get(i)+Math.toRadians(vars.getAngV())));
		vars.setFormaDeOndaDaFundamental(FormaDeOndaDaFundamental);
	}

	private void setFormaDeOndaDaOrdemHarmonicaH1() {
		List<Double> FormaDeOndaDaOrdemHarmonicaH1 = new ArrayList<>();
		FormaDeOndaDaOrdemHarmonicaH1.clear();
		List<Double> t = vars.getT();
		FormaDeOndaDaOrdemHarmonicaH1.clear();
		int i;
		for(i = 0; i < t.size(); i++) {
				FormaDeOndaDaOrdemHarmonicaH1.add(vars.getVrmsh()[0]*Math.cos(vars.getOrdemHarmonica()[0]*w*t.get(i)+Math.toRadians(vars.getAngVh()[0])));
			}
		vars.setFormaDeOndaDaOrdemHarmonicaH1(FormaDeOndaDaOrdemHarmonicaH1);
		}
	public List<Double> getFormaDeOndaDaOrdemHarmonicaH1() {
		return vars.getFormaDeOndaDaOrdemHarmonicaH1();
	}
	public List<Double> getFormaDeOndaDaOrdemHarmonicaH2() {
		return vars.getFormaDeOndaDaOrdemHarmonicaH2();
	}

	public List<Double> getFormaDeOndaDaOrdemHarmonicaH3() {
		return vars.getFormaDeOndaDaOrdemHarmonicaH3();
	}

	public List<Double> getFormaDeOndaDaOrdemHarmonicaH4() {
		return vars.getFormaDeOndaDaOrdemHarmonicaH4();
	}

	public List<Double> getFormaDeOndaDaOrdemHarmonicaH5() {
		return vars.getFormaDeOndaDaOrdemHarmonicaH5();
	}

	public List<Double> getFormaDeOndaDaOrdemHarmonicaH6() {
		return vars.getFormaDeOndaDaOrdemHarmonicaH6();
	}

	private void setFormaDeOndaDaOrdemHarmonicaH6() {
		List<Double> FormaDeOndaDaOrdemHarmonicaH6= new ArrayList<>();
		FormaDeOndaDaOrdemHarmonicaH6.clear();
		int i;
		List<Double> t = vars.getT();
		for(i = 0; i < t .size(); i++) {
				FormaDeOndaDaOrdemHarmonicaH6.add(getVrmsh()[5]*Math.cos(getOrdemHarmonica()[5]*w*t.get(i)+Math.toRadians(getAngVh()[5])));
			}
		vars.setFormaDeOndaDaOrdemHarmonicaH6(FormaDeOndaDaOrdemHarmonicaH6);
		}

	private void setFormaDeOndaDaOrdemHarmonicaH5() {
		List<Double> FormaDeOndaDaOrdemHarmonicaH5= new ArrayList<>();
		FormaDeOndaDaOrdemHarmonicaH5.clear();
		int i;
		List<Double> t = vars.getT();
		for(i = 0; i < t.size(); i++) {
				FormaDeOndaDaOrdemHarmonicaH5.add(getVrmsh()[4]*Math.cos(getOrdemHarmonica()[4]*w*t.get(i)+Math.toRadians(getAngVh()[4])));
			}
		vars.setFormaDeOndaDaOrdemHarmonicaH5(FormaDeOndaDaOrdemHarmonicaH5);
		}

	private void setFormaDeOndaDaOrdemHarmonicaH4() {
		List<Double> FormaDeOndaDaOrdemHarmonicaH4= new ArrayList<>();
		FormaDeOndaDaOrdemHarmonicaH4.clear();
		int i;
		List<Double> t = vars.getT();
		for(i = 0; i < t.size(); i++) {
				FormaDeOndaDaOrdemHarmonicaH4.add(getVrmsh()[3]*Math.cos(getOrdemHarmonica()[3]*w*t.get(i)+Math.toRadians(getAngVh()[3])));
			}
		vars.setFormaDeOndaDaOrdemHarmonicaH4(FormaDeOndaDaOrdemHarmonicaH4);
		}

	private void setFormaDeOndaDaOrdemHarmonicaH3() {
		List<Double> FormaDeOndaDaOrdemHarmonicaH3= new ArrayList<>();
		FormaDeOndaDaOrdemHarmonicaH3.clear();
		int i;
		List<Double> t = vars.getT();
		for(i = 0; i < t.size(); i++) {
				FormaDeOndaDaOrdemHarmonicaH3.add(getVrmsh()[2]*Math.cos(getOrdemHarmonica()[2]*w*t.get(i)+Math.toRadians(getAngVh()[2])));
			}
		vars.setFormaDeOndaDaOrdemHarmonicaH3(FormaDeOndaDaOrdemHarmonicaH3);
		}

	private void setFormaDeOndaDaOrdemHarmonicaH2() {
		List<Double> FormaDeOndaDaOrdemHarmonicaH2= new ArrayList<>();
		FormaDeOndaDaOrdemHarmonicaH2.clear();
		int i;
		List<Double> t = vars.getT();
		for(i = 0; i < t.size(); i++) {
				FormaDeOndaDaOrdemHarmonicaH2.add(getVrmsh()[1]*Math.cos(getOrdemHarmonica()[1]*w*t.get(i)+Math.toRadians(getAngVh()[1])));
			}
		vars.setFormaDeOndaDaOrdemHarmonicaH2(FormaDeOndaDaOrdemHarmonicaH2);
		}

	public double[] getVrmsh() {
		return vars.getVrmsh();
	}

	public void setVrmsh(double vrmsh[]) {
		for(int i = 0; i < vars.getNroHarmonicos(); i++)
			if(vrmsh[i] >= 0 && vrmsh[i] <= 220)
				vars.getVrmsh()[i] = vrmsh[i];
			else
				throw new InvalidParameterException(String.format("A amplitude do harmônico %d deve estar entre 0 e 220!", i+1));
	}

	public double[] getAngVh() {
		return vars.getAngVh();
	}

	public void setAngVh(double angVh[]) {
		double AngVh[] = new double[6];
		for(int i = 0; i < vars.getNroHarmonicos(); i++)
			if(angVh[i] >= -180 && angVh[i] <= 180)
				AngVh[i] = angVh[i];
			else
				throw new InvalidParameterException(String.format("O ângulo do harmônico %d deve estar entre -180º e 180º!", i+1));
		vars.setAngVh(AngVh);
	}

	public int[] getOrdemHarmonica() {
		return vars.getOrdemHarmonica();
	}

	public void setOrdemHarmonica(int ordemHarmonica[]) {
		int[] OrdemHarmonica = new int[6];;
		for(int i = 0; i < vars.getNroHarmonicos(); i++) {
			if(vars.isPar() && (ordemHarmonica[i] % 2) != 0)
				throw new InvalidParameterException(String.format("A ordem harmônica do harmônico %d deve ser par!", i+1));
			if(!vars.isPar() && (ordemHarmonica[i] % 2) == 0)
				throw new InvalidParameterException(String.format("A ordem harmônica do harmônico %d deve ser impar!", i+1));
			if(ordemHarmonica[i] >= 0 && ordemHarmonica[i] <= 15)
				OrdemHarmonica[i] = ordemHarmonica[i];
			else
				throw new InvalidParameterException(String.format("A ordem harmônica do harmônico %d deve estar entre 0 e 15!", i+1));
		}
		vars.setOrdemHarmonica(OrdemHarmonica);
	}

	public boolean isPar() {
		return vars.isPar();
	}

	public void setPar(boolean isPar) {
		vars.setPar(isPar);
	}

	public List<Double> getFormaDeOndaDistorcidaResultante() {
		return vars.getFormaDeOndaDistorcidaResultante();
	}

	private void setFormaDeOndaDistorcidaResultante() {
		List<Double> FormaDeOndaDistorcidaResultante = new ArrayList<>();
		FormaDeOndaDistorcidaResultante.clear();
		double soma;
		List<Double> t = vars.getT();
		for(int i = 0; i < t .size(); i++) {
			soma = 0;
			if(vars.getFormaDeOndaDaFundamental().size() > i)
				soma += vars.getFormaDeOndaDaFundamental().get(i);
			if(vars.getFormaDeOndaDaOrdemHarmonicaH1().size() > 1)
				soma += getFormaDeOndaDaOrdemHarmonicaH1().get(i);
			if(getFormaDeOndaDaOrdemHarmonicaH2().size() > 1)
				soma += getFormaDeOndaDaOrdemHarmonicaH2().get(i);
			if(getFormaDeOndaDaOrdemHarmonicaH3().size() > 1)
				soma += getFormaDeOndaDaOrdemHarmonicaH3().get(i);
			if(getFormaDeOndaDaOrdemHarmonicaH4().size() > 1)
				soma += getFormaDeOndaDaOrdemHarmonicaH4().get(i);
			if(getFormaDeOndaDaOrdemHarmonicaH5().size() > 1)
				soma += getFormaDeOndaDaOrdemHarmonicaH5().get(i);
			if(getFormaDeOndaDaOrdemHarmonicaH6().size() > 1)
				soma += getFormaDeOndaDaOrdemHarmonicaH6().get(i);
			FormaDeOndaDistorcidaResultante.add(soma);
		}
		vars.setFormaDeOndaDistorcidaResultante(FormaDeOndaDistorcidaResultante);
	}

	
	
}
