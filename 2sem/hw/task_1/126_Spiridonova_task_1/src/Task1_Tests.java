import org.junit.Assert;
import org.junit.*;


public class Task1_Tests extends Assert{

    //-------------------Double linked list tests-------------------------------------------------
    @Test
    public void getNext_getNextElem_ElemIsCorrect(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        Node<Integer> prev = new Node<>(1);
        Node<Integer> next = new Node<>(3);
        Node<Integer> elem = new Node<Integer>(2, next, prev);

        assertEquals(next, elem.getNext());
    }
    @Test
    public void getPrev_getPrevElem_ElemIsCorrect(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        Node<Integer> prev = new Node<>(1);
        Node<Integer> next = new Node<>(3);
        Node<Integer> elem = new Node<Integer>(2, next, prev);

        assertEquals(prev, elem.getPrev());
    }

    @Test
    public void isEmpty_checkListWithElements_isEmptyFalse(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.insertAfter(list.getHead(), 1);
        assertFalse(list.isEmpty());
    }
    @Test
    public void getHead_getHeadOfListWithTwoElements_HeadIsCorrect(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.insertBefore(list.getHead(),2);
        Node<Integer> elem = list.insertBefore(list.getHead(), 1);
        assertEquals(elem, list.getHead());
    }
    @Test
    public void getTail_getTailOfListWithTwoElements_TailIsCorrect(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.insertBefore(list.getHead(),2);
        Node<Integer> elem = list.insertAfter(list.getHead(), 1);
        assertEquals(elem, list.getTail());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void get_getElementByIndexEqualsSize_ThrowsException(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.insertBefore(list.getHead(),10);
        list.insertBefore(list.getHead(),20);
        list.get(2);
    }
    @Test
    public void get_getElementByIndex_GetCorrectElement(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        Node<Integer> elem = list.insertBefore(list.getHead(),20);
        list.insertBefore(list.getHead(),20);
        assertEquals(elem, list.get(1));
    }
    @Test
    public void insertAfter_InsertIntoEmptyList_sizeEqualsOne(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.insertAfter(list.getHead(),1);
        assertEquals(1, list.getSize());
    }

    @Test
    public void pushFront_pushThreeElements_HeadIsCorrect(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.pushFront(30);
        list.pushFront(20);
        Node<Integer> elem = list.pushFront(10);

        assertEquals(elem, list.getHead());
    }
    @Test
    public void pushBack_pushThreeElements_TailIsCorrect(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.pushBack(10);
        list.pushBack(20);
        Node<Integer> elem = list.pushBack(30);

        assertEquals(elem, list.getTail());
    }

    @Test
    public void remove_removeElementFromList_getNextIsCorrect(){
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

            Node<Integer> elem = (Node<Integer>) list.pushBack(20);
            list.pushFront(10);
            Node<Integer> tail = list.pushBack(30);

            list.remove(elem);

            assertEquals(tail, list.getHead().getNext());
    }
    @Test
    public void remove_removeElementFromList_getPrevIsCorrect(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        Node<Integer> elem = (Node<Integer>) list.pushBack(20);
        Node<Integer> head = list.pushFront(10);
        list.pushBack(30);

        list.remove(elem);

        assertEquals(head, list.getTail().getPrev());
    }
    @Test
    public void insertListAfter_insertListIntoItself_ListIsNotEmpty() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(1);
        list.insertListAfter(list.getHead(), list);
        assertFalse(list.isEmpty());
    }

    @Test
    public void insertListAfter_insertListAfterHead_GetPrevIsCorrect(){

        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushBack(40);
        list1.pushFront(10);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        Node<Integer> elem = (Node<Integer>)list2.pushBack(20);
        list2.pushBack(30);

        list1.insertListAfter(list1.getHead(), list2);

        assertEquals(list1.getHead(),elem.getPrev());
    }
    @Test
    public void insertListAfter_insertListAfterHead_GetNextIsCorrect(){

        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushBack(40);
        list1.pushFront(10);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushBack(20);
        Node<Integer> elem = (Node<Integer>) list2.pushBack(30);

        list1.insertListAfter(list1.getHead(), list2);

        assertEquals(list1.getTail(),elem.getNext());
    }
    @Test
    public void insertListAfter_insertListIntoList_NewSizeIsCorrect() {
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();

        list1.pushFront(1);
        list1.pushFront(2);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushFront(3);
        list2.pushFront(4);

        list1.insertListAfter(list1.getHead(), list2);

        assertEquals(4, list1.getSize());
    }
    @Test
    public void insertListBefore_insertListIntoList_NewSizeIsCorrect() {
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();

        list1.pushFront(1);
        list1.pushFront(2);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushFront(3);
        list2.pushFront(4);

        list1.insertListBefore(list1.getHead(), list2);

        assertEquals(4, list1.getSize());
    }

    @Test
    public void insertListBefore_insertListIntoItself_ListIsNotEmpty() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(1);
        list.insertListBefore(list.getHead(), list);
        assertFalse(list.isEmpty());
    }
    @Test
    public void insertListBefore_insertListBeforeTail_GetPrevIsCorrect(){

        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushBack(40);
        list1.pushFront(10);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        Node<Integer> elem = (Node<Integer>)list2.pushBack(20);
        list2.pushBack(30);

        list1.insertListBefore(list1.getTail(), list2);

        assertEquals(list1.getHead(),elem.getPrev());
    }
    @Test
    public void insertListBefore_insertListBeforeTail_GetNextIsCorrect(){

        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushBack(40);
        list1.pushFront(10);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushBack(20);
        Node<Integer> elem = (Node<Integer>) list2.pushBack(30);

        list1.insertListBefore(list1.getTail(), list2);

        assertEquals(list1.getTail(),elem.getNext());
    }

    //-----------------Dynamic array tests ----------------------------------------------------
    @Test
    public void getSize_getSizeOfEmptyArray_SizeEqualsZero(){
        DynamicArray<Integer> array = new DynamicArray<>();
        assertEquals(0, array.getSize());
    }
    @Test
    public void get_getElementFromArray_ElementIsCorrect(){
        DynamicArray<Integer> array = new DynamicArray<>(1);
        array.set(0, 10);
        assertEquals(10, array.get(0).intValue());
    }
    @Test
    public void resize_setNewSizeWithNegativeValue_ThrowsException(){
        var array = new DynamicArray<>();
        var thrown = assertThrows(NegativeArraySizeException.class, () -> array.resize(-1));
        assertEquals("Size can not be negative", thrown.getMessage());
    }
    @Test
    public void resize_setNewSizeWithPositiveValue_NewSizeIsCorrect(){
        DynamicArray<Integer> array = new DynamicArray<>(2);
        array.resize(4);
        assertEquals(4, array.getSize());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void get_getElementWithIndexEqualsSize_ThrowsException(){
        DynamicArray<Integer> array = new DynamicArray<>();
        array.get(0);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void set_setElementWithIndexEqualsSize_ThrowsException(){
        DynamicArray<Integer> array = new DynamicArray<>();
        array.set(0,10);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void insert_insertElementWithIndexEqualsSize_ThrowsException(){
        DynamicArray<Integer> array = new DynamicArray<>();
        array.insert(0, 100);

    }
    @Test
    public void insert_insertElementToEmptyArray_ElemIsCorrect(){
        DynamicArray<Integer> array = new DynamicArray<>(2);
        array.insert(0, 10);
        array.set(1, 20);
        assertEquals(10, array.get(0).intValue());
    }

    @Test
    public void pushBack_pushBackElement_ElemIsCorrect(){
        DynamicArray<Integer> array = new DynamicArray<>();
        array.pushBack(400);
        assertEquals(400, array.get(0).intValue());
    }
    @Test
    public void pushBack_pushToArrayWithSizeBackElement_ElemIsCorrect(){
        DynamicArray<Integer> arr = new DynamicArray<>(1);
        arr.pushBack(1);
        assertEquals(1, arr.get(1).intValue());
    }
    @Test
    public void popBack_popBackElementFromEmptyArray_ThrowsException(){
        DynamicArray<Integer> array = new DynamicArray<>(0);
        try {
            array.popBack();
            fail();
        } catch (UnsupportedOperationException e) {
            assertTrue(true);
        }
    }
    @Test
    public void remove_removeElementWithIndexEqualsSize_ThrowsException(){
        DynamicArray<Integer> array = new DynamicArray<>(3);
        try {
            array.remove(3);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

}


