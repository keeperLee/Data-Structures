import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        BST<Integer> bst = new BST<Integer>();

        int n = 1000;
        Random random = new Random();
        //此二分搜索树不承载相同元素，所以之后的元素个数没有1000个。
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }
        ArrayList<Integer>  nums = new ArrayList<Integer>();
        while (!bst.isEmpty()){
            nums.add(bst.removeMin());
        }
        System.out.println(nums);

        for(int i=1 ; i< nums.size() ; i ++){
            if(nums.get(i-1) > nums.get(i)){
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("removeMin test completed.");

        //test removeMax
        for(int i = 0 ; i < n ; i ++){
            bst.add(random.nextInt(10000));
        }
        nums = new ArrayList<Integer>();
        while(!bst.isEmpty()){
            nums.add(bst.removeMax());
        }
        System.out.println(nums);
        for(int i = 1 ; i < nums.size() ; i ++){
            if(nums.get(i-1) < nums.get(i)){
                throw new IllegalArgumentException("Error!");
            }
        }
        System.out.println("removeMax test completed.");


//        int[] nums = {5,3,6,8,4,2};
//        for(int num : nums){
//            bst.add(num);
//        }
        ////////////////////
        //        5       //
        //      /   \     //
        //     3     6   //
        //   /  \     \  //
        //  2   4     8  //
        //////////////////
//        bst.levelOrder();
//        bst.preOrder();
//        System.out.println();
//
//        bst.preOrderNR();
//        System.out.println();
//        bst.inOrder();
//        System.out.println();
//
//        bst.postOrder();
//        System.out.println();

//        System.out.println(bst);
    }
}
