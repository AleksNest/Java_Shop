import java.util.ArrayList;
import java.util.List;

public interface Communication {                    // интерфейс навешиваем на класс Human (чтобы работал с дочерними классами Seller И Consumer )

    default double costOfItem(Item item) {
        return item.getCost();                          // стоимость товара
    }


    default void isItemsInStorage(Seller seller, List<Item> wishListOfConsumer) {

        for (int i = 0; i < wishListOfConsumer.size(); i++) {
            int count = 0;

            for (int j = 0; j < seller.getItems().size(); j++) {
                if (seller.getItems().get(j).toString() == (wishListOfConsumer.get(i)).toString()) {
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("у нас нет  " + wishListOfConsumer.get(i));//  вывод товара которого нет у продавца
                int count1 = 0;

                String str2 = wishListOfConsumer.get(i).toString();
                String[] str3 = wishListOfConsumer.get(i).toString().split(" ");

                for (int j = 0; j < seller.getItems().size(); j++) {
                    String str1 = seller.getItems().get(j).toString();


                    if (str1.contains(str3[0])) {
                        if (count1 == 0) System.out.println("могу предложить взамен: ");
                        System.out.println(seller.getItems().get(j) + " про цене: " + costOfItem(seller.getItems().get(j)));
                        count1++;
                    }
                }

            }

        }
    }


//
//    default void isItemsInStorage(Seller seller, List<Item> wishListOfConsumer) {
//
//        for (int i = 0; i < wishListOfConsumer.size(); i++) {
//            int count = 0;
//
//            for (int j = 0; j < seller.getItems().size(); j++) {
//                if (seller.getItems().get(j).toString() == (wishListOfConsumer.get(i)).toString()) {
//                    count++;
//                }
//            }
//            if (count == 0) {
//                System.out.println("у нас нет  " + wishListOfConsumer.get(i));//  вывод товара которого нет у продавца
//                int count1 = 0;
//
//                String str2 = wishListOfConsumer.get(i).toString();
//
//                for (int j = 0; j < seller.getItems().size(); j++) {
//                    String str1 = seller.getItems().get(j).toString();
//
//                    if (str1.contains(str2) ){
//                        if (count1 == 0) System.out.println("могу предложить взамен: ");
//                        System.out.println(seller.getItems().get(j) + " про цене: " + costOfItem(seller.getItems().get(j)));
//                        count1++;
//                    }
//                }
//
//            }
//
//        }
//    }


//    default void isItemsInStorage(Seller seller, List<Item> wishListOfConsumer) {           // метод отсутствия позиций на складе товара, указанного в списке покупателя
//
//        for (Item item : wishListOfConsumer) {                                             // список желаний покупателя
//
//            if (!seller.getItems().toString().equals(item.getNameOfItem().toString())) {                                      // если у продавца на складе нет товара
//                System.out.println("у нас нет  " + item.getNameOfItem());//  вывод товара которого нет у продавца
//
//            }
//        }
//        System.out.println("товар на складе у продавца: " + seller.getItems());
//        System.out.println("список покупок покупателя - " + wishListOfConsumer);
//
//    }


    default double totalCost(ArrayList<Item> items) {                                 // метод возвращает общую стоимость покупки
        double summaCost = 0;
        for (Item item : items) {
            summaCost += costOfItem(item);
        }

        return summaCost;
    }

    default void areYouPoor(Consumer consumer, Seller seller) {                                            // метод нищий
        if (totalCost(consumer.getBusket()) > consumer.getMoney()) {                                  // если общая стоимость покупки больше, чем денег у покупателя
            System.out.println("Нет хватает  денег на покупку!");
            double payExtra = totalCost(consumer.getBusket()) - consumer.getMoney();
            System.out.println("Вам надо доплатить : " + payExtra);

            consumer.walkInStorage();
        } else {
            seller.walkInStorage();
        }

    }

    void walkInStorage();           // поведение пойти на склад (у продавца и покупателя)


    void loyalIndexConsumer(Consumer consumer)
            ;         // метод реализации поведения между покупателем и продавцом+

    void loyalIndexSeller(Seller seller);


}



