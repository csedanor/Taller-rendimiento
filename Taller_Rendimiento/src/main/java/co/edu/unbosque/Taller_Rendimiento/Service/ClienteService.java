package co.edu.unbosque.Taller_Rendimiento.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;

import co.edu.unbosque.Taller_Rendimiento.DTO.ClienteDTO;
import co.edu.unbosque.Taller_Rendimiento.Entidades.ClienteEntity;
import co.edu.unbosque.Taller_Rendimiento.Repository.ClienteRepository;
import co.edu.unbosque.Taller_Rendimiento.Utilities.MapperUtilities;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepo; 
	
	//ModelMapper mapper = new ModelMapper();
	

	// Model Mapping, para pasar el DTO, y usar la entidad
	public List<ClienteDTO> listCustom() {
		// TODO Auto-generated method stub
		List<ClienteEntity> clientesEntidades = clienteRepo.findAll();
		List<ClienteDTO> clientesDto = MapperUtilities.mapList(clientesEntidades, ClienteDTO.class);
		return clientesDto;
	}

//	public List<ClienteEntity> listCustomV2() {
//		// TODO Auto-generated method stub
//		return clienteRepo.findAll();
//	}

}
