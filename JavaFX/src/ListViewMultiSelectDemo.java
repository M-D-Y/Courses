
//Продемонстрировать применение представления списка
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.beans.value.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.*;

public class ListViewMultiSelectDemo extends Application {
	Label response;

	public static void main(String[] args) {
		// запустить JаvаFХ-приложение, вызвав метод launch()
		launch(args);
	}

	// переопределить метод start()
	public void start(Stage myStage) {
		// присвоить заголовок подмосткам
		myStage.setTitle("ListView Demo");
		// Демонстрация представления списка
		// Использовать панель поточной компоновки FlowPane
		// в качестве корневого узла. В данном случае с
		// промежутками 10 по вертикали и по горизонтали
		FlowPane rootNode = new FlowPane(10, 10);
		// выровнять элементы управления по центру сцены
		rootNode.setAlignment(Pos.CENTER);
		// создать сцену
		Scene myScene = new Scene(rootNode, 200, 120);
		// установить сцену на подмостках
		myStage.setScene(myScene);
		// создатьметку
		response = new Label("Select Traпsport Туре");
		// Выбрать вид транспортного средства
		// создать список типа ObservвbleList из элементов
		// для представления списка
		ObservableList<String> transportTypes = FXCollections.observableArrayList("Train", "Car", "Airplane", "Bicycle" , "Walking");
		// создать представление списка
		final ListView<String> lvTransport = new ListView<String>(transportTypes);
		lvTransport.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		// задать предпочтительную высоту и ширину представления списка
		lvTransport.setPrefSize(80, 80);
		// получить модель выбора для представления списка
		MultipleSelectionModel<String> lvSelModel = lvTransport.getSelectionModel();
		// ввести приемник событий изменения, чтобы реагировать на
		// выбор элементов в представлении списка
		lvSelModel.selectedItemProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				String selitems="";
				ObservableList<String> selected = lvTransport.getSelectionModel().getSelectedItems();
				//отобразить результаты выбора
				for(int i=0; i<selected.size(); i++) selitems += "\n	" + selected.get(i);
				response.setText("All transports selected: " + selitems);
				//Все выбранные транспортные средства
			}
		});
		// ввести метку и представление списка в граф сцены
		rootNode.getChildren().addAll(lvTransport, response);
		// показать подмостки и сцену на них
		myStage.show();
	}
}