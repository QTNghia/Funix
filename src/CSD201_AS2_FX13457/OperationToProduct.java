package CSD201_AS2_FX13457;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OperationToProduct {

    /**
     * Find and returning index of Product with bcode input from keyboard.
     * @param list Linked List
     * @return int index of Product in list
     */
    public int index(@NotNull MyList list){
        Scanner sc = new Scanner(System.in);
        String bcode = sc.nextLine();
        int idx = 0;
        Node current = list.getHead();
        while (current != null){
            if (current.getData().getBcode().equals(bcode)){
                return idx;
            }
            idx++;
            current = current.getNextNode();
        }
        return -1;
    }

    /**
     * Creating and returning a product with info input from keyboard.
     */
    public Product createProduct(@NotNull MyList list){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input new ID: ");
        String bcode = sc.nextLine();
        System.out.print("Input Product's Name: ");
        String title = sc.nextLine();
        System.out.print("Input Product's Quantity: ");
        int quantity = sc.nextInt();
        System.out.print("Input Product's Price: ");
        double price = sc.nextDouble();
        Product newProduct = new Product(bcode, title, quantity, price);
        list.insertAtTail(newProduct);
        System.out.println("Successfully!");
        return newProduct;
    }

    /**
     * Read file and save to Doubly Ended List
     * @param file file in put
     * @param list Doubly Ended List
     */
    public void readSaveAndDisplay(File file, MyList list) {
        String results = "";
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String lineOfText = reader.nextLine();
                if (lineOfText.startsWith("ID") || lineOfText.startsWith("-")) { // loại hàng title đầu tiên
                    continue;
                }
                results += lineOfText + "\n";
            }
            String[] a = results.split("\n"); // chia nho String trong file data theo hàng
            for (int j = 0; j < a.length; j++) {
                String[] b = a[j].split("   |   "); // chia nhỏ từng thành phần trong hàng qua dấu |
                Product demo = new Product(b[0],b[2],Integer.parseInt(b[4]),Double.parseDouble(b[6])); // chuyển data dạng chuỗi sang số thực và int
                list.insertAtTail(demo);
            }
            reader.close();
            System.out.println(list.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Save String data to file
     * @param file output file to save String
     * @param data String
     */
    public void saveToFile(File file, String data) {
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(data + "\n");
            System.out.println();
            writer.close();
            System.out.println("Successfully Saved!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Searching product by ID input from keyboard.
     * If not found, print -1
     * @param list Linked List
     */
    public String searchByID(@NotNull MyList list){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the ID to search = ");
        String bcode = sc.nextLine();
        Node current = list.getHead();
        while (current != null){
            if (current.getData().getBcode().equals(bcode)){
                String result = """
                ID   |  Title   |   Quantity   |   Price
                --------------------------------
                """;
                result += current.toString();
                return "Resuld:\n" + result;
            }
            current = current.getNextNode();
        }
        return "Resuld: -1";
    }

    /**
     * Deleting first product that has the ID input from keyboard from the list.
     * @param list Linked List
     */
    public String deleteByID(@NotNull MyList list){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the ID to delete = ");
        String bcode = sc.nextLine();
        return list.delete(bcode);
    }

    /**
     * Sorting products in linked list by ID. Use QUICKSORT
     * @param list Linked List
     */
    public void quickSort(@NotNull MyList list){
        Node tag, p;

        if (list.getHead() == list.getTail()){
            return;
        }

        MyList list1 = new MyList();
        MyList list2 = new MyList();

        tag = list.getHead();
        list.setHead(list.getHead().getNextNode());
        tag.setNextNode(null);

        while (list.getHead() != null){
            p = list.getHead();
            list.setHead(list.getHead().getNextNode());
            p.setNextNode(null);

            if (p.getData().getBcode().compareTo(tag.getData().getBcode()) <= 0){
                list1.insertToHead(p.getData());
            } else {
                list2.insertToHead(p.getData());
            }
        }
        quickSort(list1);
        quickSort(list2);

        if (list1.getHead() != null){
            list.setHead(list1.getHead());
            list1.getTail().setNextNode(tag);
        } else {
            list.setHead(tag);
        }

        tag.setNextNode(list2.getHead());

        if (list2.getHead() != null){
            list.setTail(list2.getTail());
        } else {
            list.setTail(tag);
        }
    }

    /**
     * Convert a decimal to a integer number. Example: input i = 18 -> Output = 10010
     * First quantity in list.
     * @param listList Linked List
     */
    public String convertToBinary(@NotNull MyList listList){
        int a = decimalToBinary(listList.getHead().getData().getQuantity());
        //Use Stack
        /*MyStack listStack = new MyStack();
        while (a != 0){
            int r = a%2;
            a = a/2;
            listStack.push(r);
        }
        System.out.print("Result: ");
        while (!(listStack.isEmpty())){
            System.out.print(listStack.pop().getQuantity());
        }*/
        return String.valueOf(a) + "\n";
    }

    public int decimalToBinary(int i){
        if (i == 0){
            return 0;
        } else {
            return (i % 2 + 10 * decimalToBinary(i / 2));
        }
    }
}
