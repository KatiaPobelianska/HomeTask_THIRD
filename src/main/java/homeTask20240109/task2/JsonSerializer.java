package homeTask20240109.task2;
/*2 Создайте собственный класс для сериализации объекта из задания 1 в JSON.
Используйте Reflection API для анализа полей объекта и их значений,
чтобы динамически создавать JSON-представление объекта.*/
import homeTask20240109.task1.MyClass;
import org.json.JSONObject;

import java.lang.reflect.Field;

public class JsonSerializer {
    public static String serializeToJson(Object obj) {
        JSONObject json = new JSONObject();
        Class<?> clazz = obj.getClass();

        try {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                json.put(field.getName(), field.get(obj));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return json.toString();
    }

    public static void main(String[] args) {
        MyClass myObject = new MyClass();

        System.out.println("Information about the object:");
        System.out.println("privateField1: " + myObject.privateField1);
        System.out.println("privateField2: " + myObject.privateField2);
        System.out.println("privateField3: " + myObject.privateField3);
        System.out.println("privateField4: " + myObject.privateField4);

        String json = serializeToJson(myObject);
        System.out.println("\nJSON representation of the object:");
        System.out.println(json);
    }
}