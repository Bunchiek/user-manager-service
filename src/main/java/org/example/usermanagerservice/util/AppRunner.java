package org.example.usermanagerservice.util;

import lombok.RequiredArgsConstructor;
import org.example.usermanagerservice.service.GetRandomUserService;
import org.example.usermanagerservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class AppRunner implements CommandLineRunner {

    private final UserService userService;
    private final GetRandomUserService getRandomUserService;

    @Override
    public void run(String... args) {

        Scanner scanner = new Scanner(System.in);
        displayCommands();

        while (true) {
            System.out.print("Введите команду: ");
            String command = scanner.nextLine();

            if (command.startsWith("load")) {
                int count = getCount(command);
                userService.saveUsers(getRandomUserService.getRandomUser(count));
            } else if (command.startsWith("unload")) {
                int count = getCount(command);
                userService.unloadUsers(count);
            } else if (command.equalsIgnoreCase("exit")) {
                System.out.println("Выход из программы.");
                break;
            } else {
                System.out.println("Неизвестная команда. Попробуйте снова.");
            }
        }
    }

    private void displayCommands() {
        System.out.println("Доступные команды:");
        System.out.println("1. load - Загрузить пользователей в БД + количество (по-умолчанию 1)");
        System.out.println("2. unload - Выгрузить пользователей из БД в CSV файл + количество (по-умолчанию 1)");
        System.out.println("3. exit - Выход из приложения");
    }

    private int getCount(String command) {
        String[] parts = command.split(" ");
        if (parts.length > 1) {
            try {
                return Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("Некорректное количество, используем значение по умолчанию 1.");
            }
        }
        return 1;
    }
}
