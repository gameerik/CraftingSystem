package item;

import java.util.List;

/**
 * A class holding the information about an item.
 */
public class Item {

	private String name;
	private int price;
	private List<Item> components;

	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Item> getComponents() {
		return components;
	}

	public void setComponents(List<Item> components) {
		this.components = components;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + ", components=" + components + "]";
	}

}
