

package prueba1mc.ui.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JTextField;
import prueba1mc.model.Number;
import prueba1mc.model.Currency;
import prueba1mc.model.CurrencySet;
import prueba1mc.model.Money;


public class SwingMoneyDialog extends JFrame implements MoneyDialog {


    private Money money;
    private Number amount;
    private Currency currency;
    private SwingCurrencyDialog currencyDialog = new SwingCurrencyDialog();
    final JTextField textField = new JTextField(10);
    private static JFrame frame = new JFrame();
    private static JPanel panel = new JPanel();

    public static JFrame getFrame() {
        return frame;
    }
    
    @Override
    public void execute(CurrencySet set) {
        frame.setTitle("Money Calculator");
        frame.setMinimumSize(new Dimension(400,150));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        createComponents(set);
        frame.setVisible(true);
    }

    @Override
    public Money getMoney() {
        return money;
    }

     private void createComponents(CurrencySet set) {
        frame.add(createButtonsPanel(), BorderLayout.SOUTH);
        frame.add(createDialogPanel(set));
    }

    private JPanel createButtonsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel.add(createCalculateButton());
        panel.add(createExitButton());
        return panel;
    }

    private JButton createCalculateButton() {
        final JButton button = new JButton();
        button.setText("Calculate");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Calculando...");
                amount = new Number(Integer.parseInt(textField.getText()),1);
                currency = currencyDialog.getCurrency();
                money = new Money(amount,currency);
                System.out.println(money);
            }
        });
        return button;
    }

    private JButton createExitButton() {
        final JButton button = new JButton("Exit");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        return button;
    }

    private JPanel createDialogPanel(CurrencySet set) {
        JPanel panel = new JPanel();
        panel.add(createAmountDialog());
        panel.add(createMoneyDialog(set));
        return panel;
    }

    private JTextField createAmountDialog() {
       // final JTextField field = new JTextField(10);
        textField.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                amount = new Number(Integer.parseInt(textField.getText()),1);
            }
        });
        return textField;
    }

    private SwingCurrencyDialog createMoneyDialog(CurrencySet set) {
        //SwingCurrencyDialog dialog = new SwingCurrencyDialog();
        //dialog.execute(set);
        //return dialog;
        currencyDialog.executeMoneyPanel(set);
        return currencyDialog;
    }
    
    public static void addPanel(JPanel panel) {
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        frame.add(panel, BorderLayout.NORTH);
    }

}
