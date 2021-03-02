package abdulbari.practice006.linkedlist;

public class T_002_SinglyLinkedList {

    public static class Node{
        public int data;
        public Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static class SinglyLinkedList{
        private Node head;

        SinglyLinkedList(){
            this.head = null;
        }

        public void insert(int index, int data){
            if(index < 0 || index > size()){
                return;
            }
            Node newNode = new Node(data);
            if(index == 0){
                newNode.next = head;
                head = newNode;
            } else {
                Node current = head;
                for(int i=0; i<index-1; i++){
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
            }
        }

        public String search(int data){
            Node current = head;
            int index = 0;
            while(current != null){
                if(current.data == data){
                    return "Node ["+data+"] found at index : " + index;
                } else {
                    current = current.next;
                    index++;
                }
            }
            return "Node ["+data+"] not found.";
        }

        public boolean delete(int data){
            if(head.data == data){
                head = head.next;
                return true;
            }
            Node current = head;
            Node previous = null;
            while(current != null && current.data != data){
                previous = current;
                current = current.next;
            }
            if(current != null){
                previous.next = current.next;
                return true;
            }
            return  false;
        }

        public int size(){
            int count = 0;
            Node current = head;
            while(current != null){
                count++;
                current = current.next;
            }
            return count;
        }

        public void display(){
            Node current = head;
            while(current != null){
                System.out.print(current.data);
                if(current.next != null){
                    System.out.print("->");
                }
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(0, 378);
        list.insert(0, 22);
        list.insert(1, 673);
        list.insert(2, 23);
        list.insert(1, 1);
        list.insert(0, 9);
        list.insert(6, 10);
        list.insert(8, 9);
        list.display();
        System.out.println("==========================");
        System.out.println(list.search(23));
        System.out.println(list.search(66));
        System.out.println("==========================");
        System.out.println(list.delete(398));
        list.display();
        System.out.println(list.delete(9));
        list.display();
        System.out.println(list.delete(378));
        list.display();
        System.out.println("==========================");
    }
}
