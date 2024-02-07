package insert;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        if (head == null) {
            // If the list is empty, the new node becomes the head
            return newNode;
        }

        SinglyLinkedListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        // Append the new node at the tail
        temp.next = newNode;

        return head;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // Handle the case where System.getenv("OUTPUT_PATH") is null
        if (System.getenv("OUTPUT_PATH") == null) {
            System.out.println("Please set the OUTPUT_PATH environment variable.");
            return;
        }

        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < llistCount; i++) {
            int llistItem = Integer.parseInt(scanner.nextLine());

            SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, llistItem);

            llist.head = llist_head;
        }

        printSinglyLinkedList(llist.head, "\n", bufferedWriter);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;

        public SinglyLinkedList() {
            this.head = null;
        }
    }
}


