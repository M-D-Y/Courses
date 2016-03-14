
//Продемонстрировать применение элемента управления меткой в JavaFX
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class JavaFXLabelDemo extends Application {
	public static void main(String[] args) {
		// Start the JavaFX application bу calling launch().
		launch(args);
		// переопределить методs tart()
	}

	public void start(Stage myStage) {
		// присвоить заголовок подмосткам
		myStage.setTitle("Demonstrate а JavaFX label.");
		// Продемонстрировать метку в JavaFX
		// использовать панель типа FlowPane в качестве корневого узла
		FlowPane rootNode = new FlowPane();
		// создать сцену
		Scene myScene = new Scene(rootNode, 300, 200);
		// установить сцену на подмостках
		myStage.setScene(myScene);
		// создать метку

		Label myLabel = new Label("This is а JavaFX label");
		// Это метка в JavaFX
		// ввести метку в граф сцены
		rootNode.getChildren().add(myLabel);
		// показать подмостки и сцену на них
		myStage.show();
	}
}