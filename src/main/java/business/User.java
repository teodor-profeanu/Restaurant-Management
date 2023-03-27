package business;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private UserRole role;

    public User(int id,String username, String password, UserRole role) {
        this.id=id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public UserRole getRole() {
        return role;
    }

    public String toString(){
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
