/**
 * 测试自己定义的数组类
 */
public class ArrayTest {

    public static void main(String[] args) {
        Array arr = new Array(20);
        //添加方法的测试如下：
        for(int i = 0 ; i < 10 ; i ++){
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1,100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        //删除方法的测试如下：
        arr.remove(2);
        System.out.println(arr);

        arr.remove(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

        arr.removeLast();
        System.out.println(arr);
    }

}
