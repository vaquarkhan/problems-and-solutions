package algoritham.java.com.vaquar.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SimpleGraph<T> {
	private Set<T> vertexSet; //Should be set Important
	private Map<T, List<T>> mapVertexAndAdjacencyNodes;
	
	public SimpleGraph() {
		vertexSet = new HashSet<T>();
		mapVertexAndAdjacencyNodes = new HashMap<T, List<T>>();
	}
	
	public List<T> getAdjacencyNodes(T vertex){
		return mapVertexAndAdjacencyNodes.get(vertex);
	}
	
	public Set<T> getAllVertex(){
		return vertexSet;
	}
	
	public void addEdge(T source, T destination, boolean isDirected) {
		vertexSet.add(source);
		List<T> adjacencyNodes = mapVertexAndAdjacencyNodes.get(source);
		if(adjacencyNodes == null) {
			adjacencyNodes = new LinkedList<T>();
			mapVertexAndAdjacencyNodes.put(source, adjacencyNodes); // This is important
		}
		adjacencyNodes.add(destination);
		if(!isDirected) {
			vertexSet.add(destination);
			 adjacencyNodes = mapVertexAndAdjacencyNodes.get(destination);
			if(adjacencyNodes == null) {
				adjacencyNodes = new LinkedList<T>();
				mapVertexAndAdjacencyNodes.put(source, adjacencyNodes);
			}
			adjacencyNodes.add(source);
		}
	}
}
