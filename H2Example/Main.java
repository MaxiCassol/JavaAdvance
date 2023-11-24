package H2Example;

public class Main {
    UserDao userDao = new UserDaoImpl();

    UserDto userDto = userDao.findById(1);
userDto.setName("John Doe");
userDao.update(userDto);

    UserDto newUserDto = new UserDto("Jane Smith", "jane@example.com");
userDao.save(newUserDto);
}
