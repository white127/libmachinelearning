package logistic;

import common.FeatureNode;
import common.Parameter;
import common.SolverType;


public class Classification {
	public static Classifier getInstance(Parameter param) {
		if (param.type == SolverType.L2R_CE_C)
			return new L2R_CE_C();
		if (param.type == SolverType.L1R_CE_C)
			return new L1R_CE_C();
		return null;
	}

	public static void predictProbability(Model model, FeatureNode[] x, double[] prob_estimate) {
		double fx = 0;
		double[] W = model.W;
		for (FeatureNode node : x)
			fx += (W[node.index] * node.value);
		prob_estimate[0] = fx;
	}
	
	public static double predict(Model model, FeatureNode[] x) {
		double fx = 0;
		double[] W = model.W;
		for (FeatureNode node : x)
			fx += (W[node.index] * node.value);
		return fx;
	}
}
