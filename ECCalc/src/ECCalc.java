import java.math.BigInteger;
//P=(8,10)
//15P=(14,23)
public class ECCalc {
	private static int p=29;
	private static int a=4;
	private static int b=20;
	
	public static void main(String[] args) {
		Integer[] pointA={14,6};
		Integer[] pointB={19,16};
		Integer[] res=getECAddResult(pointA,pointB);
		//Integer[] res=getECDoubleResult(pointA);
		System.out.println(res[0]+" "+res[1]);
	}
	
	public static Integer[] getECAddResult(Integer[] pointA,Integer[] pointB) {
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
	public static Integer[] getECDoubleResult(Integer[] point) {
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