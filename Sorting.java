public class Sorting{
    
    public static void printArray(int array[]){
        
        int tamanho = array.length;
        
        for(int i = 0; i < tamanho; i++){
            System.out.print(array[i] + " ");
        }
        
        System.out.print("\n");
    }
    
    public static void buildHeap(int array[], int tamanho){
        //considerando as posiçoes de 0 a n-1
        //divide o array no meio para fazer a divisão
        for(int i = tamanho/2 - 1; i >=0; i--)
            maxHeapify(array, i, tamanho);
        
    }
    
    //função para encontrar o max
    public static void maxHeapify(int array[], int pai, int tamanho){
        
        int esq = 2 * pai + 1;
        int dir = 2 * pai + 2;
        int maior = pai;
        
        //verifica se o esquerdo é maior que o pai, se for, troca
        if(esq < tamanho && array[esq] > array[maior]){
            maior = esq;
        }
        
        //verifica se o direito é maior que o pai, se for, troca
        if(dir < tamanho && array[dir] > array[maior]){
            maior = dir;
        }
        
        //se o maior for diferente do pai, troca  
        if(maior != pai){
            int aux = array[pai];
            array[pai] = array[maior];
            array[maior] = aux;
            maxHeapify(array,maior,tamanho);
        }
        
        
        
    }
    
    public static void heapSort(int array [], int tamanho){
        
        //controi heap
        buildHeap(array, tamanho);
       
        //troca raiz com os ultimos
        for(int i = tamanho - 1; i >= 0; i--){
           
            int aux = array[0];
            array[0] = array[i];
            array[i] = aux;
            
            // remove o último elemento, pois já está ordenado
            tamanho --;
            
            //reorganiza o heap
            maxHeapify(array, 0, tamanho);
            
        }
        
        printArray(array);
        
    }
    

     public static void main(String []args){
        int array[] = {8,7,6,5,4,3,2,1};
        
        printArray(array);
        
        System.out.println("\nORDENADO");
        
        int tamanho = array.length;
        
        heapSort(array, tamanho);
     }
}