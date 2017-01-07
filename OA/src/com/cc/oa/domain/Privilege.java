package com.cc.oa.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 实体：权限
 * 
 * @author 滴水藏海
 *
 */
public class Privilege {

	private long id;
	private String name;
	private String url;
	private String icon;

	private Set<Role> roles = new HashSet<Role>();
	private Privilege parent;
	private Set<Privilege> children = new HashSet<Privilege>();

	
	
	public Privilege() {
		super();
	}

	public Privilege(String name, String url, String icon, Privilege parent) {
		super();
		this.name = name;
		this.url = url;
		this.icon = icon;
		this.parent = parent;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Privilege getParent() {
		return parent;
	}

	public void setParent(Privilege parent) {
		this.parent = parent;
	}

	public Set<Privilege> getChildren() {
		return children;
	}

	public void setChildren(Set<Privilege> children) {
		this.children = children;
	}

}
