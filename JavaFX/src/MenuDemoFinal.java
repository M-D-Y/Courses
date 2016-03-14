
//Продемонстрировать меню-окончательный вариант
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.input.*;
import javafx.scene.image.*;
import javafx.beans.value.*;

public class MenuDemoFinal extends Application {
	MenuBar mb;
	EventHandler<ActionEvent> MEHandler;
	ContextMenu editMenu;
	ToolBar tbDebug;
	Label response;

	public static void main(String[] args) {
		// запустить JаvаFХ-приложение, вызвав метод launch()
		launch(args);
	}

	// переопределить метод start()
	public void start(Stage myStage) {
		// присвоить заголовок подмосткам
		myStage.setTitle("Demonstrate Menus--Final Version");
		// Демонстрация меню-окончательный вариант
		// использовать панель граничной компоновки ВorderPane
		// в качестве корневого узла
		final BorderPane rootNode = new BorderPane();
		// создать сцену
		Scene myScene = new Scene(rootNode, 300, 300);
		// установить сцену на подмостках
		myStage.setScene(myScene);
		// создать метку для отображения результатов выбора
		// из разных элементов управления ГПИ приложения
		response = new Label();
		// создать один приемник действий для обработки всех
		// событий деиствия, наступающих в меню
		MEHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				String name = ((MenuItem) ae.getTarget()).getText();
				if (name.equals("Exit"))
					Platform.exit();
				response.setText(name + " selected");
			}
		};

		// создать строку меню
		mb = new MenuBar();
		// создать меню File
		makeFileMenu();
		// создать меню Options
		makeOptionsMenu();
		// создать меню Help
		makeHelpMenu();
		// создать контекстное меню
		makeContextMenu();
		// создать текстовое поле, задав ширину его столбца равной 20
		TextField tf = new TextField();
		tf.setPrefColumnCount(20);
		// ввести контекстное меню в текстовое поле
		tf.setContextMenu(editMenu);
		// создать панель инструментов
		makeToolBar();
		// ввести контекстное меню непосредственно в граф сцены
		rootNode.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
			public void handle(ContextMenuEvent ae) {
				// отобразить всплывающее контекстное меню на том месте,
				// где был произведен щелчок правой кнопкой мыши
				editMenu.show(rootNode, ae.getScreenX(), ae.getScreenY());
			}
		});
		// ввестистрокуменювверхнейобластипанели
		rootNode.setTop(mb);
		// создать панель поточной компоновки для хранения
		// текстового поля и метки ответной реакции на действия пользователя
		FlowPane fpRoot = new FlowPane(10, 10);
		// выровнять элементы управления по центру сцены
		fpRoot.setAlignment(Pos.CENTER);
		// использовать разделитель, чтобы улучшить порядок
		// расположения элементов управления
		Separator separator = new Separator();
		separator.setPrefWidth(260);
		// ввести метку, разделитель и текстовое поле на панели поточной
		// компоновки
		fpRoot.getChildren().addAll(response, separator, tf);
		// ввести панель инструментов в нижней области панели граничной
		// компоновки
		rootNode.setBottom(tbDebug);
		// ввести панель поточной компоновки в центральной области панели
		// граничной компоновки
		rootNode.setCenter(fpRoot);
		// показать подмостки и сцену на них
		myStage.show();
	}

	// создать меню File с мнемоникой
	void makeFileMenu() {
		Menu fileMenu = new Menu("_File");// Файл
		// создать отдельные пункты меню File
		MenuItem open = new MenuItem("Open");// Открыть
		MenuItem close = new MenuItem("Close");// Закрыть
		MenuItem save = new MenuItem("Save");// Сохранить
		MenuItem exit = new MenuItem("Exit");// Выход
		// ввести пункты в меню File
		fileMenu.getItems().addAll(open, close, save, new SeparatorMenuItem(), exit);
		// ввести оперативные клавиши для быстрого выбора пунктов из меню File
		open.setAccelerator(KeyCombination.keyCombination("shortcut+O"));
		close.setAccelerator(KeyCombination.keyCombination("shortcut+C"));
		save.setAccelerator(KeyCombination.keyCombination("shortcut+S"));
		exit.setAccelerator(KeyCombination.keyCombination("shortcut+E"));
		// установить обработчики событий действия для пунктов меню File
		open.setOnAction(MEHandler);
		close.setOnAction(MEHandler);
		save.setOnAction(MEHandler);
		exit.setOnAction(MEHandler);
		// ввести меню File в строку меню
		mb.getMenus().add(fileMenu);
	}

	// создать меню Options
	void makeOptionsMenu() {
		Menu optionsMenu = new Menu("Options");// Параметры
		// создать подменю Colors
		Menu colorsMenu = new Menu("Colors");// Цвета
		// использовать отмечаемые флажками пункты меню, чтобы
		// пользователь мог выбрать сразу несколько цветов
		CheckMenuItem red = new CheckMenuItem("Red");// Красный
		CheckMenuItem green = new CheckMenuItem("Green");// Зеленый
		CheckMenuItem blue = new CheckMenuItem("Blue");// Синий
		// ввести отмечаемые флажками пункты в подменю Colors, а само подменю
		// Colors - в меню Options
		colorsMenu.getItems().addAll(red, green, blue);
		optionsMenu.getItems().add(colorsMenu);
		// задать зеленый цвет в качестве исходно выбираемого
		green.setSelected(true);
		// создать подменю Priority
		Menu priorityMenu = new Menu("Priority");// Приоритет
		// использовать отмечаемые кнопками-переключателями пункты меню для
		// установки приоритета.
		// Благодаря этому в меню не только отображается установленный
		// приоритет, но и гарантируется
		// установка одного и только одного приоритета
		RadioMenuItem high = new RadioMenuItem("High");
		RadioMenuItem low = new RadioMenuItem("Low");
		// создать группу кнопок-переключателей в пунктах подменю Priority
		ToggleGroup tg = new ToggleGroup();
		high.setToggleGroup(tg);
		low.setToggleGroup(tg);
		// отметить пункт меню High как исходно выбираемый
		high.setSelected(true);
		// ввести отмечаемые кнопками-переключателями пункты
		// в подменю Priority, а последнее-в меню Options
		priorityMenu.getItems().addAll(high, low);
		optionsMenu.getItems().add(priorityMenu);
		// ввести разделитель
		optionsMenu.getItems().add(new SeparatorMenuItem());
		// создать пункт меню Reset и ввести его в меню Options
		MenuItem reset = new MenuItem("Reset");// Сбросить
		optionsMenu.getItems().add(reset);
		// установить обработчики событий действия для пунктов меню Options
		red.setOnAction(MEHandler);
		green.setOnAction(MEHandler);
		blue.setOnAction(MEHandler);
		high.setOnAction(MEHandler);
		low.setOnAction(MEHandler);
		reset.setOnAction(MEHandler);
		// использовать приемник событий изменения, чтобы оперативно
		// реагировать на изменения в отметке пунктов подменю Priority
		// кнопками-переключателями
		tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> chanched, Toggle oldVal, Toggle newVal) {
				if (newVal == null)
					return;
				// привести значение newVal к типу RadioВUtton
				RadioMenuItem rmi = (RadioMenuItem) newVal;
				// отобразить результат выбора приоритета
				response.setText("Priority selected is " + rmi.getText());
				// Выбран указанный приоритет
			}
		});
		// ввести меню Options в строку меню
		mb.getMenus().add(optionsMenu);

	}

	// создать меню Help
	void makeHelpMenu() {
		// создать представление типа ImageView для изображения
		ImageView aboutIV = new ImageView("about_icon.png");
		// создать меню Belp
		Menu helpMenu = new Menu("Help");// Справка
		// создатьпунктAЬoutиввестиеговменюHelp
		MenuItem about = new MenuItem("About", aboutIV);// Опрограмме
		helpMenu.getItems().add(about);
		// установить обработчик событий действия для
		// пункта About меню Help
		about.setOnAction(MEHandler);
		// ввести меню Help в строку меню
		mb.getMenus().add(helpMenu);
	}

	// создать пункты контекстного меню
	void makeContextMenu() {
		// создать пункты для выбора команд редактирования из контекстного меню
		MenuItem cut = new MenuItem("Cut");// Вырезать
		MenuItem copy = new MenuItem("Copy");// Копировать

		MenuItem paste = new MenuItem("Paste");// Вставить
		// создать контекстное (т.е. всплывающее) меню
		// с пунктами для выбора команд редактирования
		editMenu = new ContextMenu(cut, copy, paste);
		// установить обработчики событий действия
		// для пунктов контекстного меню
		cut.setOnAction(MEHandler);
		copy.setOnAction(MEHandler);
		paste.setOnAction(MEHandler);
	}

	// создать панель инструментов
	void makeToolBar() {
		// создать кнопки для панели инструментов
		Button btnSet = new Button("SetBreakpoint", new ImageView("breakpoint_new.png"));
		Button btnClear = new Button("ClearBreakpoint", new ImageView("breakpoint_delete.png"));
		Button btnResume = new Button("ResumeExecution", new ImageView("breakpoint_run.png"));
		// отключить текстовые надписи на кнопках
		btnSet.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
		btnClear.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
		btnResume.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
		// задатьвсплывающиеподсказкидлякнопок
		btnSet.setTooltip(new Tooltip("Set а breakpoint."));
		// Установить точку прерывания
		btnClear.setTooltip(new Tooltip("Clear а breakpoint."));
		// очиститьточкупрерывания
		btnResume.setTooltip(new Tooltip("Resume execution."));
		// Возобновить выполнение создать панель инструментов
		tbDebug = new ToolBar(btnSet, btnClear, btnResume);

		// создать обработчик событий от кнопок на панели инструментов
		EventHandler<ActionEvent> btnHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				response.setText(((Button) ae.getTarget()).getText());
			}
		};

		// установить обработчики событий действия для кнопок на панели
		// инструментов
		btnSet.setOnAction(btnHandler);
		btnClear.setOnAction(btnHandler);
		btnResume.setOnAction(btnHandler);
	}
}