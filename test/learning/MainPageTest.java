package learning;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainPageTest extends JavaFxTest
{
    @Override
    protected String loadComponent()
    {
        return "main-page.fxml";
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
