package org.demo.entity.roles;


import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

public class Manager extends User {

    @OneToMany
    protected Set<User> users = new HashSet<User>();



}
