package cn.lv.hgstudy.converter;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String text) {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            return (Date) dateFormat.parse(text);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
	}
	
}
