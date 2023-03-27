package business;

import data.Serializer;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private ArrayList<User> users;

    public UserService() {
        try {
            users = Serializer.SERIALIZER.deserialize(FileNames.USERS);
        } catch (Exception exception) {
            users = new ArrayList<>();
            users.add(new User(1, "admin", "admin", UserRole.ADMIN));
            users.add(new User(2, "employee", "employee", UserRole.EMPLOYEE));
            System.out.println("Deserialization failed");
        }
    }

    public void addUser(String username, String password) {
        int idMax = 0;
        if (username == null || username.length() == 0)
            throw new IllegalArgumentException("Invalid username.");
        if (password == null || password.length() == 0)
            throw new IllegalArgumentException("Invalid password.");

        for (User user : users) {
            if (user.getId() > idMax)
                idMax = user.getId();
            if (username.compareTo(user.getUsername()) == 0)
                throw new IllegalArgumentException("Username already exists.");
        }

        users.add(new User(idMax + 1, username, password, UserRole.CLIENT));
        Serializer.SERIALIZER.serialize(users, FileNames.USERS);
    }

    public User access(String username, String password) {
        User user = null;
        for (User userAux : users) {
            if (username.compareTo(userAux.getUsername()) == 0)
                user = userAux;
        }
        if (user == null)
            throw new IllegalArgumentException("Username is not registered.");
        if (user.getPassword().compareTo(password) != 0)
            throw new IllegalArgumentException("Password is incorrect.");
        return user;
    }

    public User findById(int id) {
        for (User user : users)
            if (user.getId() == id)
                return user;
        return null;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
