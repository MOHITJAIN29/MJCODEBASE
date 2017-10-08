/**
 * Created by 1021343 on 08-Oct-17.
 */
public class MirrorProblems {

    public static void main(String arg[]) {
        Tree t = new Tree();
        t.createTree(new int[]{12, 14, 16, 10, 8});
        TreeNode node1 = new TreeNode(12);
        node1.left = new TreeNode(14);
        node1.right = new TreeNode(10);
        node1.left.left = new TreeNode(16);
        node1.right.right = new TreeNode(8);
        System.out.println("Is Tree 1 Mirror of Tree 2 --> " + isMirrorTree(t.root,node1));

        TreeNode node3 = createMirrorTree(t.root);
//        TreeNode node2 =  convertMirrorTree(node3);
        System.out.println("Is Tree 1 Mirror of Tree 2 --> " + isMirrorTree(t.root,node3));

        System.out.println("Is Tree 1 Mirror of Tree 2 --> " + isMirrorTree(node1,convertMirrorTree(node3)));
    }


    public static boolean isMirrorTree(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null )
            return true;
        else if(root1 == null)
            return false;
        else if(root2 == null)
            return false;
        else return root1.data == root2.data && isMirrorTree(root1.left,root2.right) && isMirrorTree(root1.right,root2.left);
    }

    public static TreeNode convertMirrorTree(TreeNode node)
    {
        if (node == null)
            return node;
        convertMirrorTree(node.left);
        convertMirrorTree(node.right);
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        return node;
    }

    public static TreeNode createMirrorTree(TreeNode node)
    {
        if (node == null)
            return node;

        TreeNode leftNode = createMirrorTree(node.left);
        TreeNode rightNode = createMirrorTree(node.right);
        TreeNode rootNode = new TreeNode(node.data);

        rootNode.left = rightNode;
        rootNode.right = leftNode;
        return rootNode;
    }

}



