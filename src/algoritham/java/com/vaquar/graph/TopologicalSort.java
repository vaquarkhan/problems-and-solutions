package algoritham.java.com.vaquar.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * For a directed <B>acyclic graph</B>, do a topological sort on this graph.
 * This is same as DFS; only change is add stack.
 *  
 * Do DFS by keeping visited. Put the vertex which are completely explored into a stack.
 * Pop from stack to get sorted order.
 *
 * Space and time complexity is O(n).
 * 
 *
 */
public class TopologicalSort {

    public static void main(String args[]){
    	SimpleGraph<Integer> graph = new SimpleGraph<Integer>();
        graph.addEdge(1, 3, true);
        graph.addEdge(1, 2, true);
        graph.addEdge(3, 4, true);
        graph.addEdge(5, 6, true);
        graph.addEdge(6, 3, true);
        graph.addEdge(3, 8, true);
        graph.addEdge(8, 11, true);
        
        TopologicalSort g = new TopologicalSort();
        System.out.println(g.doTopologicalSort(graph));
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
	private <T> Stack<T> doTopologicalSort(SimpleGraph<T> graph) {
		Set<T> visited = new HashSet<T>();
		Stack<T> stack = new Stack();
		for(T vertexOuter : graph.getAllVertex()) {
			doTopologicalSortUtil(graph, vertexOuter, visited, stack);
		}
		return stack;
	}
	
	private <T> void doTopologicalSortUtil(SimpleGraph<T> graph, T vertex, Set<T> visited, Stack<T> stack) {
		if(!visited.add(vertex)) { //This is important Base condition
			return;
		}
		System.out.println("Node Visisted: "+ vertex);
		List<T> children = graph.getAdjacencyNodes(vertex);
		if(children == null) {
			stack.push(vertex);
			return;
		}
		for(T child : children) {
			doTopologicalSortUtil(graph, child, visited, stack);
		}
		stack.push(vertex);
	}
}
