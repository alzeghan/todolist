package com.todo.persistance.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity(name="users")
//@NamedQueries({
//        @NamedQuery(name = "findUserByEmail", query = "SELECT u FROM users u where u.email = :p_email"),
//        @NamedQuery(name = "findUserByEmailAndPassword", query = "SELECT u FROM users u where u.email = :p_email and u.password = :p_password")
//})
public class Users implements Serializable {

    @Id
    @Generated(GenerationTime.INSERT)
    private Long id;

    private String name;

    private String username;

    private String password;

    public Users() {
    }

    public Users(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User[" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ']';
    }
}
