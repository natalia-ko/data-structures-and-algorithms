package collections.impl;

public class BinaryTree {

    private Node root;

    public boolean find(int value) {
        Node current = root;

        while (value != current.value) {
            if (value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }
        return true;
    }

    public void insert(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if (null == root) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (value < current.value) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int value) {
        Node current = root;
        Node nodeToDelete = current;
        Node parentOfNodeToDelete = current;

        while (value != current.value) {
            parentOfNodeToDelete = current;
            if (value < current.value) {
                current = current.left;
                nodeToDelete = current;
            } else {
                current = current.right;
                nodeToDelete = current;
            }
            if (current == null) {
                return false;
            }
        }
        if (null == nodeToDelete.left && null == nodeToDelete.right) {
            if (parentOfNodeToDelete.left == nodeToDelete) {
                parentOfNodeToDelete.left = null;
            } else {
                parentOfNodeToDelete.right = null;
            }
        }
        // todo Incorrectly removes the minimum value
        else if (null == nodeToDelete.left || null == nodeToDelete.right) {
            if (parentOfNodeToDelete.left == nodeToDelete) {
                parentOfNodeToDelete.left = nodeToDelete.left;
            } else {
                parentOfNodeToDelete.right = nodeToDelete.right;
            }
        } else {
            //todo Works incorrectly
            Node successor = findNodeWithNextValue(nodeToDelete.right);
            if (parentOfNodeToDelete.left == nodeToDelete) {
                current = nodeToDelete;
                parentOfNodeToDelete.left = nodeToDelete.right;
                nodeToDelete = successor;
            } else {
                current = nodeToDelete;
                parentOfNodeToDelete.right = nodeToDelete.right;
                nodeToDelete = successor;
            }
        }

        return true;
    }

    private Node findNodeWithNextValue(Node tree) {
        Node current = tree.right;
        Node nextVal = current;
        while (null != current.left) {
            nextVal = current;
            current = current.left;

        }
        return nextVal;
    }

    public void printTree() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node local) {
        if (null != local) {
            inOrder(local.left);
            System.out.print(local.value + " ");
            inOrder(local.right);
        }
    }

    private static class Node {
        int value;
        Node left;
        Node right;
    }
}
