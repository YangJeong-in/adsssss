import java.util.Random;

public class Experiment {

    public void runTraversals(Graph g) {

        // BFS timing
        long startBFS = System.nanoTime();

        g.bfs(0);

        long endBFS = System.nanoTime();

        // DFS timing
        long startDFS = System.nanoTime();

        g.dfs(0);

        long endDFS = System.nanoTime();

        // Print execution times
        System.out.println("BFS Execution Time: " + (endBFS - startBFS) + " ns");

        System.out.println("DFS Execution Time: " + (endDFS - startDFS) + " ns");
    }

    public void runMultipleTests() {

        // Graph sizes
        int[] sizes = {10, 30, 100};

        // Random object
        Random random = new Random();

        for (int size : sizes) {

            System.out.println("\n==============================");
            System.out.println("Testing graph with " + size + " vertices");
            System.out.println("==============================");

            Graph graph = new Graph();

            // Create vertices
            for (int i = 0; i < size; i++) {

                graph.addVertex(new Vertex(i));
            }

            /*
             STEP 1:
             Create a connected chain first

             0 - 1 - 2 - 3 ...

             This guarantees that all vertices
             are reachable.
            */

            for (int i = 0; i < size - 1; i++) {

                graph.addEdge(i, i + 1);
            }

            /*
             STEP 2:
             Add random edges

             Makes graph more realistic
            */

            int randomEdges = size * 2;

            for (int i = 0; i < randomEdges; i++) {

                int from = random.nextInt(size);

                int to = random.nextInt(size);

                // Avoid self-loops
                if (from != to) {

                    graph.addEdge(from, to);
                }
            }

            /*
             Print graph only for small graph
             Otherwise output becomes huge
            */

            if (size == 10) {

                System.out.println("\nGraph Structure:");

                graph.printGraph();
            }

            // Run BFS and DFS
            System.out.println();

            runTraversals(graph);
        }
    }

    public void printResults() {

        System.out.println("\n==============================");
        System.out.println("All experiments completed.");
        System.out.println("==============================");
    }
}