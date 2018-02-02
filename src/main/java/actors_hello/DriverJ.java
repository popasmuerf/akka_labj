package actors_hello;

import actors_hello.Greeter;
import actors_hello.Printer;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Status;
import scala.PartialFunction;

import java.io.IOException;

/**
 * Created by mdb on 9/21/17.
 * https://developer.lightbend.com/guides/akka-quickstart-java/main-class.html
 */
public class DriverJ {
    public static void main(String[] args) throws IOException {
        final ActorSystem system = ActorSystem.create("helloAkka");
        {
            try {
                final ActorRef printerActor = system.actorOf(Printer.props(), "printerActor");
                final ActorRef howdyGreeter = system.actorOf(Greeter.props("Howdy", printerActor), "howdyGreeter");
                final ActorRef helloGreeter = system.actorOf(Greeter.props("Hello", printerActor), "helloGreeter");
                final ActorRef goodayGreeter = system.actorOf(Greeter.props("GoodDay", printerActor), "gooddayGreeter");

                /*
                howdyGreeter.tell(new Greeter.WhoToGreet("Akka"),ActorRef.noSender());
                howdyGreeter.tell(new Greeter.Greet(),ActorRef.noSender());

                howdyGreeter.tell(new Greeter.WhoToGreet("LightBend"),ActorRef.noSender());
                howdyGreeter.tell(new Greeter.Greet(),ActorRef.noSender());

                helloGreeter.tell(new Greeter.WhoToGreet("LightBend"),ActorRef.noSender());
                helloGreeter.tell(new Greeter.Greet(),ActorRef.noSender());
                */

                howdyGreeter.tell(new Greeter.WhoToGreet("Akka"), ActorRef.noSender());
                howdyGreeter.tell(new Greeter.Greet(), ActorRef.noSender());

                howdyGreeter.tell(new Greeter.WhoToGreet("Lightbend"), ActorRef.noSender());
                howdyGreeter.tell(new Greeter.Greet(), ActorRef.noSender());

                helloGreeter.tell(new Greeter.WhoToGreet("Java"), ActorRef.noSender());
                helloGreeter.tell(new Greeter.Greet(), ActorRef.noSender());


                System.out.println(">>> Press ENTER to exit <<<");
                System.in.read();

            } finally{
                system.terminate();
            }
        }

    }
}
