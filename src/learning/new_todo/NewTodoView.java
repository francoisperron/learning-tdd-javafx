package learning.new_todo;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import learning.Store;

public class NewTodoView extends HBox
{
    private TextField _textField;
    private Store _store;

    public NewTodoView(Store store)
    {
        _store = store;

        setId("newTodoView");
        setPrefWidth(100);

        addTextField();
        addButton();
    }

    private void addTextField()
    {
        _textField = new TextField();
        _textField.setId("newTodo");
        getChildren().add(_textField);

        _textField.setOnAction(this::onNewTodo);
    }

    private void addButton()
    {
        Button button = new Button();
        button.setId("addButton");
        button.setText("Add");
        getChildren().add(button);

        button.setOnAction(this::onNewTodo);
    }

    @SuppressWarnings("unused")
    private void onNewTodo(ActionEvent actionEvent)
    {
        _store.dispatch(new NewTodoEvent(_textField.getText()));
        _textField.clear();
    }
}
