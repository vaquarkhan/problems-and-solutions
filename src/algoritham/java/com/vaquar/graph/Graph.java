package algoritham.java.com.vaquar.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Graph is going to hold Vertex List and Edge List.
 * To access the Vertex in O(1) time we are making the Vertex List is part of Map.
 * 
 * Basics should be learn from mycodeschool.
 * Then problems can be solved using Tushar
 * I took this code from Tushar githup.
 * 
 * Unlike Tree, there is no root node in graph
 * Node can be picked randomly.
 * 
 * 
 *
 * @param <T>
 */
public class Graph<T>{

    private List<GEdge<T>> allEdges;
    private Map<T, GVertex<T>> allVertex;
    boolean isDirected = false;
    
    public Graph(boolean isDirected){
        allEdges = new ArrayList<GEdge<T>>();
        allVertex = new HashMap<T,GVertex<T>>();
        this.isDirected = isDirected;
    }
    
    public void addEdge(T id1, T id2){
        addEdge(id1,id2,0);
    }
    
    //This works only for directed graph because for undirected graph we can end up
    //adding edges two times to allEdges
    public void addVertex(GVertex<T> vertex){
        if(allVertex.containsKey(vertex.getId())){
            return;
        }
        allVertex.put(vertex.getId(), vertex);
        for(GEdge<T> edge : vertex.getEdges()){
            allEdges.add(edge);
        }
    }
    
    public GVertex<T> addSingleVertex(T id){
        if(allVertex.containsKey(id)){
            return allVertex.get(id);
        }
        GVertex<T> v = new GVertex<T>(id);
        allVertex.put(id, v);
        return v;
    }
    
    public GVertex<T> getVertex(long id){
        return allVertex.get(id);
    }
    
    public void addEdge(T id1, T id2, int weight){
        GVertex<T> vertex1 = null;
        if(allVertex.containsKey(id1)){
            vertex1 = allVertex.get(id1);
        }else{
            vertex1 = new GVertex<T>(id1);
            allVertex.put(id1, vertex1);
        }
        GVertex<T> vertex2 = null;
        if(allVertex.containsKey(id2)){
            vertex2 = allVertex.get(id2);
        }else{
            vertex2 = new GVertex<T>(id2);
            allVertex.put(id2, vertex2);
        }

        GEdge<T> edge = new GEdge<T>(vertex1,vertex2,isDirected,weight);
        allEdges.add(edge);
        vertex1.addAdjacentVertex(edge, vertex2);
        if(!isDirected){
            vertex2.addAdjacentVertex(edge, vertex1);
        }

    }
    
    public List<GEdge<T>> getAllEdges(){
        return allEdges;
    }
    
    public Collection<GVertex<T>> getAllVertex(){
        return allVertex.values();
    }
    
    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        for(GEdge<T> edge : getAllEdges()){
            buffer.append(edge.getVertex1() + " " + edge.getVertex2() + " " + edge.getWeight());
            buffer.append("\n");
        }
        return buffer.toString();
    }
}






 