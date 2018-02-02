package actors.ping_pong;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.event.Logging;
import akka.event.LoggingAdapter ;


/**
 * Created by mdb on 9/21/17.
 * https://alvinalexander.com/scala/scala-akka-actors-ping-pong-simple-example
 */

/*
    1. Check my mail box...
    2. If I get a message...
        2.1 get what I need from it
        2.3 run based on the info...
        2.4 GO!
    3. If I don't...then sleep..let other threads work...

 */
public class JavaPongActor extends AbstractActor{

    /* message types */
    class PingMessage{}
    class PongMessage{}
    class StartMessage{}
    class StopMessage{}



    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(),this);
    @Override
    public Receive createReceive() {
        Receive _receiveBulder = receiveBuilder()
                .matchEquals("Ping",s->{
                    System.out.println("PING : " + s);
                })
                .match(String.class,s ->{
                    System.out.println("It's a string: " + s );
                })
                .matchAny(x -> System.out.println("Don't known what this is...." + x)).build() ;

        return null ;
    }
}
