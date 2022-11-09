package classes;

public class Edge {

    public Vertex startVertex;
    public Vertex destinationVertex;

    public int weight;

    public Edge(Vertex startVertex, Vertex destinationVertex, int weight) {
        this.startVertex = startVertex;
        this.destinationVertex = destinationVertex;
        this.weight = weight;
    }
}
