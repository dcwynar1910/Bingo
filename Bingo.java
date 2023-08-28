import java.util.Arrays;   
import java.util.Collections;   
import java.util.Random;

public class Bingo{

      static boolean Verticalcheck(int [] board) {
            for (int k = 0; k < 5; k++){
               for (int x = k; x < (k+21); x+=5){
                  //System.out.println(k + " " + x);
                  if (board[x] == 0){
                     break;
                  }               
                  if (x == (k+20)){
                  
                     System.out.println(" BINGO vertical");
                     return true;
                    }
               }
         }
         return false;
        }
        
        static boolean Horizontalcheck(int [] board) {
            for (int k = 0; k < 21; k+=5){
               for (int x = k; x < (k+5); x++){
                  if (board[x] == 0){
                     break;
                  }               
                  if (x == k+4){
                  
                     System.out.println(" BINGO horizontal");
                     return true;
                    }
               }
         }
         return false;
        }
        
         static boolean Diagnol1check(int [] board) {
            for (int r = 0; r<25; r+=6){
            //System.out.println(r);
            if (board[r] == 0){
               break;
            }          
               
            if(r == 24){
               System.out.println(" BINGO diagonal");
               return true;
               } 
            }
          return false;
        }
        
        static boolean Diagnol2check(int [] board) {
            for (int u = 4; u<21; u+=4){
            //System.out.println(u);
            if (board[u] == 0){
               break;               
            }
                           
            if(u == 20){
               System.out.println(" BINGO diagonal");
               return true; 
               } 
            }
          return false;
        }

   public static void main(String[] args){   
      
      Random generator = new Random();
      
      int num;
      int choice;
           
      int [] pull = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
      int [] numbers = {};
      int [] board = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
      
  
      
      for (int i = 0; numbers.length < 25; i++){
    
          num = generator.nextInt(25); // (0 - 24 choice)
           choice = pull[num];
           
          boolean check = false;
           for (int a = 0; a < numbers.length; a++) {
               if (numbers[a] == choice) {
                   check = true;
                   break;
               }
            }
          
          if (check == false){
          
             numbers = Arrays.copyOf(numbers, numbers.length + 1);
             numbers[numbers.length - 1] = choice;
            }             
         }
      
      System.out.println("Numbers array in random order"); 
      
      for (int i = 0; i < numbers.length; i++){
         System.out.print(" " + numbers[i]); 
         } 

      System.out.println("\n"); 
      
      int co = 0;

     
       //MAIN
       for (int i = 0; i < numbers.length; i++){
         board[numbers[i]] = 1;
         
         
         
         for (int q = 0; q < numbers.length; q++){
            System.out.print(" " + board[q]); 
            co++;
            if (co == 5){
               System.out.print("\n");
               co = 0;
             }
         
         } 
         System.out.print(" END ITERATION " + i + "\n\n");
         
         
         if (Verticalcheck(board) == true | Horizontalcheck(board) == true | Diagnol1check(board) == true | Diagnol2check(board) == true){
            break;
         }

         
       }           
                  
  }   
}




