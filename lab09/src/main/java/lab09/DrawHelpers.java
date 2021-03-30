package lab09;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

/**
 * this class stores misc draw functions
 */
public class DrawHelpers {

	/**
	 * Plots a line graph of the given data lists onto the supplied canvas
	 * @param canvas Canvas to be drawn on
	 * @param data1 set of data points for line 1
	 * @param data2 set of data points for line 2 (of same size as data 1)
	 */
	public static void drawLinePlot( Canvas canvas, List<Double> data1, List<Double> data2 ){

		final double PADDING = 50;

		//Error checks
		if(canvas == null || data1 == null || data2 == null || data1.size() != data2.size()) {
			System.err.println("ERROR: invalid parameters.");
			return;
		}

		GraphicsContext gc = canvas.getGraphicsContext2D();

		double graphHeight = canvas.getHeight() - PADDING * 2;
		double graphWidth = canvas.getWidth() - PADDING * 2;

		//Draw the origin lines
		gc.setStroke( Color.BLACK );
		gc.strokeLine( PADDING, PADDING, PADDING, graphHeight + PADDING);
		gc.strokeLine( PADDING, graphHeight + PADDING, graphWidth + PADDING, graphHeight + PADDING);

		//Calculate the highest value in the data (needed to scale the graph)
		double maxValue = -999999999999.0;
		for ( double a:data1 ) {
			if(a > maxValue){
				maxValue = a;
			}
		}
		for ( double a:data2 ) {
			if(a > maxValue){
				maxValue = a;
			}
		}

		gc.setStroke( Color.RED );
		plotLine(gc, graphWidth, graphHeight, PADDING, PADDING, maxValue, data1);
		gc.setStroke( Color.BLUE );
		plotLine(gc, graphWidth, graphHeight, PADDING, PADDING, maxValue, data2);
	}

	public static void plotLine( GraphicsContext gc, double sizeX, double sizeY, double offsetX, double offsetY,
								 double topValue, List<Double> data ){
		double pointSpacing = sizeX / data.size();
		double lastX = offsetX;
		double lastY = sizeY + offsetY - ((data.get( 0 )/topValue) * sizeY);
		for ( int i = 1; i < data.size(); i++ ) {
			double y = sizeY + offsetY - ((data.get( i )/topValue) * sizeY);
			double x = lastX + pointSpacing;
			gc.strokeLine(lastX, lastY, x, y);
			lastX = x;
			lastY = y;
		}
	}
}
