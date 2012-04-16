package org.courses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: stvad
 * Date: 15.04.12
 * Time: 13:36
 * To change this template use File | Settings | File Templates.
 */


public class GraphNode<Type>
{
    protected HashMap<GraphNode<Type>, Integer> related;
    protected boolean marked = false;
    protected Integer estimation = 219299911;

    Type data;

    public GraphNode(Type data)
    {
        this.data = data;
        related = new HashMap<GraphNode<Type>, Integer>();
    }

    public Integer getEstimation()
    {
        return estimation;
    }

    public Object[] getRelated()
    {
        //TODO: Cast

        return related.keySet().toArray();
    }

    public void setEstimation(Integer estimation)
    {
        this.estimation = estimation;
    }

    public boolean isMarked()
    {
        return marked;
    }

    public void setMarked(boolean marked)
    {
        this.marked = marked;
    }

    public void addRelated(GraphNode<Type> newNode, Integer weight)
    {
        related.put(newNode, weight);
        newNode.related.put(this, weight);
    }

    public Integer getEgdeWeight(GraphNode<Type> toNode)
    {
        return related.get(toNode);
    }

    public ArrayList<GraphNode<Type> > getWayTo(GraphNode<Type> to)
    {
        ArrayList<GraphNode<Type> > result = new ArrayList<GraphNode<Type> >();

        if(!reInit(to))
            return null;

        estimation = 0;
        look();

        result.add(to);
        to.addMin(result, to.estimation, 0);

        return result;
    }

    protected void addMin(ArrayList<GraphNode<Type> > to, Integer exp, Integer real)
    {
        Integer shortest = null;
        GraphNode<Type> next = null;
//        GraphNode<Type> first = null;

        Iterator it = related.keySet().iterator();
        while (it.hasNext())
        {
            GraphNode<Type> tm = (GraphNode<Type>) it.next();
            if(shortest == null || shortest > tm.estimation)// tm.estimation < shortest)
            {
                if(tm.estimation  !=0 || real+getEgdeWeight(tm) == exp)
                {
                    shortest = tm.estimation;
                    next = tm;
                }
            }
        }

//        if(first!= null && (shortest == null || shortest > ((first.estimation == 0)?(getEgdeWeight(first)):first.estimation)))
//        {
//            shortest = first.estimation;
//            next = first;
//        }

        to.add(0, next);

        if(next.estimation == 0)
            return;
        next.addMin(to, exp, real + getEgdeWeight(next));
    }

    protected void look()
    {
        marked = true;
        Integer shortest = null;
        GraphNode<Type> next = null;
        Iterator it = related.keySet().iterator();
        while (it.hasNext())
        {
            GraphNode<Type> tm = (GraphNode<Type>) it.next();
            if(!tm.isMarked())
            {
                if(tm.estimation == null || tm.estimation > estimation + getEgdeWeight(tm))
                    tm.estimation = estimation + getEgdeWeight(tm);

                if(tm.estimation != null && (shortest == null || tm.estimation < shortest))
                {
                    shortest = tm.estimation;
                    next = tm;
                }

            }

        }

//        Iterator nit = related.keySet().iterator();
//        while (nit.hasNext())
//        {
//            GraphNode<Type> tm = (GraphNode<Type>) nit.next();
//            if(!tm.isMarked())
//            {
//                tm.look();
//            }
//        }  //не так жадно)

        if(next != null)
            next.look(); //ооочень жадно

    }

    protected boolean reInit(GraphNode<Type> to)
    {
        boolean result = (this==to);
        marked = false;
        estimation = null;
        Iterator it = related.keySet().iterator();
        while (it.hasNext())
        {
            GraphNode<Type> tm = (GraphNode<Type>) it.next();
            result = result || tm == to;
            if(tm.marked || tm.estimation!=null)
                result = result || tm.reInit(to);
        }

        return result;
    }

}
