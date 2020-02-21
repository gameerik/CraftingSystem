package item;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Process data from a file. The data in the file has to be given in a special
 * format: name,price[,componentName]
 * 
 * @author CodeBlob
 *
 */
public class FileItemReader implements ItemReader {

	private Map<Item, List<String>> itemsAndTheirComponentNames;

	public FileItemReader() {
		this.itemsAndTheirComponentNames = new HashMap();
	}

	@Override
	public List<Item> parse(InputStream input) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		List<Item> result = new ArrayList();
		String line;
		while ((line = reader.readLine()) != null) {
			convertAndLinkItems(line);
		}
		createItems(result);
		return result;
	}

	private void convertAndLinkItems(String line) {
		String[] parts = line.split(",");
		String itemName = parts[0];
		int itemPrice = Integer.parseInt(parts[1]);
		Item currentItem = new Item(itemName, itemPrice);

		itemsAndTheirComponentNames.put(currentItem, new ArrayList());
		List<String> componentNames = itemsAndTheirComponentNames.get(currentItem);
		for (int i = 2; i < parts.length; i++) {
			componentNames.add(parts[i]);
		}
	}

	private void createItems(List<Item> items) {
		for (Map.Entry<Item, List<String>> itemAndTheComponentNames : itemsAndTheirComponentNames.entrySet()) {
			Item current = itemAndTheComponentNames.getKey();
			List<String> componentNames = itemAndTheComponentNames.getValue();
			List<Item> components = new ArrayList();
			for (String componentName : componentNames) {
				Item component = getItemByName(componentName);
				components.add(component);
			}
			current.setComponents(components);
			items.add(current);
		}
	}

	private Item getItemByName(String name) {
		Item result = null;
		for (Map.Entry<Item, List<String>> itemAndTheComponents : itemsAndTheirComponentNames.entrySet()) {
			Item currentItem = itemAndTheComponents.getKey();
			if (currentItem.getName().equals(name)) {
				result = currentItem;
				break;
			}
		}
		return result;
	}

}
