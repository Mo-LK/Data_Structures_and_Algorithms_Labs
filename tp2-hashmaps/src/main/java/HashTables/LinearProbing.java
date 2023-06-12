package HashTables;

public class LinearProbing<AnyType> extends AbsHashTable<AnyType> {
    public LinearProbing() { this(DEFAULT_TABLE_SIZE); }

    public LinearProbing(int size) {
        allocateArray(size);
        makeEmpty();
    }

    public int findPos(AnyType x) {
        int offset = 1;
        int currentPos = myhash(x);

        while (array[currentPos] != null && !array[currentPos].element.equals(x)) {
            currentPos += offset;
            if (currentPos >= array.length)
                currentPos -= array.length;
        }

        return currentPos;
    }
}