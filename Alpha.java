
  //Name: Assignment Alpha 
  //by Faseeh.N
import java.util.Random;
class Main{
	public static void main(String args[]){
    Random r = new Random();
      String[][] BoardQ= new String[5][5]; //5x5 grid
      for (int i=0; i<BoardQ.length; i++){
          for (int j=0; j<BoardQ[0].length; j++){
              BoardQ[i][j]="?";
          }
      }//Set all values in array into "?"

      int Random1= r.nextInt(5), Random2 = r.nextInt(5);
      BoardQ[Random1][Random2]="A"; //Randomly place "A" into array

      BoardQ = place(BoardQ,Random1,Random2,"A");//Run the main method for this program
  }


  public static String[][] place(String[][] BoardQ, int Random1, int Random2, String alpha){//the "main method"
    printArr(BoardQ); //The only print statement. Prints the array
    Random r = new Random();
    int d = giveNum(BoardQ,Random1,Random2,r.nextInt(4));

    //Directions
    if (d==0){ //Up
        Random1--;
    }
    else if (d==1){//Right
        Random2++;
    }
    else if (d==2){//Down
        Random1++;
    }
    else if (d==3){//Left
        Random2--;
    }
    else{ //Instruction to end the method
        Random1=-1;
    }

    alpha = ""+(char)(alpha.charAt(0)+1); //Get the next alphabet
    
    if (!(Random1==-1)){ //A on-off switch for the program
        BoardQ[Random1][Random2]=alpha; //Replace "?" with an alphabet
        place(BoardQ,Random1,Random2,alpha); //repeat the entire method for the next alphabet
    }
    return BoardQ;
  }
  public static int giveNum(String[][] BoardQ, int Random1, int Random2, int d){ //num is randomized 0-3
    Random r = new Random();
    boolean Up=true,Right=true,Down=true,Left=true;//n = top; e = right; s = down; w = left
    //code below prevent the program from going out of bound in the array
    //Corners
    if (Random1==0&&Random2==0){//top left 
      if(!BoardQ[Random1][Random2+1].equals("?")){ //check right
        Right=false; 
      }
      if(!BoardQ[Random1+1][Random2].equals("?")){ //check downwards
        Down=false;
      }
      Up=false;Left=false;
    }
    else if(Random1==0&&Random2==4){//top right
      if(!BoardQ[Random1][Random2-1].equals("?")){ //check left
        Left=false;
      }
      if(!BoardQ[Random1+1][Random2].equals("?")){ //check downwards
        Down=false;
      }
      Up=false;Right=false;
    }
    else if(Random1==4&&Random2==0){//bottom left
      if(!BoardQ[Random1-1][Random2].equals("?")){ //check upwards
        Up=false;
      }
      if(!BoardQ[Random1][Random2+1].equals("?")){ //check right
        Right=false;
      }
      Down=false;Left=false;
    }
    else if(Random1==4&&Random2==4){//bottom right
      if(!BoardQ[Random1][Random2-1].equals("?")){ //check left
        Left=false;
      }
      if(!BoardQ[Random1-1][Random2].equals("?")){ //check upwards
        Up=false;
      }
      Down=false;Right=false;
    }

    //edges
    else if(Random1==0){//top
      if(!BoardQ[Random1][Random2+1].equals("?")){ //check right
        Right=false;
      }
      if(!BoardQ[Random1+1][Random2].equals("?")){ //check downwards
        Down=false;
      }
      if(!BoardQ[Random1][Random2-1].equals("?")){ //check left
        Left=false;
      }
      Up=false;
    }
    else if(Random2==4){//right
      if(!BoardQ[Random1-1][Random2].equals("?")){ //check upwards
        Up=false;
      }
      if(!BoardQ[Random1+1][Random2].equals("?")){ //check downwards
        Down=false;
      }
      if(!BoardQ[Random1][Random2-1].equals("?")){ //check left
        Left=false;
      }
      Right=false;
    }
    else if(Random1==4){//top
      if(!BoardQ[Random1][Random2+1].equals("?")){ //check right
        Right=false;
      }
      if(!BoardQ[Random1-1][Random2].equals("?")){ //check upwards
        Up=false;
      }
      if(!BoardQ[Random1][Random2-1].equals("?")){ //check left
        Left=false;
      }
      Down=false;
    }
    else if(Random2==0){//top
      if(!BoardQ[Random1][Random2+1].equals("?")){ //check right
        Right=false;
      }
      if(!BoardQ[Random1+1][Random2].equals("?")){ //check downwards
        Down=false;
      }
      if(!BoardQ[Random1-1][Random2].equals("?")){ //check upwards
        Up=false;
      }
      Left=false;
    }

    //Neither corners or edges
    else{
      if(!BoardQ[Random1][Random2+1].equals("?")){ //check right
        Right=false;
      }
      if(!BoardQ[Random1+1][Random2].equals("?")){ //check downwards
        Down=false;
      }
      if(!BoardQ[Random1-1][Random2].equals("?")){ //check upwards
        Up=false;
      }
      if(!BoardQ[Random1][Random2-1].equals("?")){ //check left
        Left=false;
      }
    }
    
    //The section for returning values.
    if(Up==false&&Right==false&&Down==false&&Left==false){
      return -1; //return -1 if no directions to go to
    }
    else{
      while ((d==0&&Up==false)||(d==1&&Right==false)||(d==2&&Down==false)||(d==3&&Left==false)){ 
        d=r.nextInt(4); //generate an available direction
      }
    }
    return d;
  }
  public static void printArr(String[][] BoardQ){ //Method for printing array
    for (int i=0; i<BoardQ.length; i++){
      for (int j=0; j<BoardQ[0].length; j++){
        System.out.print(BoardQ[i][j]+" ");
      }
      System.out.println();
    }
    System.out.println("_________\n");//separation line
    
  }
}
