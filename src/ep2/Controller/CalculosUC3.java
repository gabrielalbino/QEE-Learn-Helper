package ep2.Controller;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class CalculosUC3 implements Calcular{
	private double Vrms;
	private double angV;
	private int nroHarmonicos;
	private int ordemHarmonica[];
	private double Vrmsh[];
	private double angVh[];
	private boolean isPar;
	
	private List<Double> FormaDeOndaDaFundamental;
	private List<Double> FormaDeOndaDaOrdemHarmonicaH1;
	private List<Double> FormaDeOndaDaOrdemHarmonicaH2;
	private List<Double> FormaDeOndaDaOrdemHarmonicaH3;
	private List<Double> FormaDeOndaDaOrdemHarmonicaH4;
	private List<Double> FormaDeOndaDaOrdemHarmonicaH5;
	private List<Double> FormaDeOndaDaOrdemHarmonicaH6;
	private List<Double> FormaDeOndaDistorcidaResultante;
	private List<Double> t;
	
	private final double w = 2*Math.PI*60;
	
	public CalculosUC3() {
		double i = 0;
		FormaDeOndaDaFundamental = new ArrayList<>();
		FormaDeOndaDaOrdemHarmonicaH1 = new ArrayList<>();
		FormaDeOndaDaOrdemHarmonicaH2=new ArrayList<>();
		FormaDeOndaDaOrdemHarmonicaH3=new ArrayList<>();
		FormaDeOndaDaOrdemHarmonicaH4=new ArrayList<>();
		FormaDeOndaDaOrdemHarmonicaH5=new ArrayList<>();
		FormaDeOndaDaOrdemHarmonicaH6=new ArrayList<>();
		FormaDeOndaDistorcidaResultante = new ArrayList<>();
		Vrmsh = new double[6];
		angVh = new double[6];
		ordemHarmonica = new int[6];
		t = new ArrayList<>();
		while(i <= 0.1) {
			t.add(i);
			i += 0.0005;
		}
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
		return nroHarmonicos;
	}

	public void setNroHarmonicos(int nroHarmonicos) {
		if(nroHarmonicos>= 0 && nroHarmonicos <= 6)
			this.nroHarmonicos = nroHarmonicos;
		else
			throw new InvalidParameterException("O número de harmonicos deve estar entre 0 e 6");
	}
	
	public double getVrms() {
		return Vrms;
	}

	public void setVrms(double vrms) throws InvalidParameterException{
		if(vrms >= 0 && vrms <= 220)
			Vrms = vrms;
		else
			throw new InvalidParameterException("A amplitude deve estar entre 0 e 220!");
	}

	public double getAngV() {
		return angV;
	}

	public void setAngV(double angV) throws InvalidParameterException{
		if(angV >= -180 && angV <= 180)
			this.angV = angV;
		else
			throw new InvalidParameterException("O ângulo deve estar entre -180º e 180º!");
	}

	public List<Double> getFormaDeOndaDaFundamental() {
		return FormaDeOndaDaFundamental;
	}

	private void setFormaDeOndaDaFundamental() {
		FormaDeOndaDaFundamental.clear();
		for(int i = 0; i < t.size(); i++)
			FormaDeOndaDaFundamental.add(Vrms*Math.cos(w*t.get(i)+Math.toRadians(angV)));
	}

	private void setFormaDeOndaDaOrdemHarmonicaH1() {
		FormaDeOndaDaOrdemHarmonicaH1.clear();
		int i;
		for(i = 0; i < t.size(); i++) {
				FormaDeOndaDaOrdemHarmonicaH1.add(Vrmsh[0]*Math.cos(ordemHarmonica[0]*w*t.get(i)+Math.toRadians(angVh[0])));
			}
		}
	public List<Double> getFormaDeOndaDaOrdemHarmonicaH1() {
		return FormaDeOndaDaOrdemHarmonicaH1;
	}
	public List<Double> getFormaDeOndaDaOrdemHarmonicaH2() {
		return FormaDeOndaDaOrdemHarmonicaH2;
	}

	public List<Double> getFormaDeOndaDaOrdemHarmonicaH3() {
		return FormaDeOndaDaOrdemHarmonicaH3;
	}

	public List<Double> getFormaDeOndaDaOrdemHarmonicaH4() {
		return FormaDeOndaDaOrdemHarmonicaH4;
	}

	public List<Double> getFormaDeOndaDaOrdemHarmonicaH5() {
		return FormaDeOndaDaOrdemHarmonicaH5;
	}

	public List<Double> getFormaDeOndaDaOrdemHarmonicaH6() {
		return FormaDeOndaDaOrdemHarmonicaH6;
	}

	private void setFormaDeOndaDaOrdemHarmonicaH6() {
		FormaDeOndaDaOrdemHarmonicaH6.clear();
		int i;
		for(i = 0; i < t.size(); i++) {
				FormaDeOndaDaOrdemHarmonicaH6.add(Vrmsh[5]*Math.cos(ordemHarmonica[5]*w*t.get(i)+Math.toRadians(angVh[5])));
			}
		}

	private void setFormaDeOndaDaOrdemHarmonicaH5() {
		FormaDeOndaDaOrdemHarmonicaH5.clear();
		int i;
		for(i = 0; i < t.size(); i++) {
				FormaDeOndaDaOrdemHarmonicaH5.add(Vrmsh[4]*Math.cos(ordemHarmonica[4]*w*t.get(i)+Math.toRadians(angVh[4])));
			}
		}

	private void setFormaDeOndaDaOrdemHarmonicaH4() {
		FormaDeOndaDaOrdemHarmonicaH4.clear();
		int i;
		for(i = 0; i < t.size(); i++) {
				FormaDeOndaDaOrdemHarmonicaH4.add(Vrmsh[3]*Math.cos(ordemHarmonica[3]*w*t.get(i)+Math.toRadians(angVh[3])));
			}
		}

	private void setFormaDeOndaDaOrdemHarmonicaH3() {
		FormaDeOndaDaOrdemHarmonicaH3.clear();
		int i;
		for(i = 0; i < t.size(); i++) {
				FormaDeOndaDaOrdemHarmonicaH3.add(Vrmsh[2]*Math.cos(ordemHarmonica[2]*w*t.get(i)+Math.toRadians(angVh[2])));
			}
		}

	private void setFormaDeOndaDaOrdemHarmonicaH2() {
		FormaDeOndaDaOrdemHarmonicaH2.clear();
		int i;
		for(i = 0; i < t.size(); i++) {
				FormaDeOndaDaOrdemHarmonicaH2.add(Vrmsh[1]*Math.cos(ordemHarmonica[1]*w*t.get(i)+Math.toRadians(angVh[1])));
			}
		}

	public double[] getVrmsh() {
		return Vrmsh;
	}

	public void setVrmsh(double vrmsh[]) {
		for(int i = 0; i < nroHarmonicos; i++)
			if(vrmsh[i] >= 0 && vrmsh[i] <= 220)
				Vrmsh[i] = vrmsh[i];
			else
				throw new InvalidParameterException(String.format("A amplitude do harmônico %d deve estar entre 0 e 220!", i+1));
	}

	public double[] getAngVh() {
		return angVh;
	}

	public void setAngVh(double angVh[]) {
		for(int i = 0; i < nroHarmonicos; i++)
			if(angVh[i] >= -180 && angVh[i] <= 180)
				this.angVh[i] = angVh[i];
			else
				throw new InvalidParameterException(String.format("O ângulo do harmônico %d deve estar entre -180º e 180º!", i+1));
		
	}

	public int[] getOrdemHarmonica() {
		return ordemHarmonica;
	}

	public void setOrdemHarmonica(int ordemHarmonica[]) {
		for(int i = 0; i < nroHarmonicos; i++) {
			if(isPar && (ordemHarmonica[i] % 2) != 0)
				throw new InvalidParameterException(String.format("A ordem harmônica do harmônico %d deve ser par!", i+1));
			if(!isPar && (ordemHarmonica[i] % 2) == 0)
				throw new InvalidParameterException(String.format("A ordem harmônica do harmônico %d deve ser impar!", i+1));
			if(ordemHarmonica[i] >= 0 && ordemHarmonica[i] <= 15)
				this.ordemHarmonica[i] = ordemHarmonica[i];
			else
				throw new InvalidParameterException(String.format("A ordem harmônica do harmônico %d deve estar entre 0 e 15!", i+1));
		}
		
	}

	public boolean isPar() {
		return isPar;
	}

	public void setPar(boolean isPar) {
		this.isPar = isPar;
	}

	public List<Double> getFormaDeOndaDistorcidaResultante() {
		return FormaDeOndaDistorcidaResultante;
	}

	private void setFormaDeOndaDistorcidaResultante() {
		FormaDeOndaDistorcidaResultante.clear();
		double soma;
		for(int i = 0; i < t.size(); i++) {
			soma = 0;
			if(FormaDeOndaDaFundamental.size() > i)
				soma += FormaDeOndaDaFundamental.get(i);
			if(FormaDeOndaDaOrdemHarmonicaH1.size() > 1)
				soma += FormaDeOndaDaOrdemHarmonicaH1.get(i);
			if(FormaDeOndaDaOrdemHarmonicaH2.size() > 1)
				soma += FormaDeOndaDaOrdemHarmonicaH2.get(i);
			if(FormaDeOndaDaOrdemHarmonicaH3.size() > 1)
				soma += FormaDeOndaDaOrdemHarmonicaH3.get(i);
			if(FormaDeOndaDaOrdemHarmonicaH4.size() > 1)
				soma += FormaDeOndaDaOrdemHarmonicaH4.get(i);
			if(FormaDeOndaDaOrdemHarmonicaH5.size() > 1)
				soma += FormaDeOndaDaOrdemHarmonicaH5.get(i);
			if(FormaDeOndaDaOrdemHarmonicaH6.size() > 1)
				soma += FormaDeOndaDaOrdemHarmonicaH6.get(i);
			FormaDeOndaDistorcidaResultante.add(soma);
		}
	}

	
	
}
