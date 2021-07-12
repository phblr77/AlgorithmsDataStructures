package ru.geekbrains.lesson6;

import java.util.NoSuchElementException;

public class MyTreeMap<K extends Comparable<K>, V> {

    private Node root = null;

    private class Node {
        K key;
        V value;
        Node left;
        Node right;
        int size;
        int height;

        //fixed
        public Node(K key, V value, int size, int height) {
            this.key = key;
            this.value = value;
            this.size = size;
            this.height = height;
        }
    }

    private boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return root == null ? 0 : root.size;
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.size;
        }
    }

    //added
    int height() {
        return height(root);
    }

    //added
    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public V get(K key) {
        return get(key, root);
    }

    private V get(K key, Node node) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        if (node == null) {
            return null;
        }

        V result = null;

        if (key.compareTo(node.key) == 0) {
            result = node.value;
        } else if (key.compareTo(node.key) > 0) {
            result = get(key, node.right);
        } else if (key.compareTo(node.key) < 0) {
            result = get(key, node.left);
        }
        return result;
    }

    public void put(K key, V value) {
        root = put(key, value, root);
    }

    private Node put(K key, V value, Node node) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        if (node == null) {
            return new Node(key, value, 1, 0);
        }

        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
            node.left = put(key, value, node.left);
        } else {
            node.right = put(key, value, node.right);
        }

        node.size = 1 + size(node.left) + size(node.right);

        if (node.left == null && node.right == null) {
            node.height = 0;
        } else if (node.left != null && node.right == null) {
            node.height = node.left.height + 1;
        } else if (node.left == null) {
            node.height = node.right.height + 1;
        } else if (node.left.height > node.right.height) {
            node.height = node.left.height + 1;
        } else if (node.left.height < node.right.height) {
            node.height = node.right.height + 1;
        } else {
            node.height = node.left.height + 1;
        }

        return node;
    }

    public V min() {
        return min(root).value;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }


    public V max() {
        return max(root).value;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }


    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        } else {
            node.left = deleteMin(node.left);
        }
        node.size = size(node.left) + size(node.right) + 1;

        if (node.left == null && node.right == null) {
            node.height = 0;
        } else if (node.left != null && node.right == null) {
            node.height = node.left.height + 1;
        } else if (node.left == null) {
            node.height = node.right.height + 1;
        } else if (node.left.height > node.right.height) {
            node.height = node.left.height + 1;
        } else if (node.left.height < node.right.height) {
            node.height = node.right.height + 1;
        } else {
            node.height = node.left.height + 1;
        }
        return node;
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        root = deleteMin(root);
    }

    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if (node.right == null) {
            return node.left;
        } else {
            node.right = deleteMax(node.right);
        }
        node.size = size(node.left) + size(node.right) + 1;

        if (node.left == null && node.right == null) {
            node.height = 0;
        } else if (node.left != null && node.right == null) {
            node.height = node.left.height + 1;
        } else if (node.left == null) {
            node.height = node.right.height + 1;
        } else if (node.left.height > node.right.height) {
            node.height = node.left.height + 1;
        } else if (node.left.height < node.right.height) {
            node.height = node.right.height + 1;
        } else {
            node.height = node.left.height + 1;
        }
        return node;
    }

    public void delete(K key) {
        root = delete(key, root);
    }

    private Node delete(K key, Node node) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            Node cmp1 = node;
            node = max(node.left);
            node.left = deleteMax(cmp1.left);
            node.right = cmp1.right;
            cmp1 = null;
        } else if (cmp < 0) {
            node.left = delete(key, node.left);
        } else {
            node.right = delete(key, node.right);
        }

        node.size = size(node.left) + size(node.right) + 1;

        if (node.left == null && node.right == null) {
            node.height = 0;
        } else if (node.left != null && node.right == null) {
            node.height = node.left.height + 1;
        } else if (node.left == null) {
            node.height = node.right.height + 1;
        } else if (node.left.height > node.right.height) {
            node.height = node.left.height + 1;
        } else if (node.left.height < node.right.height) {
            node.height = node.right.height + 1;
        } else {
            node.height = node.left.height + 1;
        }
        return node;
    }

    //added
    boolean isBalanced() {
        if (root == null || root.size == 1) {
            return true;
        } else {
            int leftHeight;
            int rightHeight;

            if (root.left == null) {
                leftHeight = 0;
            } else {
                leftHeight = root.left.height;
            }

            if (root.right == null) {
                rightHeight = 0;
            } else {
                rightHeight = root.right.height;
            }
            return Math.abs(leftHeight - rightHeight) <= 1;
        }
    }
}