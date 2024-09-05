package co.edu.unbosque.Taller_Rendimiento.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import co.edu.unbosque.Taller_Rendimiento.DTO.ClienteDTO;
import co.edu.unbosque.Taller_Rendimiento.Entidades.ClienteEntity;
import co.edu.unbosque.Taller_Rendimiento.Repository.ClienteRepository;
import co.edu.unbosque.Taller_Rendimiento.Utilities.MapperUtilities;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepo;

    @Autowired
    public ClienteService(ClienteRepository clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    @Cacheable(value = "clientes")
    public List<ClienteDTO> listCustom() {
        List<ClienteEntity> clientesEntidades = clienteRepo.findAll();
        return MapperUtilities.mapList(clientesEntidades, ClienteDTO.class);
    }

    @Cacheable(value = "cliente", key = "#clienteId")
    public ClienteDTO obtenerCliente(Integer clienteId) {
        ClienteEntity cliente = clienteRepo.findById(clienteId).orElse(null);
        if (cliente == null) {
            return null;
        }
        return MapperUtilities.mapearObjetos(cliente, ClienteDTO.class);
    }
}
