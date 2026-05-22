import java.util.*;

public class Graph {

    private Map<Integer, List<Integer>> adjacencyList;

    private Map<Integer, List<Edge>> weightedAdjacencyList;

    public Graph() {

        adjacencyList = new HashMap<>();

        weightedAdjacencyList = new HashMap<>();
    }

    public void addVertex(Vertex v) {

        adjacencyList.putIfAbsent(v.getId(), new ArrayList<>());

        weightedAdjacencyList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {

        adjacencyList.putIfAbsent(from, new ArrayList<>());
        adjacencyList.putIfAbsent(to, new ArrayList<>());

        adjacencyList.get(from).add(to);
        adjacencyList.get(to).add(from);
    }

    // BONUS TASK
    public void addWeightedEdge(int from, int to, int weight) {

        weightedAdjacencyList.putIfAbsent(from, new ArrayList<>());
        weightedAdjacencyList.putIfAbsent(to, new ArrayList<>());

        Vertex source = new Vertex(from);

        Vertex destination = new Vertex(to);

        weightedAdjacencyList.get(from)
                .add(new Edge(source, destination, weight));

        weightedAdjacencyList.get(to)
                .add(new Edge(destination, source, weight));
    }

    public void printGraph() {

        for (Integer vertex : adjacencyList.keySet()) {

            System.out.println(vertex + " -> "
                    + adjacencyList.get(vertex));
        }
    }

    public void bfs(int start) {

        Set<Integer> visited = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);

        queue.add(start);

        System.out.print("BFS: ");

        while (!queue.isEmpty()) {

            int current = queue.poll();

            System.out.print(current + " ");

            for (int neighbor : adjacencyList.get(current)) {

                if (!visited.contains(neighbor)) {

                    visited.add(neighbor);

                    queue.add(neighbor);
                }
            }
        }

        System.out.println();
    }

    public void dfs(int start) {

        Set<Integer> visited = new HashSet<>();

        System.out.print("DFS: ");

        dfsRecursive(start, visited);

        System.out.println();
    }

    private void dfsRecursive(int current,
                              Set<Integer> visited) {

        visited.add(current);

        System.out.print(current + " ");

        for (int neighbor : adjacencyList.get(current)) {

            if (!visited.contains(neighbor)) {

                dfsRecursive(neighbor, visited);
            }
        }
    }

    // BONUS TASK
    public void dijkstra(int start) {

        Map<Integer, Integer> distances = new HashMap<>();

        Set<Integer> visited = new HashSet<>();

        for (Integer vertex
                : weightedAdjacencyList.keySet()) {

            distances.put(vertex, Integer.MAX_VALUE);
        }

        distances.put(start, 0);

        while (visited.size()
                < weightedAdjacencyList.size()) {

            int currentVertex = -1;

            int smallestDistance = Integer.MAX_VALUE;

            for (Integer vertex : distances.keySet()) {

                if (!visited.contains(vertex)
                        && distances.get(vertex)
                        < smallestDistance) {

                    smallestDistance = distances.get(vertex);

                    currentVertex = vertex;
                }
            }

            if (currentVertex == -1) {
                break;
            }

            visited.add(currentVertex);

            for (Edge edge
                    : weightedAdjacencyList.get(currentVertex)) {

                int neighbor =
                        edge.getDestination().getId();

                int weight = edge.getWeight();

                int newDistance =
                        distances.get(currentVertex) + weight;

                if (newDistance
                        < distances.get(neighbor)) {

                    distances.put(neighbor, newDistance);
                }
            }
        }

        System.out.println("\nDijkstra Result:");

        for (Integer vertex : distances.keySet()) {

            System.out.println(start + " -> "
                    + vertex
                    + " = "
                    + distances.get(vertex));
        }
    }
}