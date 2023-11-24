package H2Example;

public class UserDaoImpl implements UserDao {
    private UserRepository userRepository; // Repositorio que interactúa con la capa de persistencia

    // Constructor u otras formas de inyección de dependencias para obtener el repositorio UserRepository

    @Override
    public UserDto findById(int id) {
        UserEntity userEntity = userRepository.findById(id);
        return mapEntityToDto(userEntity);
    }

    @Override
    public void save(UserDto userDto) {
        UserEntity userEntity = mapDtoToEntity(userDto);
        userRepository.save(userEntity);
    }

    @Override
    public void update(UserDto userDto) {
        UserEntity userEntity = mapDtoToEntity(userDto);
        userRepository.update(userEntity);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    // Métodos auxiliares para el mapeo entre el DTO y la entidad
    private UserDto mapEntityToDto(UserEntity userEntity) {
        // Lógica de mapeo
    }

    private UserEntity mapDtoToEntity(UserDto userDto) {
        // Lógica de mapeo
    }
}