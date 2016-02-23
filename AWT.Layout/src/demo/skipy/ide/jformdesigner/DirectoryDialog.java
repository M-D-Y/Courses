package demo.skipy.ide.jformdesigner;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Tue Sep 11 23:23:31 MSD 2007
 */



/**
 * @author Eugene Matyushkin
 */
public class DirectoryDialog extends JFrame {
	public DirectoryDialog() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner non-commercial license
		cp = new JPanel();
		lblChooseDrive = new JLabel();
		cbxDrive = new JComboBox();
		btnOk = new JButton();
		lblChooseDirectory = new JLabel();
		btnCancel = new JButton();
		sp = new JScrollPane();
		diskTree = new JTree();
		btnCreate = new JButton();
		btnRoot = new JButton();

		//======== this ========
		setTitle("DirectoryDialog - JFormDesigner 3.0.4");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== cp ========
		{
			cp.setBorder(new EmptyBorder(5, 5, 5, 5));
			cp.setLayout(new GridBagLayout());

			//---- lblChooseDrive ----
			lblChooseDrive.setText("Choose Drive");
			cp.add(lblChooseDrive, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));

			//---- cbxDrive ----
			cbxDrive.setModel(new DefaultComboBoxModel(new String[] {
				"C:\\",
				"D:\\",
				"E:\\"
			}));
			cp.add(cbxDrive, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));

			//---- btnOk ----
			btnOk.setText("Ok");
			cp.add(btnOk, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 5, 0, 0), 0, 0));

			//---- lblChooseDirectory ----
			lblChooseDirectory.setText("Choose Directory");
			cp.add(lblChooseDirectory, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(0, 0, 0, 0), 0, 0));

			//---- btnCancel ----
			btnCancel.setText("Cancel");
			cp.add(btnCancel, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 5, 10, 0), 0, 0));

			//======== sp ========
			{
				sp.setViewportView(diskTree);
			}
			cp.add(sp, new GridBagConstraints(0, 3, 1, 2, 1.0, 1.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));

			//---- btnCreate ----
			btnCreate.setText("Create New...");
			cp.add(btnCreate, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 5, 10, 0), 0, 0));

			//---- btnRoot ----
			btnRoot.setText("Project Root...");
			cp.add(btnRoot, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
				GridBagConstraints.NORTH, GridBagConstraints.NONE,
				new Insets(0, 5, 0, 0), 0, 0));
		}
		contentPane.add(cp, BorderLayout.CENTER);
		setSize(400, 300);
		setLocationRelativeTo(null);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner non-commercial license
	private JPanel cp;
	private JLabel lblChooseDrive;
	private JComboBox cbxDrive;
	private JButton btnOk;
	private JLabel lblChooseDirectory;
	private JButton btnCancel;
	private JScrollPane sp;
	private JTree diskTree;
	private JButton btnCreate;
	private JButton btnRoot;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
