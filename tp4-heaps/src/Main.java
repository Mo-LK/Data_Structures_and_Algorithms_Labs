// Auteurs: Simon Bachand 2164037, Mounir Lammali 2141302

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    /**
     * Method to generate an array of random integers
     * @param size the wanted size of the array
     * @param range the range of values of the integers
     * @return the array with randomly generated integers
     */
    public static Integer[] generateList(int size, int range) {
        Integer[] list = new Integer[size];
        for (int i = 0; i < size; i++) {
            list[i] = (int)(Math.random() * range);
        }
        return list;
    }
    public static void main(String[] args) throws UnderflowException{
        //Partie 1:
        System.out.println("Partie 1:");
        Integer[] array1 = generateList(10, 100);
        Integer[] array2 = generateList(10, 100);
        Integer[] array3 = generateList(10, 100);

        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(array1));
        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(array2));
        ArrayList<Integer> arrayList3 = new ArrayList<>(Arrays.asList(array3));

        System.out.println("Array1: " + arrayList1);
        System.out.println("Array2: " + arrayList2);
        System.out.println("Array3: " + arrayList3);

        Heap<Integer> heap1 = new Heap<>(arrayList1);
        Heap<Integer> heap2 = new Heap<>(true, arrayList2);
        Heap<Integer> heap3 = new Heap<>(false, arrayList3);

        System.out.println("Heap1: " + heap1.print());
        System.out.println("Heap2: " + heap2.print());
        System.out.println("Heap3: " + heap3.print());

        System.out.println();
        System.out.println();

        //Partie 2:
        System.out.println("Partie 2:");
        Integer[] array4 = generateList(25, 100);
        Integer[] array5 = generateList(25, 100);
        Integer[] array6 = generateList(25, 100);

        ArrayList<Integer> arrayList4 = new ArrayList<>(Arrays.asList(array4));
        ArrayList<Integer> arrayList5 = new ArrayList<>(Arrays.asList(array5));
        ArrayList<Integer> arrayList6 = new ArrayList<>(Arrays.asList(array6));

        System.out.println("Array4: " + arrayList4);
        System.out.println("Array5: " + arrayList5);
        System.out.println("Array6: " + arrayList6);

        Heap.heapsort(arrayList4);
        Heap.heapsort(arrayList5);
        Heap.heapsort(arrayList6);

        System.out.println("=====================================================");
        System.out.println("Sorted Array4: " + arrayList4);
        System.out.println("Sorted Array5: " + arrayList5);
        System.out.println("Sorted Array6: " + arrayList6);

        System.out.println();
        System.out.println();

        //Partie 3:
        System.out.println("Partie 3:");
        int[] intArray = {1,1,1,1,2,3,4,5,5,6,7,8,9,9,9};
        ArrayList<ComparatorInt> listInt = ComparatorInt.generate(intArray);
        Heap.heapsort(listInt);
        int k = 2;
        System.out.println("Si K = " + k + ", le heap retourne " + listInt.get(k - 1));

        String[] stringArray = {"aaa", "abc", "aab", "AaAb", "zsw" };
        ArrayList<ComparatorString> listString = ComparatorString.generate(stringArray);
        Heap.heapsort(listString);
        int q = 2;
        System.out.println("Si Q = " + q + ", le heap retourne \"" + listString.get(q - 1) + "\"");

    }
}
