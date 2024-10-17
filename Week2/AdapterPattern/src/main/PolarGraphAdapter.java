package main;
import java.math.*;
public class PolarGraphAdapter implements Graph {
	
	private PolarGraph polarGraph;
	
	public PolarGraphAdapter(PolarGraph polarGraph) {
		this.polarGraph = polarGraph;
	}
	public void point(float x, float y) {
		double r = Math.sqrt(x*x+y*y);
		double theta = Math.atan2(y, x);
		
		polarGraph.point(r, theta);
	}
}
