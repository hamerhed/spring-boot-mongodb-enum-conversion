package pl.psnc.hamerhed.mongodb.persistance;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import pl.psnc.hamerhed.mongodb.persistance.EnumReadConverterFactory.StringToEnumConverter;

/**
 * @author hamerhed
 * General factory  for creating converters of Enum to String representation. In order to handle specific
 * enum value, enum must to have overriden toString() method.
 */
public class EnumWriteConverterFactory implements ConverterFactory<Enum<?>, String>{

	
	@Override
	public <T extends String> Converter<Enum<?>, T> getConverter(Class<T> targetType) {
		return new Converter<Enum<?>, T>() {

			@Override
			public T convert(Enum<?> source) {
				
				return (T) source.toString();
			}
		};
	}
}
