
public class Ingreso extends Dinero {

    public Ingreso(double ingreso, String description) {
        super(ingreso, description);
    }

    @Override
    public String toString() {
        return "Ingreso{" +
                "cantidad=" + dinero +
                ", descripcion='" + description + '\'' +
                '}';
    }
}