import java.time.LocalDate;
import java.util.*;

public class Supermercado {
    Producto producto = new Producto(1,"1",1);
    ArrayList<ProductoAlimentacion> carritoAlimentos=new ArrayList<>();
    ArrayList<ProductoTextil> carritoTextil=new ArrayList<>();
    ArrayList<ProductoInformatica> carritoInformatica=new ArrayList<>();

    Map<String,Integer> map_CarritoParaMostrar= new HashMap<>();

    LinkedList<Producto> carrito = new LinkedList();






    public ArrayList<ProductoAlimentacion> getCarritoAlimentos() {
        return carritoAlimentos;
    }

    public void setCarritoAlimentos(ArrayList<ProductoAlimentacion> carritoAlimentos) {
        this.carritoAlimentos = carritoAlimentos;
    }

    public ArrayList<ProductoTextil> getCarritoTextil() {
        return carritoTextil;
    }

    public void setCarritoTextil(ArrayList<ProductoTextil> carritoTextil) {
        this.carritoTextil = carritoTextil;
    }

    public ArrayList<ProductoInformatica> getCarritoInformatica() {
        return carritoInformatica;
    }

    public void setCarritoInformatica(ArrayList<ProductoInformatica> carritoInformatica) {
        this.carritoInformatica = carritoInformatica;
    }

    public Map<String, Integer> getMap_CarritoParaMostrar() {
        return map_CarritoParaMostrar;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public LinkedList<Producto> getCarrito() {
        return carrito;
    }

    public void setCarrito(LinkedList<Producto> carrito) {
        this.carrito = carrito;
    }





    public void setMap_CarritoParaMostrar(Map<String, Integer> map_CarritoParaMostrar) {
        this.map_CarritoParaMostrar = map_CarritoParaMostrar;

    }


    public void mostrarCarroDeLaCompra() {
        //creo un map con el nombre y el numero de repeticiones
        for (int i = 0; i < carrito.size(); i++) {
            map_CarritoParaMostrar.put(carrito.get(i).getNombre(), Collections.frequency(carrito, new Producto(2, "Canelon", carrito.get(i).getCodigoDeBarras())));
        }
    }

    public void pasarPorCaja() {
        int contadorDeunidades=1;
        float precioTotal=0;
        //Ordenamos la lista de productos totales con el codigo de barras para agrupar los productos y luego por precios
            Collections.sort(
                    carrito,
                    new Comparator<Producto>() {
                        @Override
                        public int compare(Producto o1, Producto o2) {return o1.getCodigoDeBarras() - o2.getCodigoDeBarras();}
                        });

        Collections.sort(carrito, new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                return Float.compare(o1.getPrecio(), o2.getPrecio());
            }
        });




        LocalDate dateToday = LocalDate.now();
        System.out.println(dateToday + " " + "Mercadona");
        for (int i = 0; i < carrito.size(); i++) {
            //Todos los productos tienen un precio asi que sumandolo aqui directamente me ahorro variables y texto
            precioTotal+=carrito.get(i).getPrecio();
            //Si solo se repite 1 vez el Codigo entendemos que no tiene mas de 1 unidad y hacemos el print
            if(Collections.frequency(carrito, new Producto(2, "Canelon", carrito.get(i).getCodigoDeBarras()))==1){
                System.out.println("Producto=" + carrito.get(i).getNombre() + " | Unidades= 1 | Precio x Unidad=" + carrito.get(i).getPrecio() + "€ | Precio Total " + carrito.get(i).getPrecio() + "€");

            }
            //Por el contrario entendemos que hay mas de una unidad y con el contador se comprueba si el siguiente valor de la lista es igual y le suma un punto al contador en el momento que cambie
            //sabremos que el siguiente producto es diferente asi que lo podemos printear y pasar al siguiente
            else {
                if(i == carrito.size()-1){
                    System.out.println("Producto=" + carrito.get(i).getNombre() + " | Unidades= " + contadorDeunidades +" | Precio x Unidad=" + carrito.get(i).getPrecio()+ "€ | Precio Total " + (carrito.get(i).getPrecio()*contadorDeunidades) + "€");
                    break;
                }
                if(carrito.get(i).getCodigoDeBarras()==carrito.get(i+1).getCodigoDeBarras() && carrito.get(i).getPrecio()!=carrito.get(i+1).getPrecio()){
                    System.out.println("Producto=" + carrito.get(i).getNombre() + " | Unidades= " + contadorDeunidades +" | Precio x Unidad=" + carrito.get(i).getPrecio()+ "€ | Precio Total " + (carrito.get(i).getPrecio()*contadorDeunidades) + "€");
                    contadorDeunidades=1;
                }
                else if(carrito.get(i).getCodigoDeBarras()!=carrito.get(i+1).getCodigoDeBarras()){
                    System.out.println("Producto=" + carrito.get(i).getNombre() + " | Unidades= " + contadorDeunidades +" | Precio x Unidad=" + carrito.get(i).getPrecio()+ "€ | Precio Total " + (carrito.get(i).getPrecio()*contadorDeunidades) + "€");
                    contadorDeunidades=1;
                }
                else {
                   contadorDeunidades++;
                }
            }

        }
        System.out.println("Total: " + precioTotal + " €");
        //Vaciamos todos los carros creados
        carrito.clear();
        carritoAlimentos.clear();
        carritoInformatica.clear();
        carritoTextil.clear();
        map_CarritoParaMostrar.clear();

    }


}
