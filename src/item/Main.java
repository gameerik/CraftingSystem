package item;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Testing purposes, contains the entry point of the application.
 * @author CodeBlob
 *
 */
public class Main {

	/**
	 * The entry point of the application.
	 * @param args command line arguments
	 * @throws FileNotFoundException 
	 * @throws IOException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		FileItemReader reader = new FileItemReader();
		List<Item> items = reader.parse(new FileInputStream("items.txt"));
		items.stream().forEach(System.out::println);
		CheapItemService service = new CheapItemService(items);
		System.out.println(service.calculateCheapestWay(items.get(3)));
		
	}
	
}
