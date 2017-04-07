import java.util.*;                     // import whatever needed
					// delete this line, format the file first and then let me see it.

public class LZW {
	private static final int CHAR_SIZE = 256;  //number of chars
	private static final int DICT_SIZE = 4096;  //number of dictionary size
	private static final int CODE_SIZE = 12;   //number of bits for one codeword
	
	private LZW(){}      // why need this
	
	public static String encode(String data) {               // format this function
		StringBuilder output = new StringBuilder();      // output -> encodedData
        int pos_dict = CHAR_SIZE;	// variable name.

        //初始化dictionary                    // English comment
        HashMap<String, Integer> dic = new HashMap<String, Integer>();     // dic -> dictionary, use Map
        for(int i = 0 ; i < CHAR_SIZE; i ++){
        	dic.put((char)i + "", i);             // ???????? 
        }					// add blank line
        String previous = new String();		// stringbuilder, new String()???????
        String pc = new String();	// better name and use stringbuilder.
        for (char c : data.toCharArray()) {		// better name for c.
            pc = previous + c;
            if (dic.containsKey(pc)) {
                previous = pc;
            } else {
                dic.put(pc, pos_dict++);
                output.append(_intTo12BitBinary(dic.get(previous)));
                previous = c + "";			// String.valueOf(char ) or Character.toString(char )
            }
        }
		
	// dont' like this. combine this in the former foo loop.
	// foo (int i = 0 ; i <= data.length() ; i ++) {
	//   char c = i == data.length ? data.charAt(i) : '';
	//    .....
	// }
        //最后一次输出
        if(dic.containsKey(previous)){
        	output.append(_intTo12BitBinary(dic.get(previous)));
        }
        System.out.println(pos_dict);  //remove
        
        return output.toString();
	}
	
	public static String decode(String data){
        StringBuilder result = new StringBuilder();	   // decodedData
		int pos_dict = CHAR_SIZE;       // name

	// ditto
        //初始化dictionary
        HashMap<Integer, String> dic = new HashMap<Integer, String>();
        for(int i = 0 ; i < CHAR_SIZE; i ++){
        	dic.put(i, (char)i + "");      // (char)i + "" ???????? find a better way, ugly write like this
        }
        String c = "";		// string builder
        String p = "";          // stringbuilder
        
        for(int i = 0 ; i < data.length() ; i = i + CODE_SIZE){
        	int code = _12BitBinaryToInt(data, i, i + CODE_SIZE);
        	if(dic.containsKey(code)){
        		c = dic.get(code);
        	}else if (code == pos_dict){
        		c = c + c.charAt(0);
        	}
        	
        	if(!p.equals("")){
        		dic.put(pos_dict++, p + c.charAt(0));
        	}
        	result.append(c);
        	p = c;
        	
        }
        return result.toString();
	}
	
	// function name
	public static int _12BitBinaryToInt(String input, int start, int end){
		int result = 0;
		int pos = 1;
		for(int i = end - 1; i >= start; i --){
			result += pos * (input.charAt(i) - '0');
			pos = (pos << 1);
		}
		return result;
	}
	
	
	// why return string builder? function name
	public static StringBuilder _intTo12BitBinary(int input){
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
	
	
	public static void main(String[] args) {
		String en = encode("ASDFAWEVA;J2310988HKJLJKH/VASDFASDFADSFAEFWFASDFHAoiejfp2938hflskjdpwo3rhq3jakfnlcnz,;OWEIFNOEKJFHOAWIEUHFAWIUEFHWIUEFH");
		// LZW lzw = new LZW();
		// lzw.encode()
		
		System.out.println(en);
		
		String de = decode(en);
		
		System.out.print(de);
	
		
	}
	
}

// Didn't look you code logic, code style is very very bad. Variable name, format, (char)i + "" use java library.
