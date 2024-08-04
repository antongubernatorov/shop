package managers.AuthManager;

import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;
import managers.Basket;
import managers.Manager;
import managers.User;

import java.io.*;


public class AuthManager implements AuthManagerInterface {

    private int MY_ID = -1;
    private final File userFile = new File("C:\\Users\\4821016\\dev\\ru\\yandex\\practicum\\training\\src\\files\\users.csv");

    @Override
    public void createUser(String login, String password, String confirmPassword) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(userFile, true))){
            validateLogin(login);
            validatePassword(password, confirmPassword);
//            int id = .getUserId();
//            int idUser = shopManager.generateId(id);
            Basket userBasket = new Basket();
//            User user = new User(idUser, login, password, userBasket);
//            shopManager.users.put(idUser, user);
//            writer.write(idUser + "," + login + "," + password + "\n");
            System.out.println("Пользователь успешно зарегистрирован");
        } catch (WrongLoginException | WrongPasswordException | IOException e) {
            System.out.println("Ошибка при создании пользователя");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void authUser(String login, String password) {
        boolean auth = false;
        try (BufferedReader br = new BufferedReader(new FileReader(userFile))){
            String str;
            while((str = br.readLine()) != null){
                String[] entryArray = str.split(",");
                if (entryArray[1].equals(login)){
                    if(entryArray[2].equals(password)){
                        setMY_ID(Integer.parseInt(entryArray[0]));
                        auth = true;
                    }
                }
            }
            if(auth){
                System.out.println("Вы успешно вошли в свой аккаунт.");
            } else {
                throw new WrongLoginException("Такого пользователя не существует или неправильный пароль");
            }
        } catch (IOException | WrongLoginException e) {
            throw new RuntimeException(e);
        }
    }

    private void validateLogin(String login) throws WrongLoginException {
        if(!login.matches("[a-zA-Z0-9_]+") || login.length()>=20) {
            throw new WrongLoginException("\"Неверный логин. Логин должен содержать только латинские буквы," +
                    " цифры и знак подчеркивания, и быть короче 20 символов.");
        }
    }

    private void validatePassword(String password, String confirmPassword) throws WrongPasswordException {
        if(!password.matches("[a-zA-Z0-9_]+") || password.length()>=20
        || !password.equals(confirmPassword)) {
            throw new WrongPasswordException("Неверный пароль. Пароль должен содержать только латинские буквы, цифры и знак подчеркивания, быть короче 20 символов и совпадать с подтверждением.");
        }
    }

    public int getMY_ID() {
        return MY_ID;
    }

    public void setMY_ID(int MY_ID) {
        this.MY_ID = MY_ID;
    }

}
