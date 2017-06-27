package com.mashen.util;

import java.io.File;

public class ImgDelete {
	public static void delete(String file){
		File myfile = new File(file);
		if(myfile.exists()){
			myfile.delete();
			System.out.println("文件已删除");
		}else{
			System.out.println("文件不存在");
		}
	}
	public static void main(String[] args) {
		delete("/advertisementImg/a.txt");
	}
}
