package homeTask20240109.task1;
/*1 Создайте класс с 10 методами и 4 приватными полями. Геттеры и сеттеры добавлять
не нужно. Создайте объект Вашего класса. Выведите в консоль информацию об объекте.
Затем пользователь вводит имя поля или метода. Программа определяет, имя какого члена класса
было введено. Если введено имя метода, то этот метод немедленно вызывается. Если введено имя поля,
то программа запрашивает у пользователя новое значение и
устанавливает его новым значением этого поля.*/
public class MyClass {
    public String privateField1 = "Initial Value 1";
    public int privateField2 = 42;
    public double privateField3 = 3.14;
    public boolean privateField4 = true;

    public void method1() {
        System.out.println("Method 1 called");
    }

    public void method2() {
        System.out.println("Method 2 called");
    }

    public void method3() {
        System.out.println("Method 3 called");
    }

    public void method4() {
        System.out.println("Method 4 called");
    }

    public void method5() {
        System.out.println("Method 5 called");
    }

    public void method6() {
        System.out.println("Method 6 called");
    }

    public void method7() {
        System.out.println("Method 7 called");
    }

    public void method8() {
        System.out.println("Method 8 called");
    }

    public void method9() {
        System.out.println("Method 9 called");
    }

    public void method10() {
        System.out.println("Method 10 called");
    }
}
