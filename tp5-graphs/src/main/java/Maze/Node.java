package Maze;

import java.util.ArrayList;

public class Node {
    int distance, i, j;

    public Node(int distance, int i, int j) {
        this.distance = distance;
        this.i = i;
        this.j = j;
    }

    public Node(Node node){
        this.distance = node.distance;
        this.i = node.i;
        this.j = node.j;
    }

    public ArrayList<Node> adj(ArrayList<ArrayList<Tile>> maze) {
        ArrayList<Node> adjacentNodes = new ArrayList<>();
        // si le voisin est un floor, on l'ajoute a adjacentNodes
        // Voisin de gauche
        if (this.i - 1 > 0 && !maze.get(this.i - 1).get(this.j).toString().equals("#")){
            adjacentNodes.add(new Node(this.distance + 1, this.i - 1, this.j));
        }
        // Voisin de droite
        if (this.i + 1 < maze.size() && !maze.get(this.i + 1).get(this.j).toString().equals("#")){
            adjacentNodes.add(new Node(this.distance + 1, this.i + 1, this.j));
        }
        // Voisin du haut
        if (this.j - 1 > 0 && !maze.get(this.i).get(this.j - 1).toString().equals("#")){
            adjacentNodes.add(new Node(this.distance + 1, this.i, this.j - 1));
        }
        // Voisin du bas
        if (this.j + 1 < maze.get(this.i).size() && !maze.get(this.i).get(this.j + 1).toString().equals("#")){
            adjacentNodes.add(new Node(this.distance + 1, this.i, this.j + 1));
        }
        return adjacentNodes;
    }
}
