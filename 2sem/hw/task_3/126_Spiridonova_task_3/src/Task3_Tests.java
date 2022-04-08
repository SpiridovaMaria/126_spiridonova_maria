import org.junit.Assert;
import org.junit.*;

public class Task3_Tests extends Assert{
    class TestComparator implements MyComparator<Integer>{
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    }
    //HeapSort--------------------------------------------------
    @Test
    public void HeapSort_ArrayWithSameElems_ArrDoesNotChange(){
        HeapSort<Integer> hs = new HeapSort<>();
        Integer[] data = {1, 1, 1};
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 1, 1}, data);
    }

    @Test
    public void HeapSort_sortSortedArray_ArrDoesNotChange(){
        HeapSort<Integer> hs = new HeapSort<>();
        Integer[] data = {1, 2, 3};
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void HeapSort_sortUnsortedArray_SortIsOk(){
        HeapSort<Integer> hs = new HeapSort<>();
        Integer[] data = {9, 2, 3, 6, 1, 0, 8, 5, 7, 4};
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, data);
    }

    @Test
    public void HeapSort_sortUnsortedArrayWithSameElems_SortIsOk(){
        HeapSort<Integer> hs = new HeapSort<>();
        Integer[] data = {9, 2, 3, 6, 1, 0, 8, 5, 7, 4, 1};
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{0, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9}, data);
    }

    //MergeSort---------------------------------------------------

    @Test
    public void MergeSort_sortSortedArray_ArrayDoesNotChange(){
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {1, 2, 3};
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void MergeSort_SortUnsortedArray_SortIsOk(){
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {1, 3, 2};
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void MergeSort_sortHugeUnsortedArray_SortIsOk(){
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {9, 2, 3, 6, 1, 0, 8, 5, 7, 4};
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, data);
    }

    @Test
    public void MergeSort_SortArrayWithNegativeElems_SortIsOk(){
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {1, 0, -1};
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{-1, 0, 1}, data);
    }

    @Test
    public void MergeSort_sortUnsortedArrayWithSameElems_SortIsOk(){
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {0, 0, 1, 2, 2, 1, 2};
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{0, 0, 1, 1, 2, 2, 2}, data);
    }

    //QuickSort----------------------------
    @Test
    public void QuickSort_sortWithSameElems_ArrayDoesNotChange(){
        QuickSort<Integer> qs = new QuickSort<>();
        Integer[] data = {1, 1, 1};
        qs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 1, 1}, data);
    }

    @Test
    public void QuickSort_sortUnsortedArray_SortIsCorrect(){
        QuickSort<Integer> qs = new QuickSort<>();
        Integer[] data = {1, 3, 2};
        qs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void QuickSort_sortUnsortedArrayWithNegativeElems_SortIsOk(){
        QuickSort<Integer> qs = new QuickSort<>();
        Integer[] data = {1, 0, -1};
        qs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{-1, 0, 1}, data);
    }

    @Test
    public void QuickSort_sortHugeUnsortedArray_SortIsOk(){
        QuickSort<Integer> qs = new QuickSort<>();
        Integer[] data = {9, 2, 3, 6, 1, 0, 8, 5, 7, 4};
        qs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, data);
    }


}
