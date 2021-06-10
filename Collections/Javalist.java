import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<Integer>();
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            list.add((Integer)in.nextInt());
        }
        int queries = in.nextInt();
        for (int i=0;i<2*queries;i=i+2){
            if(in.next().equalsIgnoreCase("Insert")){
                int x = in.nextInt(); 
                int y = in.nextInt(); 
                list.add(x, (Integer)y);
            }else{
                int x = in.nextInt();
                list.remove(x);
            }
        }
        for(int i=0; i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        
    }
}
