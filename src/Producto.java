import java.util.Objects;

public class Producto {
    private float precio;
    private String nombre;
    private int codigoDeBarras;

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(int codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public Producto(float precio, String nombre, int codigoDeBarras) {
        this.precio = precio;
        this.nombre = nombre;
        this.codigoDeBarras = codigoDeBarras;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "precio=" + precio + " €" +
                ", nombre='" + nombre + '\'' +
                ", codigoDeBarras=" + codigoDeBarras +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        Producto p;
        if(!(obj instanceof  Producto)){
            return false;
        }
        else{
            p=(Producto) obj;
            if (this.codigoDeBarras==(p.getCodigoDeBarras())&& this.codigoDeBarras==p.getCodigoDeBarras()){
                return true;
            }
        }
        return false;
    }


    @Override
    public int hashCode() {
        return Objects.hash(codigoDeBarras);
    }



}

