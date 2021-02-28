package proyecto;

import javax.swing.JOptionPane;


public class Pila {
    private Nodopila UltimoValorIngresado;
    int tamano = 0;
    String Lista = "";
    
    
    public Pila(){
        UltimoValorIngresado = null;
        tamano = 0;
       
    }
    
    
    public boolean PilaVacia(){
        return UltimoValorIngresado == null;
    
    }
    
    public void InsertarNodo(int BMP){
        Nodopila nuevo_nodo = new Nodopila (BMP);
        nuevo_nodo.siguiente = UltimoValorIngresado;
        UltimoValorIngresado = nuevo_nodo;
        tamano++;
        
    
    }
    
    public int EliminarNodo(){
        int auxiliar = UltimoValorIngresado.BMP;
        UltimoValorIngresado = UltimoValorIngresado.siguiente;
        tamano--;
        return auxiliar;
        
    }
    
    public int MostrarUltimoValorIngresado(){
        return UltimoValorIngresado.BMP;
    
    
    }
    
    public int TamanoPila(){
        return tamano;
    
    }
    
    public void VaciarPila(){
        while(!PilaVacia()){
            EliminarNodo();
        
        }
     
    }
    
    public  void MostrarValores(){
        Nodopila recorrido = UltimoValorIngresado;
        
        while(recorrido != null){
            Lista += recorrido.BMP + "\n";
            recorrido = recorrido.siguiente;
        
        }
        
        JOptionPane.showMessageDialog(null, Lista);
        Lista = "";
        
    }
    
    
}
