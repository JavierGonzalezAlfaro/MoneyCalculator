

package prueba1mc.ui.viewer;

import prueba1mc.model.Money;


public class ConsoleMoneyViewer implements MoneyViewer{
    
    @Override
    public void show(Money money) {
        System.out.println(money);
    }

}
