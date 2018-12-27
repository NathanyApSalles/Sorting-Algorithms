public class QuickSort{
    
    public static void printArray(int array[]){
        
        int tamanho = array.length;
        
        for(int i = 0; i < tamanho; i++){
            System.out.print(array[i] + " ");
        }
        
        System.out.print("\n");
    }
    
    public static int partition(int array[], int start, int end){
        
        int pivot = array[end];
        int j = start - 1; // marca qual já foi analisado
        
        for(int i = start; i < end; i++){
            
            if(array[i] <= pivot){
                j++;
                int aux = array[j];
                array[j] = array[i];
                array[i] = aux;
                
            }
            
        }
        
        array[end] = array[j + 1];
        array[j + 1] = pivot;

        return j + 1;
        
    }
    
    public static void quickSort(int array [], int start, int end){
        
        
        if(start < end){
            
            int pivot = partition(array, start, end);
        
            //quick left part
            quickSort(array, start, pivot - 1);
            
            //quick right part
            quickSort(array, pivot + 1, end);
        }
        
        
    }
    

     public static void main(String []args){
        int array[] = {8,7,6,5,4,3,2,1};
        
        printArray(array);
        
        System.out.println("\nORDENADO");
        
        int tamanho = array.length;
        int start = 0;
        int end = tamanho - 1;
        
        quickSort(array, start, end);
        
        printArray(array);

     }
}