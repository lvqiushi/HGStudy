package cn.lv.hgstudy.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class BASE64Encode {
	static WebApplicationContext webApplicationContext = ContextLoader
            .getCurrentWebApplicationContext();
    static ServletContext servletContext = webApplicationContext
            .getServletContext();
	static String savePath = servletContext.getRealPath("/header");
	
	
	public static String GetImageStr()  
    {
        String imgFile = "d://test.jpg";
        InputStream in = null;  
        byte[] data = null;  
        //
        try   
        {  
            in = new FileInputStream(imgFile);          
            data = new byte[in.available()];  
            in.read(data);  
            in.close();  
        }   
        catch (IOException e)   
        {  
            e.printStackTrace();  
        }  
        //
        BASE64Encoder encoder = new BASE64Encoder();  
        return encoder.encode(data);//
    }  
      
    //base64
    public static String DecoderImage(String base64)  
    {   
    	System.out.println("the path "+savePath);
    	//
        if (base64 == null) //
            return "false";  
        BASE64Decoder decoder = new BASE64Decoder();  
        try   
        {  
            //
            byte[] b = decoder.decodeBuffer(base64);  

            // 
            long times=System.currentTimeMillis();
    		String imageName = String.valueOf(times)+".png";
            OutputStream out = new FileOutputStream(savePath+File.separator+imageName);      
            out.write(b);  
            out.flush();  
            out.close();  
            return imageName;  
        }   
        catch (Exception e)   
        {  
        	e.printStackTrace();
            return "error";  
        }  
    } 
}
