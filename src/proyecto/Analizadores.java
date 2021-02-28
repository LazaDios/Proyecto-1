package proyecto;

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.util.regex.*;


public class Analizadores {
   
    
    final int NUMERAL = 3000000; 
    Cola BMP_dia_mininicio_minfin = new Cola();
    Cola BMP_generado = new Cola();
    Cola SUENOdia = new Cola();
    Cola SUENOtipo = new Cola();
    Cola PASOSdia = new Cola();
    Cola PASOSdados = new Cola();
    
    public void LeerTXT(String nombreArchivo){
        ArrayList<String> cada_linea_txt;
        ArrayList<Integer> valores_BMP_sueño_pasos;
        String linea;
        boolean bandera = true;
        int contador;
        int cada_numeral = 9;
        int apuntador = 0;
        int iterador = 0;
        int tamano;
        Matcher encuentrador;
        
        File archivos;
        FileReader fr;
        BufferedReader br;

        cada_linea_txt = new ArrayList<>();
        valores_BMP_sueño_pasos = new ArrayList<>();
        
        try {
            archivos = new File(nombreArchivo);
            fr = new FileReader(archivos);
            br = new BufferedReader(fr);

           //Bucle para leer y guardar linea por linea la informacion encontrada en el archivo Data.txt
            while ((linea = br.readLine()) != null) {
                cada_linea_txt.add(linea);
            }
            // Bucle para sustituir # por 3000000   
            for (int i = 0; i < cada_linea_txt.size() - 2; i++) {

                if (i == cada_numeral) {
                    cada_linea_txt.set(i, "3000000");
                    cada_numeral = cada_numeral + 10;

                }
            }
            
            //Bucle para convertir los datos que estan en string a int
            for (int j = 0; j < cada_linea_txt.size(); j++) {
                if (j == 1 || j == 2) {
                    encuentrador = Pattern.compile("\\d+").matcher((String) cada_linea_txt.get(j));
                    while (encuentrador.find()) {
                        valores_BMP_sueño_pasos.add(Integer.parseInt(encuentrador.group()));
                    }
                }
                
                if ("3000000".equals(cada_linea_txt.get(j))) {
                    contador = j + 4;
                    do {
                        encuentrador = Pattern.compile("\\d+").matcher((String) cada_linea_txt.get(j));
                        while (encuentrador.find()) {
                            valores_BMP_sueño_pasos.add(Integer.parseInt(encuentrador.group()));
                        }
                        j = j + 1;
                    } while (contador != j);

                }

            }
            //Bucle para guardar los BMP generados en una cola
            for (int k = 3; k < valores_BMP_sueño_pasos.size(); k++) {
                int contenido2 = valores_BMP_sueño_pasos.get(k);
                if (contenido2 != NUMERAL) {
                    BMP_generado.Insertar2(valores_BMP_sueño_pasos.get(k));
                } else {
                    k = k + 3;
     
                }
            }
            //Bucle para guardar el dia-minuto inicio-minuto fin en una cola
            for (int l = 0; l < valores_BMP_sueño_pasos.size(); l++) {
                if (l == 0) {

                    BMP_dia_mininicio_minfin.Insertar(valores_BMP_sueño_pasos.get(0), valores_BMP_sueño_pasos.get(1), valores_BMP_sueño_pasos.get(2));
                }

                int contenido3 = valores_BMP_sueño_pasos.get(l);

                if (contenido3 == NUMERAL) {

                    BMP_dia_mininicio_minfin.Insertar(valores_BMP_sueño_pasos.get(l + 1), valores_BMP_sueño_pasos.get(l + 2), valores_BMP_sueño_pasos.get(l + 3));

                }

            }
            
            cada_numeral=9;
            
//----------------------------------------------------------------------------------------------------------------------------------- 
            //Se limpian los dos array para volverse a utilizar
            cada_linea_txt.clear();
            valores_BMP_sueño_pasos.clear();
            //Se vuelve a leer el txt para ahora obtener los datos de los sueños
            archivos = new File(nombreArchivo);
            fr = new FileReader(archivos);
            br = new BufferedReader(fr);
            
            while ((linea = br.readLine()) != null) {
                cada_linea_txt.add(linea);
            }

         
            for (int m = 0; m < cada_linea_txt.size() - 2; m++) {

                if (m == cada_numeral) {
                    cada_linea_txt.set(m, "3000000");
                    cada_numeral = cada_numeral + 10;

                }
            }
            
            //Bucle while para eliminar los datos de BMP puesto que ya fueron guardaos en cola
            //y elimino los datos de los pasos puesto que aqui solo interesa leer los datos de los sueños
            tamano = cada_linea_txt.size();
            while (iterador != tamano) {
                iterador++;
                if (apuntador >= cada_linea_txt.size() - 2) {
                    iterador = tamano;
                } else {
                    if (bandera == true) {
                        for (int t = 0; t < 4; t++) {
                            cada_linea_txt.remove(apuntador);
                        }
                        apuntador = apuntador + 2;

                        tamano = tamano - 4;

                    }
                    bandera = false;
                    if (bandera == false) {
                        for (int t = 0; t < 3; t++) {
                            cada_linea_txt.remove(apuntador);
                        }
                        apuntador = apuntador + 1;
                        tamano = tamano - 3;
                        bandera = true;
                    }
                    

                }
            }
            
            //Bucle para convertir los datos que estan en string a int
            for (int n = 0; n < 2; n++) {
                if (n == 0 || n == 1) {
                    encuentrador = Pattern.compile("\\d+").matcher((String) cada_linea_txt.get(n));
                    while (encuentrador.find()) {

                        valores_BMP_sueño_pasos.add(Integer.parseInt(encuentrador.group()));

                    }

                }

            }
            
            for (int o = 2; o < cada_linea_txt.size(); o++) {

                if ("3000000".equals(cada_linea_txt.get(o))) {

                    contador = o + 3;

                    do {

                        encuentrador = Pattern.compile("\\d+").matcher(cada_linea_txt.get(o));
                        while (encuentrador.find()) {

                            valores_BMP_sueño_pasos.add(Integer.parseInt(encuentrador.group()));

                        }

                        o = o + 1;

                    } while (o != contador);
                    o = o - 1;

                }

            }
            //Bucle para guardar los dias del sueño en una cola
            for (int p = 0; p < valores_BMP_sueño_pasos.size() - 2; p++) {
                if (p == 0) {

                    SUENOdia.Insertar3(valores_BMP_sueño_pasos.get(0), valores_BMP_sueño_pasos.get(1));
                }

                int contenido5 = valores_BMP_sueño_pasos.get(p);

                if (contenido5 == NUMERAL) {

                    SUENOdia.Insertar3(valores_BMP_sueño_pasos.get(p + 1), valores_BMP_sueño_pasos.get(p + 2));

                }

            }
            //Bucle para guardar cuada sueño en una cola
            for (int q = 2; q < valores_BMP_sueño_pasos.size() - 2; q++) {
                int contenido6 = valores_BMP_sueño_pasos.get(q);
                if (contenido6 != NUMERAL) {

                    SUENOtipo.Insertar4(valores_BMP_sueño_pasos.get(q), valores_BMP_sueño_pasos.get(q + 1), valores_BMP_sueño_pasos.get(q + 2));
                    q = q + 2;

                } else {
                    SUENOtipo.Insertar4(NUMERAL, NUMERAL, NUMERAL);
                    q = q + 2;

                }

            }

            cada_numeral=9;
//--------------------------------------------------------------------------------------------------------------------------------- 
            //Se limpian los dos array para volverse a utilizar
            cada_linea_txt.clear();
            valores_BMP_sueño_pasos.clear();
            //Se vuelve a leer el txt para ahora obtener los datos de los pasos
            archivos = new File(nombreArchivo);
            fr = new FileReader(archivos);
            br = new BufferedReader(fr);
         
            while ((linea = br.readLine()) != null) {
                cada_linea_txt.add(linea);
            }

            
            for (int r = 0; r < cada_linea_txt.size() - 2; r++) {

                if (r == cada_numeral) {
                    cada_linea_txt.set(r, "3000000");
                    cada_numeral = cada_numeral + 10;

                }

            }
            //Bucle para eliminar los datos de BMP y sueno puesto que ya fueron leidos y guardados
            apuntador = 0;
            bandera = true;
            iterador = 0;
            tamano = cada_linea_txt.size();
            while (iterador != tamano) {
                iterador++;
                if (apuntador >= cada_linea_txt.size() - 2) {
                    iterador = tamano;
                } else {
                    if (bandera == true) {
                        for (int t = 0; t < 7; t++) {
                            cada_linea_txt.remove(apuntador);
                        }
                        apuntador = apuntador + 3;

                        tamano = tamano - 7;

                    }
                    

                }
            }
            
            
            //Bucle para convertir los datos que estan en string a int
            for (int s = 0; s < cada_linea_txt.size(); s++) {
                if (s == 0 || s == 1) {
                    encuentrador = Pattern.compile("\\d+").matcher((String) cada_linea_txt.get(s));
                    while (encuentrador.find()) {

                        valores_BMP_sueño_pasos.add(Integer.parseInt(encuentrador.group()));

                    }
                }

                if ("3000000".equals(cada_linea_txt.get(s))) {
                    contador = s + 3;

                    do {
                        encuentrador = Pattern.compile("\\d+").matcher((String) cada_linea_txt.get(s));
                        while (encuentrador.find()) {

                            valores_BMP_sueño_pasos.add(Integer.parseInt(encuentrador.group()));

                        }
                        s = s + 1;

                    } while (contador != s);
                    s = s - 1;

                }

            }
            //Bucle para almacenar los dias de los pasos
            for (int t = 0; t < valores_BMP_sueño_pasos.size(); t++) {
                if (t == 0) {

                    PASOSdia.Insertar5(valores_BMP_sueño_pasos.get(0), valores_BMP_sueño_pasos.get(1));
                }

                int contenido7 = valores_BMP_sueño_pasos.get(t);

                if (contenido7 == NUMERAL) {

                    PASOSdia.Insertar5(valores_BMP_sueño_pasos.get(t + 1), valores_BMP_sueño_pasos.get(t + 2));

                }

            }
            //Bucle para almacenar los datos de los pasos dados
            for (int u = 2; u < valores_BMP_sueño_pasos.size(); u++) {

                int contenido8 = valores_BMP_sueño_pasos.get(u);
                if (contenido8 != NUMERAL) {
                    PASOSdados.Insertar6(valores_BMP_sueño_pasos.get(u));

                } else {
                    u = u + 2;

                    if (contenido8 == NUMERAL) {
                        PASOSdados.Insertar6(NUMERAL);
                    }

                }

            }
            //Se limpian los dos array para no ocupar espacio
            cada_linea_txt.clear();
            valores_BMP_sueño_pasos.clear();
            //Se cierra el archivo Data.txt
            br.close();
            fr.close();
          
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error en la lectura del archivo" + e);
        }
    
    
    }
    
    public void AnalizadorBMP(){
        Cola aux = new Cola();
        Pila auxiliar = new Pila();
        int tamano;
        int BMP;

        System.out.println("BMP");
        System.out.print("[");

        for (int l = 0; l < BMP_generado.TamanoCola(); l++) {

            BMP = BMP_generado.Extraer();
            if (BMP >= 100) {
                auxiliar.InsertarNodo(BMP);
                
            } else {
                
                aux.Insertar2(BMP);
            }
        }

        tamano = auxiliar.TamanoPila();
        for (int l = 0; l < tamano; l++) {
            BMP = auxiliar.EliminarNodo();

            System.out.print(BMP + ", ");

        }
        
        for (int l = 0; l < aux.TamanoCola(); l++) {
            BMP = aux.Extraer();
            if (l == aux.TamanoCola() - 1) {
                System.out.print(BMP);
            }
            if (l != aux.TamanoCola() - 1) {
                System.out.print(BMP + ", ");
            }
        }
        System.out.print("]");
        System.out.println();
        System.out.println();


    
    }
    
    
    public void AnalizadorSueño(){
       // Cola y arreglos auxiliares para ayudar a manejar los datos
       Cola cola_auxiliar= new Cola();
       int[] aux = new int[2];
       int[] aux2 = new int[2];
       int[] aux3 = new int[1];
       int[] aux4 = new int[2];
       
       //Variables para el tiempo de proceso de cada tipo de sueño
       int tiempo_proceso_tipo1 = 0;
       int tiempo_proceso_tipo2 = 0;
       int tiempo_proceso_tipo3 = 0;
       
       
       int tamano=SUENOtipo.TamanoCola();
       int tamano2=SUENOtipo.TamanoCola();
       
       int total_ligero=0;
       int total_pesado=0;
       int total_REM=0;
       int duracion_ultimo_registro_enviado=0;
       
       int otra_vuelta=4;
              
       System.out.println("SUENO");
       //Bucle para procesar 
       for(int l = 0; l < tamano + otra_vuelta; l++){
          
           if(cola_auxiliar.ColaVacia()){ 
               
               if (total_ligero != 0 && total_pesado != 0 && total_REM != 0) {

                   aux3 = SUENOdia.Extraer3();
                   System.out.print(aux3[0] + ", ");
                   System.out.print(total_ligero + total_pesado + total_REM + ", ");
                   System.out.print(total_ligero + ", ");
                   total_ligero = 0;
                   tiempo_proceso_tipo1 = 0;
                   System.out.print(total_pesado + ", ");
                   total_pesado = 0;
                   tiempo_proceso_tipo2 = 0;
                   System.out.print(total_REM + ", ");
                   total_REM = 0;
                   tiempo_proceso_tipo3 = 0;
                   System.out.print(duracion_ultimo_registro_enviado);
                   duracion_ultimo_registro_enviado = 0;
                   System.out.println();
               }
              
               //Bucle para extraer los datos antes de cada numeral y armacenarlos en la cola auxiliar para ser procesados
               for (int m = 0; m < tamano2; m++) {
                   aux2 = SUENOtipo.Extraer2();
                   
                   if (aux2[0] == 3000000) {
                       otra_vuelta = otra_vuelta + 2;
                   }
                   //Condicion para romper el bucle cuando extraiga todos los datos antes de cada numeral 
                   if (aux2[0] == 3000000 || SUENOtipo.ColaVacia()) {

                       m = tamano2 - 1;
                       
                       if (SUENOtipo.ColaVacia()) {
                           cola_auxiliar.Insertar4(aux2[0], aux2[1], aux2[2]);
                       }
                       
                   } else {
                       
                       cola_auxiliar.Insertar4(aux2[0], aux2[1], aux2[2]);
                   }
               }
              
           }
           //Aqui se extraen tipo por tipo el sueño 
           aux = cola_auxiliar.Extraer2();
           //condicion para disminuir el tiempo de proceso de los sueño de tipo 1
           if (tiempo_proceso_tipo1 != 0) {
               tiempo_proceso_tipo1 = tiempo_proceso_tipo1 - 20;

           }
           if (tiempo_proceso_tipo1 < 0) {
               tiempo_proceso_tipo1 = 0;
           }
           //Condicion para procesar los sueños de tipo 1 
           if(aux[2] == 1 && tiempo_proceso_tipo1 == 0){
               //Condicion para calcular el tiempo de proceso de los sueños de tipo 1 
               if (aux[0] >= 1000 && aux[1] >= 1000) {
                   tiempo_proceso_tipo1 = tiempo_proceso_tipo1 + aux[1] - aux[0] + 1;
               }
               if (aux[0] >= 1000 && aux[1] < 1000) {
                   tiempo_proceso_tipo1 = tiempo_proceso_tipo1 + 1440 - aux[0];
                   tiempo_proceso_tipo1 = tiempo_proceso_tipo1 + aux[1];
               }
               if (aux[0] < 1000 && aux[1] < 1000) {
                   tiempo_proceso_tipo1 = tiempo_proceso_tipo1 + aux[1] - aux[0] + 1;
               }
           
               
               if (tiempo_proceso_tipo1 % 8 != 0) {

                   tiempo_proceso_tipo1 = 60;

               } else {

                   tiempo_proceso_tipo1 = tiempo_proceso_tipo1 / 8;
               }
               
                //Condicion para calcular el tiempo de duracion de los sueños de ligeros
               if (aux[0] >= 1000 && aux[1] >= 1000) {
                   total_ligero = total_ligero + aux[1] - aux[0] + 1;
               }
               
               if (aux[0] >= 1000 && aux[1] < 1000) {
                   total_ligero = total_ligero + 1440 - aux[0];
                   total_ligero = total_ligero + aux[1];
               }
               
               if (aux[0] < 1000 && aux[1] < 1000) {
                   total_ligero = total_ligero + aux[1] - aux[0] + 1;
               }
            //else para que si el tiempo de proceso no ha terminado se desencole y se encole al final   
           } else {
               
               if (aux[2] == 1 && tiempo_proceso_tipo1 != 0) {

                   if (duracion_ultimo_registro_enviado == 0) {
                       if (aux[0] >= 1000 && aux[1] >= 1000) {
                           duracion_ultimo_registro_enviado = duracion_ultimo_registro_enviado + aux[1] - aux[0] + 1;
                       }
                       if (aux[0] >= 1000 && aux[1] < 1000) {
                           duracion_ultimo_registro_enviado = duracion_ultimo_registro_enviado + 1440 - aux[0];
                           duracion_ultimo_registro_enviado = duracion_ultimo_registro_enviado + aux[1];
                       }
                       if (aux[0] < 1000 && aux[1] < 1000) {
                           duracion_ultimo_registro_enviado = duracion_ultimo_registro_enviado + aux[1] - aux[0] + 1;
                       }

                   }

                   cola_auxiliar.Insertar4(aux[0], aux[1], aux[2]);

               }
           }
           
           
           //condicion para disminuir el tiempo de proceso de los sueño de tipo 2
           if (tiempo_proceso_tipo2 != 0) {
               tiempo_proceso_tipo2 = tiempo_proceso_tipo2 - 20;

           }
           if (tiempo_proceso_tipo2 < 0) {
               tiempo_proceso_tipo2 = 0;
           }
           //Condicion para procesar los sueños de tipo 2 
           if (aux[2] == 2 && tiempo_proceso_tipo2 == 0) {
               //Conicion para calcular el tiempo de proceso de los sueños de tipo 2
               if (aux[0] >= 1000 && aux[1] >= 1000) {
                   tiempo_proceso_tipo2 = tiempo_proceso_tipo2 + aux[1] - aux[0];
               }
               if (aux[0] >= 1000 && aux[1] < 1000) {
                   tiempo_proceso_tipo2 = tiempo_proceso_tipo2 + 1440 - aux[0] + 1;
                   tiempo_proceso_tipo2 = tiempo_proceso_tipo2 + aux[1];
               }
               if (aux[0] < 1000 && aux[1] < 1000) {
                   tiempo_proceso_tipo2 = tiempo_proceso_tipo2 + aux[1] - aux[0] + 1;
               }
           

               if (tiempo_proceso_tipo2 % 8 != 0) {
                   
                   tiempo_proceso_tipo2 = 80;
                   
               } else {
                   
                   tiempo_proceso_tipo2 = tiempo_proceso_tipo2 / 8;
               }
               //Condicion para calcular el tiempo de duracion de los sueños pesado
               if (aux[0] >= 1000 && aux[1] >= 1000) {
                   total_pesado = total_pesado + aux[1] - aux[0] + 1;
               }
               if (aux[0] >= 1000 && aux[1] < 1000) {
                   total_pesado = total_pesado + 1440 - aux[0];
                   total_pesado = total_pesado + aux[1];
               }
               if (aux[0] < 1000 && aux[1] < 1000) {
                   total_pesado = total_pesado + aux[1] - aux[0] + 1;
               }
            //else para que si el tiempo de proceso no ha terminado se desencole y se encole al final 
           } else {

               if (aux[2] == 2 && tiempo_proceso_tipo2 != 0) {

                   if (duracion_ultimo_registro_enviado == 0) {
                       if (aux[0] >= 1000 && aux[1] >= 1000) {
                           duracion_ultimo_registro_enviado = duracion_ultimo_registro_enviado + aux[1] - aux[0] + 1;
                       }
                       if (aux[0] >= 1000 && aux[1] < 1000) {
                           duracion_ultimo_registro_enviado = duracion_ultimo_registro_enviado + 1440 - aux[0];
                           duracion_ultimo_registro_enviado = duracion_ultimo_registro_enviado + aux[1];
                       }
                       if (aux[0] < 1000 && aux[1] < 1000) {
                           duracion_ultimo_registro_enviado = duracion_ultimo_registro_enviado + aux[1] - aux[0] + 1;
                       }

                   }

                   cola_auxiliar.Insertar4(aux[0], aux[1], aux[2]);

               }
           }
          
           //condicion para disminuir el tiempo de proceso de los sueño REM
           if (tiempo_proceso_tipo3 != 0) {

               tiempo_proceso_tipo3 = tiempo_proceso_tipo3 - 20;

           }
           if (tiempo_proceso_tipo3 < 0) {

               tiempo_proceso_tipo3 = 0;
           }
           //Condicion para procesar los sueños REM
           if (aux[2] == 3 && tiempo_proceso_tipo3 == 0) {
               //Conicion para calcular el tiempo de proceso de los sueños REM
               
               if (aux[0] >= 1000 && aux[1] >= 1000) {
                   tiempo_proceso_tipo3 = tiempo_proceso_tipo3 + aux[1] - aux[0] + 1;;
               }
               if (aux[0] >= 1000 && aux[1] < 1000) {
                   tiempo_proceso_tipo3 = tiempo_proceso_tipo3 + 1440 - aux[0] + 1;
                   tiempo_proceso_tipo3 = tiempo_proceso_tipo3 + aux[1];
               }
               if (aux[0] < 1000 && aux[1] < 1000) {
                   tiempo_proceso_tipo3 = tiempo_proceso_tipo3 + aux[1] - aux[0] + 1;
               }
           

               if (tiempo_proceso_tipo3 % 8 != 0) {

                   tiempo_proceso_tipo3 = 120;

               } else {

                   tiempo_proceso_tipo3 = tiempo_proceso_tipo3 / 8;

               }
               //Condicion para calcular el tiempo de duracion de los sueños REM
               if (aux[0] >= 1000 && aux[1] >= 1000) {
                   total_REM = total_REM + aux[1] - aux[0] + 1;
               }
               if (aux[0] >= 1000 && aux[1] < 1000) {
                   total_REM = total_REM + 1440 - aux[0];
                   total_REM = total_REM + aux[1];
               }
               if (aux[0] < 1000 && aux[1] < 1000) {
                   total_REM = total_REM + aux[1] - aux[0] + 1;
               }
            //else para que si el tiempo de proceso no ha terminado se desencole y se encole al final   
           } else {

               if (aux[2] == 3 && tiempo_proceso_tipo3 != 0) {
                  
                   if (duracion_ultimo_registro_enviado == 0) {
                       if (aux[0] >= 1000 && aux[1] >= 1000) {
                           duracion_ultimo_registro_enviado = duracion_ultimo_registro_enviado + aux[1] - aux[0] + 1;
                       }
                       if (aux[0] >= 1000 && aux[1] < 1000) {
                           duracion_ultimo_registro_enviado = duracion_ultimo_registro_enviado + 1440 - aux[0];
                           duracion_ultimo_registro_enviado = duracion_ultimo_registro_enviado + aux[1];
                       }
                       if (aux[0] < 1000 && aux[1] < 1000) {
                           duracion_ultimo_registro_enviado = duracion_ultimo_registro_enviado + aux[1] - aux[0] + 1;
                       }

                   }

                   cola_auxiliar.Insertar4(aux[0], aux[1], aux[2]);

               }
           }
            //Condicion para que si en ningun momento se ha desencolado y encolado al final la duracion del ultimo registro enviado
            //sea el ultimo en ser procesado
            if (cola_auxiliar.TamanoCola() == 1) {
                if (duracion_ultimo_registro_enviado == 0) {
                    aux4 = cola_auxiliar.UltimoValorIngresado();
                    if (aux4[0] >= 1000 && aux4[1] >= 1000) {
                        duracion_ultimo_registro_enviado = duracion_ultimo_registro_enviado + aux4[1] - aux4[0] + 1;
                    }
                    if (aux4[0] >= 1000 && aux4[1] < 1000) {
                        duracion_ultimo_registro_enviado = duracion_ultimo_registro_enviado + 1440 - aux4[0];
                        duracion_ultimo_registro_enviado = duracion_ultimo_registro_enviado + aux4[1];
                    }
                    if (aux4[0] < 1000 && aux4[1] < 1000) {
                        duracion_ultimo_registro_enviado = duracion_ultimo_registro_enviado + aux4[1] - aux4[0] + 1;
                    }

                }

            }
        }

    }

}
