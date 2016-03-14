
//Продемонстрировать меню
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.KeyCombination;
import javafx.event.*;
import javafx.geometry.*;

public class ContextMenuDemo extends Application {
	Label response;

	public static void main(String[] args) {
		// запустить JаvаFХ-приложение, вызвав метод launch()
		launch(args);
	}

	// переопределить метод start()
	public void start(Stage myStage) {
		// присвоить заголовок подмосткам
		myStage.setTitle("Demonstrate Menus");// демонстрация меню
		// использовать панель граничной компоновки ВorderPane в качестве
		// корневого узла
		BorderPane rootNode = new BorderPane();

		// создать сцену
		Scene myScene = new Scene(rootNode, 300, 300);
		// установить сцену на подмостках
		myStage.setScene(myScene);
		// создать метку для отображения результатов выбора из меню
		response = new Label("Menu Demo");//// Демонстрация меню

		// создать пункты контекстного меню
		MenuItem cut = new MenuItem("Cut");// Вырезать
		MenuItem copy = new MenuItem("Copy");// Скопировать
		MenuItem paste = new MenuItem("Paste");// Вставить
		// создать контекстное (т.е. всплывающее) меню с пунктами
		// для выбора команд редактирования
		final ContextMenu editMenu = new ContextMenu(cut, copy, paste);

		EventHandler<ActionEvent> meHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				String name = ((MenuItem) ae.getTarget()).getText();
				// выйти из программы, если выбран пункт меню Exit
				if (name.equals("Exit"))
					Platform.exit();
				response.setText(name + " selected");
				// Выбран указанный пункт меню
			}
		};
		//ввести контекстное меню непосредственно в граф сцены
		rootNode.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>(){
		public void handle(ContextMenuEvent ae){
			//отобраэить контекстное меню в том месте, где был
			//произведен щелчок кнопкой мыши
			editMenu.show(rootNode, ae.getScreenX(), ae.getScreenY());
		}
		});
		
		cut.setOnAction(meHandler);
		copy.setOnAction(meHandler);
		paste.setOnAction(meHandler);

		// создать текстовое поле, задав ширину его столбца равной 20
		TextField tf = new TextField();

		// ввести контекстное меню в текстовое поле
		tf.setContextMenu(editMenu);
		tf.setPrefColumnCount(20);

		// создать панель поточной компоновки, которая должна содержать
		// текстовое поле и метку ответной реакции на действия пользователя
		FlowPane fpRoot = new FlowPane(10, 10);
		// выровнять элементы управления по центру сцены
		fpRoot.setAlignment(Pos.CENTER);
		// ввести текстовое поле и метку на панели поточной компоновки
		fpRoot.getChildren().addAll(response, tf);
		// расположитьпанельпоточнойкомпоновкипоцентрупанели
		// граничнойкомпоновки
		rootNode.setCenter(fpRoot);

		// показать подмостки и сцену на них
		myStage.show();
	}
}