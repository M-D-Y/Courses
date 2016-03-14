
//Продемонстрировать применение экранных кнопок
//и обработку событий в JavaFX
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class JavaFXEventDemo extends Application {
	Label response;

	public static void main(String[] args) {
		// запустить JаvаFХ-приложение, вызвав метод launch()
		launch(args);
		// переопределить метод start()
	}

	public void start(Stage myStage) {
		// присвоить заголовок подмосткам
		myStage.setTitle("Demonstrate JavaFX Button sand Events.");
		// Продемонстрировать кнопки и события в JavaFX
		// Использовать панель поточной компоновки FlowPane
		// в качестве корневого узла. Установить промежутки
		// между элементами управления по горизонтали и по вертикали равными 10
		FlowPane rootNode = new FlowPane(10, 10);
		// выровнять элементы управления по центру сцены
		rootNode.setAlignment(Pos.CENTER);
		// создать сцену
		Scene myScene = new Scene(rootNode, 300, 100);
		// установить сцену на подмостках
		myStage.setScene(myScene);
		// создать метку
		response = new Label("Push а Button");// Нажать кнопку
		// создать две экранные кнопки
		Button btnAlpha = new Button("Alpha");
		Button btnBeta = new Button("Beta");
		// обработать события действия от кнопки Alpha
		btnAlpha.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ае) {
				response.setText("Alpha was pressed.");
				// Нажата кнопка Alpha
			}
		});
		// обработатьсобытиядействияоткнопкиВеtа
		btnBeta.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ае) {
				response.setText("Beta was pressed.");
			}
		});
		// Нажата кнопка Веtа
		// ввести метку и кнопки в граф сцены
		rootNode.getChildren().addAll( btnAlpha, btnBeta, response );
		// показать подмостки и сцену на них
		myStage.show();
	}
}