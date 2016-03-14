
//Загрузить и воспроизвести изображение
import javafx.application.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.*;

public class ImageDemo extends Application {
	public static void main(String[] args) {
		// запустить JаvаFХ-приложение, вызвав метод launch()
		launch(args);
	}

	// переопределить метод start()
	public void start(Stage myStage) {
		// присвоить заголовок подмосткам
		myStage.setTitle("Display an Image");
		// Использовать панель поточной компоновки FlowPane
		// в качестве корневого узла
		FlowPane rootNode = new FlowPane();
		// выполнить выравнивание по центру
		rootNode.setAlignment(Pos.CENTER);
		// создатьсцену
		Scene myScene = new Scene(rootNode, 300, 200);
		// установить сцену на подмостках
		myStage.setScene(myScene);
		// создатьобъектизображения
		Image hourglass = new Image("hourglass.png");
		// создать представление этого изображения
		ImageView hourglassIV = new ImageView(hourglass);
		// ввести изображение в граф сцены
		rootNode.getChildren().add(hourglassIV);
		// показать подмостки и сцену на них
		myStage.show();
	}
}