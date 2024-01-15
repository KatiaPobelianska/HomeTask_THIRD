package homeTask20240109.task1;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        MyClass myObject = new MyClass();

        System.out.println("Information about the object:");
        System.out.println("privateField1: " + myObject.privateField1);
        System.out.println("privateField2: " + myObject.privateField2);
        System.out.println("privateField3: " + myObject.privateField3);
        System.out.println("privateField4: " + myObject.privateField4);

        String userInput = "method1";

        Method[] methods = MyClass.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals(userInput)) {
                try {
                    method.invoke(myObject);
                    return;
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            Field field = MyClass.class.getDeclaredField(userInput);
            System.out.println("Enter new value for " + userInput + ": ");
            String newValue = "New Value";
            if (field.getType() == int.class) {
                newValue = "42";
            } else if (field.getType() == double.class) {
                newValue = "3.14";
            } else if (field.getType() == boolean.class) {
                newValue = "false";
            }

            field.setAccessible(true);
            if (field.getType() == String.class) {
                field.set(myObject, newValue);
            } else if (field.getType() == int.class) {
                field.set(myObject, Integer.parseInt(newValue));
            } else if (field.getType() == double.class) {
                field.set(myObject, Double.parseDouble(newValue));
            } else if (field.getType() == boolean.class) {
                field.set(myObject, false);
            }

            System.out.println("Updated information about the object:");
            System.out.println("privateField1: " + myObject.privateField1);
            System.out.println("privateField2: " + myObject.privateField2);
            System.out.println("privateField3: " + myObject.privateField3);
            System.out.println("privateField4: " + myObject.privateField4);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

