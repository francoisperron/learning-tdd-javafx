package learning;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage stage)
    {
        State state = new State();

        stage.setTitle("Things todo");
        stage.setScene(new Scene(new MainPage(state)));
        stage.show();
    }
}
