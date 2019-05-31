import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    //看二分搜索树中是否包含元素e
    public boolean contains(E e){
        return contains(root ,e);
    }

    //看以node为根的二分搜索树中是否包含元素e,递归算法
    private boolean contains(Node node , E e){
        //终止情况
        if(node == null){
            return false;
        }

        if(e.compareTo(node.e) == 0){
            return true;
        }else if(e.compareTo(node.e) < 0){
           return contains(node.left,e);
        }else{
            return contains(node.right,e);
        }
    }

    //二分搜索树的前序遍历
    public void preOrder(){
        preOrder(root);
    }
    //前序遍历以node为根的二分搜索树，递归算法
    private void preOrder(Node node){
        if(node == null)
            return ;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //二分搜索树的非递归前序实现
    public void preOrderNR(){
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    //二分搜索树的中序遍历
    public void inOrder(){
        inOrder(root);
    }
    //中序遍历以node为根的二分搜索树，递归算法
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //二分搜索树的后序遍历
    public void postOrder(){
        postOrder(root);
    }

    //后序遍历以node为根的二分搜索树，递归算法
    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //二分搜索树的层序遍历
    public void levelOrder(){
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);

            if(cur.left != null){
                q.add(cur.left);
            }
            if(cur.right != null){
                q.add(cur.right);
            }
        }
    }



    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0  ,res);
        return res.toString();
    }

    //生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left,depth + 1,res);
        generateBSTString(node.right,depth + 1,res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i< depth ; i ++){
            res.append("--");
        }
        return res.toString();
    }
}
