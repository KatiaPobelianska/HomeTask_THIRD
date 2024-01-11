package homeTask20240111.processor.handlers;

import homeTask20240111.processor.reflect.EventHandler;
import homeTask20240111.processor.reflect.ReflectionHelper;

import java.lang.annotation.Annotation;
import java.util.List;

public class EventProcessor {
    public static void main(String[] args) {
        processEvents("homeTask20240111.processor.handlers", EventHandler.class);
    }
    public static void processEvents(String packageName, Class<? extends Annotation> annotation){
        List<Class<?>> eventHandlerClasses = ReflectionHelper.findAnnotetedClases(packageName, annotation);
        for (Class<?> handlerClass: eventHandlerClasses){
            try {
                Object handlerInstance = handlerClass.getDeclaredConstructor().newInstance();
                System.out.println("Create instance of " + handlerClass.getName());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
