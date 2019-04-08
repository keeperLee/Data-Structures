public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    //插入元素e
    void push(E e);
    //删除元素e
    E pop();
    //获取元素e
    E peek();
}
