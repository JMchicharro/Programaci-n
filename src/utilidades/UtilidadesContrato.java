package utilidades;

import modelos.Contrato;
import modelos.TipoContrato;
import modelos.Empleado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class UtilidadesContrato {

    //1A
    public Map<TipoContrato, Double>
    getSalarioMedioTipoContrato(List<Contrato> contratos){

        return Map.of();
    }

    //1B
    public static Map<TipoContrato, Integer>
    getNumContratosPorTipo(List<Contrato> contratos){

        Map<TipoContrato, Integer> mapaSolucion = new HashMap<>();

        for (Contrato c : contratos) {

            if (mapaSolucion.containsKey(c.getTipoContrato())){
                Integer numFolios = mapaSolucion.get(c.getTipoContrato());

                mapaSolucion.put(c.getTipoContrato(), numFolios +1);

            }else{
                mapaSolucion.put(c.getTipoContrato(), 1);
            }
        }
        return mapaSolucion;
    }

    //1C
    public static Map<TipoContrato, List<Contrato>>
    getListContratosPorTipo(List<Contrato> contratos){
        Map<TipoContrato, List<Contrato>> mapaSolucion1C = new HashMap<>();

        for (Contrato c : contratos) {
            if (mapaSolucion1C.containsKey(c.getTipoContrato())){
                mapaSolucion1C.get(c.getTipoContrato()).add(c);

            }else{
                mapaSolucion1C.put(c.getTipoContrato(), List.of(c));
            }
        }
        return mapaSolucion1C;
    }
}
