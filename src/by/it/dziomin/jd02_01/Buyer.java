package by.it.dziomin.jd02_01;

import java.util.ArrayList;
import java.util.List;

import static by.it.dziomin.jd02_01.Constants.COEFFICIENT_FOR_PENSIONER;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private String name;

    private boolean pensioner;

    private IMarket market;

    private Basket basket;

    Buyer(String name, boolean pensioner, IMarket market) {
        super(name);
        this.name = name;
        this.pensioner = pensioner;
        this.market = market;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        List<Good> goods = chooseGoods();
        putGoodsToBasket(goods);
        goOut();
    }

    @Override
    public void enterToMarket() {
        market.addBuyer(this);

        if (pensioner) {
            System.out.println(name + " enter to Market. He is a pensioner");
        } else{
            System.out.println(name + " enter to Market.");
        }
    }

    @Override
    public void takeBasket() {
        this.basket = market.getBasket();

        long timeout = sleeping(Util.getRandom(100, 200));
        System.out.println(name + " took the basket " + timeout / 1000.0 + " seconds");
    }

    @Override
    public List<Good> chooseGoods() {
        List<String> goodNames = Util.generateChoseGoods(market.getGoodsNames());

        List<Good> choseGoods = new ArrayList<>();
        goodNames.forEach(name -> choseGoods.add(market.getGood(name)));

        long timeout = sleeping(Util.getRandom(500, 2000));
        System.out.println(name + " chooses goods " + timeout / 1000.0 + " seconds");
        return choseGoods;
    }

    @Override
    public void putGoodsToBasket(List<Good> goods) {
        goods.forEach(good -> basket.addGood(good));

        long timeout = sleeping(Util.getRandom(100, 200));
        System.out.println(name + " put all goods in basket " + basket.toString() + ", " + timeout / 1000.0 + " seconds");
    }

    @Override
    public void goOut() {
        market.removeBuyer(this);
        System.out.println(name + " go out from market");
    }


    private long sleeping(long millis) {
        long timeToSleep = pensioner ? (long) (millis * COEFFICIENT_FOR_PENSIONER) : millis;
        Util.sleep(timeToSleep);
        return timeToSleep;
    }

}
