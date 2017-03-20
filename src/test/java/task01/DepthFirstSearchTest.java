package task01;

import org.junit.Test;

import java.util.*;

import static task01.DepthFirstSearch.dfs;
import static org.junit.Assert.*;


public class DepthFirstSearchTest {

    class VertexTest implements Graph.Vertex{

        private String name;

        VertexTest(String name) {

            this.name = name;
        }

        public String getName() {
            return name;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            VertexTest that = (VertexTest) o;

            return name != null ? name.equals(that.name) : that.name == null;
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }
    }

    class GraphTest implements Graph {

        private Set<Vertex> vertices;
        private Map<Vertex, Set<Vertex>> verticesNeighbors;

        GraphTest() {

            Vertex vertex1 = new VertexTest("A");
            Vertex vertex2 = new VertexTest("B");
            Vertex vertex3 = new VertexTest("C");
            Vertex vertex4 = new VertexTest("D");
            Vertex vertex5 = new VertexTest("E");
            Vertex vertex6 = new VertexTest("F");


            vertices = new HashSet<Vertex>();
            vertices.add(vertex1);
            vertices.add(vertex2);
            vertices.add(vertex3);
            vertices.add(vertex4);
            vertices.add(vertex5);
            vertices.add(vertex6);

            Set<Vertex> neighborsOfVertex1 = new HashSet<Vertex>();
            neighborsOfVertex1.add(vertex2);
            neighborsOfVertex1.add(vertex3);
            Set<Vertex> neighborsOfVertex2 = new HashSet<Vertex>();
            neighborsOfVertex2.add(vertex1);
            neighborsOfVertex2.add(vertex3);
            neighborsOfVertex2.add(vertex4);
            Set<Vertex> neighborsOfVertex3 = new HashSet<Vertex>();
            neighborsOfVertex3.add(vertex1);
            neighborsOfVertex3.add(vertex2);
            neighborsOfVertex3.add(vertex5);
            Set<Vertex> neighborsOfVertex4 = new HashSet<Vertex>();
            neighborsOfVertex4.add(vertex2);
            neighborsOfVertex4.add(vertex5);
            neighborsOfVertex4.add(vertex6);
            Set<Vertex> neighborsOfVertex5 = new HashSet<Vertex>();
            neighborsOfVertex5.add(vertex3);
            neighborsOfVertex5.add(vertex4);
            Set<Vertex> neighborsOfVertex6 = new HashSet<Vertex>();
            neighborsOfVertex6.add(vertex4);

            verticesNeighbors = new HashMap<Vertex, Set<Vertex>>();
            verticesNeighbors.put(vertex1, neighborsOfVertex1);
            verticesNeighbors.put(vertex2, neighborsOfVertex2);
            verticesNeighbors.put(vertex3, neighborsOfVertex3);
            verticesNeighbors.put(vertex4, neighborsOfVertex4);
            verticesNeighbors.put(vertex5, neighborsOfVertex5);
            verticesNeighbors.put(vertex6, neighborsOfVertex6);

        }

        public Set<Vertex> getVertices() {
            return vertices;
        }

        public Set<Vertex> getNeighbors(Vertex v) {
            return verticesNeighbors.get(v);
        }
    }

    @Test
    public void dfsVerify() throws Exception {

        GraphTest g = new GraphTest();

        Graph.Vertex start = new VertexTest("A");
        Graph.Vertex finish = new VertexTest("B");

        assertEquals(dfs(g,start,finish),1);
    }
    @Test
    public void dfsVerify1() throws Exception {

        GraphTest g = new GraphTest();

        Graph.Vertex start = new VertexTest("A");
        Graph.Vertex finish = new VertexTest("E");

        assertEquals(dfs(g,start,finish), 2);
    }
    @Test
    public void dfsVerify2() throws Exception {

        GraphTest g = new GraphTest();

        Graph.Vertex start = new VertexTest("A");
        Graph.Vertex finish = new VertexTest("F");

        assertEquals(dfs(g,start,finish), 3);
    }
    @Test
    public void dfsVerify3() throws Exception {

        GraphTest g = new GraphTest();

        Graph.Vertex start = new VertexTest("C");
        Graph.Vertex finish = new VertexTest("F");

        assertEquals(dfs(g,start,finish), 3);
    }

}