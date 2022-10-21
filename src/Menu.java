import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

public class Menu {
    Scanner scanner=new Scanner(System.in);
    Supermercado supermercado= new Supermercado();


    public void menuDeCompras() {
        // Prueba para llenar el carro y comprobar si te deja añadir mas de 100
        /*for (int i = 0; i < 100; i++) {
            supermercado.carritoAlimentos.add(new ProductoAlimentacion(2, "Canelones", 1232131123, 2022, 10, 25));
        }
        supermercado.carrito.addAll(supermercado.carritoAlimentos);

        System.out.println(supermercado.carrito + " " + supermercado.carrito.size());
*/
        while (true) {
            System.out.println("Elige una opción: \n" +
                    "1. Añadir un producto a tu carrito. \n" +
                    "2. Pasar por caja \n" +
                    "3. Mostrar tu carrito \n" +
                    "0. Salir \n");
            int primeraEleccion = scanner.nextInt();
            scanner.nextLine();
            if(primeraEleccion == 1) {
                while (true) {
                    //Miramos si se pueden añadir productos o ya esta lleno
                    if (supermercado.carrito.size() > 99) {
                        System.out.println("Tu carro esta lleno! \n");
                        break;
                    } else {
                        System.out.println("Que tipo de producto quieres añadir? \n" +
                                "1. Alimentacion \n" +
                                "2. Textil \n" +
                                "3. Electronica \n" +
                                "0. Volver al menu principal \n"
                        );
                        int productoEleccion = scanner.nextInt();
                       //Añadir alimentos
                        if (productoEleccion == 1) {
                            System.out.println("Introduce: Precio, nombre, codigo de barras, fecha de caducidad formato (AÑO MES DIA ) todo separado por \"Enters\"");
                            float precio = scanner.nextInt();
                            scanner.nextLine();
                            String nombre = scanner.nextLine();
                            int codigoDeBarras = scanner.nextInt();
                            scanner.nextLine();
                            int anio = scanner.nextInt();
                            scanner.nextLine();
                            int mes = scanner.nextInt();
                            scanner.nextLine();
                            int dia = scanner.nextInt();
                            scanner.nextLine();
                            supermercado.carritoAlimentos.add(new ProductoAlimentacion(precio, nombre, codigoDeBarras, anio, mes, dia));
                            for (int i = 0; i < supermercado.carritoAlimentos.size(); i++) {
                                if (supermercado.carritoAlimentos.get(i).getCodigoDeBarras() == codigoDeBarras) {
                                    supermercado.carritoAlimentos.get(i).setPrecio(precio - precio * (1 / (supermercado.carritoAlimentos.get(i).getDiasParaCaducar() + 1) + (precio * 0.1f)));
                                    supermercado.carrito.add(supermercado.carritoAlimentos.get(i));
                                    System.out.println(supermercado.carritoAlimentos.get(i).getPrecio());
                                    break;
                                }
                            }
                        } //Añadir Textil
                        else if (productoEleccion == 2) {
                            System.out.println("Introduce: Precio, nombre, codigo de barras, tipo de producto textil , todo separado por \"Enters\"");
                            float precio = scanner.nextInt();
                            scanner.nextLine();
                            String nombre = scanner.nextLine();
                            int codigoDeBarras = scanner.nextInt();
                            scanner.nextLine();
                            String tipoTexil = scanner.nextLine();
                            supermercado.carritoTextil.add(new ProductoTextil(precio, nombre, codigoDeBarras, tipoTexil));
                            for (int i = 0; i < supermercado.carritoTextil.size(); i++) {
                                if (supermercado.carritoTextil.get(i).getCodigoDeBarras() == codigoDeBarras) {
                                    supermercado.carrito.add(supermercado.carritoTextil.get(i));
                                    break;
                                }
                            }
                        } //Añadir Informatica
                        else if (productoEleccion == 3) {
                            System.out.println("Introduce: Precio, nombre, codigo de barras, Años de garantia, todo separado por \"Enters\"");
                            float precio = scanner.nextInt();
                            scanner.nextLine();
                            String nombre = scanner.nextLine();
                            int codigoDeBarras = scanner.nextInt();
                            scanner.nextLine();
                            int anio = scanner.nextInt(); scanner.nextLine();
                            anio = anio * 365;
                            supermercado.carritoInformatica.add(new ProductoInformatica(precio, nombre, codigoDeBarras, anio));
                            for (int i = 0; i < supermercado.carritoInformatica.size(); i++) {
                                if (supermercado.carritoInformatica.get(i).getCodigoDeBarras() == codigoDeBarras) {
                                    supermercado.carritoInformatica.get(i).setPrecio(precio + precio * (1 / (supermercado.carritoInformatica.get(i).getGarantia() / 365 + (precio * 0.1f))));
                                    supermercado.carrito.add(supermercado.carritoInformatica.get(i));
                                    break;
                                }
                            }
                        }//Salir del menu de añadir Productos
                        else if (productoEleccion == 0) {
                            break;
                        } else {
                            System.out.println("No es una opcion valida selleciona otra \n");
                        }
                    }
                }
            }//Comprobar si esta vacío el carro y "pasamos por caja"
            else if(primeraEleccion == 2){
                if (supermercado.carrito.size()==0){
                    System.out.println("Tu cesta esta vacía \n");
                }
                else {
                    supermercado.pasarPorCaja();
                }

            }
            //Comprobar si esta vacío el carro y "revisamos el carro"
            else if(primeraEleccion == 3){
                if (supermercado.carrito.size()==0){
                    System.out.println("Tu cesta esta vacía \n");
                }
                else {
                    supermercado.mostrarCarroDeLaCompra();
                    System.out.println("Producto : Unidades");
                    System.out.println(supermercado.map_CarritoParaMostrar);
                }
            }//Salimos del codigo
            else if(primeraEleccion == 0){
                break;
            }
            else{
                System.out.println("No es una opcion valida selleciona otra \n");
            }
        }
    }


}
