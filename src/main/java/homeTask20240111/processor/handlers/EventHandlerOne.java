package homeTask20240111.processor.handlers;

import homeTask20240111.processor.reflect.EventHandler;

@EventHandler
public class EventHandlerOne {
    public void handleEvent(){
        System.out.println("Handling event.");
    }
}
