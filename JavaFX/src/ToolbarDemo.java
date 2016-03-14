
//Продемонстрировать меню
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.event.*;
import javafx.geometry.*;

public class ToolbarDemo extends Application {
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
		// создать строку меню
		MenuBar mb = new MenuBar();
		// создать меню File
		Menu fileMenu = new Menu("_File");// Файл
		MenuItem open = new MenuItem("_Open");// Открыть
		MenuItem close = new MenuItem("_Close");// Закрыть
		MenuItem save = new MenuItem("_Save");// Сохранить
		MenuItem exit = new MenuItem("_Exit");// Выход

		// ввести оперативные клавиши для быстрого выбора пунктов меню File
		open.setAccelerator(KeyCombination.keyCombination("shortcut+O"));
		close.setAccelerator(KeyCombination.keyCombination("shortcut+C"));
		save.setAccelerator(KeyCombination.keyCombination("shortcut+S"));
		exit.setAccelerator(KeyCombination.keyCombination("shortcut+E"));

		fileMenu.getItems().addAll(open, close, save, new SeparatorMenuItem(), exit);
		// ввести меню File в строку меню
		mb.getMenus().add(fileMenu);
		// создать меню Options
		Menu optionsMenu = new Menu("Options");// Параметры
		// создать подменю Colors
		Menu colorsMenu = new Menu("Colors");// Цвета
		MenuItem red = new MenuItem("Red");// Красный
		MenuItem green = new MenuItem("Green");// Зеленый
		MenuItem blue = new MenuItem("Blue");// синий
		colorsMenu.getItems().addAll(red, green, blue);
		optionsMenu.getItems().add(colorsMenu);
		// создать подменю Priority
		Menu priorityMenu = new Menu("Priority");// Приоритет
		MenuItem high = new MenuItem("High");// Высокий
		MenuItem low = new MenuItem("Low");// Низкий
		priorityMenu.getItems().addAll(high, low);

		optionsMenu.getItems().add(priorityMenu);
		// ввести разделитель
		optionsMenu.getItems().add(new SeparatorMenuItem());
		// создать пункт меню Reset
		MenuItem reset = new MenuItem("Reset");// Сбросить
		optionsMenu.getItems().add(reset);
		// ввести меню Options в строку меню
		mb.getMenus().add(optionsMenu);
		// создать меню Help
		Menu helpMenu = new Menu("Help");// Справка
		ImageView aboutIV = new ImageView("about_icon.png");
		// MenuItem about = new MenuItem("About", aboutIV); //1-ый способ
		MenuItem about = new MenuItem("AЬout");// о программе
		about.setGraphic(aboutIV); // 1-ой способ
		helpMenu.getItems().add(about);
		// ввести меню Help в строку меню
		mb.getMenus().add(helpMenu);
		fileMenu.setMnemonicParsing(true);

		// создать один приемник действий для обработки всех
		// событий действия, наступающих в меню
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
		// установить приемники действий от пунктов меню
		open.setOnAction(meHandler);
		close.setOnAction(meHandler);
		save.setOnAction(meHandler);
		exit.setOnAction(meHandler);
		red.setOnAction(meHandler);
		green.setOnAction(meHandler);
		blue.setOnAction(meHandler);
		high.setOnAction(meHandler);
		low.setOnAction(meHandler);
		reset.setOnAction(meHandler);
		about.setOnAction(meHandler);
		// ввести строку меню в верхней области панели
		// граничной компоновки, а метку response в центре этой панели
		rootNode.setTop(mb);
		rootNode.setCenter(response);

		// определить панель инструментов;
		// создать сначала кнопки на этой панели
		Button btnSet = new Button("Set Breakpoint", new ImageView("breakpoint_new.png"));
		Button btnClear = new Button("Clear Breakpoint", new ImageView("breakpoint_delete.png"));
		Button btnResume = new Button("Resume Execution", new ImageView("breakpoint_run.png"));
		// затем отключить текстовые надписи на кнопках
		btnSet.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
		btnClear.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
		btnResume.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
		// задать всплывающие подсказки
		btnSet.setTooltip(new Tooltip("Set а breakpoint."));
		// Установить точку прерывания
		btnClear.setTooltip(new Tooltip("Clear а breakpoint."));
		// Очистить точку прерывания
		btnResume.setTooltip(new Tooltip("Resume execution."));
		// Возобновить выполнение создать панель инструментов
		ToolBar tbDebug = new ToolBar(btnSet, btnClear, btnResume);

		// создать обработчик событий действия от каждой кнопки на панели
		// инструментов
		EventHandler<ActionEvent> btnHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				response.setText(((Button) ae.getTarget()).getText());
			}
		};
		// установить обработчики событий действия для отдельных кнопок
		// на панели инструментов

		btnSet.setOnAction(btnHandler);
		btnClear.setOnAction(btnHandler);
		btnResume.setOnAction(btnHandler);
		rootNode.setBottom(tbDebug);

		// показать подмостки и сцену на них
		myStage.show();
	}
}