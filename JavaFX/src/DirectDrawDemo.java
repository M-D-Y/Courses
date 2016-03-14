
//Продемонстрировать рисование на холсте
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.shape.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

public class DirectDrawDemo extends Application {
	GraphicsContext gc;
	Color[] colors = { Color.RED, Color.BLUE, Color.GREEN, Color.BLACK };
	int coloridx = 0;

	public static void main(String[] args) {
		// запустить JаvаFХ-nриложение, вызвав метод launch()
		launch(args);
		// переопределить метод start()
	}

	public void start(Stage myStage) {
		// присвоить заголовок подмосткам
		myStage.setTitle("Draw Directly to а Canvas.");
		// Рисование прямо на холсте
		// Использовать панель поточной компоновки FlowPane
		// в качестве корневого узла
		FlowPane rootNode = new FlowPane();
		// расположить узлы по центру сцены
		rootNode.setAlignment(Pos.CENTER);
		// создать сцену
		Scene myScene = new Scene(rootNode, 450, 450);
		// установить сцену на подмостках
		myStage.setScene(myScene);
		// создать холст
		Canvas myCanvas = new Canvas(400, 400);
		// получить графический контекст для холста
		gc = myCanvas.getGraphicsContext2D();
		// создать экранную кнопку
		Button btnChangeColor = new Button("Change Color");
		// обработать события действия от кнопки ChanqeColor
		btnChangeColor.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ае) {
				// задать цвет обводки и заливки
				gc.setStroke(colors[coloridx]);
				gc.setFill(colors[coloridx]);
				// Перерисовать линию, текст и заполненный прямоугольник
				// новым цветом. При этом цвет остальных узлов графа сцены
				// останется без изменения
				gc.strokeLine(0, 0, 200, 200);
				gc.fillText("This is drawn on the canvas.", 60, 50);
				// Это рисуется на холсте
				gc.fillRect(100, 320, 300, 40);
				// изменить цвет
				coloridx++;
				if (coloridx == colors.length)
					coloridx = 0;
			}
		});

		// нарисовать на холсте графические объекты
		// первоначально выводимые на экран
		gc.strokeLine(0, 0, 200, 200);
		gc.strokeOval(100, 100, 200, 200);
		gc.strokeRect(0, 200, 50, 200);
		gc.fillOval(0, 0, 20, 20);
		gc.fillRect(100, 320, 300, 40);
		// задать шрифт размером 20 и воспроизвести текст
		gc.setFont(new Font(20));
		gc.fillText("This is drawn on the canvas.", 60, 50);
		// ввести холст и кнопку в граф сцены
		rootNode.getChildren().addAll(myCanvas, btnChangeColor);
		// показать подмостки и сцену на них
		myStage.show();
	}
}