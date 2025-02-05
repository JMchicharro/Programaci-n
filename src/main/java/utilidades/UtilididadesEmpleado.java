package utilidades;

import modelos.Empleado;
import modelos.Empresa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilididadesEmpleado {

    //2A
    public static Map<String, List<Empleado>>
    getEmpleadosPorLetraDNI(List<Empleado> empleados){
        Map<String, List<Empleado>> mapaDNI = new HashMap<>();

        for (Empleado e : empleados) {
            String dni = e.getDni();

            for (char letra : dni.toCharArray()) {
                String letraDNI = String.valueOf(letra);

                if (!mapaDNI.containsKey(letraDNI)) {
                    mapaDNI.put(letraDNI, new ArrayList<>());
                }
                mapaDNI.get(letraDNI).add(e);
            }
        }
        return mapaDNI;
    }

    //2B
    public Map<Empresa, List<Empleado>>
    getEmpleadosPorEmpresa(List<Empleado> empleados){
        Map<Empresa, List<Empleado>> mapaEmpresa = new HashMap<>();

        for (Empleado e : empleados) {
            Empresa empresa = e.getEmpresa();

            if (!mapaEmpresa.containsKey(empresa)) {
                mapaEmpresa.put(empresa, new ArrayList<>());
            }
            mapaEmpresa.get(empresa).add(e);
        }

        return mapaEmpresa;
    }
}
