package homeTask20240111.processor.reflect;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReflectionHelper {
    private static final String CLASS_TYPE = ".class";

    private ReflectionHelper() {
    }

    public static List<Class<?>> findAnnotetedClases(String packageName, Class<? extends Annotation> annotation) {
        List<Class<?>> result = new ArrayList<>();
        if (packageName == null || packageName.isEmpty()) return result;
        String path = packageName.replace(".", "/");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader(); // Получаем classLoader, который может найти все файлы классов

        try {
            Iterator<URL> urlIterator = classLoader.getResources(path).asIterator();

            while (urlIterator.hasNext()){
                File directory = new File(urlIterator.next().getFile());
                if (!directory.exists())continue;
                String[] fileNames = directory.list();
                if (fileNames == null) continue;

                for (String fileName: fileNames) {
                    if (fileName.endsWith(CLASS_TYPE)){
                        String className = packageName + "." + fileName.substring(0, fileName.length() - CLASS_TYPE.length());

                        try {
                            Class<?> clazz = Class.forName(className);
                            if (clazz.isAnnotationPresent(annotation)) result.add(clazz);
                        }catch (ClassNotFoundException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
