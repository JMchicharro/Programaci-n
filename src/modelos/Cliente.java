package modelos;

import java.util.Objects;

public class Cliente extends Persona {

    private TipoCliente tipoCliente;


    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Cliente() {
    }

    public Cliente(Integer identificador, String dni, String nombre, String apellidos, String direccion, TipoCliente tipoCliente) {
        super(identificador, dni, nombre, apellidos, direccion);
        this.tipoCliente = tipoCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cliente cliente = (Cliente) o;
        return tipoCliente == cliente.tipoCliente;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tipoCliente);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                super.toString() +
                "tipoCliente=" + tipoCliente +
                '}';
    }
}
