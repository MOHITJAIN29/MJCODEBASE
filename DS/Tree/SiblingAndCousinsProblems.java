/**
 * Created by 1021343 on 15-Oct-17.
 */
import java.util.*;
public class SiblingAndCousinsProblems {
    /*
                       12
                     /    \               isSibling(t.root,10,12) -- False
                   10	  14
                  / \     / \           isSibling(t.root,8,11) -- True
                 8  11   13 16
                / \         / \
               6  9       15  18
       */
    public static void main(String arg[]) {
        Tree t = new Tree();
        t.createTree(new int[]{12, 14, 16, 10, 8, 6, 18, 13, 15, 11, 9});
        System.out.println("The Level order of given Tree is :- ");
        t.levelOrderTraversalLineByLine(t.root);
        System.out.println("Are Given Nodes Siblings : "+isSibling(t.root,10,12));
        System.out.println("Are Given Nodes Siblings : "+isSibling(t.root,8,11));
        System.out.println("Are Given Nodes Siblings : "+isSibling(t.root,6,13));
        System.out.println("Are Given Nodes Cousins : "+areCousins(t.root,8,13));
        System.out.println("Are Given Nodes Cousins : "+areCousins(t.root,6,8));
        System.out.println("Iterative Process- Are Given Nodes Cousins  : "+areCousinsIterative(t.root,8,13));
        System.out.println("Iterative Process- Are Given Nodes Cousins  : "+areCousinsIterative(t.root,6,8));

    }


    private static boolean isSibling(TreeNode root,int a, int b) {

        if(root == null)
            return false;
        else if(root.left == null && root.right == null)
            return false;
        else
            return (root.left.data == a && root.right.data ==b) || (root.right.data == a && root.left.data == b)
            ||(isSibling(root.left,a,b)) || isSibling(root.right,a,b);
    }

    private static boolean areCousins(TreeNode root, int a, int b) {
        // get the heights of both the nodes and return false if heights are not same
        if (getHeight(root, a, 1) != getHeight(root, b, 1))
            return false;
        else {
            // Now check if parents are not same for both the node, if it is return true otherwise false,
            if (isSibling(root, a, b) == false) {
                return true;
            } else {
                return false;
            }
        }
    }
    private static int getHeight(TreeNode root, int a, int height) {
        if (root == null)
            return 0;
        if (root.data == a)
            return height;

        int level = getHeight(root.left, a, height + 1);
        if (level != 0)
            return level;
        return getHeight(root.right, a, height + 1);
    }


    private static boolean areCousinsIterative(TreeNode start, int node1Data, int node2Data){
        if(start == null){
            return false;
        }
        boolean node1Found = false;
        boolean node2Found = false;

        int node1Level = -1;
        int node2Level = -1;

        int currentLevel = 1;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(start);
        q.add(null);

        while(q!=null) {
            TreeNode node = q.poll();

            if (node == null) {
                //If one of node is found and other node is not found,then return false
                if ((node1Found && !node2Found) || (node2Found && !node1Found)) {
                    return false;
                }

            //Check both nodes are found, if yes, then see they both are found at same level,
            //if yes then return true else false.
            if (node1Found && node2Found) {
                if (node1Level == node2Level) {
                    return true;
                } else {
                    return false;
                }
            }

            //Check if there is any further level to process
            if (q.peek() != null) {
                currentLevel++;
                q.add(null);
            }

            }else if(node.left!=null && node.right!=null){

                //Check if node1 and node2 is child of current node, if yes, then they are not cousin and is sibling.
                if(node.left.data == node1Data && node.right.data == node2Data ||
                        node.left.data == node2Data && node.right.data == node1Data ){
                    return false;
                }

                //node1 may be at left side or right side
                if(node.left.data == node1Data || node.right.data == node1Data){
                    node1Found = true;
                    node1Level = currentLevel;
                }

                //node2 may be at left side or right side
                if(node.left.data == node2Data || node.right.data == node2Data){
                    node2Found = true;
                    node2Level = currentLevel;
                }

                if(node.left!=null)
                    q.add(node.left);

                if(node.right!=null)
                    q.add(node.right);
            }
        }
        return false;
    }



}
