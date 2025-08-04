import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("alice", "alice@example.com"),
                new User("bob", "bob@example.com"),
                new User("charlie", "charlie@example.com")
        );

        Optional<User> userOptional = findUserByUsername(users, "bob");

        if (userOptional.isPresent()) {
            System.out.println("Người dùng tìm thấy: " + userOptional.get());
        } else {
            System.out.println("Không tìm thấy người dùng.");
        }

        User defaultUser = userOptional.orElse(new User("default", "default@example.com"));
        System.out.println("Người dùng (mặc định nếu không tìm thấy): " + defaultUser);

        userOptional.ifPresent(user -> System.out.println("Email của người dùng: " + user.getEmail()));
    }
    private static Optional<User> findUserByUsername(List<User> users, String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

}