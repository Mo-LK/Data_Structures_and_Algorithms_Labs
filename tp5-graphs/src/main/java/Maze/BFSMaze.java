package Maze;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

import java.util.stream.Collectors;

/** DONE
 ** Implement BFS algorithm to solve the maze.
 */
public class BFSMaze {
    static ArrayList<ArrayList<Tile>> maze;
    static Counter counterBFS;
    static boolean[][] bfsMarked;
    /** DONE
     * Returns the distance of the shortest path within the maze
     * @param mazeUsed 2D table representing the maze
     * @return Distance of the shortest path within the maze, null if not solvable
     */
    public static Integer findPath(ArrayList<ArrayList<Tile>> mazeUsed) {
        if (mazeUsed.isEmpty())
            return null;
        BFSMaze.maze = mazeUsed;
        bfsMarked = new boolean[maze.size()][maze.get(0).size()];
        Node start = findStartNode();
        return start == null ? null : bfs(start);
    }

    public static void printMaze(ArrayList<ArrayList<Tile>> mazeUsed) {
        for (ArrayList<Tile> row : mazeUsed) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining("")));
        }
    }

    private static int bfs(Node currentNode){
        counterBFS = new Counter();
        Queue<Node> q = new LinkedList<>();
        // add source
        q.add(currentNode);
        counterBFS.displayAndIncrementStackedNodes();
        counterBFS.updateMaxStackSize();
        bfsMarked[currentNode.i][currentNode.j] = true;
        while( !q.isEmpty() ){
            // poll vertex and treat neighbors
            Node v = q.poll();
            counterBFS.displayAndDecrementStackedNodes();
            for(Node w : v.adj(maze)){
                if( !bfsMarked[w.i][w.j] ){
                    if (isExit(w)){
                        // On atteint la sortie
                        System.out.println("\n" + "MaxStackSize is: " + counterBFS.maxStackSize);
                        System.out.println("totalNodesTraversed is: " + counterBFS.totalNodesTraversed);
                        return w.distance;
                    }
                    bfsMarked[w.i][w.j] = true;
                    q.add(w);
                    counterBFS.displayAndIncrementStackedNodes();
                    counterBFS.updateMaxStackSize();
                    counterBFS.incrementTotalNodesTraversed();
                }
            }
        } // end while
        System.out.println("\n" + "MaxStackSize is: " + counterBFS.maxStackSize);
        System.out.println("totalNodesTraversed is: " + counterBFS.totalNodesTraversed);
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
