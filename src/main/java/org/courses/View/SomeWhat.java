package org.courses.View;

import org.courses.GraphNode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: stvad
 * Date: 17.04.12
 * Time: 23:58
 * To change this template use File | Settings | File Templates.
 */
public class SomeWhat
{
    ArrayList<GraphNode<String> > data = new ArrayList<GraphNode<String>>();

    public void init()
    {
        GraphNode<String> Uzhgorod = new GraphNode<String>("Uzhgorod");
        data.add(Uzhgorod);
        GraphNode<String> Lviv = new GraphNode<String>("Lviv");
        data.add(Lviv);
        GraphNode<String> Luck = new GraphNode<String>("Luck");
        data.add(Luck);
        GraphNode<String> Rovno = new GraphNode<String>("Rovno");
        data.add(Rovno);
        GraphNode<String> Ternopol = new GraphNode<String>("Ternopol");
        data.add(Ternopol);
        GraphNode<String> Ivanofrankovsk = new GraphNode<String>("Ivanofrankovsk");
        data.add(Ternopol);
        GraphNode<String> Chernovtsy = new GraphNode<String>("Chernovtsy");
        data.add(Chernovtsy);
        GraphNode<String> Khmelnick = new GraphNode<String>("Khmelnick");
        data.add(Khmelnick);
        GraphNode<String> Zhitomyr = new GraphNode<String>("Zhitomyr");
        data.add(Zhitomyr);
        GraphNode<String> Vinnica = new GraphNode<String>("Vinnica");
        data.add(Vinnica);
        GraphNode<String> Kyiv = new GraphNode<String>("Kyiv");
        data.add(Kyiv);
        GraphNode<String> Chernigov = new GraphNode<String>("Chernigov");
        data.add(Chernigov);
        GraphNode<String> Cherkassy = new GraphNode<String>("Cherkassy");
        data.add(Cherkassy);
        GraphNode<String> Kirovograd = new GraphNode<String>("Kirovograd");
        data.add(Kirovograd);
        GraphNode<String> Odessa = new GraphNode<String>("Odessa");
        data.add(Odessa);
        GraphNode<String> Nikolaev = new GraphNode<String>("Nikolaev");
        data.add(Nikolaev);
        GraphNode<String> Kherson = new GraphNode<String>("Kherson");
        data.add(Kherson);
        GraphNode<String> Dnipropetrovsk = new GraphNode<String>("Dnipropetrovsk");
        data.add(Dnipropetrovsk);
        GraphNode<String> Poltava = new GraphNode<String>("Poltava");
        data.add(Poltava);
        GraphNode<String> Summy = new GraphNode<String>("Summy");
        data.add(Summy);
        GraphNode<String> Kharkov = new GraphNode<String>("Kharkov");
        data.add(Kharkov);
        GraphNode<String> Lugansk = new GraphNode<String>("Lugansk");
        data.add(Lugansk);
        GraphNode<String> Donetsk = new GraphNode<String>("Donetsk");
        data.add(Donetsk);
        GraphNode<String> Zaporozze = new GraphNode<String>("Zaporozze");
        data.add(Zaporozze);
        GraphNode<String> Simferopol = new GraphNode<String>("Simferopol");
        data.add(Simferopol);

        Uzhgorod.addRelated(Lviv, 278);
        Uzhgorod.addRelated(Ivanofrankovsk, 301);



    }
}
