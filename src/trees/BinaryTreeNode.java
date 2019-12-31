package trees;

public class BinaryTreeNode<E> {
    public E data;
    public BinaryTreeNode<E> left, right;

    BinaryTreeNode(E data_, BinaryTreeNode<E> left_, BinaryTreeNode<E> right_) {
        data = data_;
        left = left_;
        right = right_;
    }

    BinaryTreeNode() {
        this(null, null, null);
    }
}
