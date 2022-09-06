import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm {
    private JPanel mainPanel;
    private JPanel namePanel;
    private JTextField lastNameField;
    private JTextField firstNameField;
    private JTextField patronymicField;
    private JLabel lastNameLabel;
    private JLabel firstNameLabel;
    private JLabel patronymicLabel;
    private JButton collapseButton;
    private JButton expandButton;
    private JTextField fullNameField;
    private JLabel fullNameLabel;
    private JButton clearButton;

    private JPanel jPanel;

    public MainForm() {

        collapseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isEmpty(lastNameField.getText()) || isEmpty(firstNameField.getText())){
                    JOptionPane.showMessageDialog(mainPanel, "Нужно заполнить хотя бы фамилию и имя");
                } else if(!checkNameFormat()){
                    JOptionPane.showMessageDialog(mainPanel, "Неверный формат имени");
                } else {
                    disableSeparatedFields();
                    enableFullNameField();
                    fullNameField.setText(getFullName());
                }
            }
        });

        expandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getSeparatedName()) {
                    clearFullNameField();
                    disableFullNameField();
                    enableSeparatedFields();
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Неверный формат имени. " +
                            "Нужно указать хотя бы фамилию и имя");
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFullNameField();
                clearSeparatedFields();
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public boolean checkNameFormat() {
        if (lastNameField.getText().contains(" ") ||
        firstNameField.getText().contains(" ") ||
        patronymicField.getText().contains(" ")) {
            return false;
        }
        return true;
    }

    public String getFullName() {
        String fullName = lastNameField.getText() + " " +
                firstNameField.getText() + " " + patronymicField.getText();
        clearSeparatedFields();
        return fullName.trim();
    }

    public void clearSeparatedFields() {
        lastNameField.setText("");
        firstNameField.setText("");
        patronymicField.setText("");
    }

    public void disableSeparatedFields() {
        lastNameField.setVisible(false);
        lastNameLabel.setVisible(false);
        firstNameField.setVisible(false);
        firstNameLabel.setVisible(false);
        patronymicField.setVisible(false);
        patronymicLabel.setVisible(false);
        collapseButton.setVisible(false);
    }

    public void enableSeparatedFields() {
        lastNameField.setVisible(true);
        lastNameLabel.setVisible(true);
        firstNameField.setVisible(true);
        firstNameLabel.setVisible(true);
        patronymicField.setVisible(true);
        patronymicLabel.setVisible(true);
        collapseButton.setVisible(true);
    }

    public void clearFullNameField() {
        fullNameField.setText("");
    }

    public boolean getSeparatedName() {
        String[] fullName = fullNameField.getText().split(" ");
        if (fullName.length == 2) {
            lastNameField.setText(fullName[0]);
            firstNameField.setText(fullName[1]);
            return true;
        }
        if (fullName.length == 3) {
            lastNameField.setText(fullName[0]);
            firstNameField.setText(fullName[1]);
            patronymicField.setText(fullName[2]);
            return true;
        }
        return false;
    }

    public void disableFullNameField() {
        fullNameField.setVisible(false);
        fullNameLabel.setVisible(false);
        expandButton.setVisible(false);
    }

    public void enableFullNameField() {
        fullNameField.setVisible(true);
        fullNameLabel.setVisible(true);
        expandButton.setVisible(true);
    }

    public boolean isEmpty(String name) {
        return name.isEmpty();
    }
}
