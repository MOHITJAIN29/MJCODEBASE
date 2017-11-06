/**
 * Created by 1021343 on 01-Nov-17.
 */
public class BTtoDLL {

    public static void main(String arg[]) {

        Tree t = new Tree();
        t.createTree(new int[]{12, 14, 16, 10, 8, 6, 18, 11});
        BinaryTree2DoubleLinkedList(t.root);
        printList(head);

    }

    static TreeNode head;

    static TreeNode prev = null;

    static  void BinaryTree2DoubleLinkedList(TreeNode root)
    {
        if (root == null)
            return;

        BinaryTree2DoubleLinkedList(root.left);

        if (prev == null)
            head = root;
        else
        {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        BinaryTree2DoubleLinkedList(root.right);
    }

    static void printList(TreeNode node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

}
