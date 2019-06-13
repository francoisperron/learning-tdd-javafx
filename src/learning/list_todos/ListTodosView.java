package learning.list_todos;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ListTodosView extends HBox
{
    public Label label;

    public ListTodosView(ObservableList<String> todos)
    {
        setPrefWidth(100);

        this.label = new Label();
        this.label.setId("todos");

        getChildren().add(this.label);

        todos.addListener((ListChangeListener<String>) c -> label.setText(String.join("\n", c.getList())));
    }
}
