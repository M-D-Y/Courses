
//Окончательный вариант программы MenuDemoCompleted
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MenuDemoCompleted implements ActionListener {
	JFrame jfrm;
	JLabel jlab;
	JMenuBar jmЬ;
	JToolBar jtb;
	JPopupMenu jpu;
	DebugAction setAct;
	DebugAction clearAct;
	DebugAction resumeAct;

MenuDemoCompleted(){
//создать новый контейнер тиnа JFrame
jfrm = new JFrame("Menu Demo Completed");
//Полная демонстрация меню
//использовать граничную компоновку, выбираемую по умолчанию
//задать исходные размеры фрейма
jfrm.setSize(360, 200);
//завершить прикладную программу, когда пользователь закроет ее окно
jfrm.setDefaultCloseOperatioп(JFrame.EXIT_ON_CLOSE);
//создать метку для отображения результатов выбора из меню
jlab = new JLabel();
//создать строку меню
jmb =new JМenuBar();
//создатьменюFile
makeFileMenu();
//создать действия отладки
makeActions();
//создать панель инструментов
makeToolBar();
//создать меню Options
makeOptionsMenu();
//создать меню Help
makeHelpMenu();
//создать меню Edit
makeEditPUМenu();
//ввести приемник событий запуска всплывающего меню
jfrm.addМouseListener(

	newMouseAdapter(){

	public void mousePressed(MouseEvent me) {
		if (me.isPopupTrigger())
			jpu.show(me.getComponent(), me.getX(), me.getY());
	}

};

	public void mouseReleased(MouseEvent me) {
		if (me.isPopupTrigger())
			jpu.show(me.getComponent(), me.getX(), me.getY());
	}

	});

	// ввести метку в центре панели содержимого
	jfrm.add(jlab,SwingConstants.CENTER);
	// ввести панель инструментов в северном положении панели содержимого
	jfrm.add(jtb,BorderLayout.NORTH);
	// ввести строку меню во фрейм
	jfrm.setJМenuBar(jmЬ);
	// отобразить фрейм
	jfrm.setVisible(true);}

	// Обработать события действия от пунктов меню.
	// Здесь НЕ обрабатываются события, генерируемые
	// при выборе режимав отладки вподменю или напанели инструментов Debug
	public void actionPerformed(ActionEvent ae) {
		// получить команду действия из выбранного меню
		String comStr = ae.getActionCommand();
		// выйти из программы, если пользователь выберет пункт меню Exit
		if (comStr.equals("Exit"))
			System.exit(0);
		// отобразить в противном случае результат выбора из меню
		jlab.setText(comStr + " Selected");
		// Класс действий для подменю и панели инструментов Debug
	}
}

class DebugAction extends AЬstractAction {
public DebugAction(String name, Iconimage, int mnem, int ассеl, String tTip){
	super(name,image);
	putValue(ACCELERATORКЕУ, KeyStroke.getKeyStroke(ассеl, InputEvent.CTRLDOWNМАSК));
	putValue(МNEMONICКЕУ,newInteger(mnem));-putValue(SHORT_DESCRIPTION,tTip);
}

	// обработать события как на панели инструментов, так и в подменю Debug
	public void actionPerformed(ActionEvent ае) {
		String comStr = ae.getActionCommand();
		jlab.setText(comStr + " Selected");// Выбрать указанное
		// изменить разрешенное состояние вариантов выбора
		// режимов установкии очистки точек прерывания
		if (comStr.equals("Set Breakpoint")) {
			clearAct.setEnaЬled(true);
			setAct.setEnaЬled(false);
		} else if (comStr.equals("Clear Breakpoint")) {
			clearAct.setEnaЫed(false);
			setAct.setEnaЫed(true);
		}
	}

	}

	// создать меню File с мнемоникой и оперативными клавишами
void makeFileMeпu(){
JМenu jmFile = new JМenu("File");
jmFile.setMnemonic(KeyEvent.VK_F);
JMenuitem jmiOpen = new JMenuitem("Open",KeyEvent.VK_O);
jmiOpen.setAccelerator(
KeyStroke.getKeyStroke(
KeyEvent.VK_O,InputEvent.CTRL_DOWN_МASK));
JМenuitemjmiClose=newJМenuitem("Close",KeyEvent.VKС);
jmiClose.setAccelerator(-
KeyStroke.getKeyStroke(
KeyEvent.VK_C,InputEvent.CTRL_DOWN_МASK));
JМenuitemjmiSave=newJМenuitem("Save",KeyEvent.VKS);
jmiSave.setAccelerator(
-
KeyStroke.getKeyStroke(
KeyEvent.VKs,InputEvent.CTRLDOWNМАSК));
JМenuitemjmiExit=newJМenuitem("Exit",KeyEvent:-vкЕ);
jmiExit.setAccelerator(
-
KeyStroke.getKeyStroke(KeyEvent.VKЕ,
InputEvent.CTRL_DOWN_МASK));
jmFile.add(jmiOpen);
jmFile.add(jmiClose);
jmFile.add(jmiSave);
jmFile.addSeparator();
jmFile.add(jmiExit);
jmЬ.add(jmFile);
//ввестиприемникидействийдляпунктовменюFile
jmiOpen.addActionListener(this);
jmiClose.addActionListener(this);
jmiSave.addActionListener(this);
jmiExit.addActionListener(this);
//создатьменюOptiona
voidmakeOptionsMenu()(
JМenujmOptions􀁰newJМenu("Options");
//создатьподменюColora
JМenujmColors=newJMenu("Colors");
//использоватьфлажки,чтобыпользовательмогвыбрать
//сразунесколькоцветов
JCheckBoxMenuitemjmiRed=newJCheckBoxMenuitem("Red");
JCheckBoxMenuitemjmiGreen=newJCheckBoxMenuitem("Green");
JCheckBoxMenuitemjmiBlue=newJCheckBoxMenuitem("Blue");
//ввестипунктывподменюColors
jmColors.add(jmiRed);
jmColors.add(jmiGreen);
jmColors.add(jmiBlue);
jmOptions.add(jmColors);
//создатьподменюPriority
1205
1206Часть//1.ВведениевпрограммированиеГПИсредствамиSwing
JМenujmPriority=newJМenu("Priority"J;
//Использоватькнопки-переКJIJ)Чателидляустановкиприоритета.
//Благодаряэтомувменюне·толькоотображаетсяустановленный
//приоритет,ноигарантируетсяустановкаодногоитолько
//одногоприоритета.Исходновыбираетсякнопка-переключатель
//впунктеменюBigh
JRadioButtonМenuitemjmiHigh=
newJRadioButtonMenuitem("High",true);
JRadioButtonМenuitemjmiLow=
newJRadioButtonMenuitem("Low"J;
//ввестипунктывподменюPriority
jmPriority.add(jmiHigh);
jmPriority.add(jmiLow);
jmOptionз.add(jmPriority);
//создатьгруппукнопок-переключателей
//впунктахподменюPriority
ButtonGroupbg=newButtonGroup();
bg.add(jmiHigh);
bg.add(jmiLow);
//создатьподменюDeЬug,входящеевменюOptiona,
//используядействиядлясозданияпунктовэтогоподменю
JМenujmDebug=newJМenu("Debug"J;
JМenuitemjmiSetBP=newJМenuitem(зetAct);
JМenuitemjmiClearBP=newJМenuitem(clearAct);
JМenuitemjmiReзume=newJМenuitem(resumeAct);
//ввестипунктывподменюDeЬug
jmDebug.add(jmiSetBP);
jmDebug.add(jmiClearBP);
jmDebug.add(jmiResumeJ;
jmOptionз.add(jmDebug);
//создатьпунктменюR8set
JМenuitemjmiReset=newJМenuitem("Reset");
jmOptions.addSeparator();
jmOptions.add(jmiReset);
//Инаконец,ввестивсевыбираемыеменювстрокуменю
jmЬ.add(jmOptionз);
//ввестиприемникидействийдляпунктовменюOptions,
//крометех,чтоподдерживаютсявподменюDeЬug
jmiRed.addActionLiзtener(this);
jmiGreen.addActionListener(this);
jmiBlue.addActionListener(this);
jmiHigh.addActionListener(this);
jmiLow.addActionListener(this);
jmiReset.addActionListener(this);
//создатьменюBelp
voidmakeHelpMenu(){
JМenujmнelp=newJМenu("Help");
//ввестизначокдляпунктаменюAЬout
Imageiconicon=newImageicon("AЬouticon.gif");
Глава33.ВведениевменюSwing
JМenuitemjmiAЬout=newJМenuitem("AЬout",icon);
jmiAЬout.setToolTipText("InfoabouttheMenuDemoprogram.");
jmНelp.add(jmiAЬout);
jmЬ.add(jmНelp);
//ввестиприемникдействийдляпунктаменюAЬout
jmiAЬout.addActionListener(this);
//создатьдействиядляуправленияподменюи
//панельюинструментовDeЬug
voidmakeActions(){
//загрузитьизображениядляобозначениядействий
Image!conseticon=newImageicon("setBP.gif");
Imageiconclearicon=newImageicon("clearBP.gif");
Imageiconresumeicon=newImageicon("resume.gif");
//создатьдействия
setAct=
newDebugAction("SetBreakpoint",
set!con,
KeyEvent.VKS,
KeyEvent.VK
-
B,
"Setаbreakpoint.");
clearAct=
newDebugAction("ClearBreakpoint",
clearicon,
KeyEvent.VKС,
KeyEvent.VK
-
L,
"Clearаbreakpoint.");
resumeAct=
newDebugAction("Resume",
resumeicon,
KeyEvent.VКR,
KeyEvent.VK
-
R,
"Resumeexecutionafterbreakpoint.");
//InitiallydisaЫetheClearBreakpointoption.
clearAct.setEnaЫed(false);
//создатьпанельинструментовDeЬug
voidmakeToolBar(){
//создатькнопкидляпанелиинструментов,
//используясоответствующиедействия
JButtonjbtnSet=newJButton(setAct);
JButtonjbtnClear=newJButton(clearAct);
JButtonjbtnResume=newJButton(resumeAct);
//создатьпанельинструментовDeЬuq
jtb=newJToolBar("Breakpoints");
//ввестикнопкинапанелиинструментов
jtb.add(jbtnSet);
jtb.add(jbtnClear);
jtb.add(jbtnResume);
//создатьвсплывающееменюEdit
1207
1208Часть//1.ВведениевпрограммированиеГПИсредствамиSwing

voidmakeEditPUMeпu(){
jpu=пеwJPopupMeпu();
//создатьпунктывсплывающегоменюEdit
JМeпuitemjmiCut=пеwJМenu!tem("Cut");
JМeпuitemjmiCopy=пеwJМenultem("Copy");
JМenuitemjmiPaste=newJMenuitem("Paste");
//ввестипунктывовсплывающееменюEdit
jpu.add(jmiCut);
jpu.add(jmiCopy);
jpu.add(jmiPaste);
//ввестиприемникидействийдлявсплывающегоменюEdit
jmiCut.addActionListener(this);
jmiCopy.addActionListener(this);
jmiPaste.addActionListener(this);
puЫicstaticvoidmain(Stringargs[]){
//создатьфреймвпотокедиспетчеризациисобытий
SwiпgUtilities.invokeLater(

	newRunnaЬle(){

puЬlicvoidrun(){
}
});пеwMeпuDemo();Дал