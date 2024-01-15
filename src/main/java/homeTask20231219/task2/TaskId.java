package homeTask20231219.task2;

public class TaskId {
    private final long id;

    public TaskId() {
        this.id = UniqueIdGenerator.generateUniqueId();
    }

    public long getId() {
        return id;
    }
}
