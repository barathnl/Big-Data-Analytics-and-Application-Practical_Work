import java.util.Hashmap;
import java.util.*;
class Odd_man_Out{
  public static void main(String args[]){

    //Using Hashmap to put the input Integer with count value
    Hashmap<Integer,Integer> hMap = new Hashmap<Integer,Integer>();

    //Input array containing number repeated twice except one number
    int[] arrayInput={2,3,1,2,1};
    int initalCount = 1;

      for(int i=0;i<arrayInput.length;i++){
        int keyValue=arrayInput[i];
        if(hMap.containKey(keyValue)){
          //If input is present in Hashmap , then increment the count
          int countvalue=hMap.get(keyValue);
          ++countvalue;
          hMap.put(keyValue,countvalue);
        }else{
          //If input is not present , put input as keyValue and count as 1 initally
          hMap.put(keyValue,initalCount);
        }
      }

    //Number which as 1 as count is present once, so it is Odd_man_Out solution
    Set<Integer> keySolution =hMap.keySet();
    int solution=keySolution.getKey(initalCount);
  }
}
