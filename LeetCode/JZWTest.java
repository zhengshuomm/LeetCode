import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LZWTest {
	private LZW lzw;

	@Before
	public void setUp() throws Exception {
		lzw = new LZW();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEncodeSameSequence() {
		String data = "AAAAA";
		assertEquals("000001000001000100000000000100000000", lzw.encode(data));
	}

	@Test
	public void testEncode() {
		String data = "ABCDEFG";
		assertEquals("000001000001000100000000000100000000", lzw.encode(data));
	}

	@Test
	public void testDecode() throws Exception {
		String data = "000001011010000001000001000001010001000001010111000001010011000001011000000001011000000001010011000001010111000001010001000001000001000001011010";
		assertEquals("ZAQWSXXSWQAZ", lzw.decode(data));
	}

	@Test(expected = RuntimeException.class)
	// INVALIDARGUMENT.
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
