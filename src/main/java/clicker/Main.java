package clicker;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
	private String titleMessage;
	private int counter;
	private int r;
	private int g;
	private int b;
	
	{
		titleMessage = "Count me!";
		r = (int) (Math.random()*255);
		g = (int) (Math.random()*255);
		b = (int) (Math.random()*255);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		GridPane gridPane = new GridPane();

		Button btnPlus = new Button("( + )");
		btnPlus.setMinSize(100, 50);

		Button btnMinus = new Button("( - )");
		btnMinus.setMinSize(100, 50);

		Button btnRes = new Button("reset");
		btnRes.setMinSize(100, 50);

		TextArea text = new TextArea(titleMessage);
		text.setMaxSize(100, 50);
		text.setEditable(false);
		
		Rectangle rectangleL = new Rectangle(100,50); 
		rectangleL.setFill(Color.rgb(r, g, b));
		
		Rectangle rectangleR = new Rectangle(100,50);
		rectangleR.setFill(Color.rgb(r, g, b));
		

		btnPlus.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(counter < 10)
					counter++;
				else if(counter <100)
					counter+=2;
				else
					counter+=100;
				primaryStage.setTitle(titleMessage +" "+counter);
				text.setText(titleMessage +"\n"+ counter);
				r = Math.abs((r+1)%255);
				g = Math.abs((g+2)%255);
				b = Math.abs((b-3)%255);
				rectangleL.setFill(Color.rgb(r, g, b));
				rectangleR.setFill(Color.rgb(r, g, b));
			}
		});

		btnMinus.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				counter--;
				primaryStage.setTitle(titleMessage +" "+counter);
				text.setText(titleMessage +"\n"+ counter);
				r = Math.abs((r-1)%255);
				g = Math.abs((g-2)%255);
				b = Math.abs((b+3)%255);
				rectangleL.setFill(Color.rgb(r, g, b));
				rectangleR.setFill(Color.rgb(r, g, b));
			}
		});
		
		btnRes.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				counter = 0;
				primaryStage.setTitle(titleMessage);
				text.setText(titleMessage);
			}
		});

		GridPane.setRowIndex(btnPlus, 0);
		GridPane.setColumnIndex(btnPlus, 0);

		GridPane.setRowIndex(text, 0);
		GridPane.setColumnIndex(text, 1);

		GridPane.setRowIndex(btnMinus, 0);
		GridPane.setColumnIndex(btnMinus, 2);
		
		GridPane.setRowIndex(rectangleL, 1);
		GridPane.setColumnIndex(rectangleL, 0);		

		GridPane.setRowIndex(btnRes, 1);
		GridPane.setColumnIndex(btnRes, 1);
		
		GridPane.setRowIndex(rectangleR, 1);
		GridPane.setColumnIndex(rectangleR, 2);	

		gridPane.getChildren().addAll(btnPlus, text, btnMinus,rectangleL ,btnRes, rectangleR);

		primaryStage.setScene(new Scene(gridPane));
		primaryStage.setTitle(titleMessage);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}// start

	public static void main(String[] args) {
		launch(args);
	}

}// class Main
