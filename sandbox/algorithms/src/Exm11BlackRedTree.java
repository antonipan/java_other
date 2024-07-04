package algorithms;

public class Exm11BlackRedTree {
    public static void main(String[] args) {
        BlackRedTree tree = new BlackRedTree();
        tree.insertNode(5);
        tree.insertNode(6);
        tree.insertNode(1);
        tree.insertNode(13);
        tree.insertNode(4);


    }
}
class BlackRedTree {
    Node root; // root of tree;

    static final boolean RED = false;
    static final boolean BLACK = true;

    // search
    public Node searchNode(int value) {
        Node node = root;
        while (node != null) {
            if (value == node.value) {
                return node;
            } else {
                if (value < node.value) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
        }
        System.out.println("Node " + value + " is not find");
        return null;
    }

    // insertion
    public void insertNode (int value) {
        Node cuurentNode = root;
        Node parent = null;
        while (cuurentNode != null) {
            parent = cuurentNode;
            if (value < cuurentNode.value) {
                cuurentNode = cuurentNode.left;
            } else if (value > cuurentNode.value) {
                cuurentNode = cuurentNode.right;
            } else {
                throw new IllegalArgumentException("A node with this value already exists " + value);
            }
        }

        Node newNode = new Node ();
        newNode.value = value;
        newNode.color = RED;
        if (parent == null) {
            root = newNode;
        } else if (value < parent.value) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        newNode.parent = parent;

        changingColorAfterInsert(newNode);
    }
    // изменение цветов элементов.
    private void changingColorAfterInsert (Node node) {
        Node parent = node.parent;
        if (parent == null) {
            node.color = BLACK;
            return;
        }
        if (parent.color == BLACK){
            return;
        }
        Node grandParent = parent.parent;
        if (grandParent == null) {
            parent.color = BLACK;
            return;
        }

        Node uncle = getUncle (parent);
        if (uncle != null && uncle.color == RED) {
            parent.color = BLACK;
            grandParent.color = RED;
            uncle.color = BLACK;

            changingColorAfterInsert(grandParent);
        } else if (parent == grandParent.left) {
            if (node == parent.right) {
                rotateLeft(parent);
                parent = node;
            }
            rotateRight(grandParent);
            parent.color = BLACK;
            grandParent.color = RED;
        } else {
            if (node == parent.left) {
                rotateRight(parent);
                parent = node;
            }
            rotateLeft(grandParent);
            parent.color = BLACK;
            grandParent.color = RED;
        }


    }
    // Определение дяди
    private Node getUncle (Node parent) {
        Node grandparent = parent.parent;
        if (grandparent.left == parent) {
            return grandparent.right;
        } else if (grandparent.right == parent) {
            return grandparent.left;
        } else {
            throw new IllegalArgumentException("Parent is not child of grandparent");
        }
    }
    // Правый поворот поворот
    private void rotateRight(Node node) {
        Node parent = node.parent;
        Node leftchild = node.left;
        node.left = leftchild.right;
        if (leftchild.right != null) {
            leftchild.right.parent = node;
        }
        leftchild.right = node;
        node.parent = leftchild;

        replaceParentsChild(parent, node, leftchild);
    }
    // Левый поворот
    private void rotateLeft(Node node) {
        Node parent = node.parent;
        Node rightChild = node.right;

        node.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }

        rightChild.left = node;
        node.parent = rightChild;

        replaceParentsChild(parent, node, rightChild);
    }
    // правый поворот

    private void replaceParentsChild(Node parent, Node oldChild, Node newChild) {
        if (parent == null) {
            root = newChild;
        } else if (parent.left == oldChild) {
            parent.left = newChild;
        } else if (parent.right == oldChild) {
            parent.right = newChild;
        } else {
            throw new IllegalStateException("Node is not a child of its parent");
        }

        if (newChild != null) {
            newChild.parent = parent;
        }
    }

    class Node {
        int value;
        Node left;
        Node right;
        Node parent;

        boolean color; // true - black, false - red;


    }
}
