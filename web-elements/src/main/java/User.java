import lombok.Getter;

public class User {

    public int id;
    @Getter
    public String name;

    User(int id , String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
