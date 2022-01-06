package Tests;

import org.junit.*;
import Core.*;

import java.util.ArrayList;
import java.util.List;


public class doc_tests extends Assert {
    @Test
    public void create_CreateEmptyDocBook_DocCountEqualsZero(){
        DocBook docBook = DocBook.create();
        assertEquals(0,docBook.getDocCount());
    }
    //--------------------------------------------------------------------------
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

    //--------------------------------------------------------------
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
        docBook.registerPaymentDoc(100, 1, "number", TypeOfPaymentDoc.BankOrder, "20000101");
        assertEquals(1,docBook.getDocs().get("number").getPaymentDocCount());
    }
    @Test
    public void registerPaymentDoc_registerPayDocWithData_PaymentDocCountEqualsThree(){
        DocBook docBook = DocBook.create();

        docBook.addDoc("number","date");
        docBook.registerPaymentDoc(100, 1, "number", TypeOfPaymentDoc.PaymentOrder, "20030204");
        docBook.registerPaymentDoc(200, 2, "number", TypeOfPaymentDoc.PaymentOrder, "20100305");
        docBook.registerPaymentDoc(300, 3, "number", TypeOfPaymentDoc.BankOrder, "20000303");
        assertEquals(3,docBook.getDocs().get("number").getPaymentDocCount());
    }
    @Test
    public void registerPaymentDoc_registerPayDocWithSumLessThenZero_TrowsException(){
        DocBook docBook = DocBook.create();
        docBook.addDoc("number","date");

        var exc = assertThrows(IllegalArgumentException.class, () ->
                docBook.registerPaymentDoc(-100, 1, "number", TypeOfPaymentDoc.PaymentOrder, "20030204"));
        assertTrue(exc.getMessage().toLowerCase().contains("sum is a positive number"));
    }
    @Test
    public void registerPaymentDoc_registerPayDocWithPaymentDocNumberLessThenZero_TrowsException(){
        DocBook docBook = DocBook.create();
        docBook.addDoc("number","date");

        var exc = assertThrows(IllegalArgumentException.class, () ->
                docBook.registerPaymentDoc(100, -7, "number", TypeOfPaymentDoc.PaymentOrder, "20030204"));
        assertTrue(exc.getMessage().toLowerCase().contains("number of payment document is a positive number"));
    }

    //------------------------------------------------------------------------------------------------------------
    @Test
    public void getList_getListOfAllPayments_equalLists(){
        DocBook docBook = DocBook.create();
        docBook.addDoc("number","date");
        docBook.registerPaymentDoc(100, 1, "number", TypeOfPaymentDoc.PaymentOrder, "20030204");
        docBook.registerPaymentDoc(500, 2, "number", TypeOfPaymentDoc.BankOrder, "20030204");
        docBook.registerPaymentDoc(300, 3, "number", TypeOfPaymentDoc.PaymentOrder, "20030204");

        List<Integer> paymentDocs = new ArrayList();
        paymentDocs.add(100);
        paymentDocs.add(500);
        paymentDocs.add(300);

        assertArrayEquals(paymentDocs.toArray(),docBook.getAllPayments().toArray());

    }

    // -------------------------------------------------------------------------------------------------------------------
    @Test
    public void deletePaymentDoc_DeletePaymentDocWithDocNumberNumberAndDate_PaymentDocCountEqualsZero(){
        DocBook docBook = DocBook.create();
        docBook.addDoc("number","20110825");
        docBook.registerPaymentDoc(100,2, "number", TypeOfPaymentDoc.PaymentOrder,"20110919");
        docBook.registerPaymentDoc(100,1, "number", TypeOfPaymentDoc.PaymentOrder,"20150321");

        docBook.deletePayment( "number", 2, "20110919");
        docBook.deletePayment( "number", 1, "20150321");
        assertEquals(0, docBook.getDocs().get("number").getPaymentDocCount());
    }
    //-------------------------------------------------------------------
    @Test
    public void getGeneralSum_CalculateDocGeneralSumOfPayments_GeneralSumEquals400(){
       DocBook docBook = DocBook.create();
        docBook.addDoc("123","20200327");
        docBook.registerPaymentDoc(300,101,"123", TypeOfPaymentDoc.BankOrder, "20211229");
        docBook.registerPaymentDoc(100,102,"123", TypeOfPaymentDoc.BankOrder, "20181109");
        assertEquals(400, docBook.getDocs().get("123").getSumOfPayments());
    }
    //------------------------------------------------------------------------------
    @Test
    public void getListOfPayments_GetAllPaymentsFromDoc_EqualLists(){
        DocBook docBook = DocBook.create();
        docBook.addDoc("123","20200327");
        docBook.registerPaymentDoc(200,101,"123", TypeOfPaymentDoc.BankOrder, "20211229");
        docBook.registerPaymentDoc(100,102,"123", TypeOfPaymentDoc.BankOrder, "20181109");
        docBook.addDoc("321","20200327");
        docBook.registerPaymentDoc(500,101,"321", TypeOfPaymentDoc.BankOrder, "20211229");
        docBook.registerPaymentDoc(400,102,"321", TypeOfPaymentDoc.BankOrder, "20181109");

        List<Integer> sums = new ArrayList();
        sums.add(200);
        sums.add(100);

        assertArrayEquals(sums.toArray(), docBook.getDocs().get("123").getListOfPayments().toArray());
    }

}
