package Assignment_5;
//Abdul Arif 105075345 08/16/2020
// Java program for different tree traversals
/*
Q3 d)
Insertion takes O(logn) in best case and O(n) in worst case for BST
Search takes O(logn) in best case and O(n) in worst case for BST
Deletion takes O(logn) in best case and O(n) in worst case for BST
 */

// Class containing left and right child of current node and key value
class Node {
    int key;
    Node left, right;

    public Node(int item) { // item is the term we use for data when talking about trees
        key = item;
        left = right = null;
    }
}

//class takes both a binary tree and binary search trees
public class TreeADT {
    Node root;// Root of BST
    // Default Constructor
    TreeADT() { root = null; }

    /* A recursive function to insert a new key in the BST */
    Node insert(Node root, int key) {
        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key); // creating a new node
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.key) // if it's less than the current node insert it as a left child
            root.left = insert(root.left, key);
        else if (key > root.key) // if it's greater than the current node insert it on the right branch
            root.right = insert(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    // Question 3 c) method to demonstrate delete operation in binary search tree
    // This method mainly calls deleteRec()
    /* A recursive function to delete a key in BST */
    Node deleteKey(Node root, int key) {
        /* Base Case: If the tree is empty */
        if (root != null) {
            /* Otherwise, recur down the tree */
            if (key < root.key)
                root.left = deleteKey(root.left, key);
            else if (key > root.key)
                root.right = deleteKey(root.right, key);
                // if the cases above failed then the key is same as root's key
                // (key == root.key), then this is the node to be deleted
            else {
                // node with only one child or no child
                if (root.left == null)
                    return root.right;
                else if (root.right == null)
                    return root.left;
                // node with two children: Get the inorder successor (smallest
                // in the right subtree)
                root.key = minValue(root.right);
                // Delete the inorder successor
                root.right = deleteKey(root.right, root.key);
            }
        }
        return root;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(Node node) { //Preorder Traversal: <Root><Left Subtree><Right Subtree>
        if (node != null) {
            System.out.print(node.key + " "); /* first print data of node */
            printPreorder(node.left); /* then recur on left subtree */
            printPreorder(node.right); /* now recur on right subtree */
        }
    }
    /* Given a binary tree, print its nodes according to the
   "bottom-up" postorder traversal. */
    void printPostorder(Node node) { //Postorder Traversal: <Left Subtree><Right Subtree><Root>
        if (node != null) {
            printPostorder(node.left);// first recur on left subtree
            printPostorder(node.right); // then recur on right subtree
            System.out.print(node.key + " "); // now deal with the node
        }
    }

    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(Node node) { //Inorder Traversal: <Left Subtree><Root><Right Subtree>
        if (node != null) {
            printInorder(node.left);/* first recur on left child */
            System.out.print(node.key + " ");/* then print the data of node */
            printInorder(node.right);/* now recur on right child */
        }
    }

    // A utility function to search a given key in BST
    //Search method for BST Question 3 b)
    boolean search(int key) {
        root = searchRec(root, key);
        if (root == null)
            return false;
        else if (root.key == key)
            return true;
        else
            return false;
    }

    public Node searchRec(Node root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.key == key)
            return root;
        // val is greater than root's key
        if (root.key > key)
            return searchRec(root.left, key);
        // val is less than root's key
        return searchRec(root.right, key);
    }

    public static void main(String[] args) {
        // Driver Program to test above functions for question 1
        System.out.println("Question 1: building the given sequence in the given order on a complete binary tree");
        TreeADT tree = new TreeADT(); // create a binary tree
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(11);
        tree.root.right.left.left = new Node(12);
        tree.root.right.left.right = new Node(13);
        tree.root.right.right.left = new Node(14);
        tree.root.right.right.right = new Node(15);

        // Question 2
        System.out.println("Question 2");
        System.out.println("a)\nPreorder traversal of binary tree is ");
        tree.printPreorder(tree.root);

        System.out.println("\nb)\nPostorder traversal of binary tree is ");
        tree.printPostorder(tree.root);

        System.out.println("\nc)\nInorder traversal of binary tree is ");
        tree.printInorder(tree.root);

        //Question 3 i.
        TreeADT tree1 = new TreeADT(); //create a BST
        tree1.root = tree1.insert(tree1.root, 1);
        tree1.root = tree1.insert(tree1.root,2);
        tree1.root = tree1.insert(tree1.root,3);
        tree1.root = tree1.insert(tree1.root,4);
        tree1.root = tree1.insert(tree1.root,5);
        tree1.root = tree1.insert(tree1.root,6);
        tree1.root = tree1.insert(tree1.root,7);
        tree1.root = tree1.insert(tree1.root,8);
        tree1.root = tree1.insert(tree1.root,9);
        tree1.root = tree1.insert(tree1.root,10);
        tree1.root = tree1.insert(tree1.root,11);
        tree1.root = tree1.insert(tree1.root,12);
        tree1.root = tree1.insert(tree1.root,13);
        tree1.root = tree1.insert(tree1.root,14);
        tree1.root = tree1.insert(tree1.root,15);

        
        System.out.println("\n\nQuestion 3 \ni. a)");
        // print inorder traversal of the BST
        System.out.println("Inorder traversal of the given binary search tree: ");
        tree1.printInorder(tree1.root);

        //Question 3 i.c)
        System.out.println("\n\ni. c)");
        System.out.println("I.");
        System.out.println("Delete 13");
        tree1.deleteKey(tree1.root, 13);
        System.out.println("Inorder traversal of the modified BST");
        tree1.printInorder(tree1.root);

        System.out.println("\nDelete 8");
        System.out.println("\nII.");
        tree1.deleteKey(tree1.root,8);
        System.out.println("Inorder traversal of the modified BST");
        tree1.printInorder(tree1.root);
        //Question 3 i.b)
        System.out.println("\n\ni. b)");
        System.out.println("Searching for keys which are stored in each node of the BST.");
        System.out.println(tree1.search(15));
        System.out.println(tree1.search(25));


        //Question 3. ii.
        TreeADT tree2 = new TreeADT();
        tree2.root = tree2.insert(tree2.root,8);
        tree2.root = tree2.insert(tree2.root,12);
        tree2.root = tree2.insert(tree2.root,14);
        tree2.root = tree2.insert(tree2.root,10);
        tree2.root = tree2.insert(tree2.root,4);
        tree2.root = tree2.insert(tree2.root,6);
        tree2.root = tree2.insert(tree2.root,13);
        tree2.root = tree2.insert(tree2.root,11);
        tree2.root = tree2.insert(tree2.root,2);
        tree2.root = tree2.insert(tree2.root,5);
        tree2.root = tree2.insert(tree2.root,9);
        tree2.root = tree2.insert(tree2.root,1);
        tree2.root = tree2.insert(tree2.root,7);
        tree2.root = tree2.insert(tree2.root,3);
        tree2.root = tree2.insert(tree2.root,15);

        // Question 3 ii.a)
        System.out.println("\nii. a)");
        tree2.printInorder(tree2.root);

        //Question 3 ii.c)
        System.out.println("\n\nii. c)");
        System.out.println("I.");
        System.out.println("Delete 13");
        tree2.deleteKey(tree2.root,13);
        System.out.println("Inorder traversal of the modified BST");
        tree2.printInorder(tree2.root);

        System.out.println("\n\nII.");
        System.out.println("Delete 8");
        tree2.deleteKey(tree2.root,8);
        System.out.println("Inorder traversal of the modified BST");
        tree2.printInorder(tree2.root);
        //TESTING METHODS again
        //System.out.println("\nPostorder traversal of the modified BST");
        //tree2.printPostorder(tree2.root);
        //System.out.println("\nPreorder traversal of the modified BST");
        //tree2.printPreorder(tree2.root);

        //Question 3 ii.b)
        System.out.println("\n\nii. b)");
        System.out.println("Searching for keys which are stored in each node of the BST.");
        System.out.println(tree2.search(15));
        System.out.println(tree2.search(25));
    }
}
