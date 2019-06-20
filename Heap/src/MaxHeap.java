public class MaxHeap<E  extends Comparable<E>>{

    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<E>(capacity);
    }

    public MaxHeap(){
        data = new Array<E>();
    }

    //返回堆中的个数
    public int size(){
        return data.getSize();
    }

    //返回一个布尔值，表示堆中是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    //返回完全二叉树的数组表示中，一个索引所表示元素的父亲节点的索引
    public  int parent(int index){
        if(index == 0 ){
            throw new IllegalArgumentException("0下标是没有父亲节点的！");
        }
        return (index - 1) / 2;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    public int leftChild(int index){
        return index * 2 + 1;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    public int rightChild(int index){
        return  index *  2 + 2;
    }
}
