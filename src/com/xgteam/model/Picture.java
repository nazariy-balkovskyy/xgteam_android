package com.xgteam.model;

public class Picture {
	private static int picturesCount;

	public static int getPicturesCount() {
		switch(User.getId()){
			case 1:{
				picturesCount=98;
				break;
			}
			case 2:{
				picturesCount=105;
				break;
			}
			default:{
				picturesCount=0;
				break;
			}
		}
		return picturesCount;
	}

	public static void setPicturesCount(int picturesCount) {
		Picture.picturesCount = picturesCount;
	}
}
