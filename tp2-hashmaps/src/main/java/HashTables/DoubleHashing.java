package HashTables;

public class DoubleHashing<AnyType> extends AbsHashTable<AnyType> {
    public DoubleHashing() { this(DEFAULT_TABLE_SIZE); }

    public DoubleHashing(int size) {
        allocateArray(size);
        makeEmpty();
    }

    public int findPos(AnyType x) {
        int offset = 1;
        int currentPos = myhash(x);

        int R = biggestPrimeArraySize();
        int H2 = R - (x.hashCode() % R);

        while (array[currentPos] != null && !array[currentPos].element.equals(x)) {
            currentPos = offset * H2 % array.length;
            offset++;

            if (currentPos >= array.length) {
                currentPos -= array.length;
            }
        }
        return currentPos;
    }
}