package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.UserStatusDao;
import com.example.demo.dao.impl.UserDaoImpl;
import com.example.demo.dao.impl.UserStatusDaoImpl;
import com.example.demo.entity.Search;
import com.example.demo.entity.User;
import com.example.demo.entity.UserGrade;
import com.example.demo.entity.UserStatus;
import com.example.demo.service.UserGradeService;
import com.example.demo.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    //用户登陆
    @Override
    public int login(User user) {
        UserDao userDao = new UserDaoImpl();
        //根据用户密码查询用户是否存在
        String sqlUser = "SELECT * FROM user WHERE userName=? AND userPwd=?";
        Object paramUser[] = {user.getUserName(), user.getUserPwd()};
        user = userDao.getUserRun(sqlUser, paramUser);
        System.out.println(user);
        if (user != null) {
            //查询状态为正常的用户
            UserStatus user_status = new UserStatus();
            user_status.setStatusName("正常");
            UserStatusDao userStatusDao = new UserStatusDaoImpl();
            user_status = userStatusDao.getStatus(user_status);

            if (user.getUserStatus() == user_status.getStatusId()) {
                List<UserGrade> list = new ArrayList<UserGrade>();
                //查询所有等级
                UserGradeService userGradeService = new UserGradeServiceImpl();
                list = userGradeService.getUserAll();
                for (int i = 0; i < list.size(); i++) {
                    if (user.getUserGrade() == list.get(i).getGradeId()) {
                        System.out.println("登录登记判断:" + i);
                        return i;
                    }

                }
            }
            //账号状态不为正常返回-1
            return -1;
        }

        //账号不存在返回-2;
        return -2;
    }

    /**
     * 查询所有用户
     */
    @Override
    public List<User> getUserAll(int page, int limit) {
        UserDao userDao = new UserDaoImpl();
        List<User> liUser = new ArrayList<User>();
        Object[] param = {(page - 1) * limit, limit};
        String sql = "SELECT userId,userName,userPwd,userPhone,sex,shippingAddress,s.statusName,g.gradeName,registrationTime,userMoney FROM user u INNER JOIN user_grade g ON u.userGrade=g.gradeId INNER JOIN user_status s ON u.userStatus=s.statusId ORDER BY userId LIMIT ?,?";
        liUser = userDao.getUser(sql, param);
        return liUser;
    }

    @Override
    public List<User> getUser(Search search, String type, int page, int limit) {
        UserDao userDao = new UserDaoImpl();
        String sql = null;
        System.out.println(search.getName() + search.getEnd() + search.getStart());
        /*System.out.println("时间"+start+end);*/
        List<User> list = null;
        if (type.equals("refermember")) {    //根据参数查询所有用户
            if (search.getName() == null || search.getName() == "" && search.getEnd() != "" && search.getStart() != "") {
                Object params[] = {search.getEnd(), search.getStart(), (page - 1) * limit, limit};
                //根据时间查询
                sql = "SELECT userId,userName,userPwd,userPhone,sex,shippingAddress,s.statusName,g.gradeName,registrationTime,userMoney FROM user u INNER JOIN user_grade g ON u.userGrade=g.gradeId INNER JOIN user_status s ON u.userStatus=s.statusId WHERE registrationTime<=? and registrationTime>=? ORDER BY userId LIMIT ?,?";
                list = userDao.getUser(sql, params);
            } else if (search.getName() != null && search.getEnd() == "" && search.getStart() == "") {
                //根据名称查询
                Object params[] = {search.getName(), (page - 1) * limit, limit};
                sql = "SELECT userId,userName,userPwd,userPhone,sex,shippingAddress,s.statusName,g.gradeName,registrationTime,userMoney FROM user u INNER JOIN user_grade g ON u.userGrade=g.gradeId INNER JOIN user_status s ON u.userStatus=s.statusId WHERE username=? ORDER BY userId LIMIT ?,?";
                list = userDao.getUser(sql, params);
            } else if (search.getName() != null && search.getEnd() != "" && search.getStart() != "") {
                Object params[] = {search.getName(), search.getEnd(), search.getStart(), (page - 1) * limit, limit};
                //根据时间和姓名查询
                sql = "SELECT userId,userName,userPwd,userPhone,sex,shippingAddress,s.statusName,g.gradeName,registrationTime,userMoney FROM user u INNER JOIN user_grade g ON u.userGrade=g.gradeId INNER JOIN user_status s ON u.userStatus=s.statusId WHERE userName=? and registrationTime<=? and registrationTime>=? ORDER BY userId LIMIT ?,?";
                list = userDao.getUser(sql, params);
            }
        } else if (type.equals("merchant")) {
            //根据参数查询商家
            if (search.getName() == null || search.getName() == "" && search.getEnd() != "" && search.getStart() != "") {
                Object params[] = {search.getUser().getUserGrade(), search.getEnd(), search.getStart(), (page - 1) * limit, limit};
                //根据时间查询商家
                sql = "SELECT userId,userName,userPwd,userPhone,sex,shippingAddress,s.statusName,g.gradeName,registrationTime,userMoney FROM user u INNER JOIN user_grade g ON u.userGrade=g.gradeId INNER JOIN user_status s ON u.userStatus=s.statusId WHERE userGrade=? and registrationTime<=? and registrationTime>=? ORDER BY userId LIMIT ?,?";
                list = userDao.getUser(sql, params);
            } else if (search.getName() != null && search.getEnd() == "" && search.getStart() == "") {
                Object params[] = {search.getUser().getUserGrade(), search.getName(), (page - 1) * limit, limit};
                //根据姓名查询商家
                sql = "SELECT userId,userName,userPwd,userPhone,sex,shippingAddress,s.statusName,g.gradeName,registrationTime,userMoney FROM user u INNER JOIN user_grade g ON u.userGrade=g.gradeId INNER JOIN user_status s ON u.userStatus=s.statusId WHERE userGrade=? and userName=? ORDER BY userId LIMIT ?,?";
                list = userDao.getUser(sql, params);
            } else if (search.getName() != null && search.getEnd() != "" && search.getStart() != "") {
                Object params[] = {search.getUser().getUserGrade(), search.getName(), search.getEnd(), search.getStart(), (page - 1) * limit, limit};
                //根据时间,姓名查询商家
                sql = "SELECT userId,userName,userPwd,userPhone,sex,shippingAddress,s.statusName,g.gradeName,registrationTime,userMoney FROM user u INNER JOIN user_grade g ON u.userGrade=g.gradeId INNER JOIN user_status s ON u.userStatus=s.statusId WHERE userGrade=? and userName=? and registrationTime<=? and registrationTime>=? ORDER BY userId LIMIT ?,?";
                list = userDao.getUser(sql, params);
            }
        } else if (type.equals("violationlist")) {
            //根据参数查询违规商家
            if (search.getName() == null || search.getName() == "" && search.getEnd() != "" && search.getStart() != "") {
                Object params[] = {search.getUser().getUserGrade(), search.getUser().getUserStatus(), search.getEnd(), search.getStart(), (page - 1) * limit, limit};
                //根据时间查询商家
                sql = "SELECT userId,userName,userPwd,userPhone,sex,shippingAddress,s.statusName,g.gradeName,registrationTime,userMoney FROM user u INNER JOIN user_grade g ON u.userGrade=g.gradeId INNER JOIN user_status s ON u.userStatus=s.statusId WHERE userGrade=? and userStatus=? and registrationTime<=? and registrationTime>=? ORDER BY userId LIMIT ?,?";
                list = userDao.getUser(sql, params);
            } else if (search.getName() != null && search.getEnd() == "" && search.getStart() == "") {
                Object params[] = {search.getUser().getUserGrade(), search.getUser().getUserStatus(), search.getName(), (page - 1) * limit, limit};
                //根据姓名查询商家
                sql = "SELECT userId,userName,userPwd,userPhone,sex,shippingAddress,s.statusName,g.gradeName,registrationTime,userMoney FROM user u INNER JOIN user_grade g ON u.userGrade=g.gradeId INNER JOIN user_status s ON u.userStatus=s.statusId WHERE userGrade=? and userStatus=? and userName=? ORDER BY userId LIMIT ?,?";
                list = userDao.getUser(sql, params);
            } else if (search.getName() != null && search.getEnd() != "" && search.getStart() != "") {
                Object params[] = {search.getUser().getUserGrade(), search.getUser().getUserStatus(), search.getName(), search.getEnd(), search.getStart(), (page - 1) * limit, limit};
                //根据时间,姓名查询商家
                sql = "SELECT userId,userName,userPwd,userPhone,sex,shippingAddress,s.statusName,g.gradeName,registrationTime,userMoney FROM user u INNER JOIN user_grade g ON u.userGrade=g.gradeId INNER JOIN user_status s ON u.userStatus=s.statusId WHERE userGrade=? and userStatus=? and userName=? and registrationTime<=? and registrationTime>=? ORDER BY userId LIMIT ?,?";
                list = userDao.getUser(sql, params);
            }
        }

        return list;
    }

    /**
     * 注册用户
     */
    @Override
    public int addUser(User user) {
        UserDao userDao = new UserDaoImpl();
        String sql = null;
        int count = 0;
        if (user.getUserGrade() > 0) {
            sql = "INSERT INTO `user` (userName,userPwd,tradePwd,userPhone,sex,registrationTime,userGrade)VALUES(?,?,?,?,?,?,?)";
            Object param[] = {user.getUserName(), user.getUserPwd(), user.getTradePwd(), user.getUserPhone(), user.getSex(), user.getRegistrationTime(), user.getUserGrade()};
            count = userDao.upUser(sql, param);
        } else {
            sql = "INSERT INTO `user` (userName,userPwd,tradePwd,userPhone,sex,registrationTime)VALUES(?,?,?,?,?,?)";
            Object param[] = {user.getUserName(), user.getUserPwd(), user.getTradePwd(), user.getUserPhone(), user.getSex(), user.getRegistrationTime()};
            count = userDao.upUser(sql, param);
        }
        return count;
    }

    //根据参数查询总条数
    @Override
    public int getTotalNumber(Search search, String type) {
        UserDao userDao = new UserDaoImpl();
        int count = 0;
        String sql = null;
        if (type.equals("memberlist")) {    //查询所有用户条数
            sql = "SELECT count(1) FROM user u INNER JOIN user_grade g ON u.userGrade=g.gradeId INNER JOIN user_status s ON u.userStatus=s.statusId ";
            count = userDao.getTotalNumber(sql);
        } else if (type.equals("merchantlist")) {
            //查询所有商家条数
            Object[] param = {search.getUser().getUserGrade()};
            sql = "SELECT COUNT(1) FROM USER u INNER JOIN user_grade g ON u.userGrade=g.gradeId INNER JOIN user_status s ON u.userStatus=s.statusId WHERE`userGrade`=?";
            count = userDao.getTotalNumber(sql, param);
        } else if (type.equals("refermember")) {
            if (search.getName() == null || search.getName() == "" && search.getEnd() != "" && search.getStart() != "") {
                Object params[] = {search.getEnd(), search.getStart()};
                //根据时间查询
                sql = "SELECT count(1) FROM user u INNER JOIN user_grade g ON u.userGrade=g.gradeId INNER JOIN user_status s ON u.userStatus=s.statusId WHERE registrationTime<=? and registrationTime>=?";
                count = userDao.getTotalNumber(sql, params);
            } else if (search.getName() != null && search.getEnd() == "" && search.getStart() == "") {
                //根据姓名查询
                Object params[] = {search.getName()};
                sql = "SELECT count(1) FROM user u INNER JOIN user_grade g ON u.userGrade=g.gradeId INNER JOIN user_status s ON u.userStatus=s.statusId WHERE username=?";
                count = userDao.getTotalNumber(sql, params);
            } else if (search.getName() != null && search.getEnd() != "" && search.getStart() != "") {
                Object params[] = {search.getName(), search.getEnd(), search.getStart()};
                sql = "SELECT COUNT(1) FROM user WHERE userName=? and registrationTime<=? and registrationTime>=?";
                count = userDao.getTotalNumber(sql, params);
            }

        } else if (type.equals("violation")) {
            //查询所有违规商家
            Object[] param = {search.getUser().getUserGrade(), search.getUser().getUserStatus()};
            sql = "SELECT COUNT(1) FROM USER u INNER JOIN user_grade g ON u.userGrade=g.gradeId INNER JOIN user_status s ON u.userStatus=s.statusId WHERE`userGrade`=? and userStatus=?";
            count = userDao.getTotalNumber(sql, param);
        } else if (type.equals("merchant")) {

            if (search.getName() == null || search.getName() == "" && search.getEnd() != "" && search.getStart() != "") {
                Object params[] = {search.getUser().getUserGrade(), search.getEnd(), search.getStart()};
                //根据时间查询
                sql = "SELECT count(1) FROM user u INNER JOIN user_grade g ON u.userGrade=g.gradeId INNER JOIN user_status s ON u.userStatus=s.statusId WHERE userGrade=? and registrationTime<=? and registrationTime>=?";
                count = userDao.getTotalNumber(sql, params);
            } else if (search.getName() != null && search.getEnd() == "" && search.getStart() == "") {
                //根据姓名查询
                Object params[] = {search.getUser().getUserGrade(), search.getName()};
                sql = "SELECT count(1) FROM user u INNER JOIN user_grade g ON u.userGrade=g.gradeId INNER JOIN user_status s ON u.userStatus=s.statusId WHERE userGrade=? and username=?";
                count = userDao.getTotalNumber(sql, params);
            } else if (search.getName() != null && search.getEnd() != "" && search.getStart() != "") {
                Object params[] = {search.getUser().getUserGrade(), search.getName(), search.getEnd(), search.getStart()};
                sql = "SELECT COUNT(1) FROM user WHERE userGrade=? and userName=? and registrationTime<=? and registrationTime>=?";
                count = userDao.getTotalNumber(sql, params);
            }
        } else if (type.equals("violationlist")) {
            //根据参数查询违规商家
            if (search.getName() == null || search.getName() == "" && search.getEnd() != "" && search.getStart() != "") {
                Object params[] = {search.getUser().getUserGrade(), search.getUser().getUserStatus(), search.getEnd(), search.getStart()};
                //根据时间查询
                sql = "SELECT count(1) FROM user u INNER JOIN user_grade g ON u.userGrade=g.gradeId INNER JOIN user_status s ON u.userStatus=s.statusId WHERE userGrade=? and userStatus=? and registrationTime<=? and registrationTime>=?";
                count = userDao.getTotalNumber(sql, params);
            } else if (search.getName() != null && search.getEnd() == "" && search.getStart() == "") {
                //根据姓名查询
                Object params[] = {search.getUser().getUserGrade(), search.getUser().getUserStatus(), search.getName()};
                sql = "SELECT count(1) FROM user u INNER JOIN user_grade g ON u.userGrade=g.gradeId INNER JOIN user_status s ON u.userStatus=s.statusId WHERE userGrade=? and userStatus=? and username=?";
                count = userDao.getTotalNumber(sql, params);
            } else if (search.getName() != null && search.getEnd() != "" && search.getStart() != "") {
                Object params[] = {search.getUser().getUserGrade(), search.getName(), search.getUser().getUserStatus(), search.getEnd(), search.getStart()};
                sql = "SELECT COUNT(1) FROM user WHERE userGrade=? and userName=? and userStatus=? and registrationTime<=? and registrationTime>=?";
                count = userDao.getTotalNumber(sql, params);
            }
        }
        return count;
    }

    //修改用户状态信息
    @Override
    public int updata(User user) {
        UserDao userDao = new UserDaoImpl();
        String sql = null;
        int count = 0;
        System.out.println("等级编号:" + user.getUserStatus());
        if (user.getUserStatus() > 0) {
            sql = "UPDATE user SET userStatus=? WHERE userId = ?";
            Object[] param = {user.getUserStatus(), user.getUserId()};
            count = userDao.upUser(sql, param);
        }

        return count;
    }

    //修改用户信息
    @Override
    public int upUser(User user) {
        UserDao userDao = new UserDaoImpl();
        String sql = null;
        int count = 0;

        if (user.getUserStatus() > 0 && user.getUserName() != null) {
            System.err.println("加密后密码" + user.getUserPwd());
            sql = "UPDATE USER SET userName=?,userPwd=?,sex=?,tradePwd=?,userPhone=?,shippingAddress=?,userStatus=?,userGrade=?,userMoney=? WHERE userId = ?";
            Object[] param = {user.getUserName(), user.getUserPwd(), user.getSex(), user.getTradePwd(), user.getUserPhone(), user.getShippingAddress(), user.getUserStatus(), user.getUserGrade(), user.getUserMoney(), user.getUserId()};
            count = userDao.upUser(sql, param);
        } else {
            //修改密码
            sql = "UPDATE USER SET userPwd=?,tradePwd=? WHERE userId = ?";
            System.err.println("加密后密码" + user.getUserPwd());
            Object[] param = {user.getUserPwd(), user.getTradePwd(), user.getUserId()};
            count = userDao.upUser(sql, param);
        }
        return count;
    }

    //根据信息查询单个用户
    @Override
    public User getUser(User user) {
        UserDao userDao = new UserDaoImpl();
        String sql = null;
        if (user.getUserName() != null) {
            sql = "SELECT * FROM user WHERE userName=?";
            Object param[] = {user.getUserName()};
            user = userDao.getUserRun(sql, param);
        } else {
            sql = "SELECT * FROM user WHERE userId=?";
            Object param[] = {user.getUserId()};
            user = userDao.getUserRun(sql, param);
        }
        return user;
    }

    @Override
    public int delUser(String[] list) {
        String sql = "DELETE FROM USER WHERE userId in(?)";
        UserDao userDao = new UserDaoImpl();
        int count = 0;
        for (int i = 0; i < list.length; i++) {
            Object param[] = {Integer.parseInt(list[i])};
            count = userDao.upUser(sql, param);
        }
        System.out.println("删除次数:" + count);
        return count;
    }

    //验证支付密码是否正确
    @Override
    public int isCorrect(int userId, String pwd) {
        int num = 0;
        String sql = "SELECT count(1) FROM user WHERE userId=? AND tradePwd=?";
        UserDao userDao = new UserDaoImpl();
        Object[] param = {userId, pwd};
        num = userDao.getTotalNumber(sql, param);
        return num;
    }

    //更新用户金额
    @Override
    public int upMoney(double money, int userId) {
        int count = 0;
        UserDao userDao = new UserDaoImpl();
        String sql = "UPDATE `USER` SET `userMoney`=? WHERE userId = ?";
        Object[] param = {money, userId};
        count = userDao.upUser(sql, param);
        return count;
    }

    @Override
    public List<User> getUserRun(User user, int page, int limit) {
        UserDao userDao = new UserDaoImpl();
        List<User> liUser = new ArrayList<User>();
        String sql = null;
        if (user.getUserGrade() != 0 && user.getUserStatus() == 0) {
            Object[] param = {user.getUserGrade(), (page - 1) * limit, limit};
            sql = "SELECT userId,userName,userPwd,userPhone,sex,shippingAddress,s.statusName,g.gradeName,registrationTime,userMoney FROM USER u INNER JOIN user_grade g ON u.userGrade=g.gradeId INNER JOIN user_status s ON u.userStatus=s.statusId WHERE`userGrade`=? ORDER BY userId LIMIT ?,?";
            liUser = userDao.getUser(sql, param);
        } else if (user.getUserGrade() != 0 && user.getUserStatus() != 0) {
            Object[] param = {user.getUserGrade(), user.getUserStatus(), (page - 1) * limit, limit};
            sql = "SELECT userId,userName,userPwd,userPhone,sex,shippingAddress,s.statusName,g.gradeName,registrationTime,userMoney FROM USER u INNER JOIN user_grade g ON u.userGrade=g.gradeId INNER JOIN user_status s ON u.userStatus=s.statusId WHERE`userGrade`=? AND `userStatus`=? ORDER BY userId LIMIT ?,?";
            liUser = userDao.getUser(sql, param);
        }

        return liUser;
    }

    @Override
    public int upEnter(int userId) {
        String sql = "UPDATE USER SET  userGrade=2 WHERE userId = ?";
        UserDao userDao = new UserDaoImpl();
        Object[] param = {userId};
        return userDao.upUser(sql, param);
    }

    @Override
    public int upuser(User user) {
        UserDao userDao = new UserDaoImpl();
        String sql = "UPDATE USER SET userName=?,userPwd=?,sex=?,tradePwd=?,userPhone=? WHERE userId = ?";
        Object[] param = {user.getUserName(), user.getUserPwd(), user.getSex(), user.getTradePwd(), user.getUserPhone(), user.getUserId()};
        return userDao.upUser(sql, param);
    }

}
