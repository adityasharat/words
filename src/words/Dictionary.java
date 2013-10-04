package words;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {

    private HashMap<String, ArrayList<String>> dictionary;
    private long count = 0;
    public Dictionary(String[] paths) throws IOException {
	this.dictionary = new HashMap<>();
	for (String path : paths)
	    this.fetchFromfile(path);
	System.out.println("\n\n");
    }
    
    private void fetchFromfile(String path) throws IOException {
	BufferedReader br = new BufferedReader(new FileReader(new File(path)));
	ArrayList<String> tempArrayList;
	String dictWord, key;

	while ((dictWord = br.readLine()) != null) {
	    dictWord = dictWord.toLowerCase();
	    key = bubbleSort(dictWord.toCharArray());
	    if (dictionary.containsKey(key)) {
		tempArrayList = dictionary.get(key);
		if (!tempArrayList.contains(dictWord))
		    dictionary.get(key).add(dictWord);
	    } else {
		ArrayList<String> t = new ArrayList<String>();
		t.add(dictWord);
		dictionary.put(key, t);
	    }
	    if (count % 2500 == 0) {
		System.out.print("\r");
		System.out.print(count + " words.");
	    }
	    count++;
	}
	br.close();
	System.out.print("\r");
	System.out.print(count + " words.");
    }

    public static String bubbleSort(char[] x) {
	int newLowest = 0; // index of first comparison
	int newHighest = x.length - 1; // index of last comparison

	while (newLowest < newHighest) {
	    int highest = newHighest;
	    int lowest = newLowest;
	    newLowest = x.length; // start higher than any legal index
	    for (int i = lowest; i < highest; i++) {
		if (x[i] > x[i + 1]) {
		    // exchange elements
		    char temp = x[i];
		    x[i] = x[i + 1];
		    x[i + 1] = temp;
		    if (i < newLowest) {
			newLowest = i - 1;
			if (newLowest < 0) {
			    newLowest = 0;
			}
		    } else if (i > newHighest) {
			newHighest = i + 1;
		    }
		}
	    }
	}
	return new String(x);
    }

    public boolean containsKey(String key) {
	return this.dictionary.containsKey(key);
    }

    public ArrayList<String> get(String key) {
	return this.dictionary.get(key);
    }

}
