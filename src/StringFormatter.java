import java.util.List;

public class StringFormatter {
	public static int totalLetters (List<String> wordList) {
		String listAsString = "";
		for(String word : wordList) {
			listAsString = listAsString + word;
		}
		return listAsString.length();
	}
	
	public static int basicGapWidth(List<String> wordList, int formattedLen) {
		//I assumed that formattedLen is the length of the formatted string, but that might have been wrong
		return (formattedLen - StringFormatter.totalLetters(wordList)) / (wordList.size() - 2);
	}
	
	public static int leftoverSpaces(List<String> wordList, int formattedLen) {
		return (formattedLen - StringFormatter.totalLetters(wordList)) % (wordList.size() - 2);
	}
	public static String format(List<String> wordList, int formattedLen) {
		String formattedStr = "";
		int extraSpaces = StringFormatter.leftoverSpaces(wordList, formattedLen);
		int spaceSize = StringFormatter.basicGapWidth(wordList, formattedLen);
		for(String word: wordList) {
			formattedStr = formattedStr + word;
			for(int i = spaceSize; i > 0; i--) {
				formattedStr = formattedStr + " ";
			}
			if(extraSpaces > 0) {
				formattedStr = formattedStr + word;
				extraSpaces--;
			}
		}
		return formattedStr;
		
	}
	
}