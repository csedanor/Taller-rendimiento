package co.edu.unbosque.Taller_Rendimiento.DTO;

import java.util.List;

public class RequestOrderDTO {
	
	private PedidoDTO pedidoDTO;
	private List<DetallePedidoDTO> detalleDTO;
	
	
	public RequestOrderDTO() {
		// TODO Auto-generated constructor stub
	}
	
	


	public RequestOrderDTO(PedidoDTO pedidoDTO, List<DetallePedidoDTO> detalleDTO) {
		super();
		this.pedidoDTO = pedidoDTO;
		this.detalleDTO = detalleDTO;
	}


	public PedidoDTO getPedidoDTO() {
		return pedidoDTO;
	}

	public void setPedidoDTO(PedidoDTO pedidoDTO) {
		this.pedidoDTO = pedidoDTO;
	}

	public List<DetallePedidoDTO> getDetalleDTO() {
		return detalleDTO;
	}

	public void setDetalleDTO(List<DetallePedidoDTO> detalleDTO) {
		this.detalleDTO = detalleDTO;
	}
	
	

	
	
	
	
	

}
