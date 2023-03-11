import java.util.LinkedList;

/**
 * Deterministic Finite State Machine
 * Using graph theory
 *
 * @author Riberiko Niyomwungere
 * @version 1.0
 **/
public class DFA {

    private DirectedGraph<String> graph;

    /**
     * Create Non-Deterministic Finite Machine for language
     * (a+b)c*
     */
    public DFA(){
        graph = new DirectedGraph<>();

        graph.addVertex("q0");
        graph.addVertex("q1");
        graph.addVertex("q2");
        graph.addVertex("q3");
        graph.addVertex("q4");

        graph.addEdge("q0", "q1", "a");
        graph.addEdge("q0", "q2", "b");
        graph.addEdge("q0", "q4", "c");

        graph.addEdge("q1", "q3", "c");
        graph.addEdge("q2", "q3", "c");

        graph.addEdge("q3", "q3", "c");

        graph.addEdge("q3", "q4", "a");
        graph.addEdge("q3", "q4", "b");

        graph.addEdge("q1", "q4", "a");
        graph.addEdge("q1", "q4", "b");

        graph.addEdge("q2", "q4", "a");
        graph.addEdge("q2", "q4", "b");

        graph.addEdge("q0", "q4", "c");

        graph.getVertex("q2").setVisited(true);
        graph.getVertex("q1").setVisited(true);

        graph.getVertex("q3").setVisited(true);
    }

    /**
     * Validate the sentence using the language (a+b)c*
     * @param str   the sentence to validate
     * @return  true when it is a valid sentence
     */
    public boolean isSentenceValid(String str){
        if (str.isEmpty()) return false;
        DirectedGraph.Vertex<String> current = graph.getVertex("q0");
        char[] chars = str.toCharArray();

        for(char c : chars){
            LinkedList<DirectedGraph.Edge<String>> edgeList = current.getEdgeList();
            boolean foundWeight = false;
            for(DirectedGraph.Edge<String> edge : edgeList) if (edge.getWeight().equals( Character.toString(c) )) {
                current = edge.getTo();
                foundWeight = true;
            }
            if(!foundWeight) return false;
        }

        return current.getIsVisited();
    }


}
