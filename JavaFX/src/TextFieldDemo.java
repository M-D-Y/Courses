//Продемонстрировать применение текстового поля
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class TextFieldDemo extends Application {
	TextField tf;
	Label response;

	public static void main(String[] args) {
		// запустить JаvаFХ-приложение, вызвав метод launch()
		launch(args);
	}

	// переопределитьметод•tart()
	public void start(Stage myStage) {
		// присвоить заголовок подмосткам
		myStage.setTitle("Demonstrate а TextField");
		// Продемонстрировать элемент управления типа TextField
		// Использовать панель поточной компоновки FlowPane
		// в качестве корневого узла. в данном случае с
		// промежутками 10 по вертикали и по горизонтали
		FlowPane rootNode = new FlowPane(10, 10);
		// выровнять элементы управления по центру сцены
		rootNode.setAlignment(Pos.CENTER);
		// создать сцену
		Scene myScene = new Scene(rootNode, 230, 140);
		// установить сцену на подмостках
		myStage.setScene(myScene);
		// создать метку, извещающую о содержимом текстового поля
		response = new Label("Search String:");
		// Строка запроса на поиск информации
		// создать кнопку для получения текста
		Button btnGetText = new Button("Get Search String");
		// Получить строку запроса на поиск информации
		// создать текстовое поле
		tf = new TextField();
		// задать подсказку
		tf.setPromptText("Enter Search String");
		// Ввести строку запроса на поиск информации
		// задать предпочтительное количество столбцов
		tf.setPrefColumnCount(15);
		// Обработать события действия от текстового поля. События действия
		// генерируются при нажатии клавиши <ENTER>, когда
		// фокус ввода находится в текстовом поле. В таком случае получается и
		// отображается текст, введенный в текстовом поле
		tf.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				response.setText("Search String: " + tf.getText());
				// Строка запроса на поиск информации
			}
		});
		// получить текст из текстового поля, если нажата
		// клавиша <ENTER>, а затем отобразить его
		btnGetText.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ае) {
				response.setText("Search String: " + tf.getText());
				// Строка запроса на поиск информации
			}
		});
		// использовать разделитель, чтобы улучшить порядок
		// расположения элементов управления
		Separator separator = new Separator();
		separator.setPrefWidth(180);
		// ввести все элементы управления в граф сцены
		rootNode.getChildren().addAll(tf, btnGetText, separator, response);
		// показать подмостки и сцену на них
		myStage.show();
	}
}