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
        Integer[] arr = new Integer[]{5,3};
        QuickSort<Integer> qs = new QuickSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{3, 5}, arr);
    }
    @Test
    public void quickSort_sortUnsortedArrayWithTwoSameElems_sortIsOk(){
        Integer[] arr = new Integer[]{1,5,1,3};
        QuickSort<Integer> qs = new QuickSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,1,3, 5}, arr);
    }
    @Test
    public void quickSort_UnsortedArray_sortIsOk(){
        Integer[] arr = new Integer[]{1,5,1,3,5};
        QuickSort<Integer> qs = new QuickSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,1,3,5, 5}, arr);
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
        Integer[] arr = new Integer[]{2,1,3};
        MergeSort<Integer> qs = new MergeSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,2, 3}, arr);
    }
    @Test
    public void mergeSort_SortedArray_ArrayDoesNotChange(){
        Integer[] arr = new Integer[]{1,2,3,4};
        MergeSort<Integer> qs = new MergeSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3,4}, arr);
    }
    @Test
    public void mergeSort_UnsortedArrayWithTwoSameElems_SortIsOk(){
        Integer[] arr = new Integer[]{1,5,4,1};
        MergeSort<Integer> qs = new MergeSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,1,4,5}, arr);
    }
    @Test
    public void mergeSort_UnsortedArray_SortIsOk(){
        Integer[] arr = new Integer[]{1,5,2,5,3,2};
        MergeSort<Integer> qs = new MergeSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,2,2,3,5,5}, arr);
    }

    //----------------------------HeapSort----------------------------------------------
    @Test
    public void heapSort_sortUnsortedArrayWithTwoElems_sortIsOk(){
        Integer[] arr = new Integer[]{3,2};
        HeapSort<Integer> hs = new HeapSort();
        hs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{2, 3}, arr);
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
        Integer[] arr = new Integer[]{3,2,4};
        HeapSort<Integer> hs = new HeapSort();
        hs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{2,3,4}, arr);
    }
    @Test
    public void heapSort_unsortedArray_sortIsOK(){
        Integer[] arr = new Integer[]{5,1,3,1,1,3};
        HeapSort<Integer> hs = new HeapSort();
        hs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,1,1,3,3,5}, arr);
    }
    @Test
    public void heapSort_unsortedArray2_sortIsOK(){
        Integer[] arr = new Integer[]{5,1,2,3,1,5,5,2};
        HeapSort<Integer> hs = new HeapSort();
        hs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,1,2,2,3,5,5,5}, arr);
    }
}
