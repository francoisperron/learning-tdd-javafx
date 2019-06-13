package learning.new_todo;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Region;
import learning.JavaFxTest;
import learning.Store;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NewTodoViewTest extends JavaFxTest
{
    private Store _store;

    @Override
    protected Region loadComponent()
    {
        _store = new Store();
        return new NewTodoView(_store);
    }

    @Test
    public void withStyle()
    {
        NewTodoView view = find("#newTodoView");

        assertThat(view.getPrefWidth(), is(100.0));
    }

    @Test
    public void hasAnAddButton()
    {
        Button button = find("#addButton");

        assertThat(button.getText(), is("Add"));
    }

    @Test
    public void newTodoOnClick()
    {
        clickOn("#newTodo");
        write("learn");
        clickOn("#addButton");

        assertThat(_store.getTodos().size(), is(1)); // should check that NewTodoEvent is dispatched with text
    }

    @Test
    public void newTodoOnEnter()
    {
        clickOn("#newTodo");
        write("learn");
        press(KeyCode.ENTER);

        assertThat(_store.getTodos().size(), is(1)); // should check that NewTodoEvent is dispatched with text
    }

    @Test
    public void clearsTextFieldOnAdd()
    {
        clickOn("#newTodo");
        write("learn");
        press(KeyCode.ENTER);

        TextField newTodo = find("#newTodo");
        assertThat(newTodo.getText(), is(""));
    }
}