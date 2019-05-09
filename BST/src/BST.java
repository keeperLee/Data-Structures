/**
 * 在此实现的二分搜索树不包含重复元素，如果需要包含重复元素则需要定义：左子树小于等于节点；或者右子树大于等于节点
 * @param <E>
 */
public class BST<E extends Comparable<E>> {

    private class Node{
        E e;
        Node left , right;

        public Node(E e){
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    //根节点
    private Node root;

    //元素个数
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0 ;
    }
/*
    //向二分搜索树中添加新的元素e
    public void add(E e){
        if(root == null){
            root = new Node(e);
            size++;
        }else{
            add(root ,e);
        }
    }
    //向以node为根的二分搜索树中插入元素E，递归算法
    //如果递归终止条件不满足，则进行递归调用，直到递归终止条件满足，退出递归调用
    private void add(Node node , E e){
        //递归终止条件
        if(e.equals(node.e)){
            return ;
        }else if(e.compareTo(node.e) < 0 && node.left == null){
            node.left = new Node(e);
            size++;
            return ;
        }else if(e.compareTo(node.e) > 0 && node.right == null){
            node.right = new Node(e);
            size++;
            return ;
        }

        //递归调用
        if(e.compareTo(node.e) < 0) {
            add(node.left, e);
        }else{
            add(node.right,e);
        }
    }*/

    //向二分搜索树中添加新的元素e
    public void add(E e){
        root = add(root,e);
    }

   //向以node为根的二分搜索树中插入元素e,递归算法
    //返回插入新节点后二分搜索树的根
    private Node add(Node node , E e){
        if(node == null){
            size++;
            return new Node(e);
        }

        //递归调用
        if(e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        }else if(e.compareTo(node.e) > 0){
            node.right = add(node.right,e);
        }
        return node;

    }
}
