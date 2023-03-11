import java.util.LinkedList;

/**
 * Non-Deterministic Finite State Machine
 * Using graph theory
 *
 * @author Riberiko Niyomwungere
 * @version 1.0
 */
public class NFA {

    private DirectedGraph<String> graph;

    /**
     * Create Non-Deterministic Finite Machine for language
     * (a|b)*abb
     */
    public NFA(){
        graph = new DirectedGraph<>();

        graph.addVertex("q0");
        graph.addVertex("q1");
        graph.addVertex("q2");
        graph.addVertex("q3");
        graph.addVertex("q4");

        graph.addEdge("q0", "q1", "a");
        graph.addEdge("q0", "q4", "b");

        graph.addEdge("q1", "q1", "a");
        graph.addEdge("q1", "q2", "b");

        graph.addEdge("q2", "q3", "b");
        graph.addEdge("q2", "q1", "a");

        graph.addEdge("q3", "q1", "a");
        graph.addEdge("q3", "q4", "b");

        graph.addEdge("q4", "q4", "b");
        graph.addEdge("q4", "q1", "a");


        graph.getVertex("q3").setVisited(true);
    }

    /**
     * Validate the sentence using the language (a|b)*abb
     * @param str   the sentence to validate
     * @return  true when it is a valid sentence
     */
    public boolean isSentenceValid(String str){
        char chars[] = str.toCharArray();
        return isSentenceValid(chars, graph.getVertex("q0"), 0);
    }

    /**
     * Recursive helper function to test all possibilities and see if at least one is valid
     * @param chars the chars of the sentence
     * @param current   the current vertext
     * @param index the index for the char we are at
     * @return  true if the current path is valid
     */
    private boolean isSentenceValid(char[] chars, DirectedGraph.Vertex<String> current, int index){

        if(index == chars.length){
            return current.getIsVisited();
        }

        boolean search = false;

            LinkedList<DirectedGraph.Edge<String>> edgeList = current.getEdgeList();
            for(DirectedGraph.Edge<String> edge : edgeList) if (edge.getWeight().equals( Character.toString(chars[index]))) {
                search = search || isSentenceValid(chars, edge.getTo(), index+1);
                if(search) return true;
            }
        return false;
    }
}
