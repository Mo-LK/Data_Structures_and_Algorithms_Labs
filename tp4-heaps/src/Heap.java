import java.util.ArrayList;

public class Heap<AnyType extends Comparable<AnyType>>{

    public ArrayList<AnyType> array;
    private AnyType root;
    private int currentSize;
    private boolean isMaxHeap;

    /**
     * Base constructor of Heap
     * @param values the ArrayList to be transformed into a heap
     */
    public Heap(ArrayList<AnyType> values) {
        this(true, values);
    }

    /**
     * Constructor of Heap
     * @param max boolean specifying the type of Heap to be created. True being a MaxHeap
     * @param items the ArrayList to be transformed into a heap
     */
    public Heap(boolean max, ArrayList<AnyType> items) {
        this.isMaxHeap = max;
        currentSize = items.size();
        array = new ArrayList<AnyType>();
        array.add(null);
        array.addAll(items);
        heapify();
    }

    /**
     * (From the textbook)
     * Establish heap order property from an arbitrary * arrangement of items. Runs in linear time.
     */
    public void heapify(){
        for( int i = currentSize / 2; i > 0; i-- )
            percolateDown( i );
    }

    /**
     * (From the textbook, but modified)
     * Insert into the priority queue, maintaining heap order.
     * Duplicates are allowed.
     * @param x the item to insert.
     */
    public void insert( AnyType x )
    {
        if( currentSize == array.size() - 1 )
            array.add(null);
        // Percolate up
        int hole = ++currentSize;
        for( ; hole > 1 && (!isMaxHeap && x.compareTo( array.get(hole / 2)) < 0 || isMaxHeap && x.compareTo( array.get(hole / 2)) > 0); hole /= 2)
            array.set(hole, array.get(hole / 2));

        array.set(hole, x);
    }

    /**
     * (From the textbook)
     * Remove the smallest item from the priority queue.
     * @return the smallest item, or throw UnderflowException, if empty.
     */
    public AnyType deleteMin( )
    {
        if( array.isEmpty( ) )
            throw new UnderflowException( );
        AnyType minItem = findMin( );
        array.set(1, array.remove(currentSize--));
        percolateDown( 1 );
        return minItem;
    }

    /**
     * (From the textbook, but modified)
     * Internal method to percolate down in the heap.
     * @param hole the index at which the percolate begins. */
    private void percolateDown( int hole ) {
        int child;
        AnyType tmp = array.get(hole);
        for( ; hole * 2 <= currentSize; hole = child ) {
            child = hole * 2; //Considérer fils de gauche
            if( child != currentSize && // il y a deux fils
                ( !isMaxHeap && array.get(child + 1).compareTo( array.get(child) ) < 0 || isMaxHeap && array.get(child + 1).compareTo( array.get(child) ) > 0)) //et fils droit<fils gauche
                child++; //Considérer fils droit
            if( !isMaxHeap && array.get(child).compareTo( tmp ) < 0 || isMaxHeap && array.get(child).compareTo( tmp ) > 0)//fils considéré< élément à percoler
                array.set(hole, array.get(child));//Remonter le fils courrant d'un niveau
            else
                break; //Sortir de la boucle. L’élément à percoler sera inséré à position hole
        }
        array.set(hole, tmp); // Insérer l’élément à percoler à la position hole
    }

    /**
     * (From the textbook)
     * Internal method for heapsort.
     * @param i the index of an item in the heap.
     * @return the index of the left child.
     */
    private static int leftChild( int i )
    {
        return 2 * i + 1;
    }

    /**
     * (From the textbook, but modified)
     * Internal method for heapsort
     * @param a: an ArrayList of elements that implement the Comparable interface
     * @param i: the position of the element to percolate
     * @param n: the position after the last element of the heap
     */
    private static <AnyType extends Comparable<? super AnyType>>
    void percDown( ArrayList<AnyType> a, int i, int n ) {
        int child;
        AnyType tmp;
        for( tmp = a.get(i); leftChild( i ) < n; i = child ) {
            child = leftChild( i );
            if( child != n - 1 && a.get(child).compareTo( a.get(child + 1) ) > 0 )
                child++;
            if( tmp.compareTo( a.get(child) ) > 0 )
                a.set(i, a.get(child));
            else
                break;
        }
        a.set(i, tmp);
    }

    /**
     * (From the textbook, but modified)
     * Standard heapsort.
     * @param a an array of Comparable items.
     */
    public static <AnyType extends Comparable<? super AnyType>>
    void heapsort( ArrayList<AnyType> a ) {
        for( int i = a.size() / 2; i >= 0; i-- ) /* construire le monceau */
            percDown( a, i, a.size() );
        for( int i = a.size() - 1; i > 0; i-- ) {
            AnyType temp = a.get(0);
            a.set(0, a.get(i));
            a.set(i, temp); /* permuter le maximum (racine) et dernière élément du monceau */
            percDown( a, 0, i );
        }
    }

    /**
     * (From the textbook)
     * Internal method for heapsort
     * @return the maximum value in the heap
     */
    AnyType findMax( ) {
        AnyType max = array.get(1);
        for( int i = currentSize/2 + 1; i <= currentSize; i++ ) {
            if ( array.get(i).compareTo(max) > 0 )
                max = array.get(i);
        }
        return max;
    }

    /**
     * (From the textbook)
     * Internal method for heapsort
     * @return the minimum value in the heap
     */
    AnyType findMin( ) {
        AnyType min = array.get(1);
        for( int i = currentSize/2 + 1; i <= currentSize; i++ ) {
            if ( array.get(i).compareTo(min) < 0 )
                min = array.get(i);
        }
        return min;
    }

    /**
     * Method used to print the array on which it is called upon
     * @return visual representation of heap array
     */
    public StringBuilder print(){
        StringBuilder print = new StringBuilder("[");
        for (int i = 1; i < array.size() - 1; i++){
            print.append(array.get(i)).append(", ");
        }
        print.append(array.get(array.size() - 1)).append("]");
        return print;
    }
}
