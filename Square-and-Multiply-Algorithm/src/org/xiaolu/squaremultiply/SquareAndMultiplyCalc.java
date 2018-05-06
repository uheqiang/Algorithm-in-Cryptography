package org.xiaolu.squaremultiply;

public class SquareAndMultiplyCalc {
	private int baseElement,exponent,modulus;
	public SquareAndMultiplyCalc(int baseElement,int exponent,int modulus) {
		this.baseElement=baseElement;
		this.exponent=exponent;
		this.modulus=modulus;
	}
	public Integer getSquareAndMultipyResult() {
		byte[] expBinaryArray=Integer.toBinaryString(exponent).getBytes();
		int result=baseElement;
		for(int i=1;i<expBinaryArray.length;++i) {
			result=(result*result)%modulus;
			if(expBinaryArray[i]=='1') {
				result=(result*baseElement)%modulus;
			}
		}
		return result;
	}
}
