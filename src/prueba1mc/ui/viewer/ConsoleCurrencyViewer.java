package prueba1mc.ui.viewer;

import prueba1mc.model.Currency;

public class ConsoleCurrencyViewer implements CurrencyViewer {

    @Override
    public void show(Currency currency) {
        System.out.println(currency.getSymbol());
    }
}
