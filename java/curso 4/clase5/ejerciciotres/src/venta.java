public class venta {
    private String cliente;
    private String producto;
    private int categoria;
   
    private int cantidad;

    private double precioUnitario;

    public venta(String cliente, String producto, int categoria, int cantidad, double precioUnitario) {
        this.cliente = cliente;
        this.producto = producto;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public String getCliente() {
        return cliente;
    }

    public String getProducto() {
        return producto;
    }

    public int getCategoria() {
        return categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("venta{");
        sb.append("cliente=").append(cliente);
        sb.append(", producto=").append(producto);
        sb.append(", categoria=").append(categoria);
        sb.append(", cantidad=").append(cantidad);
        sb.append(", precioUnitario=").append(precioUnitario);
        sb.append('}');
        return sb.toString();
    }


    

}
