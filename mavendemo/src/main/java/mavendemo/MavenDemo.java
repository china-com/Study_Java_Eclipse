package mavendemo;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;

public class MavenDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String url="https://hr.tencent.com/position.php?&start=";
		ArrayList<String> urls=new ArrayList<String>();
		for(int i=0;i<3810;i+=10) {
			urls.add(url+i);
		}
		String u= urls.get(0);
		String body=Jsoup.connect(u).execute().body();
		System.out.println(body);
	}

}
