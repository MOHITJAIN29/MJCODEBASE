/**
 * Created by 1021343 on 01-Nov-17.
 */
import java.util.*;


public class Graph {


    public static int V;
    public static ArrayList<ArrayList<Integer>> adjList;

        Graph(int v)
        {
            V = v;
            adjList = new ArrayList<>();
            for (int i=0; i<v; i++)
               adjList.add(new ArrayList<>());
        }

        void addEdge(int v,int w)
        {
            adjList.get(v).add(w);
            adjList.get(w).add(v);
        }


    }
