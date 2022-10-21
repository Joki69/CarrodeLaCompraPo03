public class ProductoTextil extends Producto{
    private String composicionTextil;

    public ProductoTextil(float precio, String nombre, int codigoDeBarras,String composicionTextil) {
        super(precio, nombre, codigoDeBarras);
    this.composicionTextil=composicionTextil;

    }

    public String getComposicionTextil() {
        return composicionTextil;
    }

    public void setComposicionTextil(String composicionTextil) {
        this.composicionTextil = composicionTextil;
    }

    @Override
    public String toString() {
        return super.toString() +
                "ProductoTextil{" +
                "composicionTextil='" + composicionTextil + '\'' +
                '}';
    }
}
