public class Dice {

 int sides;
 
 public Dice (int sided){
  
  sides = sided;
  
 }
 
 public int Roll (int times){
  
  int results = 0;
  
  for (int i = times; i > 0; i--){
   
   results += (int) ((Math.random()*this.sides) +1);
   
  }
  
  return results;
  
 }
}