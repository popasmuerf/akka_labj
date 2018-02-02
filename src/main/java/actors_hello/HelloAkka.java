package actors_hello;

import akka.actor.AbstractActor;
import akka.actor.Actor;
import akka.actor.Props;

/**
 * Created by mdb on 12/13/17.
 */

//https://doc.akka.io/docs/akka/current/guide/introduction.html

public class HelloAkka extends AbstractActor{
    public static Props props(){
        return null ;
    }



    @Override
    public Receive createReceive() {
        return null;
    }
}
