/**
 * 测试自己定义的数组类
 */
public class ArrayTest {

    public static void main(String[] args) {
        //--------------------------------------------一般性的测试如下--------------------------------------//
        System.out.println("    //--------------------------------------------一般性的测试如下--------------------------------------//");
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

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

        arr.removeLast();
        System.out.println(arr);

        //--------------------------------------------使用泛型的测试如下--------------------------------------//
        System.out.println("    //--------------------------------------------使用泛型的测试如下--------------------------------------//");
        Array<Integer> arr2 = new Array<Integer>(20);
        //添加方法的测试如下：
        for(int i = 0 ; i < 10 ; i ++){
            arr2.addLast(i);
        }
        System.out.println(arr2);

        arr2.add(1,100);
        System.out.println(arr2);

        arr2.addFirst(-1);
        System.out.println(arr2);

        //删除方法的测试如下：
        arr2.remove(2);
        System.out.println(arr2);

        arr2.removeElement(4);
        System.out.println(arr2);

        arr2.removeFirst();
        System.out.println(arr2);

        arr2.removeLast();
        System.out.println(arr2);
        //--------------------------------------------动态扩容的测试如下--------------------------------------//
        System.out.println(" //--------------------------------------------动态扩容的测试如下--------------------------------------//\n" +
                "    ");
        Array<Integer> arr3 = new Array<Integer>();
        for (int i = 0 ; i < 10 ; i ++){
            arr3.addLast(i);
        }
        System.out.println(arr3);

        arr3.add(1,100);
        System.out.println(arr3);

        arr3.addFirst(-1);
        System.out.println(arr3);

        arr3.remove(2);
        System.out.println(arr3);

        arr3.removeElement(4);
        System.out.println(arr3);

        arr3.removeFirst();
        System.out.println(arr3);


    }



}
