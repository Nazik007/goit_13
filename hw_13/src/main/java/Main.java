import java.io.IOException;
import java.net.URI;
import java.util.List;

/**
 * @author Nazarii Soviak
 */

public class Main {
    private static final String POSTS = "https://jsonplaceholder.typicode.com/posts";
    private static final String USERS = "https://jsonplaceholder.typicode.com/users";


    public static void main(String[] args) throws IOException, InterruptedException {
        User defaultUser = new User(1, "Harry Potter", "MagicBoy",
                "magicwand45@kzz.net", new Address("NewFound", "Apt. 556", "Hogsmith",
                "92998-3874", new Geo("-37.3159", "81.1496")),
                "1-770-736-8031 x56442","hildegard.org",
                new Company("Hogwarts", "Help will be given",
                        "magic and e-commerce"));

        //1.1 створення новго об'єкта
        User createdUser = HttpUtil.putUser(URI.create(USERS), defaultUser);
        System.out.println(createdUser);

        //1.2 оновлення об'єкта
        User updatedUser = HttpUtil.postUser(URI.create(USERS), defaultUser);
        System.out.println(updatedUser);

        //1.3 видалення об'єкта
        HttpUtil.deleteUser(URI.create(USERS), 11);

        //1.4отримання інфи по об'єктам
        List<User> allUsers = HttpUtil.getUsers(URI.create(USERS));
        System.out.println(allUsers);

        //1.5 отримання по id
        User userById = HttpUtil.getUserById(URI.create(USERS),1);
        System.out.println(userById);

        //1.6 отримання по username
        User userName = HttpUtil.getUserByUserName(URI.create(USERS), "Antonette");
        System.out.println(userName);

        //2.0 всі коментаорі до останнього поста
        HttpUtil.getUserComments(2);

        //3.0 всі відкриті задачі
        List<Todo> allTodos = HttpUtil.getUserTodos(URI.create(USERS), 1);
        System.out.println(allTodos);

    }
}


