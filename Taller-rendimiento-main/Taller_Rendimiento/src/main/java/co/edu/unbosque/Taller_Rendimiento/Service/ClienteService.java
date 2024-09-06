package co.edu.unbosque.Taller_Rendimiento.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import co.edu.unbosque.Taller_Rendimiento.DTO.ClienteDTO;
import co.edu.unbosque.Taller_Rendimiento.Entidades.ClienteEntity;
import co.edu.unbosque.Taller_Rendimiento.Repository.ClienteRepository;
import co.edu.unbosque.Taller_Rendimiento.Utilities.MapperUtilities;

/**
 * Servicio para gestionar las operaciones relacionadas con la entidad {@code ClienteEntity}.
 * Proporciona métodos para listar y obtener clientes, utilizando {@code ClienteRepository} para 
 * las operaciones de acceso a datos y {@code MapperUtilities} para la conversión entre entidades y DTOs.
 * El servicio está anotado con {@code @Service}, indicando que es un componente de servicio en 
 * la capa de servicio de la aplicación. Utiliza caché para almacenar los resultados de las consultas 
 * para mejorar el rendimiento de las operaciones repetidas.
 */
@Service
public class ClienteService {

    private final ClienteRepository clienteRepo;

    /**
     * Constructor de {@code ClienteService}.
     * 
     * @param clienteRepo El repositorio de clientes a ser utilizado por el servicio.
     */
    @Autowired
    public ClienteService(ClienteRepository clienteRepo) {
        this.clienteRepo = clienteRepo;
    }


    /**
     * Lista todos los clientes, mapeados desde {@code ClienteEntity} a {@code ClienteDTO}.
     * Los resultados se almacenan en caché bajo la clave {@code "clientes"}.
     * 
     * @return Una lista de {@code ClienteDTO} que representa todos los clientes.
     */
    @Cacheable(value = "clientes")
    public List<ClienteDTO> listCustom() {
        List<ClienteEntity> clientesEntidades = clienteRepo.findAll();
        return MapperUtilities.mapList(clientesEntidades, ClienteDTO.class);
    }


    /**
     * Obtiene un cliente específico por su ID, mapeado desde {@code ClienteEntity} a {@code ClienteDTO}.
     * El resultado se almacena en caché bajo la clave {@code "cliente"} y la clave de caché es el ID del cliente.
     * 
     * @param clienteId El ID del cliente a obtener.
     * @return El {@code ClienteDTO} correspondiente al ID proporcionado, o {@code null} si no se encuentra.
     */
    @Cacheable(value = "cliente", key = "#clienteId")
    public ClienteDTO obtenerCliente(Integer clienteId) {
        ClienteEntity cliente = clienteRepo.findById(clienteId).orElse(null);
        if (cliente == null) {
            return null;
        }
        return MapperUtilities.mapearObjetos(cliente, ClienteDTO.class);
    }
}
