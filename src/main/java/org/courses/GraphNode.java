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
    protected Integer estimation = null;

    Type data;

    public GraphNode(Type data)
    {
        this.data = data;
    }

    public Integer getEstimation()
    {
        return estimation;
    }

//    public GraphNode<Type> getRelated()
//    {
//
//    }

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

        addMin(result);

        return result;
    }

    protected void addMin(ArrayList<GraphNode<Type> > to)
    {
        Integer shortest = null;
        GraphNode<Type> next = null;
        Iterator it = related.keySet().iterator();
        while (it.hasNext())
        {
            GraphNode<Type> tm = (GraphNode<Type>) it.next();
            if(tm.estimation < shortest || shortest == null)
            {
                shortest = tm.estimation;
                next = tm;
            }
        }

        to.add(0, next);
        next.addMin(to);

        if(next.estimation == 0)
            return;

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
            if(!tm.isMarked() && tm.estimation > estimation + getEgdeWeight(tm))
            {
                tm.estimation = estimation + getEgdeWeight(tm);
                if(tm.estimation < shortest || shortest == null)
                {
                    shortest = tm.estimation;
                    next = tm;
                }
            }
        }

        if(next != null)
            next.look();

    }

    protected boolean reInit(GraphNode<Type> to)
    {
        boolean result = (this==to);
        marked = false;
        estimation = null;
        Iterator it = related.keySet().iterator();
        while (it.hasNext())
        {
            result = result || ((GraphNode<Type>) it.next()).reInit(to);
        }

        return result;
    }

}
