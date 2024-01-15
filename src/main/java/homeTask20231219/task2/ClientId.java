package homeTask20231219.task2;
/*2 Создайте классы Клиент, Товар, Задание. Создайте единый механизм для генерации
уникальных идентификаторов для каждого из классов (у Клиентов свои идентификаторы,
у Товаров – свои, у Заданий - свои). Используйте обёртку ThreadLocal для хранения счетчика
уникальных идентификаторов в каждом потоке. Реализуйте класс UniqueIdGenerator, который
предоставляет метод generateUniqueId(),
возвращающий уникальный идентификатор.*/
public class ClientId {
    private final long id;

    public ClientId() {
        this.id = UniqueIdGenerator.generateUniqueId();
    }

    public long getId() {
        return id;
    }
}
