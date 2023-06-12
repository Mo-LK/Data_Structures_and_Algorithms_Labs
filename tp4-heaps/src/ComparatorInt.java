import java.util.ArrayList;

public class ComparatorInt implements Comparable<ComparatorInt>{
    private int value;
    private int frequency = 0;

    private static int[] initialArray;

    /**
     * Constructor of ComparatorInt
     * @param value the int to be converted into ComparatorString
     * @return the generated ComparatorInt
     */
    public ComparatorInt(int value) {
        this.value = value;
        countFrequency();
    }

    /**
     * Getter for ComparatorInt
     * @return the s1 attribute of the class of type ComparatorInt
     */
    public int getValue() {
        return value;
    }

    /**
     * Method to compare the number of occurrences of the char 'a' in two given ComparatorInt
     * @param o the ComparatorInt to be compared with the one calling the method
     * @return the difference between the frequencies of both ComparatorInt
     */
    @Override
    public int compareTo(ComparatorInt o) {
        return this.getFrequency() - o.getFrequency();
    }

    /**
     * Method to generate an array of ComparatorInt
     * @param arr the array of strings to be converted into the array of ComparatorInt
     * @return the generated array of ComparatorInt
     */
    public static ArrayList<ComparatorInt> generate(int[] arr){
        initialArray = arr;
        ArrayList<ComparatorInt> list = new ArrayList<>();
        for (int x : arr){
            if (!contains(list, x))
                list.add(new ComparatorInt(x));
        }
        return list;
    }

    /**
     * Method returning true if the value given in parameter exists in the array of ComparatorInt
     * @param list the array of ComparatorInt to analyze
     * @param value the value to be found inside the array of ComparatorInt
     * @return the generated array of ComparatorString
     */
    private static boolean contains(ArrayList<ComparatorInt> list, int value){
        for (ComparatorInt comp : list){
            if (comp.getValue() == value)
                return true;
        }
        return false;
    }

    /**
     * Method called by the constructor to count the number of occurrences of the integer in initialArray
     */
    private void countFrequency() {
        int frequency = 0;
        for (int i : initialArray) {
            if (this.value == i) {
                frequency++;
            }
        }
        this.frequency = frequency;
    }

    /**
     * Getter of the frequency class attribute
     * @return the frequency class attribute
     */
    public int getFrequency(){
        return this.frequency;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
