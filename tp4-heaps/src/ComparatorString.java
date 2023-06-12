import java.util.ArrayList;

public class ComparatorString implements Comparable<ComparatorString>{
    private String s1;

    /**
     * Constructor of ComparatorString
     * @param s1 the string to be converted into ComparatorString
     * @return the generated ComparatorString
     */
    public ComparatorString(String s1) {
        this.s1 = s1;
    }

    /**
     * Getter for ComparatorString
     * @return the s1 attribute of the class of type ComparatorString
     */
    public String getS1() {
        return s1;
    }

    /**
     * Method to compare the number of occurrences of the char 'a' in two given ComparatorString
     * @param s1 the ComparatorString to be compared with the one calling the method
     * @return the difference of the number of char 'a' in both ComparatorString
     */
    @Override
    public int compareTo(ComparatorString o) {
        return countOccurrencesOfA(this.s1) - countOccurrencesOfA(o.getS1());
    }

    /**
     * Method to generate an array of ComparatorString
     * @param arr the array of strings to be converted into the array of ComparatorString
     * @return the generated array of ComparatorString
     */
    public static ArrayList<ComparatorString> generate(String[] arr){
        ArrayList<ComparatorString> list = new ArrayList<>();
        for (String s : arr){
            list.add(new ComparatorString(s));
        }
        return list;
    }

    /**
     * Method counting the number of occurrences of the char 'a' in a given string
     * @param word the string on which the number of occurrences will be calculated
     * @return integer containing the number of occurrences of the char 'a' in the given strings
     */
    public int countOccurrencesOfA(String word) {
        int counter = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'a') {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Method converting the ComparatorString on which the method is called upon into a String
     * @return the String generated from converting the ComparatorString into a String
     */
    @Override
    public String toString() {
        return this.s1;
    }
}
