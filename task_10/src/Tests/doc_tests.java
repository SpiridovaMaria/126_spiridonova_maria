package Tests;

import org.junit.*;
import Core.*;

import java.util.Locale;

public class doc_tests extends Assert {
    @Test
    public void create_CreateEmptyDocBook_DocCountEqualsZero(){
        DocBook docBook = DocBook.create();
        assertEquals(0,docBook.getDocCount());
    }
    @Test
    public void addDoc_addDocWithNumberAndDate_DocCountEqualsOne(){
        DocBook docBook = DocBook.create();
        docBook.addDoc("number","date");
        assertEquals(1,docBook.getDocCount());
    }
    @Test
    public void addDoc_addDocWithNullNumber_ThrowsException(){
        DocBook docBook = DocBook.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> docBook.addDoc(null,"date"));
        assertTrue(exc.getMessage().toLowerCase().contains("number cannot be null"));
    }
    @Test
    public void addDoc_addDocWithNullDate_ThrowsException(){
        DocBook docBook = DocBook.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> docBook.addDoc("number",null));
        assertTrue(exc.getMessage().toLowerCase().contains("date cannot be null"));
    }

    @Test
    public void addDoc_addDocWithNullNumberAndNullDate_ThrowsException(){
        DocBook docBook = DocBook.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> docBook.addDoc(null,null));
        assertTrue(exc.getMessage().toLowerCase().contains("number cannot be null") &&
                exc.getMessage().toLowerCase().contains("date cannot be null"));
    }
    @Test
    public void registerPaymentDoc_registerPayDocWithoutData_PaymentDocCountEqualsZero(){
        DocBook docBook = DocBook.create();

        docBook.addDoc("number","date");
        assertEquals(0,docBook.getDocs().get("number").getPaymentDocCount());
    }
    @Test
    public void registerPaymentDoc_registerPayDocWithData_PaymentDocCountEqualsOne(){
        DocBook docBook = DocBook.create();

        docBook.addDoc("number","date");
        docBook.registerPaymentDoc(100, 01, "number", "date");
        assertEquals(1,docBook.getDocs().get("number").getPaymentDocCount());
    }
}
