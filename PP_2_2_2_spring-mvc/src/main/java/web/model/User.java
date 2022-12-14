package web.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "userlastname")
    private String userlastname;
    @Column(name = "age")
    private int age;
    @Column(name = "email")
    private String email;

    public User() { }
    public User(int id, String username, String userlastname, int age, String email) {
        this.id = id;
        this.username = username;
        this.userlastname = userlastname;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserlastname() {
        return userlastname;
    }

    public void setUserlastname(String userlastname) {
        this.userlastname = userlastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userlastname='" + userlastname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
