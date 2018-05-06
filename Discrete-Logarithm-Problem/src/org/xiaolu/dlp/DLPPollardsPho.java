package org.xiaolu.dlp;

import java.math.BigInteger;

public class DLPPollardsPho implements DLPResult {
	public Integer getDLPResult(Integer cyclicGroupOrder,Integer primitiveElement,Integer bInteger) throws Exception{
		BigInteger N=new BigInteger(cyclicGroupOrder.toString());
		--cyclicGroupOrder;
		BigInteger n=new BigInteger(cyclicGroupOrder.toString());
		BigInteger alpha=new BigInteger(primitiveElement.toString());
		BigInteger beta=new BigInteger(bInteger.toString());
		BigInteger x=BigInteger.ONE;
		BigInteger a=BigInteger.ZERO;
		BigInteger b=BigInteger.ZERO;
		BigInteger X=x,A=a,B=b;
		int i;
		for(i=1;i<n.intValue();++i) {
			BigInteger temp=x.mod(new BigInteger("3"));
			if(temp.equals(BigInteger.ZERO)) {
				x=(x.multiply(x).mod(N));
				a=(a.multiply(new BigInteger("2")).mod(n));
				b=(b.multiply(new BigInteger("2")).mod(n));
			}
			else if(temp.equals(BigInteger.ONE)) {
				x=(x.multiply(alpha).mod(N));
				a=(a.add(BigInteger.ONE).mod(n));
			}
			else if(temp.equals(new BigInteger("2"))) {
				x=(x.multiply(beta).mod(N));
				b=(b.add(BigInteger.ONE).mod(n));
			}
			temp=X.mod(new BigInteger("3"));
			if(temp.equals(BigInteger.ZERO)) {
				X=(X.multiply(X).mod(N));
				A=(A.multiply(new BigInteger("2")).mod(n));
				B=(B.multiply(new BigInteger("2")).mod(n));
			}
			else if(temp.equals(BigInteger.ONE)) {
				X=(X.multiply(alpha).mod(N));
				A=(A.add(BigInteger.ONE).mod(n));
			}
			else if(temp.equals(new BigInteger("2"))) {
				X=(X.multiply(beta).mod(N));
				B=(B.add(BigInteger.ONE).mod(n));
			}
			temp=X.mod(new BigInteger("3"));
			if(temp.equals(BigInteger.ZERO)) {
				X=(X.multiply(X).mod(N));
				A=(A.multiply(new BigInteger("2")).mod(n));
				B=(B.multiply(new BigInteger("2")).mod(n));
			}
			else if(temp.equals(BigInteger.ONE)) {
				X=(X.multiply(alpha).mod(N));
				A=(A.add(BigInteger.ONE).mod(n));
			}
			else if(temp.equals(new BigInteger("2"))) {
				X=(X.multiply(beta).mod(N));
				B=(B.add(BigInteger.ONE).mod(n));
			}
			if(x.equals(X)) {
				break;
			}
		}
		BigInteger Aa=A.subtract(a).add(n).mod(n);
		BigInteger bB=b.subtract(B).add(n).mod(n);
		if(bB.equals(BigInteger.ZERO)) {
			throw new Exception("No Such Result");
		}
		BigInteger gcd = Aa.gcd(bB.gcd(n));
		Aa=Aa.divide(gcd);
		bB=bB.divide(gcd);
		n=n.divide(gcd);
		BigInteger result=Aa.multiply(DLPModInverse.requestModInverse(bB,n));
		result=result.mod(n);
		return result.intValue();
	}
}
