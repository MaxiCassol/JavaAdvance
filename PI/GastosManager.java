package PI;
import java.util.List;

interface GastosManager {
    void agregarGasto(double cantidad, String categoria);
    void eliminarGasto(int id);
    List<Gasto> listarGastos();
    List<Gasto> filtrarGastos(FiltroGasto filtro);
}
