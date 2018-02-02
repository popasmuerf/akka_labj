package actors_hello;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;

/**
 * Created by mdb on 1/24/18.
 * https://developer.lightbend.com/guides/akka-quickstart-java/define-actors.html
 */
public class Printer extends AbstractActor{
    public  Printer(){

    }
    static public Props props(){
        return Props.create(Printer.class,() -> new Printer());
    }
    @Override
    public Receive createReceive() {
        ReceiveBuilder recbuilder = receiveBuilder().match(Greeting.class,greeting ->{
           log.info(greeting.message);
        });
        return recbuilder.build();
    }

    static public class Greeting{
        public final  String message ;
        public Greeting(String message){
            this.message = message ;
        }
    }

    private LoggingAdapter log = Logging.getLogger(getContext().getSystem(),this);

}
