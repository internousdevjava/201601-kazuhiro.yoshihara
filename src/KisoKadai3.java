import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class KisoKadai3 {


	public static void main(String[] args){
		boolean flag=true;

		String path0="c:\\temp";//スタートするフォルダ 存在しない場合
		String path=path0;

		while(flag){
			//メニュー
			System.out.println
			("メニュー\n 1ファイル作成:2:ファイル上書き3:ファイルに追記"
					+ "4:ファイルの読み込み5:ファイルの削除\n"
					+ "6:ディレクトリの作成10:パス移動11:パス確認\n100:終了します");

			String select=getstr();
			switch(select){

			case "1"://ファイルの作成
				System.out.println("txtファイルを作成するディレクトリを選択します");

				path=selectf(path);

				if (new File(path).isFile()){
					System.out.println("選択したのはファイルなので終了します");
				}else if(new File(path).isDirectory()){
				mkfile(path);
				}else{
					System.out.println("ファイルでもディレクトリでもありません");
				}
				break;

			case "2"://ファイルの上書き
				System.out.println("文字を上書きするファイルを選択します");
				path=selectf(path);
				if (new File(path).isFile()){
				filew(path);
				}else if (new File(path).isDirectory()){
					System.out.println("選択したのはディレクトリなので終了します");
				}else{
					System.out.println("ファイルでもディレクトリでもありません");
				}
				break;
			case "3":
				System.out.println("文字を追記するファイルを選択します");
				path=selectf(path);
				if (new File(path).isFile()){
				filea(path);
				}else if (new File(path).isDirectory()){
					System.out.println("選択したのはディレクトリなので終了します");
				}else{
					System.out.println("ファイルでもディレクトリでもありません");
				}
				break;
			case "4":
				System.out.println("読み込むファイルを選択してください");
				path=selectf(path);
				if (new File(path).isFile()){
				filer(path);
				}else if (new File(path).isDirectory()){
					System.out.println("選択したのはディレクトリなので終了します");
				}else{
					System.out.println("ファイルでもディレクトリでもありません");
				}
				break;
			case "5":
				System.out.println("削除するファイルを選択してください");
				path=selectf(path);
				deletef(path);
				break;

			case "6":
				System.out.println("新しいディレクトリを作成するディレクトリを選択してください");
				path=selectf(path);
				if (new File(path).isFile()){
					 System.out.println("選択したのはファイルなので終了します");
				}else if(new File(path).isDirectory()){
				mkdirs(path);
				}else{
					System.out.println("ファイルでもディレクトリでもありません");
				}
				break;
			case "10":
				path=cddir(path);
				System.out.print("選択してるパスは"+path+"です\n");
				break;
			case "11":
				System.out.println(path+"を選択しています");
				break;
			case "100":
				flag=false;
				System.out.println("終了します");
				break;
			default:
				System.out.println("表示されてる数字以外の入力です");
			break;
			}
		}
	}
	//文字入力

	//コンソールに文字列を入力させる
	public static String getstr() {
		String s = "";
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			s = br.readLine();
		} catch (IOException e) {
		}
		return s;
	}

	//yes or no
	public static boolean yorn(){
		while(true){
			System.out.println("(y/n)");
			switch (getstr()){
			case "y":
				return true;
			case "n":
				return false;
			default:
				break;
			}
		}
	}

	//ファイル上書き
	public static void filew(String s){
		try{
			System.out.println("文字を入力します");
			FileWriter fw =new FileWriter(s);
			fw.write(getstr());
	        fw.close();
	        } catch(Exception e){
	        	System.out.println("例外が発生したので終了します");
	        	}
		}

	//ファイル・フォルダのリストを表示して移動
	@SuppressWarnings("resource")
	public static String cddir(String s){
		 File cdirectory = new File(s);
		 if(cdirectory.isFile()){
			 System.out.println("選択してるのはファイルです");
			 return s;
		 }
		 else if(cdirectory.isDirectory()){
		 File filelist[] = cdirectory.listFiles();
		 if(filelist.length==0){
			 System.out.println("ファイル・フォルダが存在しません");
			 return s;
		 }
		 else{
		    for (int i = 0 ; i < filelist.length ; i++){
		      if (filelist[i].isFile()){
		        System.out.println(i+"[F]" + filelist[i].getName());
		      }else if (filelist[i].isDirectory()){
		        System.out.println(i+"[D]" + filelist[i].getName());
		      }else{
		        System.out.println(i+"[?]" + filelist[i].getName());
		      }
		    }
		    System.out.println("移動したいファイルまたはフォルダの番号をえらんでください");
		    	int select=0;
		    	try{
		    		select=new java.util.Scanner(System.in).nextInt();
		    	}catch(InputMismatchException e){
		    		System.out.println(e);
		    	}

		    if((select>=filelist.length)||(select<0)){
		    	System.out.println("終了します");
		    	return s;
		    }else{
		    return filelist[select].getAbsolutePath();
		    }
		 }
		 }
		 else{
			 System.out.println("選択したのはファイルでもディレクトリでもありません");
			 return s;
		 }
	 }

	//ファイル・ディレクトリ選択
	public static String selectf(String s){
		boolean flag=true;

		while(flag==true){
			System.out.println(s+"を選択しています\n続けて選択しますか？(y/n) bで親ディレクトリへ");
			switch(getstr()){
			case "y":
				s=cddir(s);
				break;
			case "n":
				flag=false;
				break;
			case "b":
				try {
					s=(new File(s).getParentFile()).getAbsolutePath();
				}catch(NullPointerException e){
					System.out.println("親ディレクトリが存在しません");
				}
				break;
			default :
				System.out.println("(y/n b)で選択してください");//c:でb の時 ぬるぽ
			 }
		}
		return s;
	}



	//リスト表示
 	public static void cd(String s){
		 File cdirectory = new File(s);

		    File filelist[] = cdirectory.listFiles();
		    for (int i = 0 ; i < filelist.length ; i++){
		      if (filelist[i].isFile()){
		        System.out.println(i+"[F]" + filelist[i].getName());
		      }else if (filelist[i].isDirectory()){
		        System.out.println(i+"[D]" + filelist[i].getName());
		      }else{
		        System.out.println(i+"[?]" + filelist[i].getName());
		      }
		    }
	}


	//ファイルの作成
	 public static void mkfile(String s){

		 System.out.println("作成するファイルの名前を書いてください(.txt)は要りません");
		 File newfile = new File(s+"\\"+getstr()+".txt");
		 try{
			 if(newfile.exists()){
				 System.out.println("すでに同じ名前のファイルが存在します");
			}else{
				 if (newfile.createNewFile()){
					 System.out.println(newfile.getName()+"の作成に成功しました");
					 }else{
						 System.out.println("ファイルの作成に失敗しました");
						 }
				 }
			 }catch(IOException e){
				 System.out.println(e);
				 }
	 }
	//ディレクトリの作成
	public static void mkdirs(String s){
		File newfile = new File(s+"\\"+getstr());
		if (newfile.mkdirs()){
		System.out.println("ディレクトリの作成に成功しました");
		}else{
		System.out.println("ディレクトリの作成に失敗しました");
		}
	}
	//ファイルの読み込み
	  public static void filer(String s){
		  try{
			  File file = new File(s);
			  if (checkBeforeReadfile(file)){
				  FileReader filereader = new FileReader(file);
				  int ch;
				  while((ch = filereader.read()) != -1){
					  System.out.print((char)ch);
					  }
				  filereader.close();
				  }else{
					  System.out.println("ファイルが見つからないか開けません");
					  }
			  }catch(FileNotFoundException e){
				  System.out.println(e);
				  }catch(IOException e){
					  System.out.println(e);
					  }
		  System.out.println("");
		  }
		  private static boolean checkBeforeReadfile(File file){
		    if (file.exists()){
		      if (file.isFile() && file.canRead()){
		        return true;
		      }
		    }

		    return false;
		  }
	//ファイルに文字追加
	public static void filea(String s){
		try{
			File file = new File(s);
			if (checkBeforeWritefile(file)){
				FileWriter filewriter = new FileWriter(file, true);
				filewriter.write("はい。元気です¥r¥n");
				filewriter.write("ではまた¥r¥n");
				filewriter.close();
				}else{
					System.out.println("ファイルに書き込めません");
					}
			}catch(IOException e){
				System.out.println(e);
				}
	}
		  private static boolean checkBeforeWritefile(File file){
			    if (file.exists()){
			      if (file.isFile() && file.canWrite()){
			        return true;
			      }
			    }

			    return false;
			  }

	//ファイルの削除
	public static boolean deletef(String s){
		 File file = new File(s);

		    if (file.exists()){
		    	System.out.print(file.getName()+"を本当に削除しますか");
		    	if(yorn()){
		    		if (file.delete()){
		    			System.out.println("ファイルを削除しました");
		    			return true;
		    		}else{
		    			System.out.println("ファイルの削除に失敗しました");
		    		}
		      }else{
		    	  System.out.println("終了します");
		      }
		    }else{
		      System.out.println("ファイルが見つかりません");
		    }
		    return false;
	 }
}
