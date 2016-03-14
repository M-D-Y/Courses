
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

public class CheckMenuDemo extends Application {
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
		
		//ввести оперативные клавиши для быстрого выбора пунктов меню File
		open.setAccelerator(KeyCombination.keyCombination("shortcut+O"));
		close.setAccelerator(KeyCombination.keyCombination("shortcut+C"));
		save.setAccelerator(KeyCombination.keyCombination("shortcut+S"));
		exit.setAccelerator(KeyCombination.keyCombination("shortcut+E"));
		
		fileMenu.getItems().addAll(open, close, save, new SeparatorMenuItem(), exit);
		// ввести меню File в строку меню
		mb.getMenus().add(fileMenu);

		//создать меню Options
		Menu optionsMenu = new Menu("Options");
		//создать подменю Colors
		Menu colorsMenu = new Menu("Colors");
		//использовать отмечаемые флажками пункты меню, чтобы
		//пользователь мог выбрать сразу несколько цветов
		CheckMenuItem red = new CheckMenuItem ("Red");
		CheckMenuItem green = new CheckMenuItem("Green");
		CheckMenuItem blue = new CheckMenuItem("Blue");
		colorsMenu.getItems().addAll(red, green, blue);
		optionsMenu.getItems().add(colorsMenu);
		//выбрать по умолчанию зеленый цвет
		green.setSelected(true);
		//создать подменю Priority
		Menu priorityMenu = new Menu("Priority");
		//использовать отмечаемые кнопками-переключателями пункты
		//меню для установки приоритета. Благодаря этому в меню не
		//только отображается установленный приоритет, но и
		//гарантируется установка одного и только одного приоритета
		RadioMenuItem high = new RadioMenuItem("High");
		RadioMenuItem low = new RadioMenuItem("Low");
		//создать группу кнопок-переключателей в пунктах подменюPriority
		ToggleGroup tg = new ToggleGroup();
		high.setToggleGroup(tg);
		low.setToggleGroup(tg);
		//отметитьисходнопунктменюHiqhкакисходновыбираемый
		high.setSelected(true);
		//ввестиотмечаемыекнопками-переключателямипункты
		//вподменюPriority,апоследнее-вменюOptions
		priorityMenu.getItems().addAll(high,low);
		optionsMenu.getItems().add(priorityMenu);
		//ввестиразделитель
		optionsMenu.getItems().add(new SeparatorMenuItem());
		//создатьпунктменюReset
		MenuItem reset = new MenuItem("Reset");
		optionsMenu.getItems().add(reset);
		//инаконец,ввестименюOptionsвстрокуменю
		mb.getMenus().add(optionsMenu);


		// создать меню Help
		Menu helpMenu = new Menu("Help");// Справка
		ImageView aboutIV = new ImageView("about_icon.png");
		//MenuItem about = new MenuItem("About", aboutIV); //1-ый способ
		MenuItem about = new MenuItem("AЬout");// о программе
		about.setGraphic(aboutIV); //1-ой способ
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
		// показать подмостки и сцену на них
		myStage.show();
	}
}