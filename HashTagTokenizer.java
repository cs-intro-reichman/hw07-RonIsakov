

public class HashTagTokenizer {

	public static void main(String[] args) {
		String hashTag = "loveyouman";
		//String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
		
		
		//System.out.println(existInDictionary("ron",dictionary));
		//System.out.println(dictionary[6]);
	}
	

	public static String[] readDictionary(String fileName) {
		In in = new In(fileName);
		String[] dictionary = new String[3000];
		for(int i=0 ;i<3000; i++){
		dictionary[i] = in.readString();
		}
		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {
	boolean check =false;
	for(int i=0;i<3000;i++){
		if(word.equals(dictionary[i])){
			check = true;
			break;
		}
	}
	return check;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {
		
		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
        int N = hashtag.length();
        for (int i = 1; i <=N && !hashtag.isEmpty(); i++) {
			if(existInDictionary(hashtag.substring(0,i), dictionary)) {
				System.out.println(hashtag.substring(0,i));	
				hashtag = hashtag.substring(i);
				breakHashTag(hashtag, dictionary);
				break;
			}
        }
    }

}

