/**
 * 
 */
package words;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Aditya Sharat
 *
 */
public class Words {
    
    private List<String> words;

    public Words(String paths[]) throws IOException {
	this.words = new LinkedList<>();
	for (String path : paths)
	    this.words.addAll(this.fetchFromfile(path));
    }

    private List<String> fetchFromfile(String path) throws IOException {
	List<String> words = new LinkedList<>();
	BufferedReader br = new BufferedReader(new FileReader(new File(path)));
	String w = br.readLine();

	if (w == null) {
	    br.close();
	    return null;
	}

	do {
	    words.add(w.toLowerCase());
	} while ((w = br.readLine()) != null);
	
	br.close();

	return words;
    }

    public boolean isWord(String word) {
	return this.words.contains(word);
    }

    public String getWord(int i) {
	return this.words.get(i);
    }

    public long getSize() {
	return this.words.size();
    }

    /*
     * public static void main(String args[]) throws IOException { Words w = new
     * Words(new String[] { "english.0" }); for (int i = 0; i < 50; i++)
     * System.out.println(w.getWord(i)); }
     */

}
