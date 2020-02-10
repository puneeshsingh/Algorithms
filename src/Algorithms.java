import java.util.Arrays;
abstract class Sort{
    protected int [] array;
    protected int no_of_comparisons=0;
    protected int no_of_swaps=0;

    public Sort(int[] array) {
        this.array = array;
    }
    abstract public void sort();
    public void getStats(){
        System.out.println("No. of comparisons=" + no_of_comparisons);
        System.out.println("No. of swaps=" + no_of_swaps);
    }
    public int[] getArray() {
        return array;
    }
    public void setArray(int[] array) {
        this.array = array;
    }
}
class SelectionSort extends Sort{
    public SelectionSort(int[] array) {
        super(array);
    }
    @Override
    public void sort() {
        int smallest = this.array[0];
        int temp;
        boolean found = false;
        int pos=0;
        for(int j=0;j<=array.length-1;j++){
            smallest=array[j];
            for(int i=j+1;i<=array.length-1;i++){
                no_of_comparisons++;
                if(smallest > array[i]){
                    smallest = array[i];
                    pos=i;
                    found=true;
                }
            }
            if(found){
                temp=array[j];
                array[j]=smallest;
                array[pos] = temp;
                found=false;
                no_of_swaps++;
                System.out.println(Arrays.toString(array));
            }
        }
    }
}

class BubbleSort extends Sort{
    public BubbleSort(int[] array) {
        super(array);
    }
    @Override
    public void sort() {
        int temp;
        for(int j=0;j<=array.length-1;j++){
            for(int i=0;i<array.length-1;i++){
                no_of_comparisons++;
                if(array[i] > array[i+1]){
                    temp=array[i];
                    array[i]=array[i+1];
                    array[i+1]=temp;
                    no_of_swaps++;
                    System.out.println(Arrays.toString(array));
                }
            }
        }
    }
}

class InsertionSort extends Sort{
    public InsertionSort(int[] array) {
        super(array);
    }
    @Override
    public void sort() {
        int temp;
        for(int i=1;i<=array.length-1;i++) {
            no_of_comparisons++;
                if(array[i] < array[i-1]) {
                for(int j=i;j>0;j--){
                    temp=array[j];
                    array[j] =array[j-1];
                    array[j-1]=temp;
                    no_of_swaps++;
                    System.out.println(Arrays.toString(array));
                }
            }
        }
    }
}

class QuickSort extends Sort{
    public QuickSort(int[] array) {
        super(array);
    }
    @Override
    public void sort() {
        int low=0;
        int high = array.length-1;
        quickSortHelper(array,low,high);
    }

    public void quickSortHelper(int [] array, int low, int high){
        if (low < high){
            int partitionIndex = partition(array,low,high);
            quickSortHelper(array,low,partitionIndex-1);
            quickSortHelper(array,partitionIndex+1,high);
        }
    }
    public int partition(int [] array, int low, int high){
        int pivot = array[high];
        System.out.println("pivpt=" + pivot);
        int i=low-1;
        int temp;

        for(int j=low;j<high;j++){
            no_of_comparisons++;
            if(array[j] < pivot){
                i++;
                temp=array[j];
                array[j]=array[i];
                array[i]=temp;
                no_of_swaps++;
                System.out.println(Arrays.toString(array));
            }
        }
        temp=array[i+1];
        array[i+1]=array[high];
        array[high]=temp;
        no_of_swaps++;
        System.out.println(Arrays.toString(array));
        return (i+1);
    }
}
public class Algorithms {
    public static void main(String [] args){
        SelectionSort selectSort = new SelectionSort(new int []{3,8,1,0,9,-1,10});
        System.out.println("Original array=" + Arrays.toString(selectSort.getArray()));
        System.out.println("Selection sort");
        selectSort.sort();
        System.out.println("Sorted array=" + Arrays.toString(selectSort.getArray()));
        System.out.println("Sorted array=" + Arrays.toString(selectSort.getArray()));
        selectSort.getStats();

        System.out.println("Bubble sort");
        BubbleSort bubbleSort = new BubbleSort(new int []{3,8,1,0,9,-1,10});
        bubbleSort.sort();
        System.out.println("Sorted array=" + Arrays.toString(bubbleSort.getArray()));
        bubbleSort.getStats();

        System.out.println("Insertion sort");
        InsertionSort insertionSort = new InsertionSort(new int []{3,8,1,0,9,-1,10});
        insertionSort.sort();
        System.out.println("Sorted array=" + Arrays.toString(insertionSort.getArray()));
        insertionSort.getStats();

        System.out.println("Quick sort");
        QuickSort quickSort= new QuickSort(new int []{3,8,1,0,9,-1,10});
        quickSort.sort();
        System.out.println("Sorted array=" + Arrays.toString(quickSort.getArray()));
        quickSort.getStats();
   }
}
