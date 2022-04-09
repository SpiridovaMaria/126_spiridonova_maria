import org.junit.Assert;
import org.junit.*;

public class Task2_Tests extends Assert{
    class TestComparator implements MyComparator<Integer>{
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    }

    private boolean isSorted(Integer[] data){
        for(int i=0; i<data.length-1; i++){
            if(data[i]>data[i+1])
                return false;
        }
        return true;
    }

    //-----------BubbleSort------------------------------------------------
    @Test
    public void bubbleSort_ArrayWithThreeSimilarElements_ArrayStaysTheSame(){
        Integer[] data={10,10,10};
        BubbleSort<Integer> bs = new BubbleSort<>();
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{10, 10,10}, data);
    }
    @Test
    public void bubbleSort_SortedArray_ArrayStaysTheSame(){
        BubbleSort<Integer> bs = new BubbleSort<>();
        Integer[] data={1,2,3,4};
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3,4}, data);
    }
    @Test
    public void bubbleSort_UnSortedArray_ElementsChangeTheirPosition(){
        BubbleSort<Integer> bs = new BubbleSort<>();
        Integer[] data={1,4,3,2};
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3,4}, data);
    }
    @Test
    public void bubbleSort_ArrayWithOneUnsortedElement_SortOk(){
        BubbleSort<Integer> bs = new BubbleSort<>();
        Integer[] data={1,4,2,3,5};
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3,4,5}, data);
    }

    //-----------------SelectionSort----------------------------------------------
    @Test
    public void selectionSort_ArrayWithTheFirstMaxElem_SortOk(){
        SelectionSort<Integer> ss = new SelectionSort<>();
        Integer[] data={5,4,2};
        ss.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{2,4,5}, data);
    }
    @Test
    public void selectionSort_UnsortedArrayWithTwoElements_SortOk(){
        SelectionSort<Integer> ss = new SelectionSort<>();
        Integer[] data={5,4};
        ss.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{4,5}, data);
    }
    @Test
    public void selectionSort_UnsortedArray_SortOk(){
        SelectionSort<Integer> ss = new SelectionSort<>();
        Integer[] data={5,4,1,2,3};
        ss.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3,4,5}, data);
    }

    //----------------InsertionSort---------------------------------
    @Test
    public void insertionSort_sortedArrayWithTwoElements_ArrayDoesNotChange(){
        InsertionSort<Integer> is = new InsertionSort<>();
        Integer[] data={4,5};
        is.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{4,5}, data);
    }
    @Test
    public void insertionSort_unsortedArrayWithTwoElements_SortIsOk(){
        InsertionSort<Integer> is = new InsertionSort<>();
        Integer[] data={5,4};
        is.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{4,5}, data);
    }

}
