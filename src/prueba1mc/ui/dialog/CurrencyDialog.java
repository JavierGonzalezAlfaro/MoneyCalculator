
package prueba1mc.ui.dialog;

import prueba1mc.model.Currency;
import prueba1mc.model.CurrencySet;

public interface CurrencyDialog {
    
    public void execute(CurrencySet set);
    public Currency getCurrency();
}
