package interfaces.Producto;
@FunctionalInterface
interface Filtrable {
    abstract boolean cumpleFiltro(Producto producto);
}
