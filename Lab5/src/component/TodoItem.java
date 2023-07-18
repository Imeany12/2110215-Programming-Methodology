package component;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import pane.RootPane;

public class TodoItem extends HBox{
	public TodoItem(String value){
		setSpacing(10);
		Text text = new Text(value);
		text.setFont(new Font(20));
		Button btn =new Button("Delete");
		TodoItem object = this;
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
				RootPane.getDisplayPane().removeTodoItem(object);
				
			}
		});
		this.getChildren().addAll(text,btn);
	}
	

}
