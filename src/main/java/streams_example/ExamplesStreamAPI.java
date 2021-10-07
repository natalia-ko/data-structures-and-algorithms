package streams_example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// Return type is void for all methods of class, some print their results

public class ExamplesStreamAPI {
    public static void getListOfNames(List<User> users) {
        List<String> names = users
                .stream()
                .map(User::getName)
                .collect(Collectors.toList());

        names.forEach(System.out::println);
    }

    public static void getMapIdUser(List<User> users) {
        Map<Long, User> userId = users
                .stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));
    }

    // Detailed variant
    public static void getListOfAccNumbers(List<User> users) {
        List<Account> accs = users.stream()
                .map(User::getAccounts)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        List<String> accsNumbers = accs.stream()
                .map(Account::getAccNumber)
                .collect(Collectors.toList());

        accsNumbers.forEach(System.out::println);
    }

    // Shorter variant
    public static void getListOfAccNumbers_2(List<User> users) {
        List<String> accsNumbers = users.stream()
                .map(user -> user.getAccounts().stream()
                        .map(Account::getAccNumber)
                        .collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        accsNumbers.forEach(System.out::println);
    }

    // Counts the whole sum of balances without taking the currency into consideration
    public static void getSumOfBalances(List<User> users) {
        int sumOfBalances = users.stream()
                .map(user -> user.getAccounts().stream()
                        .map(Account::getBalance)
                        .collect(Collectors.toList()))
                .flatMap((Collection::stream))
                .reduce(0, Integer::sum);

        System.out.println(sumOfBalances);
    }

    public static List<User> generateUserList() {
        List<User> users = new ArrayList<>();
        Account u1a1 = new Account(Account.generateId(), Account.Currency.EU, 0, "100");
        Account u1a2 = new Account(Account.generateId(), Account.Currency.USD, 111, "101");
        List<Account> u1Accs = new ArrayList<>();
        u1Accs.add(u1a1);
        u1Accs.add(u1a2);
        User u1 = new User(1, "Иванов", u1Accs);

        Account u2a1 = new Account(Account.generateId(), Account.Currency.EU, 200, "200");
        Account u2a2 = new Account(Account.generateId(), Account.Currency.USD, 220, "202");
        List<Account> u2Accs = new ArrayList<>();
        u2Accs.add(u2a1);
        u2Accs.add(u2a2);
        User u2 = new User(2, "Петров", u2Accs);

        users.add(u1);
        users.add(u2);
        return users;
    }

}
