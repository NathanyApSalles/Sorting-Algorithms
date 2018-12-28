public class MergeSort{
    
    public static void printArray(int array[]){
        
        int tamanho = array.length;
        
        for(int i = 0; i < tamanho; i++){
            System.out.print(array[i] + " ");
        }
        
        System.out.print("\n");
    }
    
    
    public static void merge(int array[], int start, int middle, int end){
        
        int tam1 = middle - start + 1;
        int tam2 = end - middle;
        
        int right[] = new int[tam1];
        int left[] = new int[tam2];
        
        //copy numbers to arrays
        for(int i = 0; i < tam1; i++){
            right[i] = array[start + i];
        }
        
        for(int j = 0; j < tam2; j++){
            left[j] = array[middle + 1 + j];
            
        }
        
        int i = 0, j = 0, k = start;
        
        while(i < tam1 && j < tam2){
            // confere se o elemento do array right é menor que o primeiro elemento do array left
            if(right[i] <= left[j]){
                //se for, insere no array inicial, o num do array right
                array[k] = right[i];
                //avança
                i++;
            }else{
                //se não for, insere no array inicial o num do array left
                array[k] = left[j];
                //avança
                j++;
                
            }
            
            k++;
        }
        
        while (i < tam1) 
        { 
            array[k] = right[i]; 
            i++; 
            k++; 
        } 

        while (j < tam2) 
        { 
            array[k] = left[j]; 
            j++; 
            k++; 
        } 
    }
    
    
    public static void mergeSort(int array [], int start, int end){
        
        
        if(start < end){
            
            int middle = (start + end) / 2;
        
            //left part
            mergeSort(array, start, middle);
            
            //right part
            mergeSort(array, middle + 1, end);
            
            //merge parts
            merge(array, start, middle, end);
        }
        
        
    }
    

     public static void main(String []args){
        int array[] = {8,7,6,5,4,3,2,1};
        
        printArray(array);
        
        System.out.println("\nORDENADO");
        
        int tamanho = array.length;
        int start = 0;
        int end = tamanho - 1;
        
        mergeSort(array, start, end);
        
        printArray(array);

     }
}