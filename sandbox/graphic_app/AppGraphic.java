package projectsByJava.graphic_app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppGraphic extends  JFrame{

    JTextField name_field;
    JTextField mail_field;
    String isMale;
    JRadioButton male, femile;
    JCheckBox checkBox;


    public AppGraphic () {
        super("Контактная форма");
        super.setBounds(400, 300, 400, 400);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(10, 10, 5, 5));

        JLabel name = new JLabel("Введите имя: ");
        name_field = new JTextField("", 3 );
        JLabel mail = new JLabel("Введите mail: ");
        mail_field = new JTextField("@", 3);

        container.add(name);
        container.add(name_field);
        container.add(mail);
        container.add(mail_field);

        male = new JRadioButton("Man");
        femile = new JRadioButton("Woman");
        checkBox = new JCheckBox("Согласен? ", false);
        JButton send_button = new JButton("Отправить");

        male.setSelected(true);

        container.add(male);
        container.add(femile);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(femile);

        container.add(checkBox);
        container.add(send_button);

        send_button.addActionListener(new SendMassege());
    }

    class SendMassege implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = name_field.getText();
            String email = mail_field.getText();

            isMale = "Nam";
            if(!male.isSelected()) {
                isMale = "Woman";
            }

            boolean check = checkBox.isSelected();

            JOptionPane.showMessageDialog(null,"Ваша почта: "+ email, "Привет, " + name,
                    JOptionPane.PLAIN_MESSAGE);

        }
    }
}
