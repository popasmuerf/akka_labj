package actors.ping_pong;

import akka.actor.AbstractActor;

/**
 * Created by mdb on 1/25/18.
 */
public class JavaPingActor extends AbstractActor{
    @Override
    public Receive createReceive() {
        Receive receiveBuilder = receiveBuilder().matchEquals("Pong" s->{})
                .match()
                .matchAny().build();
        return null;
    }
}
