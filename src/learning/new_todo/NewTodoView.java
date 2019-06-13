package learning.new_todo;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.function.Consumer;

public class NewTodoView extends HBox
{
    private TextField _textField;
    private Button _button;
    private Consumer<String> _onAdd;

    public NewTodoView(Consumer<String> onAdd)
    {
        _onAdd = onAdd;

        setPrefHeight(50);
        setPrefWidth(100);

        _textField = new TextField();
        _textField.setId("newTodo");
        getChildren().add(_textField);

        _button = new Button();
        _button.setId("addButton");
        _button.contentDisplayProperty().setValue(ContentDisplay.CENTER);
        _button.setText("Add");
        getChildren().add(_button);

        _button.setOnAction(this::addTodo);
        _textField.setOnAction(this::addTodo);
    }

    private void addTodo(ActionEvent actionEvent)
    {
        _onAdd.accept(_textField.getText());
        _textField.clear();
    }
}
