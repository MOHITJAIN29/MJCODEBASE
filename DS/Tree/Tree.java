import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 1021343 on 26-Sep-17.
 */
public class Tree {

     static TreeNode root;

    public void add(int d) {
        TreeNode n = new TreeNode(d);
        if (root == null) {
            root = n;
            return;
        }
        addNode(root, n);
    }

    public void addNode(TreeNode root, TreeNode node) {
        if (root.data > node.data) {
            if (root.left == null) {
                root.left = node;
            } else {
                addNode(root.left, node);
            }
        } else {
            if (root.right == null) {
                root.right = node;
            } else {
                addNode(root.right, node);
            }
        }
    }

    public void createTree(int[] arr) {
        if (arr == null)
            return;
        Tree t = new Tree();
        for (int i: arr) {
            t.add(i);
        }
    }

    public void postOrderTraversal(TreeNode node) {
        if (node == null)
            return;


        postOrderTraversal(node.left);


        postOrderTraversal(node.right);


        System.out.print(node.data + " ");
    }


    public  void inOrderTraversal(TreeNode node) {
        if (node == null)
            return;


        inOrderTraversal(node.left);


        System.out.print(node.data + " ");


        inOrderTraversal(node.right);
    }


    public  void preOrderTraversal(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
    public void levelOrderTraversal(TreeNode node)
    {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(node);
        while (!queue.isEmpty())
        {

            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
    public void levelOrderTraversalLineByLine(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                System.out.println();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                System.out.print(node.data + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }


    public void levelOrderTraversalLineByLineUsing2Q(TreeNode root){
        if(root==null)
            return;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root);
        while(!q1.isEmpty() || !q2.isEmpty()){
            System.out.println();
            while(!q1.isEmpty()){
                TreeNode node = q1.poll();
                System.out.print(node.data + " ");
                if(node.left!=null){
                    q2.add(node.left);
                }
                if(node.right!=null){
                    q2.add(node.right);
                }
            }
            System.out.println();
            while(!q2.isEmpty()){
                TreeNode node = q2.poll();
                System.out.print(node.data + " ");
                if(node.left!=null){
                    q1.add(node.left);
                }
                if(node.right!=null){
                    q1.add(node.right);
                }
            }
        }
    }

    public static void main(String[] args) {

        Tree t = new Tree();
        t.createTree(new int[]{12,14,16,10,8,6,18,13,15,11,9});
        System.out.println("\n------------------Preorder Traversal-------------");
        t.preOrderTraversal(root);
        System.out.println("\n------------------Inorder Traversal-------------");
        t.inOrderTraversal(root);
        System.out.println("\n------------------Postorder Traversal-------------");
        t.postOrderTraversal(root);
        System.out.println("\n------------------Levelorder Traversal in Single Line-------------");
        t.levelOrderTraversal(root);
        System.out.println("\n------------------Levelorder Traversal Line by Line-------------");
        t.levelOrderTraversalLineByLine(root);
        System.out.println("\n------------------Levelorder Traversal Line by Line Using 2 Queue-------------");
        t.levelOrderTraversalLineByLineUsing2Q(root);


    }
}
