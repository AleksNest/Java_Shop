public abstract class Human implements Communication {              // есть две сущности продавуц и покупатель - абстрактный класс человек, подключен к интерфейсу Communication
    private String name;
    private double money;
    private int loveIndex;                                          // уровень вежливости (любимый продавец, покупатель)

    public Human(String name, double money, int loveIndex) {        // конструктор  имя, деньги,
        this.name = name;
        this.money = money;
        this.loveIndex = loveIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getLoveIndex() {
        return loveIndex;
    }


}
