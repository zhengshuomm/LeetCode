import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LZWTest {
	private LZW lzw;

	@Before
	public void setUp() {
		lzw = new LZW();
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testEncode() {
		String data = "ABCDEFG";
		assertEquals("00000100000100000100001000000100001100000100"
				+ "0100000001000101000001000110000001000111",
				lzw.encode(data));
	}

	@Test
	public void testEncodeSameSequence() {
		String data = "AAAAA";
		assertEquals("000001000001000100000000000100000000", lzw.encode(data));
	}

	@Test
	public void testDecode() throws Exception {
		String data = "0000010110100000010000010000010100010000010"
				+ "10111000001010011000001011000000001011000000001"
				+ "010011000001010111000001010001000001000001000001011010";
		assertEquals("ZAQWSXXSWQAZ", lzw.decode(data));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidDecodeData() throws Exception {
		lzw.decode("01234");
	}

	@Test
	public void testEncodeAndDecode() throws Exception {
		String data = "ABCABCABC";
		String encode_data = lzw.encode(data);
		assertEquals(data, lzw.decode(encode_data));
	}

}
