package com.example.a18augyougetuserdetails;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseModel implements Serializable {

	@SerializedName("data")
	private DataModel data;

	@SerializedName("support")
	private SupportModel support;

	public DataModel getData(){
		return data;
	}

	public SupportModel getSupport(){
		return support;
	}
}