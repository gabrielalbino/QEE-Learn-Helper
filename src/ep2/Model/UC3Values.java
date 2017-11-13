package ep2.Model;

import java.util.ArrayList;
import java.util.List;

public class UC3Values {
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
	
	public UC3Values() {
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
	
	public double getVrms() {
		return Vrms;
	}
	public void setVrms(double vrms) {
		Vrms = vrms;
	}
	public double getAngV() {
		return angV;
	}
	public void setAngV(double angV) {
		this.angV = angV;
	}
	public int getNroHarmonicos() {
		return nroHarmonicos;
	}
	public void setNroHarmonicos(int nroHarmonicos) {
		this.nroHarmonicos = nroHarmonicos;
	}
	public int[] getOrdemHarmonica() {
		return ordemHarmonica;
	}
	public void setOrdemHarmonica(int[] ordemHarmonica) {
		this.ordemHarmonica = ordemHarmonica;
	}
	public double[] getVrmsh() {
		return Vrmsh;
	}
	public void setVrmsh(double[] vrmsh) {
		Vrmsh = vrmsh;
	}
	public double[] getAngVh() {
		return angVh;
	}
	public void setAngVh(double[] angVh) {
		this.angVh = angVh;
	}
	public boolean isPar() {
		return isPar;
	}
	public void setPar(boolean isPar) {
		this.isPar = isPar;
	}
	public List<Double> getFormaDeOndaDaFundamental() {
		return FormaDeOndaDaFundamental;
	}
	public void setFormaDeOndaDaFundamental(List<Double> formaDeOndaDaFundamental) {
		FormaDeOndaDaFundamental = formaDeOndaDaFundamental;
	}
	public List<Double> getFormaDeOndaDaOrdemHarmonicaH1() {
		return FormaDeOndaDaOrdemHarmonicaH1;
	}
	public void setFormaDeOndaDaOrdemHarmonicaH1(List<Double> formaDeOndaDaOrdemHarmonicaH1) {
		FormaDeOndaDaOrdemHarmonicaH1 = formaDeOndaDaOrdemHarmonicaH1;
	}
	public List<Double> getFormaDeOndaDaOrdemHarmonicaH2() {
		return FormaDeOndaDaOrdemHarmonicaH2;
	}
	public void setFormaDeOndaDaOrdemHarmonicaH2(List<Double> formaDeOndaDaOrdemHarmonicaH2) {
		FormaDeOndaDaOrdemHarmonicaH2 = formaDeOndaDaOrdemHarmonicaH2;
	}
	public List<Double> getFormaDeOndaDaOrdemHarmonicaH3() {
		return FormaDeOndaDaOrdemHarmonicaH3;
	}
	public void setFormaDeOndaDaOrdemHarmonicaH3(List<Double> formaDeOndaDaOrdemHarmonicaH3) {
		FormaDeOndaDaOrdemHarmonicaH3 = formaDeOndaDaOrdemHarmonicaH3;
	}
	public List<Double> getFormaDeOndaDaOrdemHarmonicaH4() {
		return FormaDeOndaDaOrdemHarmonicaH4;
	}
	public void setFormaDeOndaDaOrdemHarmonicaH4(List<Double> formaDeOndaDaOrdemHarmonicaH4) {
		FormaDeOndaDaOrdemHarmonicaH4 = formaDeOndaDaOrdemHarmonicaH4;
	}
	public List<Double> getFormaDeOndaDaOrdemHarmonicaH5() {
		return FormaDeOndaDaOrdemHarmonicaH5;
	}
	public void setFormaDeOndaDaOrdemHarmonicaH5(List<Double> formaDeOndaDaOrdemHarmonicaH5) {
		FormaDeOndaDaOrdemHarmonicaH5 = formaDeOndaDaOrdemHarmonicaH5;
	}
	public List<Double> getFormaDeOndaDaOrdemHarmonicaH6() {
		return FormaDeOndaDaOrdemHarmonicaH6;
	}
	public void setFormaDeOndaDaOrdemHarmonicaH6(List<Double> formaDeOndaDaOrdemHarmonicaH6) {
		FormaDeOndaDaOrdemHarmonicaH6 = formaDeOndaDaOrdemHarmonicaH6;
	}
	public List<Double> getFormaDeOndaDistorcidaResultante() {
		return FormaDeOndaDistorcidaResultante;
	}
	public void setFormaDeOndaDistorcidaResultante(List<Double> formaDeOndaDistorcidaResultante) {
		FormaDeOndaDistorcidaResultante = formaDeOndaDistorcidaResultante;
	}
	public List<Double> getT() {
		return t;
	}
	public void setT(List<Double> t) {
		this.t = t;
	}
	
	
}
