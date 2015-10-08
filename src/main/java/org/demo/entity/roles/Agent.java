package org.demo.entity.roles;


import java.util.HashSet;
import java.util.Set;

public class Agent {

    private String name;

    private Set<User> users = new HashSet<User>();

    private Set<Manager> managers = new HashSet<Manager>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Manager> getManagers() {
        return managers;
    }

    public void setManagers(Set<Manager> managers) {
        this.managers = managers;
    }
}
