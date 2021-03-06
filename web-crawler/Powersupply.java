package newegg;
import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Powersupply {

	public static void main(String[] args) throws IOException {
		
		Document d = Jsoup.parse(new File("C:\\Users\\noden\\Documents\\p16.html"), "UTF-8");
		Writer writer = new FileWriter("c:\\data\\PowerSupply.txt", true);

		Element table = d.select("ul#category_content").first();
		Elements rows = table.select("li");
		
		for(Element row : rows) {
			Element namediv = row.select("div.title").first();
			Element pricediv = row.select("div.price").first();
			Element imagediv = row.select("div.image").first();
			
			if(pricediv != null && pricediv.text().contains("$")){
				String imageurl = imagediv.select("img").attr("src");
				if(imageurl.contains("http")){
					String a = namediv.text();
					String name = a.substring(0, a.lastIndexOf(" ")) + "\n" + "Power Rating: " + a.substring(a.lastIndexOf(" ") + 1);
					System.out.println(name);
					writer.write(name + "\n");				
				
					Elements divlist = row.select("div");
					for(Element div : divlist) {
						if(div.text().toLowerCase().contains("type"))	{
							System.out.println(div.text());
							writer.write("Form Factor: " + div.text() + "\n");
						}
					}
					
					System.out.println(pricediv.text());
					writer.write(pricediv.text() + "\n");
					System.out.println(imageurl + "\n");
					writer.write(imageurl + "\n\n");
				}
				
				else if(imageurl.contains("no-image")){
					continue;
				}
				
				else {
					String a = namediv.text();
					String name = a.substring(0, a.lastIndexOf(" ")) + "\n" + "Power Rating: " + a.substring(a.lastIndexOf(" ") + 1);
					System.out.println(name);
					writer.write(name + "\n");				
				
					Elements divlist = row.select("div");
					for(Element div : divlist) {
						if(div.text().toLowerCase().contains("type"))	{
							System.out.println(div.text());
							writer.write("Form Factor: " + div.text() + "\n");
						}
					}
					
					System.out.println(pricediv.text());
					writer.write(pricediv.text() + "\n");
					System.out.println("http:" + imageurl + "\n");
					writer.write("http:" + imageurl + "\n\n");
				}	
			}
		}
		writer.close();
	}

}