package com.mailonline.request.api.createpet;

import java.util.List;

public class InvalidPet {
	  	private String id;
	    private Category category;
	    private String name;
	    private List<String> photoUrls;
	    private List<Tag> tags;
	    private Status status;
	    
	    public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<String> getPhotoUrls() {
			return photoUrls;
		}
		public void setPhotoUrls(List<String> photoUrls) {
			this.photoUrls = photoUrls;
		}
		public List<Tag> getTags() {
			return tags;
		}
		public void setTags(List<Tag> tags) {
			this.tags = tags;
		}
		public Status getStatus() {
			return status;
		}
		public void setStatus(Status status) {
			this.status = status;
		}

	}


