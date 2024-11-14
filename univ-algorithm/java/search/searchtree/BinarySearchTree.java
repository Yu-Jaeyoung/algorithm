package searchtree;

public class BinarySearchTree<E extends Comparable<E>> {

    private TreeNode<E> root;

    // 중위 순회
    public void print() {
        print(root);
    }

    public void print(TreeNode<E> root) {
        if (root == null) {
            return;
        }

        print(root.left);
        System.out.println(root.item);
        print(root.right);
    }

    public TreeNode<E> search(E x) {
        return search(root, x);
    }

    private TreeNode<E> search(final TreeNode<E> t, final E x) {
        if (t == null) {
            return new TreeNode<E>((E) x, null, null);
        }

        if (x.compareTo(t.item) == 0) {
            return t;
        } else if (x.compareTo(t.item) < 0) { // x < t.item
            return search(t.left, x);
        } else { // x > t.item
            return search(t.right, x);
        }
    }

    public void insert(final E x) {
        root = insert(root, x);
    }

    private TreeNode<E> insert(TreeNode<E> t, final E x) {
        if (t == null) {
            return new TreeNode<E>((E) x, null, null); // 새 노드
        }
        if (x.compareTo(t.item) < 0) {
            t.left = insert(t.left, x);
            return t;
        } else {
            t.right = insert(t.right, x);
            return t;
        }
    }

    public void delete(final E x) {
        root = findAndDelete(root, x);
    }

    private TreeNode<E> findAndDelete(TreeNode<E> t, final E x) {
        if (t == null) {
            return null; // key not found!
        } else {
            if (x.compareTo(t.item) == 0) {
                t = deleteNode(t); // item found at t
            } else if (x.compareTo(t.item) < 0) {
                t.left = findAndDelete(t.left, x);
            } else {
                t.right = findAndDelete(t.right, x);
            }
            return t;
        }
    }

    private TreeNode<E> deleteNode(TreeNode<E> r) {
        if (r.left == null && r.right == null) {
            return null; // case 1 (no child)
        } else if (r.left == null) {
            return r.right; // case 2 (only right child
        } else if (r.right == null) {
            return r.left; // case 2 (only left child)
        } else { // case 3 (two children)
            TreeNode<E> s = r.right;
            TreeNode<E> parent = null;
            while (s.left != null) {
                parent = s;
                s = s.left;
            }
            r.item = s.item;
            if (s == r.right) {
                r.right = s.right;
            } else {
                parent.left = s.right;
            }

            return r;
        }
    }
}


