/**
 * Created by 1021343 on 01-Nov-17.
 */

import java.util.*;


public class GraphTraversals {


    public static void main(String args[])
    {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(4, 3);

        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("BFS--Starting from Vertex 2");
        BFS(2);

        System.out.println("\nDFS--Starting from Vertex 2");

        DFS(2);
    }
        private static void BFS(int s)
        {
            // Mark all the vertices as not visited(By default
            // set as false)
            boolean visited[] = new boolean[Graph.V];

            // Create a queue for BFS
            LinkedList<Integer> queue = new LinkedList<Integer>();

            // Mark the current node as visited and enqueue it
            visited[s]=true;
            queue.add(s);

            while (queue.size() != 0)
            {
                // Dequeue a vertex from queue and print it
                s = queue.poll();
                System.out.print(s+" ");

                for (int i : Graph.adjList.get(s))
                {
                    if (!visited[i])
                    {
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }
        }


    // A function used by DFS
    private static  void DFSUtil(int v,boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v+" ");

        // Recur for all the vertices adjacent to this vertex
        for (int i : Graph.adjList.get(v))        {
            if (!visited[i])
                DFSUtil(i, visited);
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
  private static  void DFS(int v)
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[Graph.V];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }


}
