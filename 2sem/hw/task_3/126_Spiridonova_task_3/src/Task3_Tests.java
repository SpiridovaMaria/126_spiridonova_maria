import org.junit.Assert;
import org.junit.*;

public class Task3_Tests extends Assert{
    class TestComparator implements MyComparator<Integer>{
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    }
    @Test
    public void quickSort_sortUnsortedArrayWithTwoElems_sortIsOk(){
        Integer[] arr = new Integer[]{2,1};
        QuickSort<Integer> qs = new QuickSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,2}, arr);
    }
    @Test
    public void quickSort_sortUnsortedArray_sortIsOk(){
        Integer[] arr = new Integer[]{1,2,3,4,5,4,3,2,1};
        QuickSort<Integer> qs = new QuickSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,1,2,2,3,3,4,4,5}, arr);
    }
    @Test
    public void quickSort_sortBigUnsortedArray_sortIsOk(){
        Integer[] arr = new Integer[]{5,4,2,7,3,2,2,1,1,3,4,1,6,7,3,2,1};
        QuickSort<Integer> qs = new QuickSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,1,1,1,2,2,2,2,3,3,3,4,4,5,6,7,7}, arr);
    }

    //-----------------------mergeSort-----------------------------------------
    @Test
    public void mergeSort_sortUnsortedArrayWithTwoElems_sortIsOk(){
        Integer[] arr = new Integer[]{3,2};
        MergeSort<Integer> qs = new MergeSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{2, 3}, arr);
    }
    @Test
    public void mergeSort_ArrayWithFirstUnsortedElems_sortIsOk(){
        Integer[] arr = new Integer[]{2,1,2,3};
        MergeSort<Integer> qs = new MergeSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,2,2,3}, arr);
    }
    @Test
    public void mergeSort_UnsortedArrayWithTwoSameElems_SortIsOk(){
        Integer[] arr = new Integer[]{5,1,4,1};
        MergeSort<Integer> qs = new MergeSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,1,4,5}, arr);
    }
    @Test
    public void mergeSort_UnsortedArray_SortIsOk(){
        Integer[] arr = new Integer[]{5,3,1,3};
        MergeSort<Integer> qs = new MergeSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,3,3,5}, arr);
    }

    @Test
    public void mergeSort_UnsortedArray2_SortIsOk(){
        Integer[] arr = new Integer[]{1,1,3,5,5,3,1,5};
        MergeSort<Integer> qs = new MergeSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,1,1,3,3,5,5,5}, arr);
    }




    //----------------------------HeapSort----------------------------------------------
    @Test
    public void heapSort_sortUnsortedArrayWithTwoElems_sortIsOk(){
        Integer[] arr = new Integer[]{10,10};
        HeapSort<Integer> hs = new HeapSort();
        hs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{10, 10}, arr);
    }
    @Test
    public void heapSort_sortedArray_arrayDoesNotChange(){
        Integer[] arr = new Integer[]{2,3};
        HeapSort<Integer> hs = new HeapSort();
        hs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{2, 3}, arr);
    }
    @Test
    public void heapSort_unsortedArrayWithThreeElems_sortIsOK(){
        Integer[] arr = new Integer[]{2,3,4};
        HeapSort<Integer> hs = new HeapSort();
        hs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{2,3,4}, arr);
    }


    @Test
    public void heapSort_UnsortedArray_SortIsOk(){
        Integer[] data = {9,1,6,3,1,9};
        Sort<Integer> hSort= new HeapSort<>();
        hSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1,1,3,6,9,9}, data);
    }
    @Test
    public void heapSort_UnsortedArray2_SortIsOk(){
        Integer[] data = {8,5,0,2,0,2,7,4,5,0,12,7};
        Sort<Integer> hSort= new HeapSort<>();
        hSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {0,0,0,2,2,4,5,5,7,7,8,12}, data);
    }

}
