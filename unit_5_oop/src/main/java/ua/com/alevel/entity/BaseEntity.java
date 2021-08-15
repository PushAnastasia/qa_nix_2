package ua.com.alevel.entity;

public abstract class BaseEntity {

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String toString() {
        return "Id = " + id;
    }
}
