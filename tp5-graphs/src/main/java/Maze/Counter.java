package Maze;

public class Counter {
    public int totalNodesTraversed = 0;
    public int stackedNodes = 0;
    public int maxStackSize = 0;

    void incrementTotalNodesTraversed() { totalNodesTraversed++; }
    void displayAndIncrementStackedNodes() { System.out.print(stackedNodes++ + ", "); }
    void displayAndDecrementStackedNodes() { System.out.print(stackedNodes-- + ", "); }
    int getStackedNodes() { return stackedNodes; }

    void updateMaxStackSize() {
        if ( maxStackSize < getStackedNodes() ) {
            maxStackSize = getStackedNodes();
        }
    }
}
