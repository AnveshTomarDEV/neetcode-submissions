class MyLinkedList {

    // Node class
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode head;
    private int size;

    // Constructor
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    // Get value at index
    public int get(int index) {

        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.val;
    }

    // Add at head
    public void addAtHead(int val) {

        ListNode node = new ListNode(val);

        node.next = head;
        head = node;

        size++;
    }

    // Add at tail
    public void addAtTail(int val) {

        ListNode node = new ListNode(val);

        if (head == null) {
            head = node;
            size++;
            return;
        }

        ListNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = node;

        size++;
    }

    // Add at any index
    public void addAtIndex(int index, int val) {

        if (index < 0 || index > size) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
            return;
        }

        ListNode current = head;

        // Move to node before insertion position
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        ListNode node = new ListNode(val);

        node.next = current.next;
        current.next = node;

        size++;
    }

    // Delete node at index
    public void deleteAtIndex(int index) {

        if (index < 0 || index >= size) {
            return;
        }

        if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        ListNode current = head;

        // Move to node before deletion
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        current.next = current.next.next;

        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */