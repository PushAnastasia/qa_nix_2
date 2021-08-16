package ua.com.alevel.entity;

public abstract class BaseEntity {

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

//    здесь не нужен toString() - ты все равно его перебиваешь в наследниках
    public String toString() {
        return "Id = " + id;
    }
}
