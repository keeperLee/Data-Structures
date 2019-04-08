public class StackTest {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<Integer>();
        //入栈操作
        for(int i = 0 ; i < 5; i ++){
            stack.push(i);
            System.out.println(stack);
        }
        //出栈操作
        stack.pop();
        System.out.println(stack);
    }
}
