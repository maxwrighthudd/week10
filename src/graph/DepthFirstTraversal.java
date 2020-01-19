package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Recursive implementation of a depth first traversal method...
 * contains three methods; traverse, visitNode & getUnvisitedNode
 *
 * @author Max Wright
 */

public class DepthFirstTraversal<T> extends AdjacencyGraph<T> implements Traversal<T> {

    List<T> visitedList = new ArrayList<>();

    /**
     * @return a list of the completed traversal
     *
     * @throws GraphError specific error
     */
    @Override
    public List<T> traverse() throws GraphError {
        T next = getUnvisitedNode();
        while (next != null) {
            visitedList.add(next);
            visitNode(next);
            next = getUnvisitedNode();
        }
        return visitedList;
    }

    /**
     * @param node which will be checked against the visited list..
     * if it's contained in the list will move on, if it is not in..
     * the list it will add to list and get the nodes neighbours
     *
     * @throws GraphError specific error
     */
    private void visitNode(T node) throws GraphError {
        if (visitedList.contains(node)) return;
        visitedList.add(node);
        for (T next: getNeighbours(node)){
            if (!visitedList.contains(next)){
                visitNode(next);
                visitedList.add(next);

            }
        }
    }

    /**
     *
     * @return an unvisited node..
     * ..the node will be passed back to the traverse method
     *
     * @throws GraphError specific error
     */
    private T getUnvisitedNode() throws GraphError {
        for (T node: getNodes()){
            if (!visitedList.contains(node)){
                return node;
            }
        }
        return null;
    }
}
