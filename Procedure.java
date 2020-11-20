package slr;

import java.util.stream.*;
import java.util.Scanner;
/**
 *
 * @author Carlos Varela
 */
public class Procedure {
    //Object
    Scanner inputs = new Scanner(System.in);
    
    // Atributes
    int sumX; 
    int sumY; 
    int sumXY;
    int sumNXY;
    int sumXsq;
    int sumYsq;
    int sumNXsq;
    int sumNYsq;
    int indy;
    
    double B0,B1,r,Ry;
    
    int[] x = {23,26,30,34,43,48,52,57,58};
    int[] y ={651,762,856,1063,1190,1298,1421,1440,1518};
    int[] p = {59,60,61,64,65,70,75,80};
    int[] a = new int[x.length];
    int[] s = new int[x.length];
    int [] sy = new int[x.length];
    //Metodos 
    
    public void sumatoriaX(){
        sumX=IntStream.of(x).sum();
    }
    
    public void sumatoriaY(){
        sumY = IntStream.of(y).sum();
    }
    
    public void sumatoriaXY(){
        for (int i=0;i<a.length;i++){
            a[i] = x[i]*y[i];
        }
        sumXY = IntStream.of(a).sum();
    }
    
    public void sumatoriaNXY(){
        sumNXY = x.length * sumXY;
    }
    
    public void sumatoriaXsq(){
        for (int i =0; i<s.length;i++){
             s[i]= x[i]*x[i];
        }
        sumXsq = IntStream.of(s).sum();
    }
    
    public void sumatoriaYsq(){
        for (int i =0;i<sy.length;i++){
            sy[i] = y[i]*y[i];
        }
        sumYsq = IntStream.of(sy).sum();
    }
    
    public void sumatoriaNXsq(){
       sumNXsq = sumXsq * x.length;
    }
    
     public void sumatoriaNYsq(){
       sumNYsq = sumYsq * y.length;
    }
    
    public void Beta1(){
        B1 = (sumNXY-(sumX*sumY))/(sumNXsq-(Math.pow(sumX, 2)));
    }
    
    public void Beta0(){
        B0 = ((sumY-(B1*sumX))/x.length);
    }
    public void CorrelationR (){     
        r =(sumNXY-(sumX*sumY))/Math.sqrt((sumNXsq-(Math.pow(sumX, 2)))*(sumNYsq-(Math.pow(sumY, 2))));     
    }

    public void AutomatedPrediction(){
        for(int i = 0;i<p.length ;i++){
            Ry = B0 + (B1*p[i]);
            System.out.println("The prediction for x= " +p[i]+" is: "+Ry);
        }        
    }
    
    public void Prediction(){
        System.out.println("Input an x value ");
        int indy = inputs.nextInt();
        
        Ry = B0 + (B1*indy);
        System.out.println("The prediction made with "+ indy +" as the x value is: " + Ry);
        System.out.println("\nWhere y = B0 + (B1*xi) is substituted by:\n y = " + B0 +" + ("+ B1 +" * "+indy+" )\n");
    }
    
     public void Results(){                                                           
        System.out.println("Beta 1 = "+B1);
        System.out.println("Beta 0 = "+B0);
        System.out.println("R coefficient = "+ r);
    }
}
