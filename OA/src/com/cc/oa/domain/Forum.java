package com.cc.oa.domain;

/**
 * 版块管理实体类
 * 
 * @author 滴水藏海
 *
 */
public class Forum {

	private long id;
	private String name;
	private String description;
	private int position;// 用于实现调整上下版块位置

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
