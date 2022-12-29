package com.mailonline.utils;
import java.util.ArrayList;
import java.util.List;
import com.mailonline.request.api.createpet.Category;
import com.mailonline.request.api.createpet.InvalidPet;
import com.mailonline.request.api.createpet.Pet;
import com.mailonline.request.api.createpet.Status;
import com.mailonline.request.api.createpet.Tag;


public class PayLoadBuilder {

	public static Pet getAddPetPayload()
	{
		Category categoryObj = new Category();
		categoryObj.setId(59); // for now hard coded the values, we can random generate the in
		categoryObj.setName("Teenu");
		
		Tag tagObj = new Tag();
		tagObj.setId(59);
		tagObj.setName("Teenu");		
		List<Tag> tagList = new ArrayList<Tag>();
		tagList.add(tagObj);
		
		List<String> photoUrlList = new ArrayList<String>();
		photoUrlList.add("url");
		
		Pet petObject = new Pet();
		petObject.setId(59);
		petObject.setName("Teenu");
		petObject.setStatus(Status.available);
		petObject.setCategory(categoryObj);
		petObject.setTags(tagList);
		petObject.setPhotoUrls(photoUrlList);
		
		return petObject;	
	}
	public static InvalidPet getInvalidAddPetPayload()
	{
		
		Category categoryObj = new Category();
		categoryObj.setId(59);
		categoryObj.setName("Teenu");
		
		Tag tagObj = new Tag();
		tagObj.setId(59);
		tagObj.setName("Teenu");		
		List<Tag> tagList = new ArrayList<Tag>();
		tagList.add(tagObj);
		
		List<String> photoUrlList = new ArrayList<String>();
		photoUrlList.add("url");
		
		InvalidPet petObject = new InvalidPet();
		petObject.setId("Id101");//Invalid id
		petObject.setName("Teenu");
		petObject.setStatus(Status.available);
		petObject.setCategory(categoryObj);
		petObject.setTags(tagList);
		petObject.setPhotoUrls(photoUrlList);
		
		return petObject;	
	}
}
