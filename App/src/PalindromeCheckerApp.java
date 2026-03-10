class Node {
    char data;
    Node next;
    Node(char data) {
        this.data = data;
        this.next = null;
    }
}
class SinglyLinkedList {
    Node head;
    public void add(char data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    public Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public boolean isPalindrome() {
        if (head == null || head.next == null)
            return true;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node secondHalf = reverse(slow);
        Node firstHalf = head;
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data)
                return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }
}
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        String input = "level";
        SinglyLinkedList list = new SinglyLinkedList();
        for (char c : input.toCharArray()) {
            list.add(c);
        }
        boolean result = list.isPalindrome();
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
    }
}