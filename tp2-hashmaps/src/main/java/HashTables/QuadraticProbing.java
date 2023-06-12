package HashTables;

import org.apache.pdfbox.jbig2.decoder.arithmetic.ArithmeticIntegerDecoder;

public class QuadraticProbing<AnyType> extends AbsHashTable<AnyType> {
    /**
     * Construct the hash table.
     */
    public QuadraticProbing() {this(DEFAULT_TABLE_SIZE);}

    /**
     * Construct the hash table.
     *
     * @param size the approximate initial size.
     */
    public QuadraticProbing(int size) {
        allocateArray(size);
        makeEmpty();
    }

    /**
     * Method that performs quadratic probing resolution.
     * Assumes table is at least half empty and table length is prime.
     *
     * @param x the item to search for.
     * @return the position where the search terminates.
     */
    public int findPos(AnyType x) {

        int offset = 1;
        int currentPos = myhash(x);

        while (array[currentPos] != null && !array[currentPos].element.equals(x)) {
            currentPos += offset;  // Compute ith probe
            offset += 2;
            if (currentPos >= array.length)
                currentPos -= array.length;
        }

        return currentPos;
    }
}