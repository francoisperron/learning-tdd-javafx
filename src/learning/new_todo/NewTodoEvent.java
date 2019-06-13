package learning.new_todo;

public class NewTodoEvent
{
    private String _text;

    public NewTodoEvent(String text)
    {
        _text = text;
    }

    public String getText()
    {
        return _text;
    }
}
