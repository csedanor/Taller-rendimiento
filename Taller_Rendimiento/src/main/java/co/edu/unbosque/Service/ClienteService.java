package co.edu.unbosque.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.Entidades.ClienteEntity;
import co.edu.unbosque.Repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepo; 
	public ClienteService() {
		// TODO Auto-generated constructor stub
	}
	
	public List<ClienteEntity> listCustom() {
		// TODO Auto-generated method stub
		return clienteRepo.findAll();
	}

}
