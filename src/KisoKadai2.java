import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class KisoKadai2{

	public static void main(String args[]) {
        Random rnd = new Random();

        int que = rnd.nextInt(100)+1;
        System.out.println("1～100までの数字を当ててください 終了するには100より大きい数を入力してください");

        int cnt=0;

        boolean flag=true;

        while(flag){
        	cnt++;
        	int ans=ans();

        	if(ans>que){
        		System.out.println("Lowあなたの入力した値より小さいです");
        	}else{
        		System.out.println("Highあなたの入力した値より大きいです");
        	}
            if(ans==que){
            	flag=false;
            	System.out.println(que+"正解です"+cnt+"回かかりました");
            }
            if(ans>que){
            	flag=false;
            	System.out.println("終了します");
            }
        }
	}


	public static String StrAns() {
		String s = "";
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("入力してください：");

			s = br.readLine();

		} catch (IOException e) {
		}
		return s;
	}

	public  static int ans(){
		int i=0;
		String s= StrAns();

		i=Integer.parseInt(s);
		return i;
	}
}

