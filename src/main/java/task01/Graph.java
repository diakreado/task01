package task01;


import java.util.Set;

public interface Graph {

    interface Vertex {

        String getName();
    }

    Set<Vertex> getVertices();
    Set<Vertex> getNeighbors(Vertex v);
}
