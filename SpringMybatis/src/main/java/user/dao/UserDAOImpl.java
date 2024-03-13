package user.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import user.bean.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private List<UserDTO> userList = new ArrayList<>(); // 사용자 정보를 저장하기 위한 리스트
    @Autowired
    private SqlSession sqlSession;
    @Override
    public void insertUser(UserDTO userDTO) {
        sqlSession.insert("userSQL.write", userDTO);
    }

    @Override
    public List<UserDTO> getUserList() {
        return new ArrayList<>(userList); // 사용자 목록을 반환 (새로운 리스트로 반환하여 외부에서의 변경 방지)
    }

    @Override
    public UserDTO getUserById(String id) {
        for (UserDTO user : userList) {
            if (user.getUserId().equals(id)) {
                return user; // 주어진 ID와 일치하는 사용자를 찾으면 해당 사용자 반환
            }
        }
        return null; // 주어진 ID와 일치하는 사용자를 찾지 못하면 null 반환
    }

    @Override
    public void updateUser(UserDTO user) {

    }

    @Override
    public void deleteUser(String id) {

    }


    /*@Override
    public void updateUser(UserDTO user) {
        Optional<UserDTO> existingUser = userList.stream()
                .filter(u -> u.getId().equals(user.getId()))
                .findFirst(); // 업데이트하고자 하는 사용자의 ID와 일치하는 기존 사용자를 찾음

        existingUser.ifPresent(u -> {
            userList.set(userList.indexOf(u), user); // 기존 사용자 정보를 새 정보로 업데이트
        });
    }

    @Override
    public void deleteUser(String id) {
        userList.removeIf(user -> user.getId().equals(id)); // 주어진 ID와 일치하는 사용자를 리스트에서 제거
    }*/
}
