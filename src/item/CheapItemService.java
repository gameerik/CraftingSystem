package item;

import java.util.List;

/**
 * Class responsible for retrieving the most cost efficient way to obtain an item.
 * @author CodeBlob
 *
 */
public class CheapItemService {

	private List<Item> items;
	
	public CheapItemService(List<Item> items) {
		this.items = items;
	}
	
	/**
	 * Calculate the cheapest way to obtain the item.
	 * @param itemName the name of the item
	 * @return the cost of the cheapest method
	 */
	public int calculateCheapestWay(Item item) {
		int fullPrice = item.getPrice();
		int componentPrice = calculateComponentPrice(item);
		return Math.min(fullPrice, componentPrice);
	}
	
	private int calculateComponentPrice(Item item) {
		int result = 0;
		for (Item currentItem : items) {
			if (item.getComponents().contains(currentItem)) {
				result += currentItem.getPrice() + calculateComponentPrice(currentItem);
			}
		}
		return result;
	}
	
}
