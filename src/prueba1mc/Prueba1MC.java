package prueba1mc;


import prueba1mc.control.Control;
import prueba1mc.persistance.CurrencySetLoader;
import prueba1mc.persistance.ExchangeRateLoader;
import prueba1mc.persistance.mock.MockCurrencySetLoader;
import prueba1mc.persistance.mock.MockExchangeRateLoader;
import prueba1mc.ui.dialog.CurrencyDialog;
import prueba1mc.ui.dialog.MoneyDialog;
import prueba1mc.ui.dialog.SwingCurrencyDialog;
import prueba1mc.ui.dialog.SwingMoneyDialog;
import prueba1mc.ui.viewer.ConsoleMoneyViewer;
import prueba1mc.ui.viewer.MoneyViewer;


public class Prueba1MC {

    public static void main(String[] args) {
        
        CurrencySetLoader loader = new MockCurrencySetLoader();
        MoneyDialog moneyDialog = new SwingMoneyDialog();
        CurrencyDialog currencyDialog = new SwingCurrencyDialog();
        ExchangeRateLoader exchangeloader = new MockExchangeRateLoader();
        MoneyViewer moneyViewer = new ConsoleMoneyViewer();
        Control control = new Control(loader, moneyDialog, currencyDialog, exchangeloader, moneyViewer);
        control.execute();

    }
}
