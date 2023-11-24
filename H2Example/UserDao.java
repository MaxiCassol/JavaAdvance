package H2Example;

public interface UserDao {
    UserDto findById(int id);
    void save(UserDto userDto);
    void update(UserDto userDto);
    void delete(int id);
}
