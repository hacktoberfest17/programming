package classes;

import java.util.ArrayList;
import java.util.List;

public class Vertex {


    private Integer index;
    private int distance;
    private List<Edge> edgeList = new ArrayList<>();
    public String path = "";
    public boolean visited;

    public Vertex(int index) {
        this.index = index;

    }

    public Integer getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setEdgeList(List<Edge> edgeList) {
        this.edgeList = edgeList;
    }
    public void addEdge(Edge edge){
        if(edge != null){
            edgeList.add(edge);
        }

    }

    @Override
    public String toString() {
        return index + ":" + distance;
    }
}
