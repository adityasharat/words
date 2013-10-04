package words;

import java.util.LinkedList;
import java.util.List;

public class Permutations {

    private static List<String> list;

    public static List<String> permutation(String str) {
	Permutations.list = new LinkedList<>();
	permutation("", str);
	return Permutations.list;
    }

    private static void permutation(String prefix, String str) {
	int n = str.length();
	if (n == 0)
	    Permutations.list.add(prefix);
	else {
	    for (int i = 0; i < n; i++)
		permutation(prefix + str.charAt(i),
			str.substring(0, i) + str.substring(i + 1, n));
	}
    }

    /*
     * public static void main(String[] args) { List<String> l =
     * Permutations.permutation("aabcde"); for (String s : l)
     * System.out.println(s); }
     */

}
