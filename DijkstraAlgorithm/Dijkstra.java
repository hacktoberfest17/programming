package classes;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra {




    public static void main(String[] args) {

        int n = 5;

        int[][] matrixx =  {{0,6,3,7,0},
                            {6,0,0,0,0},
                            {3,0,0,2,0},
                            {7,0,2,0,1},
                            {0,0,0,1,0}
                            };

        List<Vertex> vertices = new ArrayList<>();

       for(int i = 0; i < n; i++){
           Vertex vertex = new Vertex(i);
           vertices.add(vertex);
       }

       List<Edge> edges = new ArrayList<>();

       for(int j = 0; j < n; j++){
           for(int k = 0; k < n; k++){
               if(matrixx[j][k] == 0)
                   continue;
               else{
                   Vertex start = vertices.get(j);
                   Vertex dest =  vertices.get(k);
                   edges.add(new Edge(start,dest,matrixx[j][k]));
               }
           }
       }

       for(Edge edge: edges){
           for(Vertex vertex: vertices){
               if(edge.startVertex == vertex){
                   vertex.addEdge(edge);
               }
           }
       }

        Graph graph = new Graph();
        graph.vertices = vertices;
        graph.calculateShortestPath(vertices.get(0));

        List<Vertex> vertices1 = graph.vertices;

        for(Vertex vertex : vertices1){
            System.out.println(vertex.path + vertex.getIndex());
        }

    }


}
