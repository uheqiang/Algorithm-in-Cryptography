package org.xiaolu.dlp;

import java.math.BigInteger;

public class DLPModInverse {
	public static BigInteger requestModInverse(BigInteger a,BigInteger b) throws Exception {
		return a.modInverse(b);
	}
}