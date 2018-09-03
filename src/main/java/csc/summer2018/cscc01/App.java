package csc.summer2018.cscc01;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws IOException
    {
        // go through each of the given URLs
    	for (int i = 0; i < args.length; i++) {
    		// get the document from the URL
    		org.jsoup.nodes.Document doc = null;
    		// try to get the doc
			try {
				// connect to the site
				doc = Jsoup.connect(args[i]).get();
			// invalid url
			} catch (IllegalArgumentException e) {
				// print out invalid URL
				System.err.println("Invalid URL: " + args[i]);
				// TODO Auto-generated catch block
				e.printStackTrace();
				// make a newline before going to next URL
				System.out.println("");
			}
			// if the connection worked
			if (doc != null) {
				// print the title of the document
	    		System.out.println("title : " + doc.title() + "\n");
	    		// get all the hrefs in the document
	    		Elements hrefs = doc.select("a[href]");
	    		// go through the hrefs
	    		for (Element link : hrefs) {
	    			// print the link
	    			System.out.println("link : " + link.attr("href"));
	    			// print the text
	    			System.out.println("text : " + link.text() + "\n");
	    		}
			}
    	}
    }
}
