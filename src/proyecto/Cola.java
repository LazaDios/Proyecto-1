package proyecto;
import javax.swing.JOptionPane;


public class Cola {
    
    int contador=0;
    int[] ultimonodo = new int[3];
    private Nodo inicioCola, finalCola;
    String Cola = "";
    
   
    public Cola() {
        inicioCola = null;
        finalCola = null;

    }

    
    public boolean ColaVacia() {
        if(inicioCola == null) {
            return true;
        } else {
            return false;
        }

    }

    public void Insertar(int dia , int minuto_inicio , int minuto_fin) {
        Nodo nuevo_nodo = new Nodo();
        nuevo_nodo.dia = dia;
        nuevo_nodo.minuto_inicio = minuto_inicio;
        nuevo_nodo.minuto_fin = minuto_fin;
        nuevo_nodo.siguiente = null;

        if (ColaVacia()) {
            inicioCola = nuevo_nodo;
            finalCola = nuevo_nodo;
        } else {
            finalCola.siguiente = nuevo_nodo;
            finalCola = nuevo_nodo;
        }

    }
    
    public void Insertar2(int pulsacionesgeneradas) {
        contador++;
        Nodo nuevo_nodo = new Nodo();
        nuevo_nodo.pulsaciones_generadas = pulsacionesgeneradas;
        nuevo_nodo.siguiente = null;

        if (ColaVacia()) {
            inicioCola = nuevo_nodo;
            finalCola = nuevo_nodo;
        } else {
            finalCola.siguiente = nuevo_nodo;
            finalCola = nuevo_nodo;
        }

    }
    public void Insertar3(int dia_inicio,int dia_fin) {
        Nodo nuevo_nodo = new Nodo();
        nuevo_nodo.dia_inicio = dia_inicio;
        nuevo_nodo.dia_fin = dia_fin;
        nuevo_nodo.siguiente = null;

        if (ColaVacia()) {
            inicioCola = nuevo_nodo;
            finalCola = nuevo_nodo;
        } else {
            finalCola.siguiente = nuevo_nodo;
            finalCola = nuevo_nodo;
        }

    }
    public void Insertar4(int minutoinicio,int minutofin,int valor) {
        contador++;
        Nodo nuevo_nodo = new Nodo();
        nuevo_nodo.minuto_inicio_sueno = minutoinicio;
        nuevo_nodo.minuto_fin_sueno = minutofin;
        nuevo_nodo.tipo_sueno = valor;
        ultimonodo[0]=minutoinicio;
        ultimonodo[1]=minutofin;
        ultimonodo[2]=valor;
        nuevo_nodo.siguiente = null;

        if (ColaVacia()) {
            inicioCola = nuevo_nodo;
            finalCola = nuevo_nodo;
        } else {
            finalCola.siguiente = nuevo_nodo;
            finalCola = nuevo_nodo;
        }

    }
    
    public void Insertar5(int diainicio2,int diafin2) {
        Nodo nuevo_nodo = new Nodo();
        nuevo_nodo.dia_inicio_pasos= diainicio2;
        nuevo_nodo.dia_fin_pasos= diafin2;
       
        nuevo_nodo.siguiente = null;

        if (ColaVacia()) {
            inicioCola = nuevo_nodo;
            finalCola = nuevo_nodo;
        } else {
            finalCola.siguiente = nuevo_nodo;
            finalCola = nuevo_nodo;
        }

    }
    public void Insertar6(int pasos) {
        Nodo nuevo_nodo = new Nodo();
        nuevo_nodo.cantidad_pasos= pasos;
        nuevo_nodo.siguiente = null;

        if (ColaVacia()) {
            inicioCola = nuevo_nodo;
            finalCola = nuevo_nodo;
        } else {
            finalCola.siguiente = nuevo_nodo;
            finalCola = nuevo_nodo;
        }

    }
    
    public int TamanoCola(){
        return contador;    
    }
    
    public int[] UltimoValorIngresado(){
        return ultimonodo;
    
    }
     public int Extraer() {
        
        if (!ColaVacia()) {
            int pulsacionesgeneradas = inicioCola.pulsaciones_generadas;
            

            if (inicioCola == finalCola) {
                inicioCola = null;
                finalCola = null;

            } else {
                inicioCola = inicioCola.siguiente;

            }
            return pulsacionesgeneradas;

        } else {
            return Integer.MAX_VALUE;
        }

    }
public int[] Extraer2() {
        contador--;
        int[] valores = new int[3];
        if (!ColaVacia()) {
           
            valores[0]=inicioCola.minuto_inicio_sueno;
            valores[1]=inicioCola.minuto_fin_sueno;
            valores[2]=inicioCola.tipo_sueno;

            if (inicioCola == finalCola) {
                inicioCola = null;
                finalCola = null;

            } else {
                inicioCola = inicioCola.siguiente;

            }
            return valores;

        } else {
            return valores;
        }

    }
public int[] Extraer3() {
        
        int[] valores2 = new int[2];
        if (!ColaVacia()) {
           
            valores2[0]=inicioCola.dia_inicio;
            valores2[1]=inicioCola.dia_fin;
            

            if (inicioCola == finalCola) {
                inicioCola = null;
                finalCola = null;

            } else {
                inicioCola = inicioCola.siguiente;

            }
            return valores2;

        } else {
            return valores2;
        }

    }
    public void MostrarContenido() {
        Nodo recorrido = inicioCola;
        String ColaInvertida = "";
        
        while (recorrido != null) {
            Cola += recorrido.dia + " ";
            Cola += recorrido.minuto_inicio + " ";
            Cola += recorrido.minuto_fin + " ";
            
            recorrido = recorrido.siguiente;

        }

        String cadena[] = Cola.split(" ");

        for (int i = cadena.length - 1; i >= 0; i--) {
            ColaInvertida += " " + cadena[i];
        }

        JOptionPane.showMessageDialog(null, ColaInvertida);
        Cola = "";

    }
    
       public void MostrarContenido2() {
        Nodo recorrido = inicioCola;
        String ColaInvertida = "";

        while (recorrido != null) {
            Cola += recorrido.pulsaciones_generadas + " ";
            recorrido = recorrido.siguiente;

        }

        String cadena[] = Cola.split(" ");

        for (int i = cadena.length - 1; i >= 0; i--) {
            ColaInvertida += " " + cadena[i];

        }

        JOptionPane.showMessageDialog(null, ColaInvertida);
        Cola = "";

    }
       public void MostrarContenido3() {
        Nodo recorrido = inicioCola;
        String ColaInvertida = "";

        while (recorrido != null) {
            Cola += recorrido.dia_inicio + " ";
            Cola += recorrido.dia_fin + " ";
            recorrido = recorrido.siguiente;

        }

        String cadena[] = Cola.split(" ");

        for (int i = cadena.length - 1; i >= 0; i--) {
            ColaInvertida += " " + cadena[i];

        }

        JOptionPane.showMessageDialog(null, ColaInvertida);
        Cola = "";

    }
       
       public void MostrarContenido4() {
        Nodo recorrido = inicioCola;
        String ColaInvertida = "";

        while (recorrido != null) {
            Cola += recorrido.minuto_inicio_sueno + " ";
            Cola += recorrido.minuto_fin_sueno + " ";
            Cola += recorrido.tipo_sueno + " ";
            recorrido = recorrido.siguiente;

        }

        String cadena[] = Cola.split(" ");

        for (int i = cadena.length - 1; i >= 0; i--) {
            ColaInvertida += " " + cadena[i];

        }

        JOptionPane.showMessageDialog(null, ColaInvertida);
        Cola = "";

    }
    
    public void MostrarContenido5() {
        Nodo recorrido = inicioCola;
        String ColaInvertida = "";

        while (recorrido != null) {
            Cola += recorrido.dia_inicio_pasos+ " ";
            Cola += recorrido.dia_fin_pasos+ " ";
            recorrido = recorrido.siguiente;

        }

        String cadena[] = Cola.split(" ");

        for (int i = cadena.length - 1; i >= 0; i--) {
            ColaInvertida += " " + cadena[i];

        }

        JOptionPane.showMessageDialog(null, ColaInvertida);
        Cola = "";

    }
     public void MostrarContenido6() {
        Nodo recorrido = inicioCola;
        String ColaInvertida = "";

        while (recorrido != null) {
            Cola += recorrido.cantidad_pasos+ " ";
            recorrido = recorrido.siguiente;

        }

        String cadena[] = Cola.split(" ");

        for (int i = cadena.length - 1; i >= 0; i--) {
            ColaInvertida += " " + cadena[i];
            

        }

        JOptionPane.showMessageDialog(null, ColaInvertida);
        Cola = "";

    }
    
    
}
