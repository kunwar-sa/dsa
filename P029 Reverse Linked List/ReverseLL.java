public class ReverseLL {

    static class Node<Integer> {
        Integer data;
        Node<Integer> next;

        public Node(Integer data) {
            this.data = data;
        }
    }

    public static Node<Integer> insert(Node<Integer> head, int data) {

        Node<Integer> newNode = new Node<Integer>(data);
        Node<Integer> temp = head;

        if (head == null) {
            head = newNode;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
        return head;

    }

    public static void print(Node<Integer> head) {
        Node<Integer> temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();

    }

    public static void main(String[] args) {

        Node<Integer> head = null;
        // Node<Integer> head = new Node<Integer>(5);

        head = insert(head, 1);
        print(head);
        head = insert(head, 2);
        print(head);
    }
}
