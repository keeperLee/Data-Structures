public class LinkedList<E> {
    private class Node{
        //存放元素
        public E e;
        //指向下一个节点的引用
        public Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            //调用原来的两个参数的构造方法
            this(e,null);
        }
        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }

    }
    private Node dummyhead;      //设置一个头节点
    private int size;               //链表中的元素个数

    public LinkedList(){
        dummyhead = new Node(null,null);
        size = 0;
    }

    //获取链表中的元素的个数
    public int getSize(){
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }



    //在链表的index（从0开始）位置添加新的元素e。
    //在链表中不是一个常用的操作，这里只是用作练习。
    public void add(int index,E e){
        if(index < 0 || index > size)
            throw  new IllegalArgumentException("Add failed,Illegal index.");

        Node prev = dummyhead;
        for(int i = 0; i < index ; i++){
            prev = prev.next;
        }
            //执行插入操作
            Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;

            //以上三句话可以变成以下这一句话
            //prev.next = new Node(e,prev.next);

            //维护size这个变量
            size++;
        }

    //在链表头添加新的元素e
    public void addFirst(E e){
        //创建一个新的节点，然后将e赋值给该节点。
        //Node node = new Node(e);
        //执行操作
        //node.next = head;
        //head = node;

        //以上三行代码可以简化成下面这一句
        // head = new Node(e,head);

        add(0,e);
        //维护size这个变量
        //size++;
    }
    //在链表末尾添加新的元素e
    public void addLast(E e){
        add(size,e);
    }

    //获得链表的第index个位置的元素
    //在链表中不是一个常用的操作，这里作练习用。
    public E get(int index){
        if(index < 0 || index > size)
            throw  new IllegalArgumentException("Add failed,Illegal index.");
        Node current = dummyhead.next;
        for(int i = 0 ; i < index ; i++){
            current = current.next;
        }
        return current.e;
    }

    //获取链表的第一个元素
    public E getFirst(){
        return get(0);
    }

    //获取链表的最后一个元素
    public E getLast(){
        return get(size - 1);
    }

    //修改链表的第Index个位置的元素为e
    //在链表中不是一个常用的操作，练习用
    public void set(int index, E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Update failed,Illegal index.");
        }
        Node current = dummyhead.next;
        for(int i = 0 ; i < index ;i ++){
            current = current.next;
        }
        current.e = e;
    }
    //查找链表中是否有元素e
    public boolean contains(E e){

        Node current = dummyhead.next;
        while (current != null){
            if(current.equals(e))
                return true;
            current = current.next;
        }
        return false;
    }

    //从链表中删除index位置的元素，返回删除的元素
    //在链表中不是一个常用的操作，练习用。
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed.Index is illegal.");
        }
        Node prev = dummyhead;
        for(int i = 0; i< index ;i++){
            prev = prev.next;
        }
        Node removeNode = prev.next;
        prev.next = removeNode.next;
        removeNode.next  = null;
        size--;

        return removeNode.e;
    }
    //从链表中删除第一个元素,返回删除的元素
    public E removeFirst(){
        return remove(0);
    }
    //从链表中删除最后一个元素,返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }



    @Override
    public String toString() {
       StringBuilder res = new StringBuilder();
//       Node current = dummyhead.next;
//       while (current != null){
//           res.append(current +"->");
//           current = current.next;
//       }
        //使用以下的for循环等价于上面的while循环。
        for(Node current = dummyhead.next; current != null;current = current.next)
            res.append(current + "->");
       res.append("NULL");
       return res.toString();
    }
}
