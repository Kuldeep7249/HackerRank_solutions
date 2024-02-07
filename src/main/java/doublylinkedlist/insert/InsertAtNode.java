package doublylinkedlist.insert;


import java.io.*;
import java.util.stream.IntStream;

class DoublyLinkedListNode {
    public int data;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    public DoublyLinkedListNode head;
    public DoublyLinkedListNode tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
        }

        this.tail = node;
    }
}

class DoublyLinkedListPrintHelper {
    public static void printList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
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

    /*
     * Complete the 'sortedInsert' function below.
     *
     * The function is expected to return an INTEGER_DOUBLY_LINKED_LIST.
     * The function accepts following parameters:
     *  1. INTEGER_DOUBLY_LINKED_LIST llist
     *  2. INTEGER data
     */

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */


    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

        if (head == null) {
            return newNode;  // If the list is empty, the new node becomes the head
        }

        if (data < head.data) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;  // If the new node should be the new head
        }

        DoublyLinkedListNode current = head;

        while (current.next != null && current.next.data < data) {
            current = current.next;
        }

        newNode.next = current.next;
        if (current.next != null) {
            current.next.prev = newNode;
        }

        current.next = newNode;
        newNode.prev = current;

        return head;
    }


}

 class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                DoublyLinkedList list = new DoublyLinkedList();

                int listCount = Integer.parseInt(bufferedReader.readLine().trim());

                IntStream.range(0, listCount).forEach(i -> {
                    try {
                        int listItem = Integer.parseInt(bufferedReader.readLine().trim());

                        list.insertNode(listItem);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int data = Integer.parseInt(bufferedReader.readLine().trim());

                DoublyLinkedListNode list1 = Result.sortedInsert(list.head, data);

                DoublyLinkedListPrintHelper.printList(list1, " ", bufferedWriter);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}


