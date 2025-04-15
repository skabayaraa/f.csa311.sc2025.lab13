package AndrewWebServices;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDatabase implements Database {
    private Map<String, String> users = new HashMap<>();

    @Override
    public void addUser(String username, String password) {
        users.put(username, password);
    }

    @Override
    public boolean validateUser(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}
