package pl.psnc.hamerhed.mongodb.model;

import java.util.Arrays;

import org.springframework.core.convert.converter.Converter;

public enum Gender {
	MALE("x"), FEMALE("y");
	
	private String value = null;
	
	private Gender(String val) {
		this.value = val;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return value;
	}


	//approach using dedicated read and write converters for each enum
	public static class GenderWriteConverter implements Converter<Gender, String> {

		@Override
		public String convert(Gender source) {
			return source.getValue();
		}
	}
	
	public static class GenderReadConverter implements Converter<String, Gender> {

		@Override
		public Gender convert(String source) {
			return source == null ? null : Arrays.stream(Gender.values()).
                      filter(enumInstance -> enumInstance.getValue().equalsIgnoreCase(source.trim())).
                      findFirst().
                      orElseThrow(() -> new IllegalArgumentException(String.format("No parsable enumInstance representation: [%s]", source)));
		}
		
	}
	
}
