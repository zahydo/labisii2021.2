package co.edu.unicauca.layersmvc.domain;

public class Response {
  String tipo;
  Product producto;

  public Response(String tipo, Product producto) {
    this.tipo = tipo;
    this.producto = producto;
  }

  public String getTipo() {
    return this.tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public Product getProducto() {
    return this.producto;
  }

  public void setProducto(Product producto) {
    this.producto = producto;
  }
}
