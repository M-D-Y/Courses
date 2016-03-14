
//Продемонстрировать применение элемента управления TreeView
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.beans.value.*;
import javafx.geometry.*;

public class TreeViewDemo extends Application {
	Label response;

	public static void main(String[] args) {
		// запустить JаvаFХ-приложение, вызвав метод launch()
		launch(args);
	}

	// переопределить метод start()
	public void start(Stage myStage) {
		// присвоить заголовок подмосткам
		myStage.setTitle("Demonstrate а TreeView");
		// Продемонстрировать элемент управления TreeView
		// Использовать панель поточной компоновки FlowPane
		// в качестве корневого узла. В данном случае с
		// промежутками 10 по вертикали и по горизонтали
		FlowPane rootNode = new FlowPane(10, 10);
		// выровнять элементы управления по центру сцены
		rootNode.setAlignment(Pos.CENTER);
		// создать сцену
		Scene myScene = new Scene(rootNode, 310, 460);
		// установить сцену на подмостках
		myStage.setScene(myScene);
		// создать метку, извещающую о состоянии элемента, выбранного из дерева
		response = new Label("NoSelection");
		// Ничего не выбрано создать узлы дерева, начиная с корневого узла
		TreeItem<String> tiRoot = new TreeItem<String>("Food");
		// ввести поддеревья, начиная с узла фруктов
		TreeItem<String> tiFruit = new TreeItem<String>("Fruit");
		
		// построить узел яблок
		TreeItem<String> tiApples = new TreeItem<String>("Apples");
		// ввестипорожденныеузлысортовяблоквузеляблок
		tiApples.getChildren().add(new TreeItem<String>("Fuji"));
		tiApples.getChildren().add(new TreeItem<String>("Winesap"));
		tiApples.getChildren().add(new TreeItem<String>("Jonathan"));
		// ввести порожденные узлы видов фруктов в узел фруктов
		tiFruit.getChildren().add(tiApples);
		
		tiFruit.getChildren().add(new TreeItem<String>("Pears"));
		tiFruit.getChildren().add(new TreeItem<String>("Oranges"));
		// и наконец, ввести узел фруктов в корневой узел
		tiRoot.getChildren().add(tiFruit);
		
		// а теперь ввести аналогичным образом узел овощей
		TreeItem<String> tiVegetables = new TreeItem<String>("Vegetables");
		tiVegetables.getChildren().add(new TreeItem<String>("Corn"));
		tiVegetables.getChildren().add(new TreeItem<String>("Peas"));
		tiVegetables.getChildren().add(new TreeItem<String>("Broccoli"));
		tiVegetables.getChildren().add(new TreeItem<String>("Beans"));
		tiRoot.getChildren().add(tiVegetables);

		// и наконец, ввести аналогичным образом узел орехов
		TreeItem<String> tiNuts = new TreeItem<String>("Nuts");
		tiNuts.getChildren().add(new TreeItem<String>("Walnuts"));
		tiNuts.getChildren().add(new TreeItem<String>("Peanuts"));
		tiNuts.getChildren().add(new TreeItem<String>("Pecans"));
		tiRoot.getChildren().add(tiNuts);
		
		// создать древовидное представление, используя только что построенное дерево
		TreeView<String> tvFood = new TreeView<String>(tiRoot);
		// получить модель выбора для древовидного представления
		MultipleSelectionModel<TreeItem<String>> tvSelModel = tvFood.getSelectionModel();
		// использовать приемник событий изменения, чтобы оперативно
		// реагировать на выбор элементов в древовидном представлении
		tvSelModel.selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
			public void changed(ObservableValue<? extends TreeItem<String>> changed, TreeItem<String> oldVal,
					TreeItem<String> newVal) {
				// отобразить выбранный элемент и полный путь от него к
				// корневому узлу
				if (newVal != null) {
					// построить весь путь к выбранному элементу
					String path = newVal.getValue();
					TreeItem<String> tmp = newVal.getParent();
					while (tmp != null) {
						path = tmp.getValue() + " -> " + path;
						tmp = tmp.getParent();
					}
					// отобразить выбранный элемент и полный путь к нему
					response.setText("Selection is " + newVal.getValue() + "\n Complete path is " + path);
					// Выбран указанный элемент и полный путь к нему
				}
			}
		});

		// ввести элементы управления в граф сцены
		rootNode.getChildren().addAll(tvFood, response);
		// показать подмостки и сцену на них
		myStage.show();
	}
}