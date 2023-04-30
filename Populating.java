//Time = O(n), n is numbe of nodes in a binary tree
//Space = O(w), w is max width of binary tree

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        
        Queue<Node> queue = new LinkedList<>(); // to perform level order traversal
        queue.offer(root); // add the root node to the queue
        
        while (!queue.isEmpty()) {
            int size = queue.size(); // get the number of nodes in the current level
            
            // connect nodes at the same level from left to right
            for (int i = 0; i < size; i++) {
                Node node = queue.poll(); // get the first node in the queue
                
                if (i < size - 1) { // if the node is not the last node in the level
                    node.next = queue.peek(); // connect the current node to the next node in the queue
                }
                
                if (node.left != null) { // add the left child to the queue if it exists
                    queue.offer(node.left);
                }
                
                if (node.right != null) { // add the right child to the queue if it exists
                    queue.offer(node.right);
                }
            }
        }
        
        return root;
    }
}
