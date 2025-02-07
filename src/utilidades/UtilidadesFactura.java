package utilidades;


import modelos.Factura;
import modelos.LineaFactura;

import java.time.LocalDate;
import java.util.List;

public class UtilidadesFactura {

    /**
     * Que devuelve true si la fecha de vencimiento de la factura que
     * se le pasa es mayor o igual que la fecha actual y false en caso
     * contrario.
     *
     * @param factura
     * @return
     */
    public static boolean esFacturaVencida(Factura factura){

        //REFERENCIA
        LocalDate fechaVencimiento = factura.getFechaVencimiento();

        //FECHA ACTUAL
        LocalDate fechaActual = LocalDate.now();

        //fecha1  == fecha2 -> equals()
        //fecha1  > fecha2 -> isAfter()
        //fecha1 < fecha2 -> isBefore()

        // or -> ||
        // and -> &&


        //TRUE si fechaVencimiento >= fechaActual
        if(fechaVencimiento.isAfter(fechaActual) || fechaVencimiento.equals(fechaActual)){
            return true;
        }
        //FALSE SINO
        else{
            return false;
        }

    }

    public static boolean esFacturaVencida2(Factura factura){
        return factura.getFechaVencimiento().isAfter(LocalDate.now())
                ||
                factura.getFechaVencimiento().equals(LocalDate.now());
    }

    public static double calcularBaseFactura(Factura factura){

        List<LineaFactura> lineas = factura.getLineaFacturas();

        Double total = 0.0;

        for(LineaFactura lineaFactura: lineas){
            //CANTIDAD * PRECIO
            Integer cantidad = lineaFactura.getCantidad();
            Double precio = lineaFactura.getProducto().getPrecio();
            Double totalLinea = cantidad * precio;
            total += totalLinea;

        }
        return total;
    }



    public static Double calcularTotalAPagar(Factura factura){

        Double total = (factura.getImporteBase() - factura.getDescuento()) * factura.getIva();
        return total;
    }
}
