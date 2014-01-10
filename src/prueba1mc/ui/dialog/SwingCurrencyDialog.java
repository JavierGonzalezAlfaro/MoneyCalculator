
package prueba1mc.ui.dialog;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import prueba1mc.model.Currency;
import prueba1mc.model.CurrencySet;


public class SwingCurrencyDialog extends JPanel implements CurrencyDialog{
 
    private Currency currency;
    
    public SwingCurrencyDialog(){
    }

    private JPanel createDialogPanel(CurrencySet set) {
        JPanel panel = new JPanel();
        panel.add(createCurrencyDialog(set));
        return panel; 
   }

    private JComboBox createCurrencyDialog(final CurrencySet set) {
        Object[] array = new Object[set.toArray().length+1];
        Object[] array2 = set.toArray();
        array [0] = "Seleccione una Divisa";
        for (int i = 1; i < array.length; i++) {
            array[i] = array2[i-1];
            
        }
        final JComboBox combo = new JComboBox(array/*set.toArray()*/);
        combo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                String currencyName = combo.getSelectedItem().toString();
                currency = set.search(currencyName)[0];
            }
        });
        
        return combo;
    }

    @Override
    public void execute(CurrencySet set) {
        SwingMoneyDialog.addPanel(createPanel(set));
    }

    @Override
    public Currency getCurrency() {
        return currency;
    }

    public void executeMoneyPanel(CurrencySet set) {
        this.add(createDialogPanel(set));
    }

    private JPanel createPanel(CurrencySet set) {
        this.add(createCurrencyDialog(set));
        return this;
    }

}
