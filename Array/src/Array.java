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

    //向所有元素后添加一个新的元素
    public void addLast(int e){
      /*  if (size == data.length) {
            throw new IllegalArgumentException("添加失败，数组已满！");
        }
        data[size] = e;
        size ++ ;*/
      //以上代码可以简化为以下代码：
        add(size,e);
    }
    //在所有元素前添加一个新元素
    public void addFirst(int e){
        add(0,e);
    }

    //在第index个位置插入一个新元素e
    public void add(int index , int e){
        if (size == data.length) {
            throw new IllegalArgumentException("添加失败，数组已满！");
        }
        if( index <  0 || index > size){
            throw new IllegalArgumentException("添加失败，索引值不符合要求！");
        }
        for(int i = size - 1 ; i >= index ; i -- ){
            data[i+1] = data[i];
        }
        data[index] = e;
        size ++;

    }

}
