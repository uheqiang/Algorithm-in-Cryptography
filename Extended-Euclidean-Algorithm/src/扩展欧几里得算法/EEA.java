package 扩展欧几里得算法;
import java.util.Scanner;
import java.math.BigInteger;
public class EEA {
	public static String requestModInverseByEEA (String ai,String bi) {
		BigInteger a=new BigInteger(ai);
		BigInteger b=new BigInteger(bi);
		boolean isSmall=false;
		if(a.compareTo(b)<0) {
			System.out.println("Warning:"+a.toString()+"<"+b.toString()+",exchange them");
			BigInteger temp=a;
			a=b;
			b=temp;
			isSmall=true;
		}
		BigInteger simm=new BigInteger("1");
		BigInteger timm=new BigInteger("0");
		BigInteger sim=new BigInteger("0");
		BigInteger tim=new BigInteger("1");
		BigInteger rim=b,ri=a.remainder(b),qim=a.divide(b),qi,temp;
		while(ri.toString()!="0") {
			qi=rim.divide(ri);
			temp=sim;
			sim=simm.subtract(qim.multiply(sim));
			simm=temp;
			temp=tim;
			tim=timm.subtract(qim.multiply(tim));
			timm=temp;
			qim=qi;
			temp=ri;
			ri=rim.remainder(ri);
			rim=temp;
		}
		if(isSmall==true) {
			return tim.toString();
		}
		else {
			return sim.toString();
		}
	}
	public static String requestModInverse(String a,String b) {
		BigInteger ai=new BigInteger(a);
		BigInteger bi=new BigInteger(b);
		return ai.modInverse(bi).toString();
	}
	public static void main(String args[]) throws Exception {
		System.out.println("请输入两个数:");
		String a,b;
		Scanner scan=new Scanner(System.in);
		a=scan.next();
		b=scan.next();
		scan.close();
		String result=requestModInverseByEEA(a,b);
		String right=requestModInverse(a,b);
		System.out.println(a+"^-1 mod "+b+"="+result);
		System.out.println(a+"^-1 mod "+b+"="+right);
	}
}
//37975227936943673922808872755445627854565536638199
//150341221