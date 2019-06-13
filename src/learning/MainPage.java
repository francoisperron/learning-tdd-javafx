package learning;

import javafx.collections.ListChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainPage extends VBox
{
    public TextField newTodoTextField;
    public Button addButton;
    public Label todos;

    private MainPageModel _model;

    public MainPage(MainPageModel model)
    {
        _model = model;
        buildView();
        bindActions();
    }

    private void buildView()
    {
        setPrefHeight(600);
        setPrefWidth(640);

        HBox newTodoBox = new HBox();
        newTodoBox.setPrefHeight(50);
        newTodoBox.setPrefWidth(100);

        newTodoTextField = new TextField();
        newTodoTextField.setId("newTodo");
        newTodoBox.getChildren().add(newTodoTextField);

        addButton = new Button();
        addButton.setId("addButton");
        addButton.contentDisplayProperty().setValue(ContentDisplay.CENTER);
        addButton.setText("Add");
        newTodoBox.getChildren().add(addButton);

        getChildren().add(newTodoBox);

        HBox todoListBox = new HBox();
        todoListBox.setPrefHeight(500);
        todoListBox.setPrefWidth(100);
        todos = new Label();
        todos.setId("todos");
        todoListBox.getChildren().add(todos);

        getChildren().add(todoListBox);
    }

    private void bindActions()
    {
        addButton.setOnAction(event -> addTodo());
        newTodoTextField.setOnAction(event -> addTodo());

        _model.todos.addListener((ListChangeListener<String>) c -> todos.setText(String.join("\n", c.getList())));
        _model.todos.addListener((ListChangeListener<String>) c -> newTodoTextField.setText(""));
    }

    private void addTodo()
    {
        _model.todos.add(newTodoTextField.getText());
    }
}
