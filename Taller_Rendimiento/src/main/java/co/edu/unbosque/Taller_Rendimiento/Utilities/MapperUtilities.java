package co.edu.unbosque.Taller_Rendimiento.Utilities;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;


//Esto se hace para generalizar el mapeo que será utilizado para pasar de entidad a DTO 
// El código lo tompe de https://www.baeldung.com/java-modelmapper-lists
public class MapperUtilities {
	
	private static final ModelMapper modelMapper = new ModelMapper();

    public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source.stream()
                     .map(element -> modelMapper.map(element, targetClass))
                     .collect(Collectors.toList());
    }

}
