package algorithm;

/**
 * @author 794073612@qq.com
 * @time 9:13 2022/6/15
 **/
public class TraceRecord {
    public Node first;
    public Node last;

    public boolean isEmpty(){
        return first == null;
    }

    public void insert(int x, int y){
        Node newNode = new Node(x, y);
        if (this.isEmpty()){
            first = newNode;
            last = newNode;
        }else {
            last.next = newNode;
            last = newNode;
        }
    }
    public void delete(){
        Node newNode;
        if(isEmpty()){
            System.out.println("队列已经空了");
            return;
        }
        newNode = first;
        while (newNode.next != last){
            newNode = newNode.next;
        }
        newNode.next = last.next;
        last = newNode;
    }
}
class Node{
    int x;
    int y;
    Node next;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
        this.next = null;
    }
}
