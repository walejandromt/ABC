/*Algoritmo ABC que da solucion al problema de la esfera
  ABC algoritmo been colony

 */
package Algorith;

/**
 *
 * @author Williams
 */

import java.util.Random;

public class ABC {
    
    public static void main(String ...args){
    int SN = 50;//Numero de soluciones
int MCN = 300;//Numero maximo de ciclos
double fuente[][] = new double[SN][3]; //fuente de alimento[5][3]
double empleadas[][] = new double[SN][3]; // abejas empleadas
double observadoras[][] = new double[SN][4]; //abejas observadoras
double candidata[][] = new double[SN][3]; 
int generaciones = 0; 
double mejor1 =0;
double mejor2=0;
int pos1 =0;
int pos2 =0; 
Random x = new Random();
Random o = new Random();


for(int i=0; i<SN; i++){
    for(int g=0; g<2; g++){  
 
        
        fuente[i][g] =((x.nextInt(2)==0?-1:1)*5*x.nextDouble()); 
    }
    
    //calcular su valor f(x)     
        fuente[i][2] = Math.pow(fuente[i][0],2) + Math.pow(fuente[i][1],2); 
}
        System.out.println("FUENTE PRIMARIA");
 //--------------------------------IMPRIMIR------------------------------------FUENTE
    System.out.println("|x1    |x2           |f(x)   |");
 for(int f=0; f<SN;f++){
     System.out.println(fuente[f][0] + "    " + fuente[f][1] + "        " + fuente[f][2]);
 }
        System.out.println("----------------------------------");
        System.out.println("");
 //--------------------------------IMPRIMIR------------------------------------FUENTE
 
 
 while(generaciones!=MCN){
 
 
//  Calcula valores aletorio para la abejas empleadas
 for(int i=0; i<SN; i++){
//        llenar k
        empleadas[i][0] = (int)(Math.random()*(5-1+1)+1);
    for(int g=0; g<=1; g++){ 
//        double empleadas[][] = new double[5][4]; // abejas empleadas
        empleadas[i][g+1] = ((o.nextInt(2)==0?-1:1)*1*o.nextDouble()); 
         
    }  
//    System.out.println(empleadas[i][0]+ "       " + empleadas[i][1] + "   "+ empleadas[i][2]);
    
}
 
 //Calcular solucion candidata, para las primeras abejas empleadas se calcula la nueva solucion candidta
 //utilizando la formula definida por el algoritmo.
 //Vig = xig + Ø * (xig - xkg);
  for(int i=0; i<SN; i++){
    for(int g=0; g<=1; g++){
     //recorrer fuente para calcular x1 y x2 y comparar con fuente  vig de la formula y sustituir si es el caso.
        
    candidata[i][g] = (fuente[i][g])+(empleadas[i][g+1])* ((fuente[i][g])-(fuente[(int)empleadas[i][0]-1][g]));
    } 
    
    //calcular su valor f(x)     
        candidata[i][2] = (Math.pow(candidata[i][0],2)) + (Math.pow(candidata[i][1],2));  
}
  
  //comparar candidata con fuente y sustituir
   for(int i=0; i<SN; i++){
    
         
           
        if(candidata[i][2]<=fuente[i][2]){
            
            for(int g=0; g<=1; g++){
        
                fuente[i][g] = candidata[i][g];
                fuente[i][2] = candidata[i][2];
                
                 }
        }
        
   
}
        
   
     //buscar las mejores resultados de fuente  
mejor1 = fuente[0][2];
  for(int a=1;a<SN;a++){
      if(fuente[a][2]<mejor1){
           mejor1 = fuente[a][2];
         pos1 = a;
              }
        }
   fuente[pos1][2] = 51;
   mejor2 = fuente[0][2];
      for(int a=1;a<SN;a++){
      if(fuente[a][2]<mejor2){
           mejor2 = fuente[a][2];
         pos2 = a;
              }
        }
  fuente[pos1][2] = mejor1;
  
 
        
        for (int t=0; t<(int)SN/2; t++){
            observadoras[t][0]=pos1;
            observadoras[t+(int)SN/2][0]=pos2;
        }
        
       for(int i=0; i<SN; i++){
     
        observadoras[i][1] = (int)(Math.random()*(5-1+1)+1);
    for(int g=1; g<=2; g++){ 
    //llenado Ø1 y Ø2 de abejas observadoras
        observadoras[i][g+1] = ((o.nextInt(2)==0?-1:1)*1*o.nextDouble()); 
    }  
}
 
 //Calcular solucion candidata, para las primeras abejas observadoras se calcula la nueva solucion candidata
 //utilizando la formula definida por el algoritmo.
 //Vig = mejorfuente + Ø * (mejorfuente - xkg);
  for(int i=0; i<SN; i++){
    for(int g=0; g<=1; g++){
     //recorrer fuente para calcular x1 y x2 y comparar con fuente  vig de la formula y sustituir si es el caso.
    candidata[i][g] = (fuente[(int)observadoras[i][0]][g])+(observadoras[i][g==0?2:3])* ((fuente[(int)observadoras[i][0]][g])-(fuente[((int)observadoras[i][1])-1][g]));
        
    } 
    
    //calcular su valor f(x)     
        candidata[i][2] = ((Math.pow(candidata[i][0],2)) + (Math.pow(candidata[i][1],2)));  
}
    
  generaciones++;
     System.out.println("----------------GENERACION "+generaciones);
     mejor1 = fuente[0][2];
  for(int a=1;a<SN;a++){
      if(fuente[a][2]<=mejor1){
           mejor1 = fuente[a][2];
         pos1 = a;
              }
        }
     System.out.println("mejor fuente fue: "+ fuente[pos1][0] + "  "+ fuente[pos1][1] + "  "+ "f(x) = " + fuente[pos1][2]);
     System.out.println("");
 

     

 }   
    }
    




}


