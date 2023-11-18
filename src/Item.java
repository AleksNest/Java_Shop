public class Item {                                 // клас товар
    private String nameOfItem;                      // имя товара
    private double cost;                            // цена товара
    private Category category;                      // категория товара класса Категория

    public Item(String nameOfItem, double cost, Category category) {            // конструктор
        this.nameOfItem = nameOfItem;
        this.cost = cost;
        this.category = category;
    }

    public String getNameOfItem() {
        return nameOfItem;
    }                           // геттер на имя

    public void setNameOfItem(String nameOfItem) {
        this.nameOfItem = nameOfItem;
    }   // сеттер на имя

    public double getCost() {
        return cost;
    }                                       // геттер на цену

    public void setCost(double cost) {
        this.cost = cost;
    }                           // сеттер на цену

    public Category getCategory() {
        return category;
    }                               // геттер на категорию товара

    public void setCategory(Category category) {
        this.category = category;
    }               // сеттер на категорию товара

    @Override
    public String toString() {
        return nameOfItem;
    }


}