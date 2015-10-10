package org.demo.entity.roles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue
    protected int id;

    protected String email;

    protected String password;

    protected int discoverClubPoints;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDiscoverClubPoints() {
        return discoverClubPoints;
    }

    public void setDiscoverClubPoints(int discoverClubPoints) {
        this.discoverClubPoints = discoverClubPoints;
    }
}
