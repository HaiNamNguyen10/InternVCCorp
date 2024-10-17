package main;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PolarGraph polarGraph = new PolarGraph();
		Graph graph = new PolarGraphAdapter(polarGraph);
		
		graph.point(3,4);
	}

}
