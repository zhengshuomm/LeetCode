/**
 * Created by swang on 4/7/2017.
 */
import java.util.Map;
import java.util.HashMap;

public class LZW {

	// Define variables will be used.
	private static final int CHAR_SIZE = 256; // Number of chars
	private static final int DICT_SIZE = 4096; // Number of dictionary size
	private static final int CODE_SIZE = 12; // Number of bits for one codeword

	/*
	 * This is the encode function of LZW.
	 * 
	 * @param data -- A string that needs to be encoded
	 * 
	 * @output -- A String of encodedData, each codeword should be 12 bits long
	 * in binary
	 */
	public String encode(String data) {
		// Establish dictionary for all the 256 basic characters.
		Map<String, Integer> dictionary = new HashMap<String, Integer>();
		for (int i = 0; i < CHAR_SIZE; i++) {
			dictionary.put(Character.toString((char) i), i);
		}

		StringBuilder encodedData = new StringBuilder();
		int posDic = CHAR_SIZE;
		// A variable used to represent previous sequence.
		String pre = "";
		// A variable used to represent previous sequence concatenate the current
		// character.
		String preWithCur = "";
		for (int i = 0; i < data.length(); i++) {
			char cur = data.charAt(i);
			preWithCur = pre + cur;
			if (dictionary.containsKey(preWithCur)) {
				pre = preWithCur;
			} else {
				dictionary.put(preWithCur, posDic++);
				encodedData.append(intToBinary(dictionary.get(pre)));
				pre = String.valueOf(cur);
			}
		}

		// Output for the last character, prevent scenario like "AAAAAAAA".
		if (dictionary.containsKey(pre)) {
			encodedData.append(intToBinary(dictionary.get(pre)));
		}

		return encodedData.toString();
	}

	/*
	 * This is the decode function of LZW.
	 * 
	 * @param data -- A string that needed to be decoded.
	 * 
	 * @output -- A String
	 */
	public String decode(String data) throws Exception {
		// Validate input, throw a invalid argument exception if not valid.
		if (!isValidateCodeWord(data)) {
			throw new IllegalArgumentException("Illegal code word");
		}

		// Establish dictionary for all the 256 basic characters.
		HashMap<Integer, String> dic = new HashMap<Integer, String>();
		for (int i = 0; i < CHAR_SIZE; i++) {
			dic.put(i, Character.toString((char) i));
		}

		StringBuilder decodedData = new StringBuilder();
		int posDic = CHAR_SIZE;
		// A variable used to represent current character.
		String cur = "";
		// A variable used to represent previous sequence.
		String pre = "";
		for (int i = 0; i < data.length(); i = i + CODE_SIZE) {
			int code = binaryToInt(data, i, i + CODE_SIZE);
			if (dic.containsKey(code)) {
				cur = dic.get(code);
			} else if (code == posDic) {
				cur += cur.charAt(0);
			}
			if (!pre.isEmpty()) {
				dic.put(posDic++, pre + cur.charAt(0));
			}
			decodedData.append(cur);
			pre = cur;
		}
		return decodedData.toString();
	}

	/*
	 * This is the function to convert a binary string to an integer.
	 * 
	 * @param data -- A string of binary numbers, start position, end position
	 * 
	 * @output -- A number in decimal
	 */
	private int binaryToInt(String input, int start, int end) {
		int result = 0;
		int pos = 1;
		for (int i = end - 1; i >= start; i--) {
			result += pos * (input.charAt(i) - '0');
			pos = (pos << 1);
		}
		return result;
	}

	/*
	 * This is the function to convert an integer number to a binary string.
	 * 
	 * @param data -- An integer number
	 * 
	 * @output -- A String of binary numbers
	 */
	private StringBuilder intToBinary(int input) {
		StringBuilder result = new StringBuilder();
		while (input > 0) {
			result.insert(0, input % 2);
			input /= 2;
		}
		while (result.length() < CODE_SIZE) {
			result.insert(0, 0);
		}
		return result;
	}

	/*
	 * This is the function to determine if the data is a valid codeword.
	 * 
	 * @param data -- A String of codeword
	 * 
	 * @output -- true if valid , false if not valid
	 * 
	 * validation -- The data is a string only contains 0 and 1, and the
	 * length is multiple of 12.
	 */
	private boolean isValidateCodeWord(String data) {
		if (data == null || data.length() % CODE_SIZE != 0) {
			return false;
		}
		for (int i = 0; i < data.length(); i++) {
			if (data.charAt(i) != '0' && data.charAt(i) != '1')
				return false;
		}
		return true;
	}
}
