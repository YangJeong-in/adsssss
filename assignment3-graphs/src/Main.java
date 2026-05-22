public class Main {

    public static void main(String[] args) {

        Experiment experiment = new Experiment();

        experiment.runMultipleTests();

        System.out.println("\n====================");
        System.out.println("DIJKSTRA TEST");
        System.out.println("====================");

        Graph graph = new Graph();

        for (int i = 0; i < 5; i++) {

            graph.addVertex(new Vertex(i));
        }

        graph.addWeightedEdge(0, 1, 4);

        graph.addWeightedEdge(0, 2, 1);

        graph.addWeightedEdge(2, 1, 2);

        graph.addWeightedEdge(1, 3, 1);

        graph.addWeightedEdge(2, 3, 5);

        graph.addWeightedEdge(3, 4, 3);

        graph.dijkstra(0);
    }
}