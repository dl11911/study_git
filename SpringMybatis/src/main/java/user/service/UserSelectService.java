package user.service;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

import java.util.List;

public class UserSelectService implements UserService {
    @Setter
    private UserDAO userDAO;

    @Override
    public void execute() {
        System.out.println("데이터 조회 처리");

        List<UserDTO> list = userDAO.getUserList();

        System.out.println("이메일\tID\t비밀번호\t전화번호");
        for(UserDTO userDTO : list){
            System.out.println(userDTO.toString()); // toString()은 생략 가능합니다.
        }
    }
}
