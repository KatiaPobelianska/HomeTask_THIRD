package homeTask20240111.pattern.exchanger;

import homeTask20240111.pattern.connection.Connection;
import homeTask20240111.pattern.connector.Connector;

public class Exchanger {
    private final String name;

    public Exchanger(String name) {
        this.name = name;
    }

    public void exchange() {
        Connection connection = Connector.getConnection();
        System.out.println(name + " got connection with id " + connection.hashCode());
    }

}
