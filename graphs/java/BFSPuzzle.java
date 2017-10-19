/*
INPUT:
Number of puzzles(N)
Puzzle1
Puzzle2
Puzzle3
.
.
.
PuzzleN
3
145680327
346017285
041238567
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Graph {
    private ArrayList<ArrayList<Vertex>> puzzles;
    private ArrayList<Vertex> sons;
    private ArrayDeque<Vertex> queue;
    private HashMap<String, Boolean> map;

    Graph() {
        this.puzzles = new ArrayList<>();
    }

    public Graph(ArrayList<ArrayList<Vertex>> vertices) {
        this.puzzles = vertices;
    }

    public void addVertex(ArrayList<Vertex> newVertex) {

        ArrayList<Vertex> vertex = new ArrayList<>();

        puzzles.add(vertex);
    }

    public void removeVertex(int position) {
        puzzles.remove(position);
    }

    public void removeVertex(ArrayList<Vertex> v) {
        puzzles.remove(v);
    }

    private ArrayList<Vertex> generateSons(Vertex v) {

        ArrayList<Vertex> vSons = new ArrayList<>();
        int zeroPosition = v.getZeroPosition();
        Vertex u;

        if (!v.isSolved()) {

            vSons.add(v);

            switch (zeroPosition) {

                case 0:

                    if (map.get(v.movePuzzle(0, 1)) == null || map.get(v.movePuzzle(0, 1)) == Boolean.FALSE) {

                        u = new Vertex(v.movePuzzle(0, 1));
                        u.setFather(v);
                        map.put(u.getPuzzle(), Boolean.TRUE);
                        vSons.add(u);

                    } else if (map.get(v.movePuzzle(0, 3)) == null || map.get(v.movePuzzle(0, 3)) == Boolean.FALSE) {

                        u = new Vertex(v.movePuzzle(0, 3));
                        u.setFather(v);
                        map.put(u.getPuzzle(), Boolean.TRUE);
                        vSons.add(u);

                    }

                    break;

                case 1:

                    if (map.get(v.movePuzzle(1, 0)) == null || map.get(v.movePuzzle(1, 0)) == Boolean.FALSE) {

                        u = new Vertex(v.movePuzzle(1, 0));
                        u.setFather(v);
                        map.put(u.getPuzzle(), Boolean.TRUE);
                        vSons.add(u);

                    } else if (map.get(v.movePuzzle(1, 2)) == null || map.get(v.movePuzzle(1, 2)) == Boolean.FALSE) {

                        u = new Vertex(v.movePuzzle(1, 2));
                        u.setFather(v);
                        map.put(u.getPuzzle(), Boolean.TRUE);
                        vSons.add(u);

                    } else if (map.get(v.movePuzzle(1, 4)) == null || map.get(v.movePuzzle(1, 4)) == Boolean.FALSE) {

                        u = new Vertex(v.movePuzzle(1, 4));
                        u.setFather(v);
                        map.put(u.getPuzzle(), Boolean.TRUE);
                        vSons.add(u);

                    }

                    break;

                case 2:

                    if (map.get(v.movePuzzle(2, 1)) == null || map.get(v.movePuzzle(2, 1)) == Boolean.FALSE) {

                        u = new Vertex(v.movePuzzle(2, 1));
                        u.setFather(v);
                        map.put(u.getPuzzle(), Boolean.TRUE);
                        vSons.add(u);

                    } else if (map.get(v.movePuzzle(2, 5)) == null || map.get(v.movePuzzle(2, 5)) == Boolean.FALSE) {

                        u = new Vertex(v.movePuzzle(2, 5));
                        u.setFather(v);
                        map.put(u.getPuzzle(), Boolean.TRUE);
                        vSons.add(u);

                    }

                    break;

                case 3:

                    if (map.get(v.movePuzzle(3, 0)) == null || map.get(v.movePuzzle(3, 0)) == Boolean.FALSE) {

                        u = new Vertex(v.movePuzzle(3, 0));
                        u.setFather(v);
                        map.put(u.getPuzzle(), Boolean.TRUE);
                        vSons.add(u);

                    } else if (map.get(v.movePuzzle(3, 4)) == null || map.get(v.movePuzzle(3, 4)) == Boolean.FALSE) {

                        u = new Vertex(v.movePuzzle(3, 4));
                        u.setFather(v);
                        map.put(u.getPuzzle(), Boolean.TRUE);
                        vSons.add(u);

                    } else if (map.get(v.movePuzzle(3, 6)) == null || map.get(v.movePuzzle(3, 6)) == Boolean.FALSE) {

                        u = new Vertex(v.movePuzzle(3, 6));
                        u.setFather(v);
                        map.put(u.getPuzzle(), Boolean.TRUE);
                        vSons.add(u);

                    }

                    break;

                case 4:

                    if (map.get(v.movePuzzle(4, 1)) == null || map.get(v.movePuzzle(4, 1)) == Boolean.FALSE) {

                        u = new Vertex(v.movePuzzle(4, 1));
                        u.setFather(v);
                        map.put(u.getPuzzle(), Boolean.TRUE);
                        vSons.add(u);

                    } else if (map.get(v.movePuzzle(4, 3)) == null || map.get(v.movePuzzle(4, 3)) == Boolean.FALSE) {

                        u = new Vertex(v.movePuzzle(4, 3));
                        u.setFather(v);
                        map.put(u.getPuzzle(), Boolean.TRUE);
                        vSons.add(u);

                    } else if (map.get(v.movePuzzle(4, 5)) == null || map.get(v.movePuzzle(4, 5)) == Boolean.FALSE) {

                        u = new Vertex(v.movePuzzle(4, 5));
                        u.setFather(v);
                        map.put(u.getPuzzle(), Boolean.TRUE);
                        vSons.add(u);

                    } else if (map.get(v.movePuzzle(4, 7)) == null || map.get(v.movePuzzle(4, 7)) == Boolean.FALSE) {

                        u = new Vertex(v.movePuzzle(4, 7));
                        u.setFather(v);
                        map.put(u.getPuzzle(), Boolean.TRUE);
                        vSons.add(u);

                    }

                    break;

                case 5:

                    if (map.get(v.movePuzzle(5, 2)) == null || map.get(v.movePuzzle(5, 2)) == Boolean.FALSE) {

                        u = new Vertex(v.movePuzzle(5, 2));
                        u.setFather(v);
                        map.put(u.getPuzzle(), Boolean.TRUE);
                        vSons.add(u);

                    } else if (map.get(v.movePuzzle(5, 4)) == null || map.get(v.movePuzzle(5, 4)) == Boolean.FALSE) {

                        u = new Vertex(v.movePuzzle(5, 4));
                        u.setFather(v);
                        map.put(u.getPuzzle(), Boolean.TRUE);
                        vSons.add(u);

                    } else if (map.get(v.movePuzzle(5, 8)) == null || map.get(v.movePuzzle(5, 8)) == Boolean.FALSE) {

                        u = new Vertex(v.movePuzzle(5, 8));
                        u.setFather(v);
                        map.put(u.getPuzzle(), Boolean.TRUE);
                        vSons.add(u);

                    }

                    break;

                case 6:

                    if (map.get(v.movePuzzle(6, 3)) == null || map.get(v.movePuzzle(6, 3)) == Boolean.FALSE) {

                        u = new Vertex(v.movePuzzle(6, 3));
                        u.setFather(v);
                        map.put(u.getPuzzle(), Boolean.TRUE);
                        vSons.add(u);

                    } else if (map.get(v.movePuzzle(6, 7)) == null || map.get(v.movePuzzle(6, 7)) == Boolean.FALSE) {

                        u = new Vertex(v.movePuzzle(6, 7));
                        u.setFather(v);
                        map.put(u.getPuzzle(), Boolean.TRUE);
                        vSons.add(u);

                    }

                    break;

                case 7:

                    if (map.get(v.movePuzzle(7, 4)) == null || map.get(v.movePuzzle(7, 4)) == Boolean.FALSE) {

                        u = new Vertex(v.movePuzzle(7, 4));
                        u.setFather(v);
                        map.put(u.getPuzzle(), Boolean.TRUE);
                        vSons.add(u);

                    } else if (map.get(v.movePuzzle(7, 6)) == null || map.get(v.movePuzzle(7, 6)) == Boolean.FALSE) {

                        u = new Vertex(v.movePuzzle(7, 6));
                        u.setFather(v);
                        map.put(u.getPuzzle(), Boolean.TRUE);
                        vSons.add(u);

                    } else if (map.get(v.movePuzzle(7, 8)) == null || map.get(v.movePuzzle(7, 8)) == Boolean.FALSE) {

                        u = new Vertex(v.movePuzzle(7, 8));
                        u.setFather(v);
                        map.put(u.getPuzzle(), Boolean.TRUE);
                        vSons.add(u);

                    }

                    break;

                case 8:

                    if (map.get(v.movePuzzle(8, 5)) == null || map.get(v.movePuzzle(8, 5)) == Boolean.FALSE) {

                        u = new Vertex(v.movePuzzle(8, 5));
                        u.setFather(v);
                        map.put(u.getPuzzle(), Boolean.TRUE);
                        vSons.add(u);

                    } else if (map.get(v.movePuzzle(8, 7)) == null || map.get(v.movePuzzle(8, 7)) == Boolean.FALSE) {

                        u = new Vertex(v.movePuzzle(8, 7));
                        u.setFather(v);
                        map.put(u.getPuzzle(), Boolean.TRUE);
                        vSons.add(u);

                    }

                    break;

            }

        } else {

            vSons.add(v);

        }

        return vSons;

    }

    void breadthFirstSearch(Vertex v) {

        map = new HashMap<>();
        queue = new ArrayDeque<>();
        Vertex u;

        queue.addLast(v.clone());

        while (!queue.isEmpty()) {

            u = queue.pollFirst();

            if (!u.isSolved()) {

                sons = generateSons(u);

                for (Vertex i : sons) {
                    queue.addLast(i);
                }

                puzzles.add(sons);

            } else {

                queue.clear();
                sons.add(u);
                puzzles.add(sons);

            }

        }

    }

    ArrayList<String> findFathers() {

        String state;
        ArrayList<String> states = new ArrayList<>();

        // THIS GETS THE LAST VERTEX IN THE GRAPH (SOLVED PUZZLE)
        ArrayList<Vertex> alv = puzzles.get(puzzles.size()-1);
        Vertex vertex = alv.get(alv.size()-1);

        do {

            state = vertex.getPuzzle();

            states.add(state);

            vertex = vertex.getFather();

        } while (vertex.getFather() != null);

        return states;

    }

    void printMatrix() {

        ArrayList<String> path = findFathers();
        String state;

        for (int i = path.size()-1; i >= 0; i--) {
            state = path.get(i);
            for (int j = 1; j <= state.length(); j++) {
                System.out.print(state.charAt(j - 1) + " ");
                if (j % 3 == 0) {
                    System.out.println();
                }
            }
            System.out.println();
        }
    }

    void printFathers() {

        ArrayList<String> path = findFathers();

        System.out.println(path.size());

        for (int i = path.size()-1; i >= 0; i--) {
            System.out.println(path.get(i));
        }
    }
}

class Vertex {

    private String puzzle;
    private Vertex father;
    private int distance;
    private int color;

    public String getPuzzle() {
        return puzzle;
    }

    public Vertex getFather() {
        return father;
    }

    public int getDistance() {
        return distance;
    }

    public int getColor() {
        return color;
    }

    public void setPuzzle(String puzzle) {
        this.puzzle = puzzle;
    }

    public void setFather(Vertex father) {
        this.father = father;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Vertex() {
        setPuzzle("");
        setFather(null);
        setDistance(Integer.MAX_VALUE);
        setColor(0);
    }

    public Vertex(String str) {
        setPuzzle(str);
        setFather(null);
        setDistance(Integer.MAX_VALUE);
        setColor(0);
    }

    /**
     * Calculates the amount of possible inversions to determine if
     * the puzzle can be solved or not
     *
     * @return the number of inversions in the puzzle
     */
    public int inversions() {
        int inversions = 0;
        int val;

        for (int i = 0; i < puzzle.length(); i++) {
            val = Character.valueOf(puzzle.charAt(i));
            for (int j = i + 1; j < puzzle.length(); j++) {
                if (Character.valueOf(puzzle.charAt(j)) < val) {
                    inversions++;
                }
            }
        }

        return inversions;
    }

    /**
     * Verifies whether the current state of the puzzle is solved or not
     *
     * @return a boolean regarding solution of the puzzle
     */
    public boolean isSolved() {
        boolean solution = false;
        String correct = "123456780";

        if (puzzle.equals(correct)) {
            solution = true;
        }

        return solution;
    }

    /**
     * Gets the current position of the empty space in the puzzle
     *
     * @return position of the string where 0 is located
     */
    public int getZeroPosition() {
        int position = 0;

        for (int i = 0; i < puzzle.length(); i++) {
            if (Character.getNumericValue(puzzle.charAt(i)) == 0) {
                position = i;
            }
        }

        return position;
    }

    /**
     * Moves a piece on the puzzle
     *
     * @param from Initial position of zero
     * @param to   Final position of zero
     * @return The new puzzle state after moving a piece
     */
    public String movePuzzle(int from, int to) {
        String moved = "";
        char origin = puzzle.charAt(from);
        char destination = puzzle.charAt(to);

        for (int i = 0; i < puzzle.length(); i++) {
            if (puzzle.charAt(i) == origin) {
                moved += destination;
            } else if (puzzle.charAt(i) == destination) {
                moved += origin;
            } else {
                moved += puzzle.charAt(i);
            }
        }

        return moved;
    }

    /**
     * Prints puzzle as matrix
     */
    public void printMatrix() {
        System.out.println(puzzle);
    }

    @Override
    public Vertex clone() {

        Vertex cloned = new Vertex();

        cloned.setPuzzle(this.puzzle);
        cloned.setFather(this.father);
        cloned.setDistance(this.distance);

        return cloned;
    }
}

public class BFSPuzzle {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String puzzle;
        int numberOfPuzzles;
        Graph graph = new Graph();
        Vertex vertex;
        // long startTime;
        // long endTime;


        try {

            numberOfPuzzles = Integer.parseInt(reader.readLine());

            for (int i = 0; i < numberOfPuzzles; i++) {

                puzzle = reader.readLine();
                vertex = new Vertex(puzzle);

                // startTime = System.currentTimeMillis();

                graph.breadthFirstSearch(vertex);
                graph.printFathers();

                // endTime = System.currentTimeMillis();

                // System.out.println("Tempo gasto: " + (endTime-startTime) + "ms");

            }
        } catch (IOException ioe) {
            System.out.println("IOException");
        }
    }
}
