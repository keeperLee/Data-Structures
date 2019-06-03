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

    //寻找二分搜索树的最小元素
    public E minimum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty!");
        }
       return  minimum(root).e;
    }
    //返回以node为根的二分搜索树的最小值所在的节点,递归实现
    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    //寻找二分搜索树的最大元素
    public E maximum(){
        if(size == 0){
            throw  new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }
    //返回以node为根的二分搜索树的最大值所在的节点，递归实现
    private Node maximum(Node node){
        if(node.right == null){
            return node;
        }
        return maximum(node.right);
    }

    //从二分搜索树中删除最小值所在节点，返回最小值
    public E removeMin(){
        //先找到最小元素
         E ret = minimum();
        //下面的代码就是更新了二分搜索树，
        // 更新后的二分搜索树是删除了最小节点后的二分搜索树
        root = removeMin(root);
        return ret;
    }

    //删除以node为根的二分搜索树中的最小节点
    //返回删除节点后新的二分搜索树的根,递归实现
    private Node removeMin(Node node){

        //当前节点无法再向左移动，所以node就是要删除的节点
        if(node.left == null){
            //要删除的node节点可能有右子树，所以要保留右子树
            //这里node.right可能也为空，但是逻辑是对的
            Node rightNode = node.right;
            //让最左的节点与这个二叉树脱离关系
            node.right = null;
            size --;
            return rightNode;
        }
        //递归
        node.left = removeMin(node.left);
        return node;
    }

    //从二分搜索树中删除最大值所在节点，返回最大值
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }
    //删除掉以node为根的二分搜索树中的最大节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    //从二分搜索树中删除元素为e的节点
    public void remove(E e){
        root = remove(root ,e);
    }
    //删除掉以node为根的二分搜索树中值为e的节点，递归算法
    //返回删除节点后新的二分搜索树的根
    private Node remove(Node node ,E e){
        if(node == null){
            return  null;
        }
        if(e.compareTo(node.e) < 0){
            node.left = remove(node.left,e);
            return node;
        }else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right,e);
            return node;
        }else{ // e == node.e
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size -- ;
                return leftNode;
            }
            //待删除的节点左右子树均不为空的情况
            /*
                解决办法：找到比待删除节点打的最小节点，即待删除节点右子树的最小节点
                用这个节点顶替待删除节点的位置
             */
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            //删除掉但删除的节点
            node.left = node.right = null;
            return successor;

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
