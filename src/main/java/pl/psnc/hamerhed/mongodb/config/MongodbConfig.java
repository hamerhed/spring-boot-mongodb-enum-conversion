package pl.psnc.hamerhed.mongodb.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import pl.psnc.hamerhed.mongodb.model.Gender;
import pl.psnc.hamerhed.mongodb.persistance.EnumReadConverterFactory;
import pl.psnc.hamerhed.mongodb.persistance.EnumWriteConverterFactory;

@Configuration
public class MongodbConfig {

	@Bean
	public MongoCustomConversions customConversions() {
	    List<Object> converterList = new ArrayList<>();
	    //dedicated converters for particular enum types
	    //converterList.add(new Gender.GenderReadConverter());
	   // converterList.add(new Gender.GenderWriteConverter());
	    
	    //used converter factory handling all  enum types
	   converterList.add(new EnumWriteConverterFactory());
	   converterList.add( new EnumReadConverterFactory());
	   return new MongoCustomConversions(converterList);
	 
	}
}
