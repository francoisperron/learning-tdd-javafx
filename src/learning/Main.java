package learning;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        Parent mainPage = MainPage.build();

        stage.setTitle("Things todo");
        stage.setScene(new Scene(mainPage));
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
