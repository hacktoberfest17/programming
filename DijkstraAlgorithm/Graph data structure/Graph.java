package classes;

import java.util.*;

public class Graph {

    public List<Vertex> vertices;
    private static final int INFINITY = Integer.MAX_VALUE;

    public void calculateShortestPath(Vertex source) {

        List<Vertex> unVisited = new ArrayList<>(vertices);

        for (Vertex vertex : vertices) {
            vertex.setDistance(INFINITY);
        }

        source.setDistance(0);
        source.path += source.getIndex() + "-->";

        while(unVisited.size() > 0){
            Vertex currentVertex = minimalVertex(unVisited);
             List<Edge> edges = currentVertex.getEdgeList();

             for(Edge edge : edges){
                 if(unVisited.contains(edge.destinationVertex)){
                     if(edge.destinationVertex.getDistance() > currentVertex.getDistance() + edge.weight){
                         Vertex nextVertex = edge.destinationVertex;
                         nextVertex.setDistance(currentVertex.getDistance() + edge.weight);
                         nextVertex.path +=  currentVertex.getIndex() +"-->";
                     }
                 }
             }
             unVisited.remove(currentVertex);
        }
    }

    private Vertex minimalVertex(List<Vertex> vertices){
        Vertex minDist = vertices.get(0);

        for(Vertex vertex: vertices){
            if( vertex.getDistance() == 0 || vertex.getDistance() < minDist.getDistance()){
                minDist = vertex;
            }
        }

        return minDist;
    }

}


