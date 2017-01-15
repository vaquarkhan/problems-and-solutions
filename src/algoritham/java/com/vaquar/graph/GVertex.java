package algoritham.java.com.vaquar.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Ideally the Vertex will be holding only ID.
 * To simplify working on Graph; we are also adding 
 * the List of edges and adjacentVertices into here.
 * 
 * 
 * 
 *
 * @param <T>
 */
public class GVertex<T> {
    T id;
    private List<GEdge<T>> edges = new ArrayList<>();
    private List<GVertex<T>> adjacentVertex = new ArrayList<>();
    
    GVertex(T id){
        this.id = id;
    }
    
    public T getId(){
        return id;
    }

    public void addAdjacentVertex(GEdge<T> e, GVertex<T> v){
        edges.add(e);
        adjacentVertex.add(v);
    }
    
    public String toString(){
        return String.valueOf(id);
    }
    
    public List<GVertex<T>> getAdjacentVertexes(){
        return adjacentVertex;
    }
    
    public List<GEdge<T>> getEdges(){
        return edges;
    }
    
    public int getDegree(){
        return edges.size();
    }
    
    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GVertex other = (GVertex) obj;
        if (id != other.id)
            return false;
        return true;
    }
}