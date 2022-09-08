import java.util.Arrays;

public class Dijkstra {

    public int[] shortPathFrom(int[][] graph, int startingVertex) {
        // an array of booleans to show which vertices are still not visited
        boolean[] isVisited = new boolean[graph.length];
        // an array of ints, where the shortest path from the startingVertex is stored
        int[] shortestPaths = new int[graph.length];
        // fill an array with infinity values
        Arrays.fill(shortestPaths, Integer.MAX_VALUE);
        // a path from a startingVertex to the starting Vertex is 0
        shortestPaths[startingVertex] = 0;

        // a loop for visiting every vertex in a graph
        for (int ind = 0; ind < graph.length; ind++){
            // a variable for tracking the smallest shortest path to the startingVertex
            int currentVertexRemoteness = Integer.MAX_VALUE;
            // a varialbe for tracking the vertex, which has the smallest path to the startingVertex
            int currentVertex = -1;
            // a loop for finding the vertex, which is the least remoted from the startingVertex
            for (int i = 0; i < graph.length; i++) {
                // if the vertex is still not visited and the distance from the startingVertex is less than
                // the current minimum, assign this vertex to the currentVertex variable
                if (!isVisited[i]) {
                    if (shortestPaths[i] < currentVertexRemoteness) {
                        currentVertexRemoteness = shortestPaths[i];
                        currentVertex = i;
                    }
                }
            }
            // mark the currentVertex as visited
            isVisited[currentVertex] = true;
            // a loop for recalculating all the adjacent vertices
            for (int i = 0; i < graph.length; i++) {
                // if there is a connection between the current vertex and the Ith vertex, recalculate the minimal path
                if (graph[currentVertex][i] > 0) {
                    shortestPaths[i] =
                            Math.min(shortestPaths[i], shortestPaths[currentVertex] + graph[currentVertex][i]);
                }
            }

        }
        // return the array of the shortest paths to the startingVertex
        return shortestPaths;
    }

}
