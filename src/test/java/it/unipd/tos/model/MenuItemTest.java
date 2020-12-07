////////////////////////////////////////////////////////////////////
// [ANTONIO] [BADAN] [1201209]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.unipd.tos.model.MenuItem.item;

public class MenuItemTest {
	
	private MenuItem menuItem;
	
	@Before
	public void setup() {
        menuItem = new MenuItem(MenuItem.item.Gelati, "Stracciatella", 2.00);
    }

	@Test
	public void getItemTypeTest(){
		assertEquals(MenuItem.item.Gelati,menuItem.getItemType());
	}
	
	@Test
	public void getNameTest(){
		assertEquals("Stracciatella",menuItem.getName());
	}
	
	@Test
	public void getPriceTest(){
		assertEquals(2.00,menuItem.getPrice(),0.01);
	}

}
