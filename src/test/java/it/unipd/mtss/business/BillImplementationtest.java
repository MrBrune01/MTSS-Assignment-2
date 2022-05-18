package it.unipd.mtss.business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import it.unipd.mtss.business.exception.BillException;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.User;
import it.unipd.mtss.model.EItem.itemType;

public class BillImplementationtest {
    public List<EItem> itemsOrdered;
    public BillImplementation bill;
    public User user;
    
    @Before
    public void setUp() throws Exception {
        bill = new BillImplementation();
        user = new User("Mattia", "Brunello", LocalDate.of(2001,1,1));
        itemsOrdered = new ArrayList<EItem>();
    }
    
    @Test
    public void testGetOrderPrice() throws BillException {
        
        EItem topo = new EItem(itemType.MOUSE, 20, "Logitech G50");
        EItem cpu = new EItem(itemType.PROCESSOR, 30, "Ryzen 5 2600");
        EItem motheboard = new EItem(itemType.MOTHERBOARD, 40, "Asus B450");

        itemsOrdered.add(topo);
        itemsOrdered.add(cpu);
        itemsOrdered.add(motheboard);
        assertEquals(90.0, bill.getOrderPrice(itemsOrdered, user),1e-15);
    }
}
