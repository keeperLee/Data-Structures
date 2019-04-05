public class Main {

    public static void main(String[] args) {

        //定义一个数组
        int[] a;
        //创建一维数组对象,此时jvm会在堆区中为数组分配空间。
        a = new int[100];

        //动态初始化：指的是数组定义、分配空间与赋值的操作分开进行，如下
        int[] arr = new int[10];
        for(int i = 0 ; i < arr.length ; i ++){
            arr[i] = i;
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        //静态初始化：指的是定义数组的同时就为数组分配空间并且赋值。
        //静态初始化方式一 ，如下
        int[] scores = new int[]{100,99,88};
        for(int i = 0 ; i < scores.length ; i ++){
            System.out.print(scores[i] + " ");
        }
        System.out.println();

        //静态初始化二 ，如下
        int[] scores2 = {99,99,97};
        for(int score : scores2){
            System.out.print( score + " ");
        }

    }
}
