package PI;

import java.util.ArrayList;
import java.util.List;

public class GastosManagerImpl implements GastosManager {
    private List<Gasto> gastos = new ArrayList<>();

    @Override
    public void agregarGasto(double cantidad, String categoria) {
        Gasto gasto = new Gasto(cantidad, categoria);
        gastos.add(gasto);
    }

    @Override
    public void eliminarGasto(int id) {
        gastos.removeIf(gasto -> gasto.getId() == id);
    }

    @Override
    public List<Gasto> listarGastos() {
        return new ArrayList<>(gastos);
    }

    @Override
    public List<Gasto> filtrarGastos(FiltroGasto filtro) {
        List<Gasto> gastosFiltrados = new ArrayList<>();
        for (Gasto gasto : gastos) {
            if (filtro.cumpleFiltro(gasto)) {
                gastosFiltrados.add(gasto);
            }
        }
        return gastosFiltrados;
    }
}
