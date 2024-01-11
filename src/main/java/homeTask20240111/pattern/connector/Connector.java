package homeTask20240111.pattern.connector;

import homeTask20240111.pattern.connection.Connection;
import homeTask20240111.pattern.connection.FastConnection;
import homeTask20240111.pattern.connection.SlowConnection;

import java.util.Random;

public class Connector {
    private static final Random RANDOM = new Random();

    public static Connection getConnection() {
        int id = RANDOM.nextInt(Integer.MAX_VALUE);

        if (RANDOM.nextBoolean()) {
            return new FastConnection(id,"fast_host", 80, "fast_protocol");
        } else {
            return SlowConnection.getInstance(id,"slow_host", 8080, "slow_protocol");
        }
    }

}
