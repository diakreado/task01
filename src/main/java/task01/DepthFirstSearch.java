package task01;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DepthFirstSearch {

    static int dfs(Graph g, Graph.Vertex start, Graph.Vertex finish) {

        List<Graph.Vertex> way = new ArrayList<Graph.Vertex>();
        way.add(start);

        findWay(g,start,finish,way);

        for (Graph.Vertex v : way)
            System.out.println(v.getName());

        return way.size() - 1;
    }

    private static boolean findWay(Graph g, Graph.Vertex start, Graph.Vertex finish,List<Graph.Vertex> way) {

        Set<Graph.Vertex> neighbors = g.getNeighbors(start);

        for(Graph.Vertex neighbor : neighbors) {

            if(way.contains(neighbor))
                continue;

            way.add(neighbor);

            if(neighbor.equals(finish)  || findWay(g,neighbor,finish,way)) {
                 return true;
            }
            else {
                way.remove(way.size() - 1);
            }
        }

        return false;
    }
}
