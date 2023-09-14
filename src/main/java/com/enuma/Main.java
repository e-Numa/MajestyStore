package com.enuma;

import com.enuma.model.Cashier;
import com.enuma.model.Customer;
import com.enuma.model.Manager;
import com.enuma.services.implementations.CashierImpl;
import com.enuma.services.implementations.CustomerImpl;
import com.enuma.services.implementations.ManagerImpl;

public class Main {
    public static void main(String[] args) {

      //Manager Implementation Object
        ManagerImpl manager = new ManagerImpl(new Manager("Eva Chikwendu", "07084733873", 28, "evachi@majestystore" +
                ".com","Port Harcourt", 3));
        Manager manager1 = new Manager("Rowling Obi", "08066656901", 30, "rowling.obi@majestystores.com", "Port " +
                "Harcourt", 3);
        Manager manager2 = new Manager("Andrew Pulin", "08066656672", 32, "puliand@majestystores.com", "Port " +
                "Harcourt", 3);

        // To check Manager Detail
        //System.out.println(manager1.getName());
        //System.out.println(manager1.getName() + " " + manager1.getTelephone());

       //Cashier Implementation Object
        Cashier cashier = new Cashier("Sewese Lucy", "080237387285", 28, "seweselucy@majestystores.com",
                "PortHarcourt");
        Cashier cashier1 = new Cashier("Theorex Obinwa", "08065784598", 26, "theoobinwa@majestystores.com",
                "PortHarcourt");
        Cashier cashier2 = new Cashier("Abie Anwa", "0808894023", 16, "AbInwa@majestystores.com",
                "PortHarcourt");
        Cashier cashier3 = new Cashier("Ruben Livingstone", "08034511128", 25, "livingstone@majestystores.com",
                "PortHarcourt");
        Cashier cashier4 = new Cashier("Gabriel Gin", "08034453623", 42, "Gin@majestystores.com",
                "PortHarcourt");

       //Manager Hire Method
        manager.hire(cashier);
       //manager.hire(cashier1);
       //manager.hire(cashier2);
       //manager.hire(cashier3);
       //manager.hire(cashier4);

        // Manager Strike Method/Fire
        //manager1.strikeCashier(cashier3);

       //Cashier Service Implementation
          CashierImpl cashierImp = new CashierImpl(cashier);
          cashierImp.reStockProduct();

      //Cashier View products
        Customer customer1 = new Customer("Dickson",100000.00);
        Customer customer2 = new Customer("Victor",300000.00);
        Customer customer3 = new Customer("Francis",50000.00);
        Customer customer4 = new Customer("Riley",20000.00);
        Customer customer5 = new Customer("Sammie",100000.00);
        Customer customer6 = new Customer("Kris",500000.00);
        Customer customer7 = new Customer("Jewel",200000.00);
        Customer customer8 = new Customer("Victor",1000000.00);

      //Customer Implementation
        CustomerImpl customerImpl1 = new CustomerImpl(customer1);
        CustomerImpl customerImpl2 = new CustomerImpl(customer2);
        CustomerImpl customerImpl3 = new CustomerImpl(customer3);
        CustomerImpl customerImpl4 = new CustomerImpl(customer4);
        CustomerImpl customerImpl5 = new CustomerImpl(customer5);
        CustomerImpl customerImpl6 = new CustomerImpl(customer6);

      //Customer adds to cart
        customerImpl1.addToCart("NokiaTorch", 2);
        customerImpl4.addToCart("Handkerchief", 12);
        customerImpl2.addToCart("FruitBread", 2);
        customerImpl1.addToCart("CiproTab", 1);

        customerImpl2.addToCart("SamsungDuo", 1);
        customerImpl4.addToCart("Paracetamol", 8);
        customerImpl3.addToCart("SardineBread", 2);
        customerImpl2.addToCart("Boxers", 3);

        customerImpl3.addToCart("Tecno", 1);
        customerImpl2.addToCart("Fanta", 10);
        customerImpl4.addToCart("Monster", 6);
        customerImpl6.addToCart("JollofRice", 3);

        customerImpl2.addToCart("TecnoLite", 2);
        customerImpl6.addToCart("BottledWater", 4);
        customerImpl3.addToCart("Mozzarella", 4);
        customerImpl5.addToCart("Creamora", 3);

        customerImpl5.addToCart("Oldenburg", 6);
        customerImpl6.addToCart("Oldenburg", 4);
        customerImpl5.addToCart("SardineBread", 5);
        customerImpl6.addToCart("Bournvita", 3);

        customerImpl6.addToCart("Horlicks", 5);
        customerImpl3.addToCart("Fanta", 2);
        customerImpl2.addToCart("BodySpray", 3);
        customerImpl1.addToCart("JollofRice", 3);

        customerImpl6.addToCart("Pad", 3);
        customerImpl6.addToCart("Flagyl", 2);
        customerImpl4.addToCart("BathingSoap", 10);
        customerImpl1.addToCart("NoteBook", 3);

        customerImpl6.addToCart("Bread", 3);
        customerImpl6.addToCart("ChiVita", 2);
        customerImpl4.addToCart("MeatPie", 10);
        customerImpl1.addToCart("ChickenPie", 3);


        //Customers can also view cart
       //customerImpl3.viewCart();
       //customerImpl2.viewCart();
       //customerImpl4.viewCart();
       //customerImpl1.viewCart();
       //customerImpl5.viewCart();
       //customerImpl6.viewCart();

      //Cashier views stock to sort product in stock.
       //cashierImp.viewStock();

      //Customer Proceed to pay point/buy product
        System.out.println('\n' + "Customer Proceed to checkout:");
        customerImpl4.buyProduct();
        customerImpl3.buyProduct();
        customerImpl1.buyProduct();
        customerImpl2.buyProduct();
        customerImpl6.buyProduct();
        customerImpl5.buyProduct();


      cashierImp.sellPriority();
      //cashierImp.sellFIFO();
    }
}
