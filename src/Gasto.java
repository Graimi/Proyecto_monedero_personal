
public class Gasto extends Dinero {

    public Gasto(double gasto, String description) {
        super(gasto, description);
    }

    @Override
    public String toString() {
        return "Gasto{" +
                "cantidad=" + dinero +
                ", descripcion='" + description + '\'' +
                '}';
    }
}