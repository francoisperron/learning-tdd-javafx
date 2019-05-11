package learning;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class MainPage extends Parent
{
    @FXML
    public TextField newTodo;
    @FXML
    public Button addButton;
    @FXML
    public Label todos;

    private MainPageModel _model;

    public static Parent build() throws IOException
    {
        FXMLLoader loader = new FXMLLoader(MainPage.class.getResource("main-page.fxml"));
        MainPage mainPage = new MainPage(new MainPageModel());
        loader.setController(mainPage);
        return loader.load();
    }

    public MainPage(MainPageModel model)
    {
        _model = model;
    }

    @FXML
    public void initialize()
    {
        addButton.setOnAction(event -> addTodo());
        newTodo.setOnAction(event -> addTodo());

        _model.todos.addListener((ListChangeListener<String>) c -> todos.setText(String.join("\n", c.getList())));
        _model.todos.addListener((ListChangeListener<String>) c -> newTodo.setText(""));
    }

    private void addTodo()
    {
        _model.todos.add(newTodo.getText());
    }
}
