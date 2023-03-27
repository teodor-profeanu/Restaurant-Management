package business;

import java.io.Serializable;
import java.util.Objects;

public abstract class MenuItem implements Serializable {
    int id;
    protected String title;

    public abstract int computePrice();
    public abstract void validate() throws AssertionError;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id){
        this.id=id;
    }

    public int getId(){
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem item = (MenuItem) o;
        return id == item.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
