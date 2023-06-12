import java.lang.reflect.Array;
import java.util.*;

class AVLTreeTester {
    static ArrayList<Integer> generateNumbers(int size) {
        ArrayList<Integer> randomList = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            int node = (int)(Math.random() * size);
            if (!randomList.contains(node))
                randomList.add(node);
        }
        return randomList;
    }

    static Set<Integer> randomSet(int size) {
        Set<Integer> returnedSet = new HashSet<Integer>();
        while(returnedSet.size() < size) {
            returnedSet.add((int)(Math.random() * size * 100));
        }
        return returnedSet;
    }
    static Set<Integer> increasingSet(int size) {
        Set<Integer> returnedSet = new HashSet<Integer>();
        for (int i = 1; i <= size; i++){
            returnedSet.add(i);
        }
        return returnedSet;
    }

    public static void main(String[] args) {
        int start = 100;
        int end = 17000;
        int steps = 100;
        int amountSearch = 10;
        int increment = (end-start)/(steps-1);
        for(int i = start; i <= end; i+=increment) {
            AvlTree<Integer> avl = new AvlTree<>();
            BinarySearchTree<Integer> bst = new BinarySearchTree<>();
            Set<Integer> set = randomSet(i);
            for(int elem : set) {
                avl.add(elem);
                bst.add(elem);
            }
            Set<Integer> searchRandomElems = randomSet(amountSearch);
            for(int elem : searchRandomElems) {
                avl.contains(elem);
            }
            int AVLSearchCount = avl.counterSearch.value;
            avl.counterSearch.reset();
            for(int elem : searchRandomElems) {
                bst.contains(elem);
            }
            System.out.println(String.format("%s, %s, %s, %s, %s", set.size(), avl.AVLcounterInsertion.value,
                    bst.counterInsertion.value, AVLSearchCount,
                    bst.counterSearch.value));
        }


//        System.out.println("Parcours préordre de BST: "); bst.printPreOrder(); System.out.println("");
//        System.out.println("Parcours en ordre de BST: "); bst.printInOrder(); System.out.println("");
//        System.out.println("Parcours par niveau de BST: "); bst.printPostOrder(); System.out.println("");
//
//        System.out.println("Parcours préordre de AVL: "); avl.printPreOrder(); System.out.println("");
//        System.out.println("Parcours en ordre de AVL: "); avl.printInOrder(); System.out.println("");
//        System.out.println("Parcours par niveau de AVL: "); avl.printPostOrder(); System.out.println("");
    }
}
