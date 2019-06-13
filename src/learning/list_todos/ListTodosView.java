package learning.list_todos;

import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import learning.Store;

public class ListTodosView extends HBox
{
    public Label label;

    public ListTodosView(Store store)
    {
        setId("listTodoView");
        setPrefWidth(100);

        this.label = new Label();
        this.label.setId("todos");

        getChildren().add(this.label);

        store.getTodos().addListener((ListChangeListener<String>) c -> Platform.runLater(() -> label.setText(String.join("\n", c.getList()))));
    }
}
