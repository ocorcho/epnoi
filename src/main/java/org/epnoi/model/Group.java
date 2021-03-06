package org.epnoi.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

public class Group implements Resource {
	boolean autoAccept;
	String description;
	Long ID;
	String owner;
	String resource;
	String title;
	String URI;
	ArrayList<String> tags;

	Group() {
		this.tags = new ArrayList<String>();
	}

	public boolean isAutoAccept() {
		return autoAccept;
	}

	public void setAutoAccept(boolean autoAccept) {
		this.autoAccept = autoAccept;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getID() {
		return this.ID;
	}

	public void setID(Long id) {
		this.ID = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement(name = "URI")
	public String getURI() {
		return this.URI;
	}

	public void setURI(String URI) {
		this.URI = URI;
	}

}
