package lab06;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Draw {
	public static void drawBarGraph( Canvas canvas, double[] dataA, double[] dataB){
		Color colorA = Color.RED;
		Color colorB = Color.BLUE;

		final double SIZE_W = canvas.getWidth();
		final double SIZE_H = canvas.getHeight();

		GraphicsContext gc = canvas.getGraphicsContext2D();

		double groupWidth = SIZE_W / dataA.length;
		double barWidth = groupWidth * 0.4;

		//Get the largest value
		double largestValue = 0;
		for(double val: dataA){
			if(val > largestValue){
				largestValue = val;
			}
		}
		for(double val: dataB){
			if(val > largestValue){
				largestValue = val;
			}
		}

		//Draw the bars
		for(int i = 0; i < dataA.length; i++){
			gc.setFill( colorA );
			double barLength = (dataA[i]/largestValue)*SIZE_H;
			gc.fillRect( groupWidth*i , SIZE_H - barLength, barWidth, barLength);

			gc.setFill( colorB );
			barLength = (dataB[i]/largestValue)*SIZE_H;
			gc.fillRect( groupWidth*i + barWidth, SIZE_H - barLength, barWidth, barLength);
		}
	}

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
		for(int i = 0; i < data.length; i++){
			gc.setFill( colors[i] );
			double arcAngle = ((double)data[i] / sum) * 360;
			gc.fillArc( 0,0,SIZE_W,SIZE_H,lastAngle,arcAngle,ArcType.ROUND );
			lastAngle += arcAngle;

		}
	}
}
