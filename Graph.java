package Lecture17_Graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

	ArrayList<Vertex> vertices;

	Graph() {
		vertices = new ArrayList<>();
	}

	public boolean addVertex(String name) {
		Vertex v = getVertex(name);
		if (v != null) {
			return false;
		}

		v = new Vertex(name);
		vertices.add(v);
		return true;
	}

	private Vertex getVertex(String name) {
		for (Vertex v : vertices) {
			if (v.name.equals(name)) {
				return v;
			}
		}
		return null;
	}

	public boolean addEdge(String name1, String name2) {
		Vertex v1 = getVertex(name1);
		Vertex v2 = getVertex(name2);
		if (v1 == null || v2 == null) {
			return false;
		}

		if (areAdjacent(name1, name2)) {
			return false;
		}

		Edge e = new Edge(v1, v2);
		v1.addEdge(e);
		v2.addEdge(e);
		return true;

	}

	public boolean removeEdge(String name1, String name2) {
		Vertex v1 = getVertex(name1);
		Vertex v2 = getVertex(name2);
		if (v1 == null || v2 == null) {
			return false;
		}

		if (!areAdjacent(name1, name2)) {
			return false;
		}

		v1.removeEdge(v2);
		v2.removeEdge(v1);
		return true;

	}

	public void removeVertex(String name) {
		Vertex v = getVertex(name);
		if (v == null) {
			return;
		}

		ArrayList<Vertex> list = v.getAdjacentVertices();
		for (Vertex currentVertex : list) {
			currentVertex.removeEdge(v);
		}
		vertices.remove(v);

	}

	public boolean havePath(String name1, String name2) {
		Vertex v1 = getVertex(name1);
		Vertex v2 = getVertex(name2);
		if (v1 == null || v2 == null) {
			System.out.println("City doesn't exist!");
			return false;
		}
		HashMap<Vertex, Boolean> map = new HashMap<>();
		map.put(v1, true);
		return helper(v1, v2, map);
	}

	private boolean helper(Vertex v1, Vertex v2, HashMap<Vertex, Boolean> map) {
		if (v1.isAdjacent(v2)) {
			return true;
		}
		ArrayList<Vertex> adjacentList = v1.getAdjacentVertices();
		for (Vertex v : adjacentList) {
			if (!map.containsKey(v)) {
				map.put(v, true);
				if (helper(v, v2, map)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean areAdjacent(String name1, String name2) {
		Vertex v1 = getVertex(name1);
		Vertex v2 = getVertex(name2);
		if (v1 == null || v2 == null) {
			return false;
		}
		return v1.isAdjacent(v2);
	}

	public void printGraph() {
		for (Vertex v : vertices) {
			v.print();
		}
	}
}
