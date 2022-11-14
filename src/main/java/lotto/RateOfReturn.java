package lotto;

import lotto.view.LottoView;

public class RateOfReturn {
    private static final String BEFORE_RATE = "총 수익률은 ";
    private static final String AFTER_RATE = "입니다.";
    private static final String UNIT = "%";
    private static double ROUNDS = 10.0;

    private Win win;
    private int money;
    private LottoView view;

    public RateOfReturn(Win win, int money, LottoView view) {
        this.win = win;
        this.money = money;
        this.view = view;
    }

    public RateOfReturn(Win win, int money) {
        this.win = win;
        this.money = money;
    }

    public void printRate(double rate) {
        StringBuilder context = new StringBuilder();

        context.append(BEFORE_RATE).append(rate)
                .append(UNIT).append(AFTER_RATE);

        view.printMessage(context.toString());
    }

    public double calculate() {
        double percentage = getPercentage();

        return getRounds(percentage);
    }

    private double getRounds(double percentage) {
        return Math.round((percentage * ROUNDS)) / ROUNDS;
    }

    private double getPercentage() {
        return win.getWinnings() / money * 100;
    }
}