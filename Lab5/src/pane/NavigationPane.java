package pane;

import component.CreatePageButton;
import component.PageButton;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class NavigationPane extends VBox {
    private final ArrayList<PageButton> pageButtons = new ArrayList<>();
    private int currentPage;

    public NavigationPane() {
        this.setPrefWidth(80);
        this.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        this.setSpacing(15);
        this.setPadding(new Insets(15));

        CreatePageButton createPageButton = new CreatePageButton();
        
        this.getChildren().add(createPageButton);
    }

    public void addPage() {
        // TODO: FILL CODE HERE
    	int page ;
    	if (pageButtons.isEmpty()) {
    		page = 0;
    	} else {
    		page = pageButtons.size();
    	}
    	PageButton newPageButtom = new PageButton(page);
    	pageButtons.add(newPageButtom);
    	this.getChildren().add(pageButtons.size()-1,newPageButtom); 
    	RootPane.getDisplayPane().addTodoList();
    	this.setCurrentPage(page);
    	
    	

    	
    }

    public int getCurrentPage() {
        // TODO: FILL CODE HERE
    	return currentPage;
    }

    public void setCurrentPage(int pageNumber) {
        // TODO: FILL CODE HERE
    	if (pageNumber >= 0&& pageNumber< (pageButtons.size())) {
    		pageButtons.get(currentPage).setActive(false);
    		currentPage =pageNumber ;
    		pageButtons.get(pageNumber).setActive(true);
    		RootPane.getDisplayPane().setActiveTodoList(pageNumber);
    	} 
    }
}
