package task01;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class DepthFirstSearch {

    private static int shortestWay = 0;

    static int dfs(Graph g, Graph.Vertex start, Graph.Vertex finish) {

        List<Graph.Vertex> currentWay = new ArrayList<Graph.Vertex>();

        currentWay.add(start);

        findWay(g,start,finish,currentWay);

        return --shortestWay;
    }

    private static void findWay(Graph g, Graph.Vertex start, Graph.Vertex finish,List<Graph.Vertex> currentWay) {

        Set<Graph.Vertex> neighbors = g.getNeighbors(start);

        for(Graph.Vertex neighbor : neighbors) {

            if(currentWay.contains(neighbor))
                continue;

            currentWay.add(neighbor);

            if(neighbor.equals(finish) && (shortestWay == 0 || shortestWay > currentWay.size())) {

                shortestWay = currentWay.size();
            }

            findWay(g,neighbor,finish,currentWay);

            currentWay.remove(currentWay.size() - 1);
        }
    }
}
