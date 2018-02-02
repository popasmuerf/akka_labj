package actors_hello;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

/**
 * Created by mdb on 1/23/18.
 *
 * The Greeter class extends the akka.actor.AbstractActor
 * class and implements the createReciecer
 * method.
 *
 *
 * Teh Greeter constructor accepts two
 * parameters:
 *  -   String message
 *  -   ActorRef printerActor # reference to actor handling the greeting output
 *
 *
 * the recieveBuilder defines the behavior;
 * how the Actor should react to the differenc messages
 * it recieves.  An
 * actor can have state.  Accessing or mutating
 * the interal of an Actor is fully thread safe
 * since it is proteced by the Actor model.
 *
 *
 *
 *
 *
 */
public class Greeter extends AbstractActor{
    public  static  String who ;
    private  String message ;
    private  ActorRef printerActor ;
    private  String greeting = "" ;

    public Greeter(String message,
                   ActorRef printerActor){
        this.message = message ;
        this.printerActor = printerActor;

    }
    static public Props props(String message,
                              ActorRef printerActor) {
        return Props.create(Greeter.class,() -> new Greeter(message,printerActor));
    }
    static public class WhoToGreet{
        String who = null ;
        public WhoToGreet(String who){
            this.who = who ;
        }
    }
    static public class Greet{
        public Greet(){}
    }

    /**
     *
     * @return
     * RecieveBuilder defines the behavior of the class
     */

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(WhoToGreet.class, wtg -> {
                    this.greeting = message + ", " + wtg.who;
                })
                .match(Greet.class, x -> {
                    printerActor.tell(new Greeter(greeting,printerActor), getSelf());
                })
                .build();
    }



}
