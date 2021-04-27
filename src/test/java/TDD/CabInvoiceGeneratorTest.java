package TDD;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CabInvoiceGeneratorTest {
    @Test
    public void testFare()
    {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        int distance = 20;
        int time = 180;
        int fare = cabInvoiceGenerator.calculateFare(distance,time);
        Assertions.assertEquals(380, fare);
    }

    @Test
    public void testTotalFare()
    {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        int[] fare = new int[3];
        fare[0] = cabInvoiceGenerator.calculateFare(20,180);
        fare[1] = cabInvoiceGenerator.calculateFare(20,180);
        fare[2] = cabInvoiceGenerator.calculateFare(20,180);
        int totalFare = cabInvoiceGenerator.calculateTotalFare(3,fare);
        Assertions.assertEquals(1140, totalFare);
    }

    @Test
    public void testInvoice()
    {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        ArrayList<Integer> fare = new ArrayList<>();
        fare.add(cabInvoiceGenerator.calculateFare(20,180));
        fare.add(cabInvoiceGenerator.calculateFare(20,180));
        fare.add(cabInvoiceGenerator.calculateFare(20,180));
        int count = cabInvoiceGenerator.getCount();
        int totalFare = cabInvoiceGenerator.calculateTotalFare(fare);
        int avgFare = cabInvoiceGenerator.getAvgFare();
        Assertions.assertEquals(3, count);
        Assertions.assertEquals(1140, totalFare);
        Assertions.assertEquals(380, avgFare);
    }

    @Test
    public void testInvoiceService()
    {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        ArrayList<Integer> fare = new ArrayList<>();
        fare.add(cabInvoiceGenerator.calculateFare(20,180));
        fare.add(cabInvoiceGenerator.calculateFare(20,180));
        fare.add(cabInvoiceGenerator.calculateFare(20,180));
        int count = cabInvoiceGenerator.getCount();
        int totalFare = cabInvoiceGenerator.calculateTotalFare(fare);
        int avgFare = cabInvoiceGenerator.getAvgFare();
        cabInvoiceGenerator.idList(1);
        ArrayList<Integer> idList = new ArrayList<>();
        idList = cabInvoiceGenerator.getList(1);
        int count1 = idList.get(0);
        int totalFare1 = idList.get(1);
        int avgFare1 = idList.get(2);
        Assertions.assertEquals(3, count1);
        Assertions.assertEquals(1140, totalFare1);
        Assertions.assertEquals(380, avgFare1);
    }

    @Test
    public void testPremimumFare()
    {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        int distance = 20;
        int time = 180;
        String cx = "Premium";
        int fare = cabInvoiceGenerator.calculateFare(cx,distance,time);
        Assertions.assertEquals(660, fare);
    }
}

