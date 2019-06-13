package learning;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage stage)
    {
        Store store = new Store();

        stage.setTitle("Things todo");
        stage.setScene(new Scene(new MainPage(store)));
        stage.show();
    }
}
