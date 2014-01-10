
package prueba1mc.persistance.mock;

import prueba1mc.model.Currency;
import prueba1mc.model.CurrencySet;
import prueba1mc.persistance.CurrencySetLoader;

public class MockCurrencySetLoader implements CurrencySetLoader{
    private CurrencySet instance;
    @Override
    public CurrencySet load() {
        instance = CurrencySet.getInstance();
        instance.add(new Currency("Dolar Americano","USD","$"));
        instance.add(new Currency("Dolar Canadiense","CND","T"));
        instance.add(new Currency("Euro","EUR","E"));
        instance.add(new Currency("Libra","LIB","L"));
        return instance;
    }

    
}
