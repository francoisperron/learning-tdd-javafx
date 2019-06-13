package learning;

import javafx.scene.layout.Region;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainPageTest extends JavaFxTest
{
    @Override
    protected Region loadComponent()
    {
        return new MainPage(new Store());
    }

    @Test
    public void hasStyle()
    {
        MainPage mainPage = find("#mainPage");

        assertThat(mainPage.getPrefHeight(), is(600.0));
        assertThat(mainPage.getPrefWidth(), is(640.0));
    }
}