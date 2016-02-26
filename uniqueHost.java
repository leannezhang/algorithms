
/*Problem
You're given an array of CSV strings representing search results. Results are sorted by a score initially. A given host may have several listings that show up in these results. Suppose we want to show 12 results per page, but we don't want the same host to dominate the results. Write a function that will reorder the list so that a host shows up at most once on a page if possible, but otherwise preserves the ordering. Your program should return the new array and print out the results in blocks representing the pages.
*/

  
import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) {
    
    int PER_PAGE = 5;

    ArrayList<String> input = new ArrayList<String>();
    //input.add("host_id,listing_id,score,city");
    input.add("1,28,300.1,San Francisco");
    input.add("1,5,209.1,San Francisco");
    input.add("20,7,208.1,San Francisco");
    input.add("23,8,207.1,San Francisco");
    input.add("16,10,206.1,Oakland");
    input.add("1,16,205.1,San Francisco");
    input.add("6,29,204.1,San Francisco");
    input.add("7,20,203.1,San Francisco");
    input.add("8,21,202.1,San Francisco");
    input.add("2,18,201.1,San Francisco");
    input.add("2,30,200.1,San Francisco");
 
    int pagesetter = 1;
    int counter = 0;

    HashSet<String> uniqueHosts = new HashSet<>();
    boolean traversed = false;

    while (!input.isEmpty()) {
      for (int i = 0; i < input.size(); i++) {
        if (counter >= PER_PAGE) {
          uniqueHosts.clear();
          counter = 0;
          pagesetter++;
          i=0;
          traversed = false;
        }

        // get the hostid
        String word = input.get(i);
        String[] data = word.split(",");
        String host = data[0];

        if (!uniqueHosts.contains(host) || traversed) {
          System.out.println("Page" + pagesetter + ":" + word);
          input.remove(word);
          i--;
          counter++;
          uniqueHosts.add(host);
        }

      }

      traversed = true;

    }

  }
}
