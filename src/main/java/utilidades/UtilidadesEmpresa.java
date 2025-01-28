package utilidades;

import modelos.Empresa;
import modelos.Empleado;
import modelos.TipoContrato;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.List;

public class UtilidadesEmpresa {

    //A
    public List<Empleado> getEmpleadosPorContrato(Empresa empresa, TipoContrato tipoContrato) {
        List<Empleado> empleadosPorContrato = new ArrayList<>();

        for (Empleado empleado : empresa.getEmpleado()) {
            if (tipoContrato == empleado.getContrato().getTipoContrato()) {
                empleadosPorContrato.add(empleado);
            }
        }
        return empleadosPorContrato;
    }


    //B
    public List<Empleado> getMileuristasOrdenadosPorSalario(Empresa empresa) {
        List<Empleado> mileuristas = new ArrayList<>();

        for (Empleado empleado : empresa.getEmpleado()) {
            if (empleado.getContrato().getSalarioBase() >= 1000)
                mileuristas.add(empleado);
        }

        //Comparator.comparing(Empleado::getContrato)
        //Comparator.comparing(e-> e.getContrato().getSalarioBase())
        mileuristas.sort(Comparator.comparing(salarios -> salarios.getContrato().getSalarioBase()));

        return mileuristas;
    }


    //C
    public double fondoSalarialEmpresa(Empresa empresa) {
        double salariototal = 0;

        for (Empleado empleado : empresa.getEmpleado()) {
            double salario = empleado.getContrato().getSalarioBase();
            salariototal += salario;
        }
        return salariototal;
    }


    //D
    public Empleado getMejorPagado(List<Empresa> empresas) {
        List<Empleado> empleados = new ArrayList<>();

        for (Empresa empresa : empresas) {
            for (Empleado empleado : empresa.getEmpleado()) {
                empleados.add(empleado);
            }
        }
        empleados.sort(Comparator.comparing(salarios -> salarios.getContrato().getSalarioBase()));
        return empleados.get(0);
    }
}
