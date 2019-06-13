package learning.feature;

import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import learning.JavaFxTest;
import learning.MainPage;
import learning.Store;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddTodoFeatureTest extends JavaFxTest
{
    @Override
    protected Region loadComponent()
    {
        return new MainPage(new Store());
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
}
