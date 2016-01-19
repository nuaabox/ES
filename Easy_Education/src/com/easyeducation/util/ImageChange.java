package com.easyeducation.util;

import java.io.ByteArrayOutputStream;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Base64;

public class ImageChange {
	
	
	public  static String  ImgtoByte( Bitmap  bp)
	{
		String str="";
		ByteArrayOutputStream out = new ByteArrayOutputStream();  
		bp.compress(Bitmap.CompressFormat.JPEG, 100, out);  
		byte[] imagebyte = out.toByteArray();
		str=Base64.encodeToString(imagebyte, Base64.DEFAULT);
		System.gc();
		return str;
	}
	
	public   static Bitmap BytetoImg( String  str)
	{
		byte imgbyte[]= Base64.decode(str, Base64.DEFAULT);
		Bitmap bitmap = BitmapFactory.decodeByteArray(imgbyte, 0, imgbyte.length);  
		System.gc();
		return bitmap;
	}

	 @SuppressWarnings("static-access")
	public static Bitmap resiezeBitmap(Bitmap srcbitmap)
	 {
		 Bitmap bitmap = null;
		 bitmap = srcbitmap.createScaledBitmap(srcbitmap, 600, 600, true);
		return bitmap;
		
		 
	 }

}
