package homeTask20240111.pattern.connection;

public class SlowConnection extends Connection{
    private static SlowConnection instance;

    private SlowConnection(int id, String host, int port, String protocol) {
        super(id, host, port, protocol);
    }

    public static synchronized SlowConnection getInstance(int id,String host, int port, String protocol) {
        if (instance == null) {
            instance = new SlowConnection(id,host, port, protocol);
        }
        return instance;
    }

}
