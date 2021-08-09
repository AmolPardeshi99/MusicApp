package com.example.firstapp;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseModel implements Serializable {

	@SerializedName("image")
	private String image;

	@SerializedName("subTitle")
	private String subTitle;

	@SerializedName("title")
	private String title;

	public String getImage(){
		return image;
	}

	public String getSubTitle(){
		return subTitle;
	}

	public String getTitle(){
		return title;
	}

	@Override
 	public String toString(){
		return 
			"ResponseModel{" + 
			"image = '" + image + '\'' + 
			",subTitle = '" + subTitle + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}
}