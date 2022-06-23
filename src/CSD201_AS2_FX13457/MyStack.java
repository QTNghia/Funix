package CSD201_AS2_FX13457;

import java.io.File;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Scanner;

public class MyStack {
    private Node top;

    public MyStack() {
    }

    public void push(Product data){
        //this.top = new Node(data, top);
        Node newNode = new Node(data);
        newNode.setNextNode(this.top);
        this.top = newNode;
    }

    public void push(int data){
        Product newProduct = new Product(data);
        this.top = new Node(newProduct, top);
    }

    public Product pop() throws EmptyStackException {
        if (top == null){
            throw new EmptyStackException();
        }
        Product newProduct = this.top.getData();
        this.top = this.top.getNextNode();
        return newProduct;
    }

    public int length(){
        Node current = this.top;
        int length = 0;
        while (current != null) {
            length++;
            current = current.getNextNode();
        }
        return length;
    }

    public boolean isEmpty(){
        return (top == null);
    }

    @Override
    public String toString() {
        String result = """
                ID   |  Title   |   Quantity   |   Price
                --------------------------------
                """;
        Node current = this.top;

        while (current != null) {
            result += current.toString() + "\n";
            current = current.getNextNode();
        }
        return result;
    }

    /**
     * Read file and save to Stack List. Then print Stack List
     * @param file File to read
     * @param list Stack List
     */
    public void stackReadSaveAndDisplay(File file, MyStack list) {
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
                //Product demo = new Product(b[0],b[2],Integer.parseInt(b[4]),Double.parseDouble(b[6]));
                Product demo = new Product(b[0], b[2], Integer.parseInt(b[4]), Double.parseDouble(b[6]));
                push(demo);
            }
            reader.close();
            System.out.println(list.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
