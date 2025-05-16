package prac7;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sifiso
 */
public class Prac7Gui extends JFrame implements ItemListener, ActionListener {

    private final JPanel westpnl, eastpnl, southpnl, northpnl, southeast;
    private final JComboBox box;
    private final JLabel boxOutput, firstName, secondName, radioName;
    private final JTextField firstInput, secondInput;
    private final JButton addButton, exitButton;
    private final JRadioButton jradioOption1, jradioOption2;
    private final ButtonGroup group;
    private final JTable table;
    private final DefaultTableModel tableModel;
    private final JScrollPane scrollPane;
    private String first, second, comboboxInfo, jradiobuttonInfo, output;
    private FileWriter fw;
    private BufferedWriter bw;

    public Prac7Gui() {

        super("Prac6 Gui");

        northpnl = new JPanel();
        eastpnl = new JPanel();
        westpnl = new JPanel();
        southpnl = new JPanel();
        southeast = new JPanel();
        comboboxInfo = "null";

        northpnl.setPreferredSize(new Dimension(785, 140));
        southpnl.setPreferredSize(new Dimension(785, 25));

        String[] departments = {"None", "Graphic Design", "Civil Engineering", "Information Technology"};
        box = new JComboBox(departments);

        boxOutput = new JLabel("select a department");
        firstName = new JLabel("First Name:");
        secondName = new JLabel("Second Name:");
        radioName = new JLabel("Employment Type:");

        firstInput = new JTextField();
        secondInput = new JTextField();

        jradioOption1 = new JRadioButton("Permanent");
        jradioOption2 = new JRadioButton("Temporary");
        group = new ButtonGroup();

        addButton = new JButton("Save to File");
        exitButton = new JButton("Exit");
        addButton.setPreferredSize(new Dimension(392, 20));
        exitButton.setPreferredSize(new Dimension(392, 20));

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        first = firstInput.getText();
        second = secondInput.getText();

    }

    public void setGui() {

        northpnl.setLayout(new GridLayout(1, 2));
        westpnl.setLayout(new GridLayout(5, 1));
        eastpnl.setLayout(new GridLayout(5, 1));
        southpnl.setLayout(new GridLayout(1, 2));
        southeast.setLayout(new GridLayout(5, 1));
        westpnl.add(boxOutput);
        westpnl.add(firstName);
        westpnl.add(secondName);
        westpnl.add(radioName);

        eastpnl.add(box);
        eastpnl.add(firstInput);
        eastpnl.add(secondInput);

        group.add(jradioOption1);
        group.add(jradioOption2);
        eastpnl.add(jradioOption1);
        eastpnl.add(jradioOption2);

        southpnl.add(addButton);
        southpnl.add(exitButton);

        tableModel.addColumn("Department");
        tableModel.addColumn("First Name");
        tableModel.addColumn("Second Name");
        tableModel.addColumn("Employment Type");

        add(scrollPane);

        northpnl.add(westpnl, BorderLayout.WEST);
        northpnl.add(eastpnl, BorderLayout.EAST);

        this.add(northpnl, BorderLayout.NORTH);
        this.add(southpnl, BorderLayout.SOUTH);

        addButton.addActionListener(this);
        exitButton.addActionListener(this);

        box.addItemListener(this);

    }

    @Override
    public void itemStateChanged(ItemEvent event) {
        if (event.getStateChange() == ItemEvent.SELECTED) {
            comboboxInfo = (String) box.getSelectedItem();
        }

    }

    @Override
    public void actionPerformed(ActionEvent select) {

        if (select.getSource().equals(addButton)) {
            if (jradioOption1.isSelected()) {
                jradiobuttonInfo = jradioOption1.getText();
            } else if (jradioOption2.isSelected()) {
                jradiobuttonInfo = jradioOption2.getText();
            }

            first = firstInput.getText();
            second = secondInput.getText();
            tableModel.addRow(new Object[]{comboboxInfo, first, second, jradiobuttonInfo});
          //  output = comboboxInfo + " # " + first + " # " + second + " # " + jradiobuttonInfo + "\n";
            Employee emp = new Employee(comboboxInfo, first, second, jradiobuttonInfo);
            emp.writeToFile(emp.toString());
            box.setSelectedItem("");
            firstInput.setText("");
            secondInput.setText("");
            group.clearSelection();

        } else if (select.getActionCommand().equals("Exit")) {
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "Please type in proper infomation");
        }
    }
}//End of class
