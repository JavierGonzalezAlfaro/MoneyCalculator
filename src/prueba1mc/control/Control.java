package prueba1mc.control;

import javax.swing.JFrame;
import prueba1mc.model.CurrencySet;
import prueba1mc.persistance.CurrencySetLoader;
import prueba1mc.persistance.ExchangeRateLoader;
import prueba1mc.ui.dialog.CurrencyDialog;
import prueba1mc.ui.dialog.MoneyDialog;
import prueba1mc.ui.viewer.MoneyViewer;

public class Control {

    private CurrencySetLoader loader;
    private MoneyDialog moneyDialog;
    private CurrencyDialog currencyDialog;
    private ExchangeRateLoader exchangeloader;
    private MoneyViewer moneyViewer;

    public Control(CurrencySetLoader loader, MoneyDialog moneyDialog, CurrencyDialog currencyDialog, ExchangeRateLoader exchangeloader, MoneyViewer moneyViewer) {
        this.loader = loader;
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.exchangeloader = exchangeloader;
        this.moneyViewer = moneyViewer;
    }

    public void execute() {
        CurrencySet currencySet = loader.load();
        moneyDialog.execute(currencySet);
        currencyDialog.execute(currencySet);
//        ExchangeRate rate = exchangeloader.load(moneyDialog.getMoney().getCurrency(), currencyDialog.getCurrency());
//        Money money = MoneyExchanger.exchange(moneyDialog.getMoney(), rate);
//        moneyViewer.show(money);


    }
}
