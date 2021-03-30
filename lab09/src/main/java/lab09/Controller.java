package lab09;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;

import java.util.List;

public class Controller {

	@FXML private Canvas mainCanvas;

	public void initialize(){
		mainCanvas.setHeight( Main.stageHeight);
		mainCanvas.setWidth( Main.stageWidth );

		List<Double> stonks = StockHelpers.downloadStockPrices( "GOOG" );
		List<Double> lesserStonks = StockHelpers.downloadStockPrices("AAPL");

		DrawHelpers.drawLinePlot( mainCanvas, stonks, lesserStonks );
	}
}
