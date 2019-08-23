package pl.psnc.hamerhed.mongodb.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import pl.psnc.hamerhed.mongodb.model.Gender;

@Configuration
public class MongodbConfig {

	@Bean
	public MongoCustomConversions customConversions() {
	    List<Converter<?, ?>> converterList = new ArrayList<>();
	    converterList.add(new Gender.GenderReadConverter());
	    converterList.add(new Gender.GenderWriteConverter());
	    return new MongoCustomConversions(converterList);
	 
	}
}
