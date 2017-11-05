package ep2.Controller;

import java.util.List;

public abstract class Calculos implements CalcInterface {
	public static final double w = 2*Math.PI*60;
	@Override
	public List<Double> calculaL() {
		return null;
	}
	@Override
	public double calculaA() {
		return 0;
	}
	@Override
	public double calculaR() {
		return 0;
	}	
	public List<Double> calculaFOPI(List<Double> V, List<Double> I){
		return null;
	}
}
