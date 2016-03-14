
//Продемонстрировать применение комбинированного списка
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.collections.*;
import javafx.event.*;

public class ComboBoxDemo extends Application {
	ComboBox<String> cbTransport;
	Label response;

	public static void main(String[] args) {
		// запустить JаvаFХ-приложение, вызвав метод launch()
		launch(args);
	}

	// переопределить метод start()
	public void start(Stage myStage) {
		// присвоить заголовок подмосткам
		myStage.setTitle("ComboBox Demo");
		// Демонстрация комбинированного списка
		// Использовать панель поточной компоновки FlowPane
		// в качестве корневого узла. В данном случае с
		// промежутками 10 по вертикали и по горизонтали
		FlowPane rootNode = new FlowPane(10, 10);
		// выполнить выравнивание по центру
		rootNode.setAlignment(Pos.CENTER);
		// создать сцену
		Scene myScene = new Scene(rootNode, 280, 120);
		// установить сцену на подмостках
		myStage.setScene(myScene);
		// создать метку
		response = new Label();
		// создать список типа ObservableList из элементов,
		// предназначенных для комбинированного списка
		ObservableList<String> transportTypes = FXCollections.observableArrayList("Train", "Car", "Airplane");
		// создать комбинированный список
		cbTransport = new ComboBox<String>(transportTypes);
		// установить значение по умолчанию
		cbTransport.setValue("Train");// Поезд
		// установить метку ответной реакции для отображения
		// результата выбора по умолчанию
		response.setText("Selected Traпsport is " + cbTransport.getValue());
		// Выбраноуказанноетранспортноесредство
		// приниматьсобытиядействияоткомбинированногосписка
		cbTransport.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ае) {
				response.setText("Selected Transport is " + cbTransport.getValue());
				// Выбрано указанное транспортное средство
			}
		});
		// ввести метку и комбинированный список в граф сцены
		rootNode.getChildren().addAll(cbTransport, response);
		// показать подмостки и сцену на них
		myStage.show();
	}
}