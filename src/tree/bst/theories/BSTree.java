/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tree.bst.theories;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import tree.node.BSTNode;

/**
 *
 * @author duyvu
 * @param <T>
 */
public class BSTree<T extends Comparable<T>> {

    // ======================================
    // = Fields
    // ======================================
    public BSTNode<T> root;

    // ======================================
    // = Create Methods
    // ======================================
    /**
     * Recursively adding new root to the binary tree
     *
     * <br><br> If data less than root.data then recursively move to the left
     * <br><br> If data greater than root.data then recursively move to the right
     *
     * @param data
     * @param root
     * @return
     */
    private BSTNode addNode(T data,
                            BSTNode<T> root) {
        // Ending point, if reaching the left or right leave, return a root and attach to left or right
        // Create new root with added data and attach to the tree
        if (root == null) {
            return new BSTNode<>(data);
        }

        if (data.compareTo(root.data) < 0) {
            root.left = addNode(data, (BSTNode<T>) root.left);
        } else {
            root.right = addNode(data, (BSTNode<T>) root.right);
        }

        return root;
    }

    /**
     * Function Overloadding for addNode
     *
     * <br><br> If root is null then attach to the root, else calling addNode recursively
     *
     * @param data
     * @return
     */
    public boolean addNode(T data) {
        // If empty, make it a nsew node
        if (isEmpty()) {
            root = new BSTNode<>(data);
            return true;
        }

        // if not empty, then recursively adding new node as a leave  
        return addNode(data, root) != null;
    }

    /**
     * Adding Node to the Binary Tree using iteration
     *
     * @param newData
     */
    public void addNodeIteration(T newData) {

        // If empty then attach new node into it 
        if (isEmpty()) {
            this.root = new BSTNode(newData);
        } else {
            BSTNode prevNode = null;
            BSTNode currNode = this.root;

            // Finding the fix position for the new Data
            while (currNode != null) {

                // Attach the previous node to the current tracking node
                prevNode = currNode;

                // Comparing 2 object based on the compareTo function
                int key = currNode.data.compareTo(newData);

                if (key > 0) {
                    currNode = (BSTNode) currNode.left;
                } else if (key < 0) {
                    currNode = (BSTNode) currNode.right;
                } else {
                    // Indicate the node is existes, dont need to add into the tree
                    return;
                }
            }

            // Set the previous left or right to the new data node itself
            if (prevNode.data.compareTo(newData) > 0) {
                prevNode.left = new BSTNode(newData);
            } else {
                prevNode.right = new BSTNode(newData);
            }
        }

    }

    // ======================================
    // = Read Methods
    // ======================================
    /**
     * Depth First Search using preorder recursion
     *
     * @param data: a given data
     * @return a traversal list
     */
    public List<T> preOrderRecursion() {
        ArrayList<T> resultList = new ArrayList<>();
        preOrderRecursion(resultList, this.root);
        return resultList;
    }

    private void preOrderRecursion(ArrayList<T> resultList,
                                   BSTNode root) {
        if (root == null) {
            return;
        }

        // Traversingthe list at order Middle -> Left -> Right
        resultList.add((T) root.data);
        preOrderRecursion(resultList, (BSTNode) root.left);
        preOrderRecursion(resultList, (BSTNode) root.right);
    }

    /**
     * Depth First Search Using Preorder Iteration
     *
     * @param data: passed data to form a root
     * @return a list of traversal lists
     */
    public List<T> preOrderIteration() {

        ArrayList<T> resultList = new ArrayList();
        Stack<BSTNode> stk = new Stack();

        stk.push(this.root);

        // when there are still 
        while (!stk.isEmpty() && this.root != null) {
            BSTNode currNode = stk.pop();

            resultList.add((T) currNode.data);

            if (currNode.left != null) {
                stk.push((BSTNode) currNode.left);
            }
            if (currNode.right != null) {
                stk.push((BSTNode) currNode.right);
            }
        }

        // Pattern Root, Left, Right
        return resultList;
    }

    /**
     * Depth First Search Using Post order Recursion
     *
     * @return a list after traversing
     */
    public List<T> postOrderRecursion() {
        ArrayList<T> resultList = new ArrayList<>();
        postOrderRecursion(resultList, this.root);
        return resultList;
    }

    private void postOrderRecursion(ArrayList<T> resultList,
                                    BSTNode root) {
        if (root == null) {
            return;
        }

        // Traversingthe list at order Middle -> Left -> Right
        postOrderRecursion(resultList, (BSTNode) root.left);
        postOrderRecursion(resultList, (BSTNode) root.right);
        resultList.add((T) root.data);
    }

    /**
     * Depth First Search Using post order iteration
     *
     * @return
     */
//    public List<T> postOrderIteration() {
//	ArrayList<T> resultList = new ArrayList();
//	Stack<BTNode> stk = new Stack();
//	
//	BTNode currNode = this.root;
//
//	//     5 
//	//   1    4
//	//      2   3
//	// output: 0 2
//	// Push to stack with the order 5 1 4
//	// 
//	while (!stk.isEmpty() || currNode != null) {
//	    
//	   // Start from the left-most first
//	   while (currNode.left != null) {
//	       stk.push(currNode);
//	       currNode = currNode.left;
//	   }
//	   
//	   currNode = stk.pop();
//	   resultList.add((T) currNode);
//	   
//	   currNode = currNode.right;
//	}
//	
//	return resultList;
//    }
    /**
     * Depth First Search Using Inorder Recursion
     *
     * @return a list of inorder recursion
     */
    public List<T> inOrderRecursion() {
        ArrayList<T> resultList = new ArrayList<>();
        inOrderRecursion(resultList, this.root);
        return resultList;
    }

    private void inOrderRecursion(ArrayList<T> resultList,
                                  BSTNode root) {
        if (root == null) {
            return;
        }

        // Traversingthe list at order Middle -> Left -> Right
        inOrderRecursion(resultList, (BSTNode) root.left);
        resultList.add((T) root.data);
        inOrderRecursion(resultList, (BSTNode) root.right);
    }

    /**
     * Depth First Search using inorder iteration
     *
     * @return a traversal list
     */
    public List<T> inOrderIteration() {

        ArrayList<T> resultList = new ArrayList();
        Stack<BSTNode> stk = new Stack();

        BSTNode currNode = this.root;

        while (!stk.isEmpty() || currNode != null) {

            //     12 
            //   1    30
            // 0   2
            // output: 0 1 2 12 30
            // push the 12, then 1 then 0
            // when reaching left = null, then pop it and print to the screen
            // move to the right and then move to left, if nothing then return 
            if (currNode != null) {
                stk.push(currNode);
                currNode = (BSTNode) currNode.left;
            } else {
                currNode = stk.pop();
                resultList.add((T) currNode.data);
                currNode = (BSTNode) currNode.right;
            }
        }

        return resultList;
    }

    /**
     * Breath First Search - Using Queue to solve the problem
     *
     * @return
     */
    public List<T> breadthFirstTraversal() {

        ArrayList<T> resultList = new ArrayList<>();
        Queue<BSTNode> tmpQueue = new LinkedList<>();

        if (isEmpty()) {
            return resultList;
        }

        BSTNode currNode = this.root;
        tmpQueue.add(currNode);

        while (!tmpQueue.isEmpty()) {
            currNode = tmpQueue.remove();
            resultList.add((T) currNode.data);

            // Adding both left and right of the current node to the list if found
            if (currNode.left != null) {
                tmpQueue.add((BSTNode) currNode.left);
            }

            if (currNode.right != null) {
                tmpQueue.add((BSTNode) currNode.right);
            }
        }

        return resultList;
    }

    // ======================================
    // = Additional Methods
    // ======================================
    /**
     * Print out the tree in horizontal format representation
     *
     * @param prefix: adding the prefix decoration in front of the tree
     * @param node
     */
    public static void print(String prefix,
                             BSTNode node) {

        // Applying 
        if (node != null) {
            print(prefix + "\t", (BSTNode) node.right);
            System.out.println(prefix + "|-- " + node.data.toString());
            print(prefix + "\t", (BSTNode) node.left);
        }
    }

    /**
     * Check if the tree is empty or not
     *
     * @return true if empty
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Testing Area
     *
     * @param args
     */
    public static void main(String[] args) {

        BSTree<Integer> tree = new BSTree<>();
        int[] arr = new int[]{7, 1, 0, 8, 9, 2, 15, 6, 13, 14, 5};

        for (int i = 0; i < arr.length; i++) {
            tree.addNodeIteration(arr[i]);
        }

        System.out.println(tree.breadthFirstTraversal());

        print("", tree.root);
    }
}