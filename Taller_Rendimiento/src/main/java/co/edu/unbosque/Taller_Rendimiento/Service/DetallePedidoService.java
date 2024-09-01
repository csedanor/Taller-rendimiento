package co.edu.unbosque.Taller_Rendimiento.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.Taller_Rendimiento.Repository.DetallePedidoRepository;

@Service
public class DetallePedidoService {
	@Autowired
	private DetallePedidoRepository detalleRepo;

}
