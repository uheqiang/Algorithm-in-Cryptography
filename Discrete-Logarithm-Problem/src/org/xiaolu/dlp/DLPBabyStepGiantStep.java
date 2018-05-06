package org.xiaolu.dlp;

import java.math.BigInteger;

public class DLPBabyStepGiantStep implements DLPResult{
	public Integer getDLPResult(Integer cyclicGroupOrder,Integer primitiveElement,Integer bInteger) throws Exception{
		BigInteger cyclicGroup=new BigInteger(cyclicGroupOrder.toString());
		--cyclicGroupOrder;
		BigInteger a=new BigInteger(primitiveElement.toString());
		BigInteger b=new BigInteger(bInteger.toString());
		Integer m=(int)Math.sqrt(cyclicGroupOrder.doubleValue());
		if(!cyclicGroupOrder.equals(m*m)) {
			++m;
		}
		Integer xg=0;
		Integer xb=0;
		BigInteger temp=BigInteger.ZERO;
		BigInteger temp1=BigInteger.ZERO;;
		BigInteger[] array=new BigInteger[m];
		for(int i=0;i<m;++i) {
			array[i]=(a.pow(i)).mod(new BigInteger(cyclicGroup.toString()));
		}
		while(xg<m) {
			temp1=DLPModInverse.requestModInverse(a.pow(m), cyclicGroup);
			temp1=temp1.pow(xg);
			temp=(b.multiply(temp1)).mod(cyclicGroup);
			xb=0;
			while(xb<array.length) {
				if(((array[xb].subtract(temp)).mod(cyclicGroup)).equals(BigInteger.ZERO)) {
					return (xg*m+xb)%(cyclicGroupOrder);
				}
				++xb;
			}
			++xg;
		}
		throw new Exception("No Such Result");
	}
}