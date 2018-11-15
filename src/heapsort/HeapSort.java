/* Hildana and Gloria
 * HeapSort.java
 * This program demonstrates the sorting method, HeapSort.
 * Nov/15/2018
 */
package heapsort;
import static java.lang.System.currentTimeMillis;



/**
 *
 * @author Hildana
 */
public class HeapSort {
    
    int swapsNum = 0;
    int compsNum = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //array
        int elements= 10000;
        int arr[] = new int[elements];
        
        //randomize
        for (int i=0; i<elements; i++){
        arr[i]=(int)(Math.random()*10001);
        }
        
        //calculate the total time
        double start=0;
        double finish=0;
        double total=0;
        
        start = currentTimeMillis();
        
        HeapSort ob = new HeapSort(); 
        ob.sort(arr);
        
        System.out.println("\nSorted array is"); 
        printArray(arr); 
        
        finish = currentTimeMillis();
        total = finish - start;
        
        System.out.println("\nThe time taken is: " + total + "ms");
        
    
    }
    
      public void sort(int arr[]) {
        
        //pass n as the length of the array
        int n = arr.length; 
  
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
                heapify(arr, n, i); 
  
        // One by one extract an element from heap 
        for (int i=n-1; i>=0; i--) 
        { 
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
             
            
            // call max heapify on the reduced heap 
            heapify(arr, i, 0); 
        } 
        
        //print total swaps and comparisons
        System.out.println("Heap Sort"
            + "\nthe total swaps are: " + swapsNum + "\n" + "The total comparisons: " + compsNum);
    }
      
        
       // To heapify a subtree rooted with node i which is 
       // an index in arr[]. n is size of heap 
        void heapify(int arr[], int n, int i) {
            
        compsNum++;
         
        //actually the index 
        int largest = i;  // Initialize largest as root (parent) 
        int l = 2*i + 1;  // left = 2*i + 1 
        int r = 2*i + 2;  // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) { 
            largest = l; 
        }
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]){ 
            largest = r; 
        }
  
        // If largest is not root 
        if (largest != i) 
        { 
            //swaps
            swapsNum++;
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap;
             
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest); 

        } 
    } 
        
        //prints out the sorted array
        static void printArray(int arr[]) { 
        int n = arr.length;
         
        for (int i=0; i<n; ++i)
        System.out.print(arr[i]+" "); 
        System.out.println(); 
   } 
}
