package ep2.Controller;

import java.util.ArrayList;
import java.util.List;

public class CalculaFormaOnda extends Calculos {
	private double 	V, Ang, angRad, t[];
	private List<Double> ft;
	
	public CalculaFormaOnda() {
		t = new double[101];
		for(int i = 0; i < 101; i++) {
			t[i] = 0.1*i;
		}
		ft = new ArrayList<>();
	}
	@Override
	public List<Double> calculaL() {
		for(int i = 0; i < 101; i++) {
			ft.add(V*Math.cos(Calculos.w*t[i]*angRad));
		}
		return ft;
	}
	@Override
	public List<Double> calculaFOPI(List<Double> V, List<Double> I){
		for(int i = 0; i < 101; i++) {
			ft.add(V.get(i)*I.get(i));
		}
		return ft;
	}
	
	public double getVrms() {
		return V;
	}

	public void setVrms(double vrms) {
		V = vrms;
	}

	public double getAng() {
		return Ang;
	}

	public void setAng(double ang) {
		Ang = ang;
		angRad = Ang*Math.PI/180.f;
	}
	
	
}
