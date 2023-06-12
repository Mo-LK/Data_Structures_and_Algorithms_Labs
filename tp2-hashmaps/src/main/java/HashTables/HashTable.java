package HashTables;

public interface HashTable<AnyType> { //Verify: some methods were private in teacher's notes, but this requires a body.
    public void insert( AnyType x );
    public void rehash( );
    public int findPos( AnyType x );
    public void remove( AnyType x );
    public boolean contains( AnyType x );
    public boolean isActive( int currentPos );

    public void makeEmpty( );
    public int myhash( AnyType x );
    public static class HashEntry<AnyType> {};

    /**
     * Internal method to allocate array.
     * @param arraySize the size of the array.
     */
    @SuppressWarnings("unchecked")
    public void allocateArray( int arraySize );

    /**
     * Internal method to find a prime number at least as large as n.
     * @param n the starting number (must be positive).
     * @return a prime number larger than or equal to n.
     */
    public int nextPrime( int n );

    /**
     * Internal method to test if a number is prime.
     * Not an efficient algorithm.
     * @param n the number to test.
     * @return the result of the test.
     */
    public boolean isPrime( int n );

    public int biggestPrimeArraySize();
}