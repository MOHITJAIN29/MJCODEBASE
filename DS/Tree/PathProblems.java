import java.util.*;

/**
 * Created by 1021343 on 09-Oct-17.
 */
public class PathProblems {

    static int  count=0;
    static int maxsum = -1;
    public static void main(String arg[]) {

        Tree t = new Tree();
        t.createTree(new int[]{12, 14, 16, 10, 8, 6, 18, 13, 15, 11, 9});
        getAllPaths(t.root);
        getAllPathsUsingArray(t.root);
    }

    public static void getAllPaths(TreeNode root) {
        count = 0;
        if(root == null) return;
        LinkedList path = new LinkedList<>();
        Map<Integer, LinkedList> map = new HashMap<>();
        printPathsList(root, path,map);
        System.out.println("Path having Max sum = "+maxsum+ " is --> "+map.get(maxsum));
    }

    public static void printPathsList(TreeNode root, LinkedList path, Map<Integer, LinkedList> map) {
        if(root == null) return;
        path.add(root.data);
        if(root.left == null && root.right == null) {
            count++;
            int sum = 0;
            for(int i=0;i<path.size();i++)
            {
                sum+=(int)path.get(i);
            }
            System.out.println("Path "+count+" --> "+path);
            if(sum > maxsum)
            {
                if(!map.isEmpty())
                {
                    map.remove(maxsum);
                }
                maxsum =sum;
                LinkedList l = new LinkedList(path);
                map.put(maxsum,l);
            }
        }
        printPathsList(root.left, path,map);
        printPathsList(root.right,path,map);
        path.removeLast();
    }


    public static void getAllPathsUsingArray(TreeNode root) {
        count = 0;
        int[] nodes = new int[100];
        printPathsArray(root, nodes, 0);
    }

    public static void printPathsArray(TreeNode root, int[] nodes, int level) {
        if (root == null) return;
        nodes[level] = root.data;
        level++;
        if (root.left == null && root.right == null) {
            count++;
            System.out.print("Path "+count+" --> ");
            printPath(nodes, level);
        }
        printPathsArray(root.left, nodes, level);
        printPathsArray(root.right, nodes, level);
    }

    public static void printPath(int[] path, int pathSize) {
        for (int i = 0; i < pathSize; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }



}
