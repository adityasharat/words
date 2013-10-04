package words;

import java.io.IOException;
import java.util.List;

public class FindWords {

    public static void main(String[] args) {

	String[] paths = { "english.0", "english.1", "english.2", "english.3" };

	Dictionary dict = null;
	try {
	    dict = new Dictionary(paths);
	} catch (IOException e) {
	    System.err
		    .println("IOException occured while loading the dictionary.");
	    System.exit(-1);
	}

	if (args.length != 3) {
	    System.err.println("parameters missing.");
	    System.exit(-1);
	}

	int size = 0;
	try {
	    size = Integer.parseInt(args[2]);
	} catch (NumberFormatException e) {
	    System.err.println("Size must be a positive integer.");
	    System.exit(-1);
	}
	
	Combinations cmb = new Combinations(args[1], size);
	List<String> list = cmb.getList();
	cmb = null;

	boolean noWordsFound = true;
	String key;

	for (String s : list) {
	    key = Dictionary.bubbleSort(s.toCharArray());
	    if (dict.containsKey(key)) {
		noWordsFound = false;
		for (String w : dict.get(key))
		    System.out.println(w);
	    }
	}

	if (noWordsFound)
	    System.out.println("No Words Found");

    }

}
