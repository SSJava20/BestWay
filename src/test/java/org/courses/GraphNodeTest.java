package org.courses;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: stvad
 * Date: 16.04.12
 * Time: 17:40
 * To change this template use File | Settings | File Templates.
 */
public class GraphNodeTest
{
    GraphNode<Integer> intGraph;
    @Before
    public void BeforeFunc()
    {
        intGraph = new GraphNode<Integer>(1);
    }
    
    @Test
    public void addGetRelatedTest()
    {
        GraphNode<Integer> tnode = new GraphNode<Integer>(13);
        intGraph.addRelated(tnode, 22);
        GraphNode<Integer>[] expected;//= {tnode};
        expected = new GraphNode[1];
        expected[0] = tnode;
        assertArrayEquals(expected,intGraph.getRelated());
    }

    @Test
    public void getEdgeWeightTest()
    {
        GraphNode<Integer> tnode = new GraphNode<Integer>(13);
        intGraph.addRelated(tnode, 22);
        assertEquals(22, (int) intGraph.getEgdeWeight(tnode));
    }


    @Test
    public void getWayToTest()
    {
        GraphNode<Integer> two = new GraphNode<Integer>(2);
        GraphNode<Integer> three = new GraphNode<Integer>(3);
        GraphNode<Integer> four = new GraphNode<Integer>(4);
        GraphNode<Integer> five = new GraphNode<Integer>(5);
        GraphNode<Integer> six = new GraphNode<Integer>(6);

        intGraph.addRelated(two, 7);
        intGraph.addRelated(six, 14);
        intGraph.addRelated(three, 9);

        six.addRelated(three, 2);
        six.addRelated(five, 9);

        five.addRelated(four, 6);

        four.addRelated(two, 15);
        four.addRelated(three, 11);

        three.addRelated(two, 10);

        ArrayList<GraphNode<Integer>> expected = new ArrayList<GraphNode<Integer>>();
        expected.add(intGraph);
        expected.add(three);
        expected.add(six);
        expected.add(five);

        ArrayList<GraphNode<Integer>> got =  intGraph.getWayTo(five);

        assertArrayEquals(expected.toArray(), got.toArray());
    }
}
