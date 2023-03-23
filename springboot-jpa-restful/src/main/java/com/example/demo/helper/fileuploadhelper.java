package com.example.demo.helper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Component
public class fileuploadhelper 
{
	//static path
	public final static String upload_dir="D:\\java files\\springboot-jpa-restful\\src\\main\\resources\\static\\image";
	
	//dynamic path
	//public final String upload_dir = new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	public fileuploadhelper() throws IOException
	{
		
	}
	
	public boolean uploadfile(MultipartFile multipartFile)
	{
		boolean f=false;
		try
		{
			InputStream is = multipartFile.getInputStream();
			byte data[] = new byte[is.available()];
			is.read(data);
			
			//writing data
			FileOutputStream fos = new FileOutputStream(upload_dir+File.separator+multipartFile.getOriginalFilename());
			fos.write(data);
			fos.flush();
			fos.close();
			f=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
		
	}
	
}
