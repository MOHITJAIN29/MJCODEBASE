import java.util.*;

/**
 * Created by 1021343 on 07-Oct-17.
 */
public class CloningProblems {

public static void main(String arg[]){
    Tree t = new Tree();
    t.createTree(new int[]{12, 14, 16, 10, 8, 6, 18, 13, 15, 11, 9});
    System.out.println("\n------------------Levelorder Traversal Line by Line-------------");
    t.levelOrderTraversalLineByLine(t.root);
    TreeNode newNodeRec = cloneTreeRecursive(t.root);
    System.out.println("\n------------------Levelorder Traversal of a Cloned Tree-------------");
    t.levelOrderTraversalLineByLine(newNodeRec);
    TreeNode newNodeIte = cloneTreeIterative(t.root);
    System.out.println("\n------------------Levelorder Traversal of a Cloned Tree-------------");
    t.levelOrderTraversalLineByLine(newNodeIte);


    ConnectedNode connectedNode = new ConnectedNode(12);
    connectedNode.next=null;
    connectedNode.left=new ConnectedNode(10);
    connectedNode.right=new ConnectedNode(14);
    connectedNode.left.next= connectedNode.right;

    connectedNode.left.left=new ConnectedNode(8);
    connectedNode.left.right=new ConnectedNode(11);
    connectedNode.left.left.next= connectedNode.left.right;

    connectedNode.right.left=new ConnectedNode(13);
    connectedNode.right.right=new ConnectedNode(16);
    connectedNode.left.right.next=connectedNode.right.left;
    connectedNode.right.left.next=connectedNode.right.right;
    System.out.println("---Connected Tree Before Cloning--------");
    t.levelOrderTraversalForConnectedNodes(connectedNode);
    ConnectedNode newNode = cloneTreeWithLinksRec(connectedNode);
    System.out.println("---Connected Tree After Cloning--------");
    t.levelOrderTraversalForConnectedNodes(newNode);

}

    public  static TreeNode cloneTreeRecursive(TreeNode root){
        if(root==null) return null;
        TreeNode newRoot = new TreeNode(root.data);
        if(root.left!=null)
            newRoot.left = cloneTreeRecursive(root.left);
        if(root.right!=null)
            newRoot.right = cloneTreeRecursive(root.right);
        return newRoot;
    }

    public static TreeNode cloneTreeIterative(TreeNode root1) {
        if (root1 == null) return null;
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(root1);
        TreeNode root2 = new TreeNode(root1.data);
        Queue<TreeNode> q2 = new LinkedList<>();
        q2.add(root2);
        while(!q1.isEmpty()) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            if(node1.left !=null) {
                node2.left = new TreeNode(node1.left.data);
                q1.add(node1.left);
                q2.add(node2.left);
            }
            if(node1.right !=null) {
                node2.right = new TreeNode(node1.right.data);
                q1.add(node1.right);
                q2.add(node2.right);

            }

        }

        return root2;

    }

    // will have problem if random links create an cycle itelf, then it will be in loop forever
    public static ConnectedNode cloneTreeWithLinks(ConnectedNode root){
        if(root==null) return null;
        ConnectedNode newRoot = new ConnectedNode(root.data);
        if(root.left!=null)
            newRoot.left = cloneTreeWithLinks(root.left);
        if(root.right!=null)
            newRoot.right = cloneTreeWithLinks(root.right);
        if(root.next!=null)
            newRoot.next = cloneTreeWithLinks(root.next);
        return newRoot;
    }

    private static ConnectedNode cloneTreeWithLinksRec(ConnectedNode root) {
        Map<ConnectedNode,ConnectedNode> nodeMap = new HashMap<>();
        copyAllNodes(root, nodeMap);
        storeLinks(root,nodeMap);
        return nodeMap.get(root);
    }


    private static void copyAllNodes(ConnectedNode root,Map<ConnectedNode, ConnectedNode> map) {
        if(root == null) return;
        ConnectedNode connectedNode = new ConnectedNode(root.data);
        map.put(root,connectedNode);
        copyAllNodes(root.left,map);
        copyAllNodes(root.right, map);
    }

    private static void storeLinks(ConnectedNode root,Map<ConnectedNode, ConnectedNode> map) {
        if(root == null) return;
        ConnectedNode connectedNode = map.get(root);
        connectedNode.left = map.get(root.left);
        connectedNode.right = map.get(root.right);
        connectedNode.next = map.get(root.next);
        storeLinks(root.left,map);
        storeLinks(root.right, map);
    }


}
