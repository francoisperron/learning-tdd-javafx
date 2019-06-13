package learning;

import javafx.scene.layout.VBox;
import learning.list_todos.ListTodosView;
import learning.new_todo.NewTodoView;

public class MainPage extends VBox
{
    public MainPage(Store store)
    {
        setId("mainPage");
        setPrefHeight(600);
        setPrefWidth(640);

        getChildren().add(new NewTodoView(store));
        getChildren().add(new ListTodosView(store));
    }
}
