package utilidades;

import modelos.Empresa;
import modelos.Empleado;
import modelos.TipoContrato;
import modelos.TipoEmpresa;


import java.util.*;

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

    //3A
    public static Map<TipoEmpresa, Integer>
    getNumEmpresasPorTipo(List<Empresa> empresas){
        Map<TipoEmpresa, Integer> numEmpresas = new HashMap<>();

        for (Empresa empresa : empresas) {
            TipoEmpresa tipo = empresa.getTipoEmpresa();

            numEmpresas.put(tipo, numEmpresas.getOrDefault(tipo, 0) + 1);
        }
        return numEmpresas;
    }

    //3B
    public static Map<TipoEmpresa,Integer>
    getNumEmpleadosPorTipoEmpresa(List<Empresa> empresas){
        Map<TipoEmpresa, Integer> mapaNumEmpleados = new HashMap<>();

        for (Empresa empresa : empresas) {
            TipoEmpresa tipo = empresa.getTipoEmpresa();
            int numEmpleados = empresa.getEmpleado().size();

            mapaNumEmpleados.put(tipo, mapaNumEmpleados.getOrDefault(tipo, 0) + numEmpleados);

        }
        return mapaNumEmpleados;
    }

    //3C
    public static Map<TipoContrato, List<Empleado>>
    getEmpleadosPorTipoContrato(Empresa empresas){
        Map<TipoContrato, List<Empleado>> mapaTipoContrato  = new HashMap<>();

        for (Empleado e : empresas.getEmpleado()) {
            TipoContrato tipoContrato = e.getContrato().getTipoContrato();

            if (!mapaTipoContrato.containsKey(tipoContrato)) {
                mapaTipoContrato.put(tipoContrato, new ArrayList<>());
            }
            mapaTipoContrato.get(tipoContrato).add(e);
        }

        return mapaTipoContrato;
    }

    //3D
    public static Map<Empresa, Map<TipoContrato, List<Empleado>>>
    getEmpleadosPorTipoContrato(List<Empresa> empresas){
        Map<Empresa, Map<TipoContrato, List<Empleado>>> mapaEmpresas = new HashMap<>();

        for (Empresa empresa : empresas) {
            Map<TipoContrato, List<Empleado>> mapaTipoContrato = new HashMap<>();

            for (Empleado e : empresa.getEmpleado()) {
                TipoContrato tipoContrato = e.getContrato().getTipoContrato();

                if (!mapaTipoContrato.containsKey(tipoContrato)) {
                    mapaTipoContrato.put(tipoContrato, new ArrayList<>());
                }
                mapaTipoContrato.get(tipoContrato).add(e);
            }
            mapaEmpresas.put(empresa, mapaTipoContrato);
        }
        return mapaEmpresas;
    }
}
