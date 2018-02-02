package actors.ping_pong;

import akka.actor.AbstractActor;
import akka.actor.Actor;
import scala.PartialFunction;

/**
 * Created by mdb on 1/25/18.
 */
public class PongActor extends AbstractActor{
    /**
     * What we need to pay attention to:
     * ==================================================
     *
     * Recieve.match():
     *  - match(class,function)
     *    ~ This describes behavior to apply to any unmatched
     *    class instance.   Since this takes a function/method
     *    as a paramter...we need to pass a closure as a function(or
     *    perhaps we could have passed this:
     *      Function<T,R>(){
            ....do stuff
     *      }
     *Example:
     *  -match(String.class, s-> {if(s.equals("Ping")) respondToPing(s);}):
     *
     *
     *  -match(class,predicate,function):
     *      ~This descripts behavior to apply to
     *      a message if it is the type of the class
     *      and the predicate function is true
     *
     *Example:
     *  -match(String.class, s-> s.equals("Ping"), s ->respondToPing(s))
     *
     *
     *
     * -matchAny(function):
     *  ~This matches any unmatched messages.
     *   It's generally a good proactice to respond
     *   with a failure, or at least a log in
     *   to aid in troubleshooting during
     *   development.
     *
     *
     *
     */

    @Override
    public Receive createReceive() {
        Receive _receiveBuilder = receiveBuilder().
                match(Double.class, d->{
                  sender().tell(d.isNaN() ? 0 : d, self());
                })
                .match(Integer.class, i-> {
                    sender().tell(i * 10,self());
                })
                .match(String.class, str -> {
                    sender().tell(str.toUpperCase(), self());
                }).build() ;
        return null;
    }
}
