class MinStack {
    
    class Node {
        int data;
        Node next;
        int currMin;
        Node(int data) {
            this.data = data;
            this.currMin = data;
        }
    }

    Node head;

    public MinStack() {
        head = null;
    }

    
    public void push(int val) {
        Node newNode = new Node(val);
        
        if (head != null) {
            newNode.next = head;
            newNode.currMin= Math.min(newNode.currMin, head.currMin);
        }

        head = newNode;
    }
    
    public void pop() {
        validate();
        head = head.next;
    }

    public int top() {
        validate();
        return head.data;
    }

    public int getMin() {
        validate();
        return head.currMin;
    }

    private void validate() {
       
    } 
}