/** Name: Cassie Flones
 *  COSC 311 FA19
 *  hw0912
 *  URL: https://github.com/cflones/COSC311/blob/master/SinglyLinkedList.java
 *
 *  Modified from Drozdek, Data Structures and Algorithms in Java
 */

public class SinglyLinkedList {

   public class Node {
      int   data;
      Node  next;
      
      public Node () {
         this (0, null);
      }
      
      public Node (int data) {
         this(data, null);
      }
      
      public Node(int data, Node next) {
         this.data = data;
         this.next = next;
      }
   }
   
   Node  head, tail;
   
   public SinglyLinkedList() {
      head = tail = null;
   }
   
   public void insert(int data) {
	   Node x = new Node(data);
	   Node current;
	   
	   //head node
	   if (head==null || head.data >= x.data)
	   {
		   x.next = head;
		   head = x;
	   }
	   else {
		   current = head;
		   while (current.next != null && current.next.data < x.data)
			   current = current.next;
		   
		   x.next = current.next;
		   current.next=x;
	   }
		   
   }
   
   public void delete(int el) {
      if (!isEmpty() )
         if ( head == tail && el == head.data)
            head = tail = null;
         else if (el == head.data )
            head = head.next;
         else {   
            Node p, q;
            for ( p= head, q = head.next; 
                  q != null && !(q.data == el ); 
                  p = p.next, q = q.next) ;
            if (q != null) {
               p.next = q.next;
               if (q == tail )
                  tail = p;
            }
         } 
   } 

   public boolean isEmpty() {
      return head == null;
   }
   
   public String  toString() {
      String s = "";
      if (head == null) { 
         return "Empty String" ;
      }
      for (Node p = head; p != null; p = p.next) 
         s += p.data + " ";
      return s;
   }
     
   public static void main(String[] args) {
      SinglyLinkedList list = new SinglyLinkedList();
      
      System.out.println("Execution begun");
      System.out.println("initial list: " + list );
      
      //testing
      list.insert(3);
      list.insert(5);
      System.out.println(list);
      
      list.insert(2);
      list.insert(2);
      list.insert(2);
      list.insert(7);
      list.insert(6);
      System.out.println("list after inserts: "+list);
      
      list.delete(2);
      list.delete(5);
      list.delete(7);
      System.out.println("list after deletes: " + list);
      
      System.out.println("Execution terminated");
   }
}