package learning;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import learning.new_todo.NewTodoEvent;

public class Store
{
    private ObservableList<String> _todos = FXCollections.observableArrayList();

    public ObservableList<String> getTodos() // this could be a map to model_key -> model
    {
        return _todos;
    }

    public void dispatch(NewTodoEvent event) // this could be a map of event -> action that the main app and the test fills as they need
    {
        _todos.add(event.getText());
    }
}
