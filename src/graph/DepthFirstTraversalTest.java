package graph;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DepthFirstTraversalTest {

    @Test
    void traverse() throws GraphError {

        DepthFirstTraversal<Integer> graph = new DepthFirstTraversal<>();

        graph.add(0);
        graph.add(1);
        graph.add(2);
        graph.add(3);
        graph.add(4);

        graph.add(0,1);
        graph.add(0,2);
        graph.add(2,3);
        graph.add(3,4);

        //Prints out the graph traversal to test if it only contains each node once
        System.out.println("DFT traversal: " + graph.traverse());

    }

    @Test
    void traverse2() throws GraphError {

        DepthFirstTraversal<Integer> graph = new DepthFirstTraversal<>();

        graph.add(0);
        graph.add(1);
        graph.add(2);
        graph.add(3);
        graph.add(4);
        graph.add(5);
        graph.add(6);

        graph.add(0,1);
        graph.add(0,2);
        graph.add(1,2);
        graph.add(2,0);
        graph.add(2,3);
        graph.add(3,3);
        graph.add(2,4);
        graph.add(4,5);
        graph.add(5,6);

        System.out.println("DFT traversal: " + graph.traverse());

        //Tests that the amount of edges added to the graph matches the..
        //amount of edges in the graph
        int expectedEdges = 9;
        assertEquals(expectedEdges,graph.getNoOfEdges());
    }

    @Test
    void testGetNodesInGraph() throws GraphError {
        DepthFirstTraversal<Integer> graph = new DepthFirstTraversal<>();

        graph.add(0);
        graph.add(1);
        graph.add(2);
        graph.add(3);

        graph.add(0,1);
        graph.add(0,2);
        graph.add(1,2);
        graph.add(2,0);
        graph.add(2,3);
        graph.add(3,3);

        //Tests that the graph contains all nodes set
        for (int node: graph.traverse()){
            if (!graph.contains(node)){
                fail("Test failed, doesn't contain all the nodes");
            }
        }
    }

    @Test
    void testGetNodesInTraversal() throws GraphError {
        DepthFirstTraversal<Integer> graph = new DepthFirstTraversal<>();

        graph.add(0);
        graph.add(1);
        graph.add(2);
        graph.add(3);

        graph.add(0, 1);
        graph.add(0, 2);
        graph.add(1, 2);
        graph.add(2, 0);
        graph.add(2, 3);
        graph.add(3, 3);

//        for () {
//            if () {
//                fail("Test failed, doesn't contain all the nodes");
//            }
//        }
//        //checks that the traverse ONLY contains nodes from the graph
    }
}