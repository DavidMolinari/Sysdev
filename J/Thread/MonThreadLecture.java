import java.lang.Math;
import java.util.*;

class MonThreadLecture extends Thread {
      private MonTableau monTableau;

      public MonThreadLecture (MonTableau monTableau){
            this.monTableau=monTableau;
      }
      public void run() {   
          try {
          //    this.wait();
               monTableau.lectureTab();  
          } catch (Exception e) {
              System.out.println("Meh 1 : " + e.getMessage());
          }
            
      }
}

class MonThreadEcriture extends Thread {
      private MonTableau monTableau ;

      public MonThreadEcriture (MonTableau monTableau){
            this.monTableau=monTableau;
      }

      public void run() {
          try {
          monTableau.ecritureTab();       
          } catch (Exception e) {
              System.out.println("Meh 2 : " + e.getMessage());
          }
      }
}

class MonTableau{
      int max=10;
      int tableau []=new int[max];
      

      public MonTableau(int max){
            this.max=max;
            this.tableau =new int[max];
      }

      public void lectureTab(){
            try{
                  for (int i=0;i<max; i++){
                        System.out.println("lecture a l'indice "+i+" => "+tableau[i]);
                  }
            }
            catch (Exception e){
                  e.printStackTrace() ;
            }
      }
      public void ecritureTab(){
            try{
                  for (int i=0;i<max; i++){
                        int nb= (int)(Math.round((Math.random())*10) ) ;
                        tableau[i]=nb;
                        System.out.println("ecriture a l'indice "+i+" => "+tableau[i]);
                  }
            }
            catch (Exception e){
                  e.printStackTrace() ;
            }
      }

}
class MesThreads {
      public static void main(String args[]){
            try{

                  int max=10;
                  while (true){
                        Scanner keyboard = new Scanner(System.in);
                        System.out.print ("Entrez un max  : ");
                        String s=keyboard.nextLine();
                        try{
                              max = Integer.parseInt(s);
                              break;
                        }
                        catch (Exception e){
                              System.out.println ("Valeur entiere SVP ");
                              continue;
                        }
                  }
                  MonTableau monTableau=new MonTableau(max);
                  MonThreadLecture monThreadLecture=new MonThreadLecture(monTableau) ;
                  MonThreadEcriture monThreadEcriture=new MonThreadEcriture(monTableau);
                  
                  if(!monThreadLecture.isAlive()) monThreadEcriture.start();
                  if(monThreadEcriture.isAlive()) monThreadLecture.start();
                  
                  MonThreadLecture monThreadLecture2=new MonThreadLecture(monTableau) ;
                  MonThreadEcriture monThreadEcriture2=new MonThreadEcriture(monTableau);
/*
                  Thread.sleep(1000);
                  monThreadLecture2.start();
                  monThreadEcriture2.start();
*/ 
}
            catch (Exception e){
                  e.printStackTrace() ;
            }
      }
}
