package lab07;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

import java.io.File;
import java.util.*;

public class Controller {
	@FXML public Canvas graphCanvas;
	@FXML public Canvas legendCanvas;

	private Color[] colors = {Color.RED, Color.CYAN, Color.GREEN, Color.YELLOW};

	public void initialize(){
		File file = new File("./weatherwarnings-2015.csv");
		Map<String, Integer> frequencyMap = parseWeatherWarnings( file );

		//Convert to arrays
		String[] keys = frequencyMap.keySet().toArray(new String[0]);
		int[] data = new int[ keys.length];
		for(int i = 0; i < keys.length; i++){
			data[i] = frequencyMap.get(keys[i]);
		}

		Draw.drawPieGraph( graphCanvas, data, colors );
		Draw.drawColorLegend( legendCanvas, keys, colors );
	}

	/**
	 * Takes in a csv file of weather warnings and returns a frequency map of weather types
	 * @param file Csv file to be read, weather type must be in 6th column
	 * @return Frequency map of each weather event
	 */
	private Map<String, Integer> parseWeatherWarnings( File file){
		Map<String, Integer> results = new TreeMap<>();
		try {
			Scanner scanner = new Scanner( file );
			scanner.useDelimiter( "\n" );
			while (scanner.hasNext()){
				String line = scanner.next();									// get full line of text
				String weatherType = line.split(",")[5];					// weather type is 6th value on the line

				if(results.containsKey( weatherType )){
					results.put(weatherType, results.get( weatherType ) + 1); 	//Increment weather frequency by one
				}else{
					results.put(weatherType, 1);								//Initialize weather frequency to one
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		return results;
	}
}