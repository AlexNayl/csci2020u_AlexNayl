package lab09;

import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class stores misc functions relating to stock data
 */
public class StockHelpers {

	/**
	 * downloads the selected stocksymble and returns a list of its adjusted closing values
	 * @param stockSymbol String of the stock symbol, eg "GOOG"
	 * @return List of doubles, containing adjusted closing values
	 */
	public static List<Double> downloadStockPrices(String stockSymbol){
		List<Double> results = new ArrayList<>();
		try{
			//assemble the source url for the target stock
			String urlString = "https://query1.finance.yahoo.com/v7/finance/download/"
							+ stockSymbol + "?"
							+ "period1=1262322000&"
							+ "period2=1451538000&"
							+ "interval=1mo&"
							+ "events=history&"
							+ "includeAdjustedClose=true";

			//open connection and prep inputstream
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			conn.setDoOutput( false );
			conn.setDoInput( true );
			Scanner in = new Scanner(conn.getInputStream());

			//Drop the header line, we don't want it
			in.nextLine();
			//parse the inputstream into the array of results
			while(in.hasNext()){
				String currentLine = in.nextLine();
				String[] items = currentLine.split( "," );
				String adjClose = items[5];					//The adjusted close column from this source is column 5
				results.add( Double.parseDouble( adjClose ));
			}
		}catch(Exception e){
			e.printStackTrace();
		}




		return results;
	}
}
