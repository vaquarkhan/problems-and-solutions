package algoritham.java.com.vaquar.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
 * http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/
 * 
 * Part of code is taken from Tushar git.
 * 
 */
public class GraphTraversal {

    public void DFS(Graph<Integer> graph){
        Set<Integer> visited = new HashSet<Integer>();
        for(GVertex<Integer> vertex : graph.getAllVertex()){
            if(!visited.contains(vertex.getId())){
                DFSUtil(vertex,visited);
            }
        }
    }
    
    private void DFSUtil(GVertex<Integer> v,Set<Integer> visited){
        visited.add(v.getId());
        System.out.print(v.getId() + " ");
        for(GVertex<Integer> vertex : v.getAdjacentVertexes()){
            if(!visited.contains(vertex.getId()))
                DFSUtil(vertex,visited);
        }
    }
    
//	public void BFS(Graph<Integer> graph) {
//		Set<Integer> visited = new HashSet<Integer>();
//		Queue<GVertex<Integer>> q = new LinkedList<GVertex<Integer>>();
//		for (GVertex<Integer> vertex : graph.getAllVertex()) {
//			if (!visited.contains(vertex.getId())) {
//				q.add(vertex);
//				visited.add(vertex.getId());
//				while (q.size() != 0) {
//					GVertex<Integer> vq = q.poll();
//					System.out.print(vq.getId() + " ");
//					for (GVertex<Integer> v : vq.getAdjacentVertexes()) {
//						if (!visited.contains(v.getId())) {
//							q.add(v);
//							visited.add(v.getId());
//						}
//					}
//				}
//			}
//		}
//	}
    
    
    public static void main(String args[]){
    	SimpleGraph<Integer> graph = new SimpleGraph<Integer>();
        graph.addEdge(1, 2, true);
        graph.addEdge(1, 3, true);
        graph.addEdge(2, 4, true);
        graph.addEdge(3, 4, true);
        graph.addEdge(4, 6, true);
        graph.addEdge(6, 5, true);
    //  graph.addEdge(5, 1);
        graph.addEdge(5,3, true);
        
        GraphTraversal g = new GraphTraversal();
        g.doBFSTraversal(graph);
        g.doDFSTraversal(graph);
	}

    
    
    /**
     * Note that DFS needs two methods, one is recursive.
     * This is needed we need to check all the nodes are traversed.
     * e.g) A ---> B <---- C
     *    
     *     A has children B, if i choose only A then only A and B will be counted.
     *     And C will be missed.
     *     So iterate through all the nodes, outer loop does this. 
     *   
     *  
     * @param graph
     */
	private <T> void doDFSTraversal(SimpleGraph<T> graph) {
		Set<T> visited = new HashSet<T>();
		for(T vertexOuter : graph.getAllVertex()) {
			doDFSTraversalUtil(graph, vertexOuter, visited);
		}
	}
	
	private <T> void doDFSTraversalUtil(SimpleGraph<T> graph, T vertex, Set<T> visited) {
		if(!visited.add(vertex)) { //This is important Base condition
			return;
		}
		System.out.println("Node Visisted: "+ vertex);
		List<T> children = graph.getAdjacencyNodes(vertex);
		if(children == null) { 
			//There is a possibility of node with no adjacent nodes in directed graph.
			// A --> B here B has no adjacent nodes.
			return;
		}
		for(T child : children) {
			doDFSTraversalUtil(graph, child, visited);
		}
	}
	

	
    /**
     * Note that BFS needs THREE loops.
     * 
     * @param graph
     */
	private void doBFSTraversal(SimpleGraph<Integer> graph) {
		Set<Integer> visited = new HashSet<Integer>();
		Queue<Integer> levelOrderQueue = new LinkedList<Integer>();
		
		for(Integer vertexOuter : graph.getAllVertex()) {
			levelOrderQueue.add(vertexOuter);
			while(!levelOrderQueue.isEmpty()){
				Integer vertex =  levelOrderQueue.poll();
				if(!visited.add(vertex)) { //This is important
					continue;
				}
				System.out.println("Node Visisted: "+ vertex);
				List<Integer> childrens = graph.getAdjacencyNodes(vertex);
				for(Integer child: childrens) {
					if(visited.contains(child)) {
						continue;
					}
					levelOrderQueue.offer(child);
				}
			}
		}
	}
}
