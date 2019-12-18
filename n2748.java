import java.io.*;

public class n2747{
	public static long[] list;

	public static long dp(int n){
		if(n==0) list[0]=0;
		else if(n==1) list[1]=1;
		else if(n==2) list[2]=1;
		else if(list[n]==0)  {
			list[n] = dp(n-2)+dp(n-1);
		}
		return list[n];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		list = new long[n+1];
		System.out.print(dp(n));
	} 

}