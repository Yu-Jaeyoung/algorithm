package searchtree;

public class TreeNode<E> {
    E item;
    TreeNode<E> left;
    TreeNode<E> right;

    public TreeNode(final E key) {
        this.item = key;
        this.left = this.right = null;
    }

    public TreeNode(final E key, final TreeNode<E> left, final TreeNode<E> right) {
        this.item = key;
        this.left = left;
        this.right = right;
    }
}


