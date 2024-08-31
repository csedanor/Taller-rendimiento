package co.edu.unbosque.Taller_Rendimiento.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.Taller_Rendimiento.Entidades.ClienteEntity;
import co.edu.unbosque.Taller_Rendimiento.Repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepo; 
	public ClienteService() {
		// TODO Auto-generated constructor stub
	}
	// Model Mapping, para pasar el DTO, y usar la entidad
	public List<ClienteEntity> listCustom() {
		// TODO Auto-generated method stub
		return clienteRepo.findAll();
	}

}
