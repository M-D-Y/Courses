
//Продемонстрировать применение переключателя
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class ToggleButtonDemo extends Application {
	ToggleButton tbOnOff;
	Label response;

	public static void main(String[] args) {
		// запустить JаvаFХ-приложение, вызвав метод launch()
		launch(args);
	}

	// переопределить метод start()
	public void start(Stage myStage) {
		// присвоить заголовок подмосткам
		myStage.setTitle("Demonstrate а ToggleButton");
		// Продемонстрировать переключатель
		// Использовать панель поточной компоновки FlowPane
		// в качестве корневого узла. В данном случае с
		// промежутками 10 по вертикали и погоризонтали
		FlowPane rootNode = new FlowPane(10, 10);
		// выровнять элементы управления по центру сцены
		rootNode.setAlignment(Pos.CENTER);
		// создать сцену
		Scene myScene = new Scene(rootNode, 220, 120);
		// установить сцену на подмостках
		myStage.setScene(myScene);
		// создать метку
		response = new Label("Push the Button.");//// Нажать кнопку
		// создать переключатель
		tbOnOff = new ToggleButton("On/Off");// Включить/Выключить
		// обработать события действия от переключателя
		tbOnOff.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ае) {
				if (tbOnOff.isSelected()) {
					response.setText("Button is on.");
					// Переключатель нажат
				} else {
					response.setText("Button is off.");
					// Переключатель отпущен
				}
			}
		});
		// ввестиметкуипереключательвграфсцены
		rootNode.getChildren().addAll(tbOnOff, response);
		// покаэать подмостки и сцену на них
		myStage.show();
	}
}