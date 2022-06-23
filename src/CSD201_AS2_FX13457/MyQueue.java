package CSD201_AS2_FX13457;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MyQueue {
    private Node front;
    private Node back;

    /**
     * Insert a Node at front
     * @param data info Product
     */
    public void enQueue(Product data){
        Node newNode = new Node(data);
        if (front == null){
            this.front = newNode;
            this.back = newNode;
            return;
        }
        this.back.setNextNode(newNode);
        this.back = newNode;
    }

    /**
     * Delate a Node at front
     */
    public void deQueue(){
        this.front = this.front.getNextNode();
    }

    public int length(){
        Node current = this.front;
        int length = 0;
        while (current != null){
            length++;
            current = current.getNextNode();
        }
        return length;
    }

    public boolean isEmpty(){
        /*if (length() != 0){
            return false;
        }
        return true;*/
        return length() == 0;
    }

    @Override
    public String toString() {
        String result = """
                ID   |  Title   |   Quantity   |   Price
                --------------------------------
                """;
        Node current = this.front;

        while (current != null) {
            result += current.toString() + "\n";
            current = current.getNextNode();
        }
        return result;
    }

    /**
     * Read file and save to Queue List. Then print Queue List
     * @param file File to read
     * @param list Queue List to save
     */
    public void queueReadSaveAndDisplay(File file, MyQueue list) {
        String results = "";
        try {
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String lineOfText = reader.nextLine();
                if (lineOfText.startsWith("ID") || lineOfText.startsWith("-")) {
                    continue;
                }
                results += lineOfText + "\n";
            }
            String[] a = results.split("\n");
            for (int j = 0; j < a.length; j++) {
                String[] b = a[j].split("   |   ");
                Product demo = new Product(b[0],b[2],Integer.parseInt(b[4]),Double.parseDouble(b[6]));
                enQueue(demo);
            }
            reader.close();
            System.out.println(list.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
