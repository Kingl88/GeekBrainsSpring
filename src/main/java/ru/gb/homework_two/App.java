package ru.gb.homework_two;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.homework_two.beans.Cart;
import ru.gb.homework_two.beans.ProductRepository;
import ru.gb.homework_two.config.ApplicationConfiguration;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("If you want creating cart, then write \"new\"");
            System.out.println("If you want finishing the work, then write \"end\"");
            String command = scanner.next();
            if ("new".equals(command)) {
                Cart cart = context.getBean(Cart.class);
                do {
                    System.out.println("To view the products, write \"all\"");
                    System.out.println("To add an item to the cart, write \"add\"");
                    System.out.println("To remove an item to the cart, write \"remove\"");
                    System.out.println("To view the products in the cart, write \"view\"");
                    System.out.println("To return to the previous menu, write \"back\"");
                    command = scanner.next();
                    switch (command) {
                        case "all":
                            for (int i = 0; i < context.getBean(ProductRepository.class).getAllProduct().size(); i++) {
                                System.out.println(context.getBean(ProductRepository.class).getAllProduct().get(i));
                            }
                            System.out.println();
                            break;
                        case "add":
                            System.out.println("Write ID");
                            int id = scanner.nextInt();
                            cart.addProduct(context.getBean(ProductRepository.class).getProductById(--id));
                            break;
                        case "remove":
                            System.out.println("Write ID");
                            id = scanner.nextInt();
                            cart.removeProductById(context.getBean(ProductRepository.class).getProductById(--id));
                            break;
                        case "view":
                            for (int i = 0; i < cart.getAllProducts().size(); i++) {
                                System.out.println(cart.getAllProducts().get(i));
                            }
                            System.out.println();
                            break;
                    }
                } while (!command.equals("back"));
            }
            if (command.equals("end")) {
                break;
            }
        }
    }
}
