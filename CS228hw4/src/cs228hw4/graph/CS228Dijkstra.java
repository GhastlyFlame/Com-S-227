package cs228hw4.graph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

/**
 * @author Haadi Majeed
 *
 */

public class CS228Dijkstra<V> implements Dijkstra<V> {

    private DiGraph<V> myGraph;
    private HashMap<V, Integer> distance;
    private HashMap<V, V> predecessors;
    private Set<V> unvisited;
    private Set<V> visited;

    public CS228Dijkstra(DiGraph<V> graph){
        myGraph = graph;
    }

    /**
     * Uses Dijkstra's shortest path algorithm to calculate and store the
     * shortest paths to every vertex in the graph as well as the total costs
     * of each of those paths.  This should run in O(E log V) time, where E is
     * the size of the edge set, and V is the size of the vertex set.
     *
     * @param start the vertex from which shortest paths should be calculated
     */
    @Override
    public void run(V start) {
        unvisited = new HashSet<V>(); //Initallizes all the stuffs
        visited = new HashSet<V>();
        distance = new HashMap<>();
        predecessors = new HashMap<>();
        predecessors.put(start, start); //puts the first node into pre
        distance.put(start,0);
        unvisited.add(start);
        while (unvisited.size() > 0) {
            V node = getMinimum(unvisited);
            visited.add(node);
            unvisited.remove(node);
            findMinimalDistances(node);
        }
        
    }

    private void findMinimalDistances(V node) {
        Set<? extends V> adj = myGraph.getNeighbors(node);
        for(V target : adj){ //add all to correct lists
            if(getShortestDistance(target) > getShortestDistance(node) + myGraph.getEdgeCost(node,target)){
                distance.put(target, getShortestDistance(node) + myGraph.getEdgeCost(node,target));
                predecessors.put(target,node);
                unvisited.add(target);
            }
        }
    }


    private V getMinimum(Set<V> unvisited) {
        V minimum = null; //returns the vector at minimum dist
        for (V vertex : unvisited) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    /**
     * Retrieve, in O(V) time, the pre-calculated shortest path to the given
     * node.
     *
     * @param vertex the vertex to which the shortest path, from the start
     *               vertex, is being requested
     * @return a list of vertices comprising the shortest path from the start
     * vertex to the given destination vertex, both inclusive
     */
    @Override
    public List<V> getShortestPath(V vertex) {
        LinkedList<V> path = new LinkedList<>();
        V step = vertex;
        if(predecessors.get(step) == null) return null;
        path.add(step);
        while(predecessors.get(step) != null  && !predecessors.get(step).equals(step)){
            step = predecessors.get(step);
            path.add(step);
        }
        Collections.reverse(path);
        return path;
    }

    /**
     * Retrieve, in constant time, the total cost to reach the given vertex from
     * the start vertex via the shortest path.  If there is no path, this value
     * is Integer.MAX_VALUE.
     *
     * @param vertex the vertex to which the cost of the shortest path, from the
     *               start vertex, is desired
     * @return the cost of the shortest path to the given vertex from the start
     * vertex or Integer.MAX_VALUE if there is path
     */
    @Override
    public int getShortestDistance(V vertex) {
        Integer val = distance.get(vertex);
        if(val == null)
            return Integer.MAX_VALUE;
        return val;
    }
}
