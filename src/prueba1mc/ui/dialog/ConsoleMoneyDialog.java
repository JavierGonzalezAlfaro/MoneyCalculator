package prueba1mc.ui.dialog;

import java.io.BufferedReader;
import prueba1mc.model.Number;
import java.io.InputStreamReader;
import prueba1mc.model.Currency;
import prueba1mc.model.CurrencySet;
import prueba1mc.model.Money;

public class ConsoleMoneyDialog implements MoneyDialog {

    private Money money;
    
    @Override
    public Money getMoney() {
        return money;
    }

    @Override
    public void execute(CurrencySet set) {
        money = new Money(readAmount(), readCurrency(set));
    }

    private Number readAmount() {
        while (true) {
            System.out.println("Introduce una cantidad de dinero");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                return new Number(Integer.parseInt(reader.readLine()),1);
            } catch (Exception e) {
                System.out.println("Cantidad de dinero no valida!");
            }
        }
    }

    private Currency readCurrency(CurrencySet set) {
        CurrencyDialog dialog = new ConsoleCurrencyDialog();
        dialog.execute(set);
        return dialog.getCurrency();
    }
}
