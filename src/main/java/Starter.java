import Scene.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Starter extends Application {
    public static void main (String [] args){
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        SceneManager.setStage(stage);
        SceneManager.switchPage("/view/Login/login_page.fxml");

    }
}
