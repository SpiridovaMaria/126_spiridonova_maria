package task;

public class DoubleLinkedList<T extends Comparable<T>> {
    private DoubleLinkedListItem first;
    private DoubleLinkedListItem last;
    private int size;

    public DoubleLinkedList(){
        size=0;
    }
    public DoubleLinkedListItem findFirstItem(T data){
        DoubleLinkedListItem item = first;
        while(item.getData() != data){
            item = item.getNext();
        }
        return item;
    }
    public DoubleLinkedListItem findLastItem(T data){
        DoubleLinkedListItem item = last;
        while(item.getData() != data){
            item = item.getPrev();
        }
        return item;
    }
    public void insertAfter(DoubleLinkedListItem item, T data){
        DoubleLinkedListItem itemNew = new DoubleLinkedListItem(data);

        if(item == null && size == 0){
            first = itemNew;
            last = itemNew;
        }
        else if(item == null && size > 0){
            insertBefore(first,data);
            size--;
        }
        else if(item.getNext() == null){
            item.setNext(itemNew);
            itemNew.setPrev(item);
            last = itemNew;
        }
        else{
            itemNew.setNext(item.getNext());
            itemNew.setPrev(item);
            item.getNext().setPrev(itemNew);
            item.setNext(itemNew);
        }
        size++;
    }
    public void insertBefore(DoubleLinkedListItem item, T data){
        DoubleLinkedListItem itemNew = new DoubleLinkedListItem(data);
        if(item == null && size == 0){
            first = itemNew;
            last = itemNew;
        }
        else if(item == null && size > 0){
            insertAfter(last,data);
            size--;
        }
        else if(item.getPrev() == null){
            item.setPrev(itemNew);
            itemNew.setNext(item);
            first = itemNew;
        }
        else{
            itemNew.setPrev(item.getPrev());
            itemNew.setNext(item);
            item.getPrev().setNext(itemNew);
            item.setPrev(itemNew);
        }
        size++;
    }
    public void remove(DoubleLinkedListItem item){
        if(item.getNext()==null && item.getPrev()==null){
            last=null;
            first = null;
        }
        else if(item.getNext()==null && item.getPrev()!=null){
            item.getPrev().setNext(null);
            last = item.getPrev();
        }
        else if(item.getNext()!=null && item.getPrev()==null){
            item.getNext().setPrev(null);
            first = item.getNext();
        }
        else {
            item.getNext().setPrev(item.getPrev());
            item.getPrev().setNext(item.getNext());
            item.setNext(null);
            item.setPrev(null);
        }
        size--;
    }
    public int getSize(){
        return size;
    }
    public DoubleLinkedListItem getFirst(){
        return first;
    }
    public DoubleLinkedListItem getLast(){
        return last;
    }
}
