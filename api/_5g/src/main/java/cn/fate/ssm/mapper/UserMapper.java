package cn.fate.ssm.mapper;

import cn.fate.ssm.beans.User;

/**
 * 用户映射
 *
 * @author fate
 * @date 2019-06-07 15:28
 */
public interface UserMapper {

    /**
     *
     * @param user
     * @return
     */
    User userById(User user);


    /**
     * 登陆验证
     *
     * @param user 构造一个用户信息
     * @return User
     */
    User userQuery(User user);

    /**
     * 注册验证手机号是否重复
     *
     * @param user 构造一个用户信息
     * @return User
     */
    User userQueryByPhone(User user);

    /**
     * 注册用户
     *
     * @param user 用户数据
     * @return 注册是否成功
     */
    int registerUser(User user);

    /**
     *更改用户信息
     *
     * @param user 传入用户数据
     * @return 返回受影响的行数
     */
    int changeUser(User user);
}
