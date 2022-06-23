package CSD201_AS2_FX13457;

import java.io.File;
import java.util.Scanner;

public class AS2_Main {

    /**
     * Show Meunu
     */
    public static void showMenu(){
        System.out.println("Choose one of this options:");
        System.out.println("Product list:");
        System.out.println("1. Load data from file and display");
        System.out.println("2. Input & add to the end.");
        System.out.println("3. Display data");
        System.out.println("4. Save product list to file.");
        System.out.println("5. Search by ID");
        System.out.println("6. Delete by ID");
        System.out.println("7. Sort by ID.");
        System.out.println("8. Convert to Binary");
        System.out.println("9. Load to stack and display");
        System.out.println("10. Load to queue and display.");
        System.out.println("0. Exit");
        System.out.print("Chose: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyList listList = new MyList();
        MyStack listStack = new MyStack();
        MyQueue listQueue = new MyQueue();
        OperationToProduct op = new OperationToProduct();

        File data = new File("D:/Funix/CSD201x_02-A_VN_DN/Phan2/src/CSD201_AS2_FX13457/data.txt");
        File output = new File("D:/Funix/CSD201x_02-A_VN_DN/Phan2/src/CSD201_AS2_FX13457/console_output.txt");
        int chose;
        do {
            showMenu();
            chose = sc.nextInt();
            switch (chose) {
                case 1 -> {
                    op.readSaveAndDisplay(data, listList);
                    op.saveToFile(output, listList.toString());
                }
                case 2 -> {
                    Product newProduct = op.createProduct(listList);
                    op.saveToFile(output, newProduct.toString());
                }
                case 3 -> {
                    System.out.println(listList.toString());
                    op.saveToFile(output, listList.toString());
                }
                case 4 -> {
                    op.saveToFile(output, listList.toString());
                }
                case 5 -> {
                    op.saveToFile(output, op.searchByID(listList));
                }
                case 6 -> {
                    String delete = op.deleteByID(listList);
                    op.saveToFile(output, delete);
                }
                case 7 -> {
                    op.quickSort(listList);
                    op.saveToFile(output, listList.toString());
                }
                case 8 -> {
                    String decimalToBinary = op.convertToBinary(listList);
                    op.saveToFile(output, decimalToBinary);
                }
                case 9 -> {
                    listStack.stackReadSaveAndDisplay(data, listStack);
                    op.saveToFile(output, listStack.toString());
                }
                case 10 -> {
                    listQueue.queueReadSaveAndDisplay(data, listQueue);
                    op.saveToFile(output, listQueue.toString());
                }
                case 0 -> {
                    break;
                }
            }
        } while (!(chose == 0));
    }
}
