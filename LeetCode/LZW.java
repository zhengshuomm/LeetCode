/**
 * Created by swang on 4/7/2017.
 * @author: Siyang Wang
 */
import java.util.Map;
import java.util.HashMap;

// Use ctrl+shift+F to format the file in Eclipse.

public class LZW {

    // Define variables will be used
    private static final int CHAR_SIZE = 256;  // Number of chars
    private static final int DICT_SIZE = 4096;  // Number of dictionary size
    private static final int CODE_SIZE = 12;   // Number of bits for one codeword

    /*
    * This is the encode function of LZW.
    *
    * @param data -- A string that needs to be encoded
    * @output -- A String of encodedData, each codeword should be 12 bits long in binary
    */
    public static String encode(String data) {
        StringBuilder encodedData = new StringBuilder();
        int pos_dict = CHAR_SIZE;

        // Build dictionary for all the basic characters
        Map<String, Integer> dictionary = new HashMap<String, Integer>();
        for(int i = 0 ; i < CHAR_SIZE; i ++){
            dictionary.put(Character.toString((char) i), i);
        }

        String pre = new String();                       // ???? Why new String().
        String pre_with_cur = new String();              // Ditto
        for (int i = 0 ; i < data.length(); i ++) {
			char cur = data.charAt(i);       // line?
            pre_with_cur = pre + cur;
            if (dictionary.containsKey(pre_with_cur)) {
                pre = pre_with_cur;
            } else {
                dictionary.put(pre_with_cur, pos_dict++);
                encodedData.append(_intTo12BitBinary(dictionary.get(pre)));
                pre = String.valueOf(cur);
            }
        }
        
	// Follow my previous comment.
	// For (int i = 0 ; i <= data.length(); i ++) {
        //      char cur = i == data.length() ? data.charAt(i) : '';
        //}
        //output for the last character, prevent scnario like "AAAAAAAA"
        if(dictionary.containsKey(pre)){
            encodedData.append(_intTo12BitBinary(dictionary.get(pre)));
        }

        return encodedData.toString();
    }



    /*
    * This is the decode function of LZW.
    * @param data -- A string that needs to be decoded.
    * @output -- A String
    */
    public static String decode(String data){
        StringBuilder decodedData = new StringBuilder();
        int pos_dict = CHAR_SIZE;

        //Build dictionary for all the basic characters
        HashMap<Integer, String> dic = new HashMap<Integer, String>();
        for(int i = 0 ; i < CHAR_SIZE; i ++){
            dic.put(i, Character.toString((char) i));
        }
        String cur = "";                 
        String pre = "";

        for(int i = 0 ; i < data.length() ; i = i + CODE_SIZE){
            int code = _12BitBinaryToInt(data, i, i + CODE_SIZE);
            if(dic.containsKey(code)){
                cur = dic.get(code);
            }else if (code == pos_dict){
                cur = cur + cur.charAt(0);
            }
            if(!pre.equals("")){              // pre.isEmpty()
                dic.put(pos_dict++, pre + cur.charAt(0));
            }
            decodedData.append(cur);
            pre = cur;
        }
        return decodedData.toString();
    }

	    // Function name. Don't you _ for start. binaryToInt.
    /*
    * This is the function to covert a binary string to an integer number
    * @param data -- A string of binary numbers, start position, end position
    * @output -- A number in decimal
    */
    private static int _12BitBinaryToInt(String input, int start, int end){
        int result = 0;
        int pos = 1;
        for(int i = end - 1; i >= start; i --){
            result += pos * (input.charAt(i) - '0');
            pos = (pos << 1);
        }
        return result;
    }
    
	
    // Function name. Don't you _ for start. intToBinary.
    /*
    * This is the function to convert an integer number to a binary string
    * @param data -- An integer number
    * @output -- A string of binary numbers
    */
    private static StringBuilder _intTo12BitBinary(int input){
        StringBuilder result = new StringBuilder();
        while(input > 0){
            result.insert(0, input % 2);
            input /= 2;
        }
        while(result.length() < CODE_SIZE){
            result.insert(0, 0);
        }
        return result;
    }

    // Do not need this main function. Write unit test in another file. https://www.tutorialspoint.com/junit/junit_test_framework.html
    // Just need to verify given a input, the result is expected. Using assertEquals.
    // Write three test cases.
    public static void main(String[] args) {
        LZW lzw = new LZW();

        String en = lzw.encode("ASDFAWEVA;J2310988HKJLJKH/VASDFASDFADSFAEFWFASDFHAoiejfp2938hflskjdpwo3rhq3jakfnlcnz,;OWEIFNOEKJFHOAWIEUHFAWIUEFHWIUEFH");
        System.out.println(en);

	String de = lzw.decode(en);
        System.out.print(de);
    }

}
