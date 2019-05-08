package learning;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class MainPage extends Parent
{
    @FXML
    public TextField newTodo;
    @FXML
    public Button addButton;
    @FXML
    public Label todos;

    private ArrayList<String> _todoModel = new ArrayList<>();

    public void addTodo()
    {
        _todoModel.add(newTodo.getText());

        todos.setText(String.join("\n", _todoModel));

        newTodo.setText("");
    }
}
