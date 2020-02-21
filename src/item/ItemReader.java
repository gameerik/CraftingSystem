package item;

import java.util.List;
import java.io.IOException;
import java.io.InputStream;

/**
 * Process item data from a source.
 */
public interface ItemReader {

	/**
	 * Read item data from the input stream.
	 * @param input the input stream.
	 * @return the acquired items.
	 * @throws IOException 
	 */
	List<Item> parse(InputStream input) throws IOException;
	
}
