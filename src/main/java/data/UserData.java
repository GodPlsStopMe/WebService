package data;

public class UserData {
    private long id;
    private String name;
    private String password;

    public UserData(long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public UserData(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName(){
        return this.name;
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
