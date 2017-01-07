package com.cc.oa.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 滴水藏海 on 2016/12/6.
 */
public class Role {
    private long id;
    private String name;
    private String description;
    private Set<User> users = new HashSet<User>();
    private Set<Privilege> privileges = new HashSet<Privilege>();
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}
    
}

