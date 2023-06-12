package Maze;

import java.util.*;
import java.util.stream.Collectors;

/** DONE
 ** Implement DFS algorithm to solve the maze.
 */
public class DFSMaze {
    static ArrayList<ArrayList<Tile>> maze;
    static boolean[][] dfsMarked;
    static int dist = 0;
    static Counter counterDFS;
    /** DONE
     * Returns the distance of the path within the maze
     * @param mazeUsed 2D table representing the maze
     * @return Distance of the path within the maze, null if not solvable
     */
    public static Integer findPath(ArrayList<ArrayList<Tile>> mazeUsed) {
        if (mazeUsed.isEmpty())
            return null;
        DFSMaze.maze = mazeUsed;
        dfsMarked = new boolean[maze.size()][maze.get(0).size()];
        Node start = findStartNode();
        counterDFS = new Counter();

        if ( start == null ) {
            return null;
        }
        else {
            int dist = dfs(start);
            System.out.println("\n" + "MaxStackSize is: " + counterDFS.maxStackSize);
            System.out.println("totalNodesTraversed is: " + counterDFS.totalNodesTraversed);
            return dist;
        }
    }

    public static void printMaze(ArrayList<ArrayList<Tile>> maze) {
        for (ArrayList<Tile> row : maze) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining("")));
        }
    }

    private static int dfs(Node currentNode){
        dfsMarked[currentNode.i][currentNode.j] = true;
        for(Node w : currentNode.adj(maze)){
            if( !dfsMarked[w.i][w.j] ) {
                counterDFS.incrementTotalNodesTraversed();
                if (maze.get(w.i).get(w.j).toString().equals("*")) {
                    // On atteint la sortie
                    dist = w.distance;
                    break;
                } else {
                    counterDFS.displayAndIncrementStackedNodes();
                    counterDFS.updateMaxStackSize();
                    dfs(w);
                    counterDFS.displayAndDecrementStackedNodes();
                }
            }
        }
        return dist; // Si on ne trouve jamais la sortie
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

