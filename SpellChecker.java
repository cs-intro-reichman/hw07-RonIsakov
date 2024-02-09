
public class SpellChecker {


	public static void main(String[] args) {
		//String word = args[0];
		//int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker("h0llo", 1, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
		return str.substring(1);
	}

	public static int levenshtein(String word1, String word2) {
		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();
		int ans = -1;
		/* you could just return the value of ans each time instead of saving it into ans
		and by doing this you wold also avoid al the else's */
		if(word2.length()==0)
			ans = word1.length();
		else if(word1.length()==0)
			ans = word2.length();
		else if(word1.charAt(0) == word2.charAt(0))
			ans = levenshtein(tail(word1), tail(word2));
		else
			ans = 1 + Math.min(Math.min(levenshtein(tail(word1), word2),  levenshtein(word1, tail(word2))),  levenshtein(tail(word1), tail(word2)));
		return ans;
	}
	

	public static String[] readDictionary(String fileName) {
		In in = new In(fileName);
		String[] dictionary = new String[3000];
		for(int i=0 ;i<3000; i++){
		dictionary[i] = in.readString();
		}
		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
	String similar = "";
    int minDistance = Integer.MAX_VALUE;
	int i =0;
    for ( i = 0; i < dictionary.length; i++) {
        int distance = levenshtein(word, dictionary[i]);
        if (distance < minDistance) {
            minDistance = distance;
            similar = dictionary[i];
        }
    }

    if(minDistance <= threshold)
	return similar;
	else
	return word;

}
}
