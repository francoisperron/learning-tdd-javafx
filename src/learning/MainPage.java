package learning;

import javafx.scene.layout.VBox;
import learning.list_todos.ListTodosView;
import learning.new_todo.NewTodoView;

public class MainPage extends VBox
{
    private State _model;

    public MainPage(State state)
    {
        _model = state;

        setPrefHeight(600);
        setPrefWidth(640);

        getChildren().add(new NewTodoView(this::addTodo));
        getChildren().add(new ListTodosView(_model.todos));
    }


    private void addTodo(String todo)
    {
        _model.todos.add(todo);
    }
}
