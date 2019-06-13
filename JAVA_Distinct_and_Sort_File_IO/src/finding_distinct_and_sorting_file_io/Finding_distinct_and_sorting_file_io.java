
package finding_distinct_and_sorting_file_io;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Saleh
 */

public class Finding_distinct_and_sorting_file_io {
    
    public static class DNS {

        public void findDistinctAndSort(String read, int sort, String write){

            Set<Integer> s;
            ArrayList<Integer> al;

            try{
                FileReader flr = new FileReader(read);
                s = new LinkedHashSet<>();
                al = new ArrayList<>();

                Scanner fetch = new Scanner(flr);
                while(fetch.hasNext()){
                    s.add(fetch.nextInt());
                }

                flr.close();

                al.addAll(s);

                switch(sort){
                    case 0:
                        Collections.sort(al, Collections.reverseOrder());
                        break;
                    case 1:
                        Collections.sort(al);
                        break;
                    default:
                      System.out.println("Not a valid choice!");  
                }

                FileWriter flw = new FileWriter(write);
                for(Integer i:al){
                    flw.write(i.toString()+System.lineSeparator());
                }
                flw.close();
            }
            catch(FileNotFoundException e){
                System.out.println(e);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String read="numbers.txt", write="sorted_distinct.txt";
        System.out.println("Sort by 1.ASC 0.DESC");
        int sortBy=sc.nextInt();
        DNS obj = new DNS();
        obj.findDistinctAndSort(read, sortBy, write);

    }
    
}
