package OnTap;

import javax.management.ValueExp;
import java.util.Arrays;

public class MyList {
    private Node head;
    private Node tail;

    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void display(int[] a){
        for (int j : a) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public void bubbleSort(int[] a){
        for (int i = 0; i < a.length - 1; i++){
            boolean flag = false;
            for (int j = 0; j < a.length - 1 - i; j++){
                if (a[j] > a[j+1]){
                    swap(a, j , j+1);
                    flag = true;
                }
            }
            display(a);
            if (!flag){
                break;
            }
        }
    }

    public void insertSort(int[] a){
        for (int i = 1; i < a.length; i++){
            int key = a[i];
            int j;
            for (j = i - 1; j >= 0 && a[j] > key; j--){
                a[j + 1] = a[j];
            }
            a[j + 1] = key;
            display(a);
        }
    }

    public void selectSort(int[] a){
        for (int i = 0; i < a.length - 1; i++){
            int minIdx = i;
            for (int j = i + 1; j < a.length; j++){
                if (a[minIdx] > a[j]){
                    minIdx = j;
                }
            }
            if (i != minIdx){
                swap(a, i, minIdx);
            }
            display(a);
        }
    }

    public void insertAtHead(int data){
        Node newNode = new Node(data, null);
        if (head == null){
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        newNode.nextNode = this.head;
        this.head = newNode;
    }

    public void insertAtTail(int data){
        Node newNode = new Node(data, null);
        if (head == null){
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        this.tail.nextNode = newNode;
        this.tail = newNode;
    }
}
