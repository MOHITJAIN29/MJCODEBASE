/**
 * Created by 1021343 on 25-Oct-17.
 */
import java.util.*;
public class KthAncestor {

    public static void main(String arg[]) {

        Tree t = new Tree();
        t.createTree(new int[]{12, 14, 16, 10, 8, 6, 18, 11});
        findKthAncestor(t.root,18,2);
        findKthAncestor(t.root,11,3);
        findKthAncestor(t.root,11,1);

    }


    private static void findKthAncestor(TreeNode root, int node, int k) {
        LinkedList<Integer> path = new LinkedList<>();
        findAllAncestors(root,node,path);
        if(path.size() >= k)
        System.out.println(k+" Ancestor of Node "+node+" is : "+path.get(path.size()-k));
        else
            System.out.println(k+" Ancestor of Node "+node+" is not Available: ");
    }

    private static boolean findAllAncestors(TreeNode node, int target,LinkedList<Integer> path)
    {
        if (node == null)
            return false;

        else if (node.data == target) {
            return true;

        }
        path.add(node.data);
        if (findAllAncestors(node.left, target,path) || findAllAncestors(node.right, target,path))
        {
//            System.out.print(node.data + " ");
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }

}
