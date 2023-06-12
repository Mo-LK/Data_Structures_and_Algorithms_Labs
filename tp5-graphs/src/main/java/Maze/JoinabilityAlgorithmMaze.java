package Maze;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.Stack;


public class JoinabilityAlgorithmMaze {
    static ArrayList<ArrayList<Tile>> maze;
    static Counter counterJoinabilityAlgorithm;
    /** DONE
     * Returns the distance of the path within the maze
     * @param mazeUsed 2D table representing the maze
     * @return Distance of the path within the maze, null if not solvable
     */
    public static Integer findPath(ArrayList<ArrayList<Tile>> mazeUsed) {
        if (mazeUsed.isEmpty())
            return null;
        JoinabilityAlgorithmMaze.maze = mazeUsed;
        Node start = findStartNode();
        return start == null ? null : joinAlgo(start);
    }

    public static void printMaze(ArrayList<ArrayList<Tile>> maze) {
        for (ArrayList<Tile> row : maze) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining("")));
        }
    }

    private static int joinAlgo(Node entryNode){
        counterJoinabilityAlgorithm = new Counter();
        boolean[][] visited = new boolean[maze.size()][maze.get(0).size()];
        Stack<Node> workList = new Stack<>();
        // add source
        visited[entryNode.i][entryNode.j] = true;
        workList.push(entryNode);
        counterJoinabilityAlgorithm.displayAndIncrementStackedNodes();
        counterJoinabilityAlgorithm.updateMaxStackSize();
        while( !workList.isEmpty() ){
            // poll vertex and treat neighbors
            Node node = workList.pop();
            counterJoinabilityAlgorithm.displayAndDecrementStackedNodes();
            for(Node succNode : node.adj(maze)){
                if( !visited[succNode.i][succNode.j] ){
                    if (isExit(succNode)){
                        // On atteint la sortie
                        System.out.println("\n" + "MaxStackSize is: " + counterJoinabilityAlgorithm.maxStackSize);
                        System.out.println("totalNodesTraversed is: " + counterJoinabilityAlgorithm.totalNodesTraversed);
                        return succNode.distance;
                    }
                    workList.push(succNode);
                    counterJoinabilityAlgorithm.displayAndIncrementStackedNodes();
                    counterJoinabilityAlgorithm.updateMaxStackSize();
                    visited[succNode.i][succNode.j] = true;
                    counterJoinabilityAlgorithm.incrementTotalNodesTraversed();
                }
            }
        } // end while
        System.out.println("\n" + "MaxStackSize is: " + counterJoinabilityAlgorithm.maxStackSize);
        System.out.println("totalNodesTraversed is: " + counterJoinabilityAlgorithm.totalNodesTraversed);
        return 0; // Si on ne trouve jamais la sortie
    }
    private static boolean isExit(Node node){
        return maze.get(node.i).get(node.j).toString().equals("*");
    }

    private static Node findStartNode(){
        for (int i = 0; i < maze.size(); i++){
            // On regarde toutes les possibilites a gauche
            if (maze.get(i).get(0).toString().equals("*")){
                return new Node(0,i,0);
            }
        }
        return null; // Si aucun noeud de départ n'est trouvé
    }
}
