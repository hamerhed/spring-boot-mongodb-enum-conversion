package pl.psnc.hamerhed.mongodb.persistance;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * @author hamerhed
 * General factory for creating converters from String to specific Enum types based on value parameter of particular enum.
 */
public class EnumReadConverterFactory implements ConverterFactory<String, Enum<?>> {

	@Override
    public <E extends Enum<?>> Converter<String, E> getConverter(
            Class<E> targetType) {
        return new StringToEnumConverter<E>(targetType);
    }
	
    static class StringToEnumConverter<E extends Enum<?>> implements Converter<String, E> {
        private Class<E> enumType;
        
        StringToEnumConverter(Class<E> enumType) {
            this.enumType = enumType;
        }
        
        @Override
        public E convert(String source) {
            source = source.trim();
            for (E constant : enumType.getEnumConstants())
                if (constant.toString().equals(source)) {
                	return constant;
                }

            throw new IllegalArgumentException(source);
        }
    }

}
