package Lecture17_Graphs;

import java.util.ArrayList;

public class Vertex {
	String name;
	ArrayList<Edge> edges;

	Vertex(String name) {
		this.name = name;
		this.edges = new ArrayList<>();
	}

	boolean isAdjacent(Vertex v) {
		for (Edge e : edges) {
			if (e.first.name.equals(v.name) || e.second.name.equals(v.name)) {
				return true;
			}
		}
		return false;
	}

	void addEdge(Edge e) {
		this.edges.add(e);
	}

	boolean removeEdge(Vertex v) {
		for (int i = 0; i < edges.size(); i++) {
			// if (edges.get(i).first == v || edges.get(i).second == v) {
			// edges.remove(i);
			// break;
			// }
			// or
			if (edges.get(i).first.name.equals(v.name) || edges.get(i).second.equals(v.name)) {
				edges.remove(i);
				return true;
			}
		}
		return false;

	}

	ArrayList<Vertex> getAdjacentVertices() {

		ArrayList<Vertex> list = new ArrayList<>();
		for (int i = 0; i < this.edges.size(); i++) {
			if (edges.get(i).first.equals(this)) {
				list.add(this.edges.get(i).second);
			}
			if (edges.get(i).second.equals(this)) {
				list.add(this.edges.get(i).first);
			}
		}
		return list;
	}

	void print() {
		StringBuilder toBePrinted = new StringBuilder("");
		toBePrinted.append(name).append(" : ");
		for (Edge e : edges) {
			if (e.first == this) {
				toBePrinted.append(e.second.name).append(" , ");
			} else {
				toBePrinted.append(e.first.name).append(" , ");
			}
		}
		System.out.println(toBePrinted);
	}
}
