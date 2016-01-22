
public class KisoKadai1 {

	public static void main(String[] args) {
		int x,y,i,j,k;
		x=100;
		y=100;

		for(i=1;i<=y;i++){
			for(j=1;j<=x;j++){
				for(k=0;(keta(i*j)+k)<keta(x*y);k++){
					System.out.print("0");
				}
				System.out.print(i*j+" ");
			}
			System.out.println();
		}

	}

	public static int keta(int i){
		int j=0;
		for(int k=1;(k-1)<i;k=k*10){//(k-1) 0,9,99,999...
			j++;
		}

		return j;
	}

}
