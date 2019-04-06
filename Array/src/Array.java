/**
 * 自己定义的的数组类
 */
public class Array {

    private int[] data;
    //数组的实际元素个数
    private int size;

    //构造函数，传入数组的容量capacity构造Array
    public Array(int capacity){
        data = new int[capacity];
        size = 0;
    }
    //无参数的构造函数，默认数组的容量capacity=10
    public Array(){
        this(10);
    }

    //获取数组中元素的个数
    public int getSize(){
        return size;
    }

    //获取数组的容量
    public  int getCapacity(){
        return data.length;
    }

    //判断数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

}
