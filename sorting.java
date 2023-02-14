import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

public class sorting {
    public static int[] createRandomArray(int arrayLength){
        Random rand = new Random();
        int arr[] = new int[arrayLength];

        for(int i = 0; i < arrayLength; ++i){
            arr[i] = rand.nextInt(101);
        }

        return arr;
    }

    public static void writeArrayToFile(int array[], String fileName){
        try{
            PrintWriter out = new PrintWriter(fileName);
            for(int i = 0; i < array.length; ++i){
                out.println(array[i]);
            }
            out.close();
    
        }catch (IOException e){
            System.out.println("There was an error");
            e.printStackTrace();
        }

    }

    public static int[] readFileToArray(String fileName){
        ArrayList<Integer> datalist = new ArrayList<>();
        try {
            Scanner scnr = new Scanner(new File(fileName));
            File file = new File(fileName);
            int count = 0;
            while (scnr.hasNextLine()){
                String x = scnr.nextLine();
                datalist.add(Integer.parseInt(x));
            }
            scnr.close();
            int data[] = new int[datalist.size()];
            for(int y = 0; y < datalist.size(); y++){
                data[y] = datalist.get(y);
            }
            return data;

        }catch (FileNotFoundException e) {
            System.out.println("An error has occured");
            e.printStackTrace();
        }
        return null;
    }

    public static void bubbleSort(int array[]){
        int len = array.length;
        int swap;
        for(int i = 0; i < len - 1; i++){
            for(int k = 0; k < len - i - 1; ++k){
                if(array[k] > array[k+1]){
                    swap = array[k];
                    array[k] = array[k+1];
                    array[k+1] = swap;
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.print("What is the file name?   ");
        String fileName = scnr.nextLine();

        System.out.print("What is the length of the array?  ");
        int arrLen = scnr.nextInt();
        int array[] = createRandomArray(arrLen);
        writeArrayToFile(array, fileName);
        System.out.println(" ");

        System.out.println("Here is the file " + fileName + " before sorting");
        System.out.println(Arrays.toString(array));
        System.out.println(" ");
        bubbleSort(array);
        System.out.println("Here isthe file " + fileName + " after sorting");
        System.out.println(Arrays.toString(array));
        System.out.println(" ");

        System.out.print("Enter name of file to read from:  ");
        Scanner scnrName = new Scanner(System.in);
        fileName = scnrName.nextLine();
        int fileArray[] = readFileToArray(fileName);
        System.out.println("\nBefore bubble sort\n" + Arrays.toString(fileArray) + "\n");
        bubbleSort(fileArray);
        System.out.println("After bubble sort\n" + Arrays.toString(fileArray));

        scnr.close();
        scnrName.close();
    }
}
