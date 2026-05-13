Assignment 4: Graph Traversal and Representation System

Project Overview

This project demonstrates graph traversal algorithms using Java.

The graph is represented using an adjacency list structure.

Implemented algorithms:
Breadth-First Search (BFS)
Depth-First Search (DFS)

A graph consists of:
Vertices (nodes)
Edges (connections between nodes)

---

Graph Representation

The graph is stored using an adjacency list.

Example:

0 -> [1,2]
1 -> [0,3]
2 -> [0]
3 -> [1]

---

Class Descriptions

Vertex.java

Represents a graph vertex.

Edge.java

Represents a connection between two vertices.

Graph.java

Represents the graph structure using an adjacency list.

Main Methods
addVertex(Vertex v)
addEdge(int from, int to)
printGraph()
bfs(int start)
dfs(int start)

---

BFS Algorithm

Breadth-First Search explores the graph level by level.

Time Complexity

O(V + E)



DFS Algorithm

Depth-First Search explores as deeply as possible before backtracking.

Time Complexity

O(V + E)

---

Experimental Results

Graphs tested:
10 vertices
30 vertices
100 vertices

---

Reflection

This assignment improved understanding of graph traversal algorithms and adjacency lists.




