
//Продемонстрировать изображение на месте метки
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.image.*;

public class LabelimageDemo extends Application {
	Label hourglassLabel;
	ContentDisplay[] contentDisplay = {ContentDisplay.BOTTOM, ContentDisplay.CENTER, ContentDisplay.GRAPHIC_ONLY, ContentDisplay.LEFT,
			ContentDisplay.RIGHT, ContentDisplay.TEXT_ONLY, ContentDisplay.TOP};
	int contentDisplayIdx = 0;
	Button btnChangeImagePosition;
	
	public static void main(String[] args) {
		// запустить JаvаFХ-приложение, вызвав метод launch()
		launch(args);
	}

	// переопределить метод start()
	public void start(Stage myStage) {
		// присвоить заголовок подмосткам
		myStage.setTitle("Use an Image in а Label");
		// Использовать изображение в метке
		// Использовать панель поточной компоновки FlowPane
		// в качестве корневого узла
		FlowPane rootNode = new FlowPane();
		// выполнить выравнивание по центру
		rootNode.setAlignment(Pos.CENTER);
		// создать сцену
		Scene myScene = new Scene(rootNode, 300, 200);
		// установить сцену на подмостках
		myStage.setScene(myScene);
		// создать представление указанного изображения
		ImageView hourglassIV = new ImageView("hourglass.png");
		// создать метку, содержащую изображение и текст
		hourglassLabel = new Label("Hourglass", hourglassIV);
		btnChangeImagePosition = new Button(hourglassLabel.getContentDisplay().name());
		btnChangeImagePosition.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				contentDisplayIdx++;
				if(contentDisplayIdx >= contentDisplay.length) contentDisplayIdx = 0;
				hourglassLabel.setContentDisplay(contentDisplay[contentDisplayIdx]);
				btnChangeImagePosition.setText(contentDisplay[contentDisplayIdx].name());
			}
		});
		// ввести метку в граф сцены
		rootNode.getChildren().addAll(hourglassLabel, btnChangeImagePosition);
		// показать подмостки и сцену на них
		myStage.show();
	}
}