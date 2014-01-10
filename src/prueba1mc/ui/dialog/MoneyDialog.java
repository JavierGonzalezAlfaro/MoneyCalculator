

package prueba1mc.ui.dialog;

import prueba1mc.model.CurrencySet;
import prueba1mc.model.Money;


public interface MoneyDialog {
    public void execute (CurrencySet set);
    public Money getMoney();
    
}
