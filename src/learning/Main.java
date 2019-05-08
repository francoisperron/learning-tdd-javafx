package learning;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    {
        Parent mainPage = FXMLLoader.load(getClass().getResource("main-page.fxml"));
        stage.setTitle("Things todo");
        stage.setScene(new Scene(mainPage));
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
