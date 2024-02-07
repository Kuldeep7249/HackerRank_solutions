package delete;

import java.io.*;
import java.util.stream.IntStream;

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}

class Result {
    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        if (head == null) {
            return null;  // Empty list
        }

        if (position == 0) {
            return head.next;  // Move head to the next node
        }

        SinglyLinkedListNode current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current.next == null) {
                return head;  // Position out of bounds
            }
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;  // Skip the node to delete
        }

        return head;
    }
}

 class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        SinglyLinkedList list = new SinglyLinkedList();

        int listCount = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, listCount).forEach(i -> {
            try {
                int listItem = Integer.parseInt(bufferedReader.readLine().trim());
                list.insertNode(listItem);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int position = Integer.parseInt(bufferedReader.readLine().trim());

        SinglyLinkedListNode list1 = Result.deleteNode(list.head, position);

        SinglyLinkedListPrintHelper.printList(list1, " ", bufferedWriter);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


