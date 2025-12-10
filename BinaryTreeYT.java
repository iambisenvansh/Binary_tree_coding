import java.util.*;

public class BinaryTreeYT {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }
    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]); 
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;

        }
        public static void preOrder(Node root){
            if(root == null){
                return;
            }
            System.out.println(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
        public static void inorder(Node root){
            if(root == null){
                return ;
            }
            inorder(root.left);
            System.out.println(root.data + " ");
            inorder(root.right);
        }
        public static void postorder(Node root){
            if(root == null){
                return ;

            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelorder(Node root){
            if(root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }

                }
                else{
                    System.out.print(currNode.data + " ");
                    if(currNode.left != null){
                        q.add(currNode.left);

                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }
        public static int countOfNodes(Node root){
            if(root == null){
                return 0;
            }
            int leftNodes = countOfNodes(root.left);
            int rightNodes = countOfNodes(root.right);
            return leftNodes + rightNodes + 1;
        }

        public static int sumOfNodes(Node root){
            if(root == null){
                return 0;
            }
            int leftsum = sumOfNodes(root.left);
            int rightsum = sumOfNodes(root.right);
            return leftsum + rightsum + root.data;
        }
        public static int height(Node root){
            if(root == null){
                return 0;
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            int myHeight = Math.max(leftHeight, rightHeight) + 1;
            return myHeight;
        }

        public static int diameter(Node root){
            if(root == null){
                return 0;
            }
            int D1 = diameter(root.left);
            int D2 = diameter(root.right);
            int D3 = height(root.left) + height(root.right) + 1;
            return Math.max(D3, Math.max(D1, D2));

        }
        public static class Info{
            int ht;
            int diam;
            Info(int ht, int diam){
                this.ht = ht;
                this.diam = diam;
            }
        }
        public static Info diameter2(Node root){
            if(root == null){
                return new Info(0, 0);
            }
            Info left = diameter2(root.left);
            Info right = diameter2(root.right);
            int myHeight = Math.max(left.ht, right.ht) + 1;
            int D1 = left.diam;
            int D2 = right.diam;
            int D3 = left.ht + right.ht + 1;
            int myDiam = Math.max(Math.max(D1, D2), D3);

            Info myInfo = new Info(myHeight, myDiam);
            return myInfo;

        }
        }
    
    public static void main(String[] args){
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1 , -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        // System.out.println(root.data);
        // tree.preOrder(root);
        // tree.inorder(root);
        // tree.postorder(root);
        // tree.levelorder(root);
        // System.out.println(tree.countOfNodes(root));
        // System.out.println(tree.sumOfNodes(root));
        // System.out.println(tree.height(root));
        System.out.println(tree.diameter(root));
    

    }
}