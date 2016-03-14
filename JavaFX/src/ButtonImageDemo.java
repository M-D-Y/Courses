
//Применить изображение в кнопке
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.image.*;

public class ButtonImageDemo extends Application {
	Label response;

	public static void main(String[] args) {
		// запустить JаvаFХ-приложение, вызвав метод launch()
		launch(args);
	}

	// переопределить метод start()
	public void start(Stage myStage) {
		// присвоить заголовок подмосткам
		myStage.setTitle("Use Images with Buttons");
		// Использовать изображения в кнопках
		// Использовать панель поточной компоновки FlowPane
		// в качестве корневого узла. В данном случае с
		// промежутками 10 по вертикали и по горизонтали
		FlowPane rootNode = new FlowPane(10, 10);
		// выровнять элементы управления по центру сцены
		rootNode.setAlignment(Pos.CENTER);
		// создать сцену
		Scene myScene = new Scene(rootNode, 250, 450);
		// установить сцену на подмостках
		myStage.setScene(myScene);
		// создать метку.
		response = new Label("Push а Button");// Нажать кнопку
		// создать две экранные кнопки с текстовыми надписями
		// и соответствующими изображениями часов
		Button btnHourglass = new Button("Hourglass", new ImageView("hourglass.png"));
		Button btnAnalogClock = new Button("AnalogClock", new ImageView("analog.png"));
		// расположитьтекстподизображением
		btnHourglass.setContentDisplay(ContentDisplay.TOP);
		btnAnalogClock.setContentDisplay(ContentDisplay.TOP);
		// обработать события действия от экранной кнопки
		// с изображением песочных часов
		btnHourglass.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ае) {
				response.setText("Hourglass Pressed");
			}
		});
		// Нажата кнопка с изображением песочных часов
		// обработать события действия от экранной кнопки
		// с изображением аналоговых часов
		btnAnalogClock.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ае) {
				response.setText("Analog Clock Pressed");
			}
		});
		// Нажата кнопка с изображением аналоговых часов
		// ввести метку и кнопки в граф сцены
		rootNode.getChildren().addAll(btnHourglass, btnAnalogClock, response);
		// показать подмостки и сцену на них
		myStage.show();
	}
}