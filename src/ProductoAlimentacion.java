import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class ProductoAlimentacion extends Producto{
    private long diasParaCaducar;

    public long getDiasParaCaducar() {
        return diasParaCaducar;
    }

    public void setDiasParaCaducar(long diasParaCaducar) {
        this.diasParaCaducar = diasParaCaducar;
    }

    public ProductoAlimentacion(float precio, String nombre, int codigoDeBarras, int anio, int mes, int dia) {
        super(precio, nombre, codigoDeBarras);
        Month month=null;
        switch (mes){
            case 1: month=Month.JANUARY;
                break;
            case 2: month=Month.FEBRUARY;
                break;
            case 3: month=Month.MARCH;
                break;
            case 4: month=Month.APRIL;
                break;
            case 5: month=Month.MAY;
                break;
            case 6: month=Month.JUNE;
                break;
            case 7: month=Month.JULY;
                break;
            case 8: month=Month.AUGUST;
                break;
            case 9: month=Month.SEPTEMBER;
                break;
            case 10: month=Month.OCTOBER;
                break;
            case 11: month=Month.NOVEMBER;
                break;
            case 12: month=Month.DECEMBER;
                break;
        }
        //24-May-2017, change this to your desired Start Date
        LocalDate dateCaduca = LocalDate.of(anio, month, dia);
        //29-July-2017, change this to your desired End Date
        LocalDate dateToday = LocalDate.now();
        long noOfDaysBetween = ChronoUnit.DAYS.between(dateToday, dateCaduca);
        this.diasParaCaducar=noOfDaysBetween;


    }

    @Override
    public String toString() {
        return super.toString() +
                "ProductoAlimentacion{" +
                "diasParaCaducar=" + diasParaCaducar +
                '}';
    }
}
