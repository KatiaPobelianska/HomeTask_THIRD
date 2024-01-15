package homeTask20231219.task1;

public class User implements Runnable{
    private final String username;
    private final Document document;

    public User(String username, Document document) {
        this.username = username;
        this.document = document;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        document.addLine("New line from " + username);
        document.changeLine(0, "Changed line by " + username);
        document.deleteLine(document.getLines().size() - 1);
        System.out.println("Document after changing by " + username + "\n" + document.getLines());
    }

}
