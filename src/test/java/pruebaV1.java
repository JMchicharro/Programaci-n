import modelos.Almacen;
import modelos.Producto;
import modelos.Factura;
import modelos.LineaFactura;
import utilidades.UtilidadesFactura;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class pruebaV1 {
    public static void main(String[] args) {

        Almacen almacen = new Almacen();
        almacen.setNombre("Almacen 1");

        System.out.println(almacen);

        Factura facturaDeLasCopasDeAyer = new Factura();
        facturaDeLasCopasDeAyer.setFechaVencimiento(LocalDate.now().plusDays(1));

        Producto producto1 = new Producto();
        producto1.setDescripcion("CERVEZAS");
        producto1.setPrecio(1.0);

        LineaFactura lineaFactura1 = new LineaFactura();
        lineaFactura1.setProducto(producto1);
        lineaFactura1.setCantidad(15);

        Producto producto2 = new Producto();
        producto2.setDescripcion("MONTADITOS");
        producto2.setPrecio(2.50);

        LineaFactura lineaFactura2 = new LineaFactura();
        lineaFactura2.setProducto(producto2);
        lineaFactura2.setCantidad(4);

        List<LineaFactura> lineaFacturaList = new ArrayList<>();
        lineaFacturaList.add(lineaFactura1);
        lineaFacturaList.add(lineaFactura2);
        facturaDeLasCopasDeAyer.setLineaFacturas(lineaFacturaList);


        facturaDeLasCopasDeAyer.setImporteBase(40.0);
        facturaDeLasCopasDeAyer.setDescuento(10.0);
        facturaDeLasCopasDeAyer.setIva(1.21);




        //FACTURA VENCIDA
        System.out.println(UtilidadesFactura.esFacturaVencida(facturaDeLasCopasDeAyer));

        //CALCULAR TOTAL
        System.out.println("USTED TIENE QUE PAGAR->"
                +UtilidadesFactura.calcularBaseFactura(facturaDeLasCopasDeAyer) + " €");


        //IMPORTE TOTAL CON DESCUENTO
        System.out.println("EL TOTAL DE SU FACTURA->" + UtilidadesFactura.calcularTotalAPagar(facturaDeLasCopasDeAyer));


    }
}