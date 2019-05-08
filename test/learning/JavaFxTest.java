package learning;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.BeforeClass;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;

public abstract class JavaFxTest extends ApplicationTest
{
    @BeforeClass
    public static void headless()
    {
        if (Boolean.getBoolean("testfx.show")) return;

        System.setProperty("testfx.robot", "glass");
        System.setProperty("testfx.headless", "true");
        System.setProperty("prism.order", "sw");
        System.setProperty("prism.text", "t2k");
        System.setProperty("java.awt.headless", "true");
    }

    public void start(Stage stage) throws IOException
    {
        Scene scene = new Scene(FXMLLoader.load(JavaFxTest.class.getResource(loadComponent())));
        stage.setScene(scene);
        stage.show();
    }

    protected abstract String loadComponent();


    protected <T extends Node> T find(String query)
    {
        return lookup(query).query();
    }
}
