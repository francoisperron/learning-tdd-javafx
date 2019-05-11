package learning;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainPageTest extends JavaFxTest
{
    public void start(Stage stage) throws IOException
    {
        Scene scene = new Scene(MainPage.build());
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void addNewTodoToTodos()
    {
        clickOn("#newTodo");
        write("learn");
        clickOn("#addButton");

        Label todos = find("#todos");
        assertThat(todos.getText(), is("learn"));
    }

    @Test
    public void clearsNewTodo()
    {
        clickOn("#newTodo");
        write("learn");
        clickOn("#addButton");

        TextField newTodo = find("#newTodo");
        assertThat(newTodo.getText(), is(""));
    }

    // if empty -- do not add todo

    // test add 2 todos

}
