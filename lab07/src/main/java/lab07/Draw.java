package lab07;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Draw {


	/**
	 * Imported from lab 6
	 * Draws a pie chart taking up the full size of the canvas provided.
	 * @param canvas Canvas on which to draw
	 * @param data List of doubles
	 * @param colors Colors of each data segement;
	 */
	public static void drawPieGraph( Canvas canvas , int[] data, Color[] colors){
		final double SIZE_W = canvas.getWidth();
		final double SIZE_H = canvas.getHeight();

		GraphicsContext gc = canvas.getGraphicsContext2D();

		//Get sum of values
		int sum = 0;
		for(int a: data){
			sum += a;
		}

		//draw pie
		double lastAngle = 0;
		gc.setStroke( Color.BLACK );
		for(int i = 0; i < data.length; i++){
			gc.setFill( colors[i] );
			double arcAngle = ((double)data[i] / sum) * 360;
			gc.fillArc( 0,0,SIZE_W,SIZE_H,lastAngle,arcAngle,ArcType.ROUND );
			gc.strokeArc(0,0,SIZE_W, SIZE_H, lastAngle, arcAngle, ArcType.ROUND);
			lastAngle += arcAngle;

		}
	}

	/**
	 * Draws a legend of colors, usefull along side other graphs
	 * @param canvas canvas to draw on
	 * @param names array of strings, what each color represents
	 * @param colors array of colors, corresponds to names array
	 */
	public static void drawColorLegend (Canvas canvas , String[] names, Color[] colors){
		final double ITEM_HEIGHT = 20;
		final double ITEM_WIDTH = 50;
		final double ITEM_GAP = 10;
		final double TEXT_GAP = 10;

		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setStroke( Color.BLACK );

		double nextStartingPoint = 0;
		for(int i = 0; i < names.length; i++){
			gc.setFill( colors[i] );
			gc.fillRect( 0, nextStartingPoint, ITEM_WIDTH, ITEM_HEIGHT );
			gc.strokeRect( 0, nextStartingPoint, ITEM_WIDTH, ITEM_HEIGHT );
			gc.strokeText( names[i], ITEM_WIDTH + TEXT_GAP, nextStartingPoint + ITEM_HEIGHT/2 );
			nextStartingPoint += ITEM_HEIGHT + ITEM_GAP;
		}
	}
}
