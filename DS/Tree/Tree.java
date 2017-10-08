import java.util.*;
import java.util.Map.Entry;

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
        for (int i : arr) {
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


    public void inOrderTraversal(TreeNode node) {
        if (node == null)
            return;


        inOrderTraversal(node.left);


        System.out.print(node.data + " ");


        inOrderTraversal(node.right);
    }


    public void preOrderTraversal(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void levelOrderTraversal(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(node);
        while (!queue.isEmpty()) {

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


    public void levelOrderTraversalLineByLineUsing2Q(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root);
        while (!q1.isEmpty() || !q2.isEmpty()) {
            System.out.println();
            while (!q1.isEmpty()) {
                TreeNode node = q1.poll();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    q2.add(node.left);
                }
                if (node.right != null) {
                    q2.add(node.right);
                }
            }
            System.out.println();
            while (!q2.isEmpty()) {
                TreeNode node = q2.poll();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    q1.add(node.left);
                }
                if (node.right != null) {
                    q1.add(node.right);
                }
            }
        }
    }


    public void verticalTraversalUsingMap(TreeNode root) {
        if (root == null) return;
        Map<Integer, LinkedList<TreeNode>> map = new HashMap<Integer, LinkedList<TreeNode>>();
        verticalTraversalTree(map, root, 0);
        for (Entry<Integer, LinkedList<TreeNode>> ent : map.entrySet()) {
            System.out.print(ent.getKey() + " -->  ");
            for (TreeNode n : ent.getValue()) {
                System.out.print(n.data + " ");
            }
            System.out.println();
        }
    }

    public void verticalTraversalTree(Map<Integer, LinkedList<TreeNode>> map, TreeNode node, int hashVal) {
        if (node == null) return;
        LinkedList<TreeNode> nodes = map.get(hashVal);
        if (nodes == null) {
            nodes = new LinkedList<TreeNode>();
        }
        nodes.add(node);
        map.put(hashVal, nodes);
        verticalTraversalTree(map, node.left, hashVal - 1);
        verticalTraversalTree(map, node.right, hashVal + 1);
    }

    public void levelOrderReverseTraversalLineByLine(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> q = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode n = q.remove();
            if (n == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    s.push(null);
                    q.add(null);
                }
            } else {
                s.push(n);
                if (n.right != null) {
                    q.add(n.right);

                }
                if (n.left != null) {
                    q.add(n.left);
                }
            }
        }
        while (!s.isEmpty()) {
            if(s.peek() != null)
            System.out.print(s.pop().data + " ");
            else
            {
                s.pop();
                System.out.println();
            }

        }
        System.out.println();
    }

    public void zigzagTraversalLinebyLine(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> s1 = new Stack<>();  // need to traverse from left to right
        Stack<TreeNode> s2 = new Stack<>();  // need to traverse from right to right

        s1.push(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                TreeNode n = s1.pop();
                System.out.print(n.data + " ");
                if (n.left != null) {
                    s2.push(n.left);
                }
                if (n.right != null) {
                    s2.push(n.right);
                }
            }
            System.out.println();
            while (!s2.isEmpty()) {
                TreeNode n = s2.pop();
                System.out.print(n.data + " ");
                if (n.right != null) {
                    s1.push(n.right);
                }
                if (n.left != null) {
                    s1.push(n.left);
                }
            }
            System.out.println();
        }
        System.out.println();
    }


    public void leftView(TreeNode root) {
        if (root == null)

        return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        System.out.println(queue.peek().data + " ");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.peek().data + " ");
                    queue.add(null);
                }
            } else {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    public void rightView(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                continue;
            } else if (queue.peek() == null )
            {
                System.out.println(node.data + " ");
            }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

        }
}
   public void inOrderTraversalIterative(TreeNode root) {

        if (root == null) {
            return;
        }

        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;

        while (node != null) {
            s.push(node);
            node = node.left;
        }
        while (s.size() > 0) {
            node = s.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    s.push(node);
                    node = node.left;
                }
            }
        }
    }

    public  void preOrderTraversalIterative(TreeNode root) {

        if (root == null) {
            return;
        }

        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;
        s.push(node);
        while (!s.isEmpty()) {
            node = s.pop();
            System.out.print(node.data + " " );
            if(node.right != null )
                s.push(node.right);
            if(node.left != null )
                s.push(node.left);
        }

    }

    public void LeftBoundary(TreeNode node) {
        if (node == null) return;
        if (node.left != null) {
            System.out.print(node.data + "\t");
            LeftBoundary(node.left);
        } else if (node.right != null) {
            System.out.print(node.data + "\t");
            LeftBoundary(node.right);
        }
    }

    public void RightBoundary(TreeNode node) {
        if (node == null) return;
        if (node.right != null) {
            RightBoundary(node.right);
            System.out.print(node.data + "\t");
        } else if (node.left != null) {
            RightBoundary(node.left);
            System.out.print(node.data + "\t");
        }

    }

    public void Leaf(TreeNode node) {
        if (node == null) return;
        Leaf(node.left);
        if (node.right == null && node.left == null) {
            System.out.print(node.data + "\t");
        }
        Leaf(node.right);
    }

   public void boundaryTraversal(TreeNode node) {
        if (root == null) return;
        System.out.print(root.data + "\t");
        LeftBoundary(root.left);
        Leaf(root);
        RightBoundary(root.right);
    }

    public void topView(TreeNode root) {
        if (root == null) return;
        Map<Integer, TreeNode> map = new TreeMap<>();
        Queue<VONode> queue = new LinkedList<>();
        VONode voNode = new VONode(root,0);
        queue.add(voNode);
        while(!queue.isEmpty()) {
            VONode xNode = queue.poll();
            map.putIfAbsent(xNode.x, xNode.node);
            if(xNode.node.left != null) {
                queue.add(new VONode(xNode.node.left,xNode.x-1));
            }
            if(xNode.node.right != null) {
                queue.add(new VONode(xNode.node.right, xNode.x+1));
            }
        }
        for (Entry<Integer, TreeNode> ent : map.entrySet()) {
                System.out.print(ent.getValue().data + " ");
        }
    }

    public void bottomView(TreeNode node) {
        if (root == null) return;
        Map<Integer, TreeNode> map = new TreeMap<>();

        Queue<VONode> queue = new LinkedList<>();
        VONode voNode = new VONode(root,0);
        queue.add(voNode);
        while(!queue.isEmpty()) {
            VONode xNode = queue.poll();
            map.put(xNode.x, xNode.node);
            if(xNode.node.left != null) {
                queue.offer(new VONode(xNode.node.left,xNode.x-1));
            }
            if(xNode.node.right != null) {
                queue.offer(new VONode(xNode.node.right, xNode.x+1));
            }
        }
        map.forEach((key, value) -> {
            System.out.print(value.data + " ");
        });
    }

    public void ConnectNodesUsingLO(ConnectedNode root1) {
        if (root == null)
            return;
        Queue<ConnectedNode> queue = new LinkedList<>();
        queue.add(root1);
        queue.add(null);
        while (!queue.isEmpty()) {
            ConnectedNode node = queue.poll();
            if (node == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                  node.next=queue.peek();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

    }


    public  void levelOrderTraversalForConnectedNodes(ConnectedNode root) {
        if (root == null)
            return;
        Queue<ConnectedNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ConnectedNode node = queue.poll();
                System.out.println("The Next Connected Node of "+queue.poll().data+" is -->  "+((node.next !=null ) ? node.next.data : "Null" ));
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

        }
    }


    public static int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static int iterativeHeight(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int height = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (!queue.isEmpty()) {
                    height++;
                    queue.offer(null);
                }
            } else {
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return height;
    }

    public static void main(String[] args) {

        Tree t = new Tree();
        t.createTree(new int[]{12, 14, 16, 10, 8, 6, 18, 13, 15, 11, 9});
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
        System.out.println("\n------------------Levelorder Reverse Traversal Line by Line-------------");
        t.levelOrderReverseTraversalLineByLine(root);
        System.out.println("\n-------------------Vertical Traversal Using Map---------------");
        t.verticalTraversalUsingMap(root);
        System.out.println("\n-------------------ZigZag Traversal Line by Line Using 2 Stacks---------------");
        t.zigzagTraversalLinebyLine(root);
        System.out.println("\n-------------------Left View of Tree---------------");
        t.leftView(root);
        System.out.println("\n-------------------Right View of Tree---------------");
        t.rightView(root);
        System.out.println("\n-------------------Inorder Traversal Iterative---------------");
        t.inOrderTraversalIterative(root);
        System.out.println("\n-------------------Preorder Traversal Iterative---------------");
        t.preOrderTraversalIterative(root);
        System.out.println("\n-------------------Boundry Traversal ---------------");
        t.boundaryTraversal(root);
        System.out.println("\n-------------------Top View of a Tree ---------------");
        t.topView(root);
        System.out.println("\n-------------------Bottom View of a Tree ---------------");
        t.bottomView(root);
        System.out.println("\n------------------Connected Nodes Level by Level-------------");
//        t.ConnectNodesUsingLO(root);
        root.left.data = 9;
        t.levelOrderTraversalLineByLine(root);
        System.out.println("Height of a Tree "+t.height(root));
        System.out.println("Height of a Tree "+t.iterativeHeight(root));

    }
}
