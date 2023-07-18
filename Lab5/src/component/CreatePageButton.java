package component;

import javafx.scene.layout.StackPane;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import pane.RootPane;
import javafx.scene.text.Font;

public class CreatePageButton extends StackPane{
	public CreatePageButton() {
		Circle circle = new Circle(20, Color.LIGHTGRAY);
		Text text = new Text("+");
		text.setFont(new Font(20));
		setCursor(Cursor.HAND);
		circle.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				RootPane.getNavigationPane().addPage();
				
			}
		});
		this.getChildren().addAll(circle,text);
	}
	
	
	

}
