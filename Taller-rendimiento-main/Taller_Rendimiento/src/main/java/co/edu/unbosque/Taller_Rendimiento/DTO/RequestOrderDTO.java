package co.edu.unbosque.Taller_Rendimiento.DTO;

import java.util.List;

/**
 * Clase que representa una solicitud de pedido en el sistema.
 * Esta clase se utiliza para encapsular la información del pedido junto con
 * los detalles de los productos asociados a ese pedido.
 */
public class RequestOrderDTO {
    private PedidoDTO pedidoDTO;
    private List<DetallePedidoDTO> detalleDTO;

    /**
     * Constructor por defecto.
     * Inicializa un nuevo objeto {@code RequestOrderDTO} sin valores asignados.
     */
    public RequestOrderDTO() {}

    /**
     * Constructor con parámetros.
     * Inicializa un nuevo objeto {@code RequestOrderDTO} con la información del pedido
     * y los detalles de los productos.
     *
     * @param pedidoDTO  El objeto {@code PedidoDTO} que contiene la información del pedido.
     * @param detalleDTO La lista de objetos {@code DetallePedidoDTO} que representan los detalles
     *                   de los productos asociados al pedido.
     */
    public RequestOrderDTO(PedidoDTO pedidoDTO, List<DetallePedidoDTO> detalleDTO) {
        this.pedidoDTO = pedidoDTO;
        this.detalleDTO = detalleDTO;
    }

    /**
     * Obtiene el objeto {@code PedidoDTO} asociado a esta solicitud de pedido.
     *
     * @return El objeto {@code PedidoDTO} que contiene la información del pedido.
     */
    public PedidoDTO getPedidoDTO() {
        return pedidoDTO;
    }
    
    /**
     * Establece el objeto {@code PedidoDTO} para esta solicitud de pedido.
     *
     * @param pedidoDTO El objeto {@code PedidoDTO} que contiene la información del pedido.
     */
    public void setPedidoDTO(PedidoDTO pedidoDTO) {
        this.pedidoDTO = pedidoDTO;
    }

    /**
     * Obtiene la lista de objetos {@code DetallePedidoDTO} que representan los detalles de los productos
     * asociados a esta solicitud de pedido.
     *
     * @return La lista de objetos {@code DetallePedidoDTO}.
     */
    public List<DetallePedidoDTO> getDetalleDTO() {
        return detalleDTO;
    }


    /**
     * Establece la lista de objetos {@code DetallePedidoDTO} para esta solicitud de pedido.
     *
     * @param detalleDTO La lista de objetos {@code DetallePedidoDTO} que representan los detalles de los productos.
     */
    public void setDetalleDTO(List<DetallePedidoDTO> detalleDTO) {
        this.detalleDTO = detalleDTO;
    }
}
