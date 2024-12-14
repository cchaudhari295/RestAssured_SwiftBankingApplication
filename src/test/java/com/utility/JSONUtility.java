package com.utility;

import com.google.gson.Gson;

public class JSONUtility {

	public static void main(String[] args) {

	}

		//Serialization=>Java object to json object
		public static String convertToJSON(Object ref) {
			Gson gson=new Gson();
			String json=gson.toJson(ref);
			return json;
			
		}
		
	}


