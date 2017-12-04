/*
 * 文件名：User.java 版权：Copyright by www.cheer.com 描述： 修改人：Administrator 修改时间：2017年12月4日
 */

package com.cheer.web.domain;

public class User
{
    private String username;

    private String password;

    public User()
    {

    }

    public User(String username, String password)
    {
        super();
        this.username = username;
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

}
