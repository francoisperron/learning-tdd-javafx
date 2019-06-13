package learning;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import org.junit.BeforeClass;
import org.testfx.framework.junit.ApplicationTest;

public abstract class JavaFxTest extends ApplicationTest
{
    @BeforeClass
    public static void headless()
    {
        System.setProperty("testfx.robot", "glass");
        System.setProperty("testfx.headless", "true");
        System.setProperty("prism.order", "sw");
        System.setProperty("prism.text", "t2k");
        System.setProperty("java.awt.headless", "true");
    }

    public void start(Stage stage)
    {
        Scene scene = new Scene(loadComponent());
        stage.setScene(scene);
        stage.show();
    }

    protected abstract Region loadComponent();


    protected <T extends Node> T find(String query)
    {
        return lookup(query).query();
    }
}
