package words;

import java.util.LinkedList;
import java.util.List;

public class Combinations {
    
    private char[] charSet;
    private int size;
    private List<String> list;

    public Combinations(String charSet, int size) {
	this.charSet = charSet.toCharArray();
	this.size = size;
	this.list = new LinkedList<>();

	char[] data = new char[size];

	this.generateCombination(this.charSet, data, 0, charSet.length() - 1,
		0, this.size);

    }

    public Combinations(char[] charSet, int size) {
	this.charSet = charSet;
	this.size = size;
	this.list = new LinkedList<>();

	char[] data = new char[size];

	this.generateCombination(this.charSet, data, 0, charSet.length - 1, 0,
		this.size);
    }

    private void generateCombination(char[] arr, char[] data, int start, int end,
	    int index,
	    int r) {
	// Current combination is ready to be printed, print it
	if (index == r) {
	    StringBuilder sb = new StringBuilder();
	    for (char c : data) {
		// System.out.print(c);
		sb.append(c);
	    }
	    // System.out.println();
	    this.list.add(sb.toString());
	    return;
	}

	// replace index with all possible elements. The condition
	// "end-i+1 >= r-index" makes sure that including one element
	// at index will make a combination with remaining elements
	// at remaining positions
	for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
	    data[index] = arr[i];
	    generateCombination(arr, data, i + 1, end, index + 1, r);

	    // Remove duplicates
	    // while (arr[i] == arr[i + 1])
	    // i++;
	}
    }

    public void printCombination() {
	System.out.println();
	for (String s : this.list)
	    System.out.println(s);
    }

    public List<String> getList() {
	return this.list;
    }

    /*
     * public static void main(String args[]) { Combinations cmb = new
     * Combinations(new char[] { 'a', 'a', 'b', 'c', 'd', 'e' }, 3);
     * cmb.print(); }
     */

}
