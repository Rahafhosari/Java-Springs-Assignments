public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
        this.head = null;
    }
    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }    
    public Integer remove(){
        //if list is empty
        if(head == null) {
            return null;
        } 
        //if list has 1 value
        Node runner = head;
        if(runner.next == null){
            int temp = head.value;
            head = null;
            return temp;
        }
        //if list has more than one value 
        while(runner.next.next != null) {
            runner = runner.next;
        }
        int temp = runner.next.value;
        runner.next = null;
        return temp;
    }
    
    public void printValues(){
        //if list is empty
        if(head == null) {
            System.out.println("The List is Empty!");
        } 
        // has values
        Node runner = head;
        while(runner.next != null){
            System.out.print(String.format(" Node Value: %s"+", Next Value: %s", runner.value, runner.next.value));
            runner = runner.next;
        }
        System.out.println(String.format("|Node Value:%s", runner.value));
        
    }   
}

//or we can define a function isEmpty() 
//and call it each time we're checking
//private boolean isEmptY(){
// return this.head == null;}


