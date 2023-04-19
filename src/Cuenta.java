import java.util.ArrayList;
import java.util.List;
  
public class Cuenta {
    private double saldo;
    private Usuario usuario;
    private List<Gasto> gastos;
    private List<Ingreso> ingresos;

    public Cuenta(Usuario usuario) {
        this.saldo = 0;
        this.usuario = usuario;
        this.gastos = new ArrayList<>();
        this.ingresos = new ArrayList<>();
    }
    
	public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
    	this.saldo = saldo;
    }
    
	public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
    	this.usuario = usuario;
    }
  
    public double addIngresos(String descripcion, double cantidad) {
        Ingreso ingreso = new Ingreso(cantidad, descripcion);
        ingresos.add(ingreso);
        saldo += ingreso.dinero;
        return saldo;
    }

    public double addGastos(String descripcion, double cantidad) throws GastoException {
        Gasto gasto = new Gasto(cantidad, descripcion);
        if (gasto.dinero > saldo) {
            throw new GastoException();
        } else {
            gastos.add(gasto);
            saldo -= gasto.dinero;
            return saldo;
        }
    }

    public List<Ingreso> getIngresos() {
        return ingresos;
    }
    
    public List<Gasto> getGastos() {
        return gastos;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "usuario=" + usuario +
                ", saldo=" + saldo +
                '}';
    }
}
