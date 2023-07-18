package pane;

import component.TodoItem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class InputPane extends HBox {
    public InputPane() {
        // TODO: FILL CODE
    	this.setPrefHeight(70);
    	this.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null,null)));
    	this.setSpacing(20);
    	this.setAlignment(Pos.CENTER);
    	TextField textField = new TextField();
    	textField.setPrefWidth(300);
    	Button button = new Button("Submit");
    	button.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if (!textField.getText().isEmpty()) {
		    		TodoItem newTodoItem = new TodoItem(textField.getText());
		    		RootPane.getDisplayPane().addTodoItem(newTodoItem);
		    		textField.clear();
		    	}
				
			}
		});
    	
    	this.getChildren().addAll(textField,button);
    }
}
