package learning.list_todos;

import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import learning.JavaFxTest;
import learning.Store;
import org.junit.Test;
import org.testfx.util.WaitForAsyncUtils;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ListTodosViewTest extends JavaFxTest
{

    private Store _store;

    @Override
    protected Region loadComponent()
    {
        _store = new Store();
        return new ListTodosView(_store);
    }

    @Test
    public void hasStyle()
    {
        ListTodosView view = find("#listTodoView");

        assertThat(view.getPrefWidth(), is(100.0));
    }

    @Test
    public void showsTodos()
    {
        _store.getTodos().add("todo 1");
        _store.getTodos().add("todo 2");

        WaitForAsyncUtils.waitForFxEvents();

        Label todos = find("#todos");
        assertThat(todos.getText(), is("todo 1\ntodo 2"));
    }
}