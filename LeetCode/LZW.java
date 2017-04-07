import java.util.*;


public class LZW {
	private static final int CHAR_SIZE = 256;  //number of chars
	private static final int DICT_SIZE = 4096;  //number of dictionary size
	private static final int CODE_SIZE = 12;   //number of bits for one codeword
	
	private LZW(){}
	
	public static String encode(String data) {
		StringBuilder output = new StringBuilder();
        int pos_dict = CHAR_SIZE;

        //初始化dictionary
        HashMap<String, Integer> dic = new HashMap<String, Integer>();
        for(int i = 0 ; i < CHAR_SIZE; i ++){
        	dic.put((char)i + "", i);
        }
        String previous = new String();
        String pc = new String();
        for (char c : data.toCharArray()) {
            pc = previous + c;
            if (dic.containsKey(pc)) {
                previous = pc;
            } else {
                dic.put(pc, pos_dict++);
                output.append(_intTo12BitBinary(dic.get(previous)));
                previous = c + "";
            }
        }

        //最后一次输出
        if(dic.containsKey(previous)){
        	output.append(_intTo12BitBinary(dic.get(previous)));
        }
        System.out.println(pos_dict);
        
        return output.toString();
	}
	
	public static String decode(String data){
        StringBuilder result = new StringBuilder();	
		int pos_dict = CHAR_SIZE;

        //初始化dictionary
        HashMap<Integer, String> dic = new HashMap<Integer, String>();
        for(int i = 0 ; i < CHAR_SIZE; i ++){
        	dic.put(i, (char)i + "");
        }
        String c = "";
        String p = "";
        
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
	
	public static int _12BitBinaryToInt(String input, int start, int end){
		int result = 0;
		int pos = 1;
		for(int i = end - 1; i >= start; i --){
			result += pos * (input.charAt(i) - '0');
			pos = (pos << 1);
		}
		return result;
	}
	
	
	
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
		
		
		System.out.println(en);
		
		String de = decode(en);
		
		System.out.print(de);
	
		
	}
	
}
