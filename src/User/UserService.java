package User;

import Dao.UserDao;
import UserException.UserException;
import org.dom4j.DocumentException;

public class UserService {
    public static User Regist(User from) throws UserException {
        User user = UserDao.findByUsername(from.getUsername());
        if(user != null){
            throw new UserException("该用户已被注册！！");
        }else{
            UserDao.add(from);
        }
        return null;
    }
    public static User login(User from) throws UserException {
        User user = UserDao.findByUsername(from.getUsername());
        if (user == null) throw new UserException("该用户名不存在.");
        if (user != null) {
            if (!user.getPassword().equals(from.getPassword())) {
                throw new UserException("密码或用户名错误");
            }
            return user;
        }
        return null;
    }
    public static User Mark(User from){
        User user = UserDao.addPrice(from);
        return user;
    }
}
