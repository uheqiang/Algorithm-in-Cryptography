package org.xiaolu.doubleadd;

import java.math.BigInteger;

public class ECDoubleAndAddCalc {
	private Integer p,a,b,pointX,pointY,mul;
	public ECDoubleAndAddCalc(int p,int a,int b,int pointx,int pointy,int mul) {
		this.p=p;
		this.a=a;
		this.b=b;
		this.pointX=pointx;
		this.pointY=pointy;
		this.mul=mul;
	}
	public Integer[] getECDoubleAndAddResult() {
		byte[] mulBinaryArray=Integer.toBinaryString(mul).getBytes();
		Integer[] p={pointX,pointY};
		Integer[] result=p;
		System.out.println("0 "+1+" ("+result[0]+","+result[1]+")");
		for(int i=1;i<mulBinaryArray.length;++i) {
			result=this.getECDoubleResult(result);
			if(mulBinaryArray[i]=='1') {
				result=this.getECAddResult(result,p);
			}
			System.out.println(i+" "+(mulBinaryArray[i]-48)+" ("+result[0]+","+result[1]+")");
		}
		return result;
	}
	private Integer[] getECAddResult(Integer[] pointA,Integer[] pointB) {
		int faiA=pointB[1]-pointA[1];
		int faiB=pointB[0]-pointA[0];
		BigInteger big_faiB=BigInteger.valueOf(faiB);
		faiB=big_faiB.modInverse(BigInteger.valueOf(p)).intValue();
		int fai=(faiA*faiB)%p;
		int resultX=(fai*fai-pointA[0]-pointB[0])%p;
		int resultY=(fai*(pointA[0]-resultX)-pointA[1])%p;
		Integer[] result={resultX,resultY};
		return result;
	}
	private Integer[] getECDoubleResult(Integer[] point) {
		int faiA=3*point[0]*point[0]+a;
		int faiB=2*point[1];
		BigInteger big_faiB=BigInteger.valueOf(faiB);
		faiB=big_faiB.modInverse(BigInteger.valueOf(p)).intValue();
		int fai=(faiA*faiB)%p;
		int resultX=(fai*fai-2*point[0])%p;
		int resultY=(fai*(point[0]-resultX)-point[1])%p;
		Integer []result={resultX,resultY};
		return result;
	}
}
