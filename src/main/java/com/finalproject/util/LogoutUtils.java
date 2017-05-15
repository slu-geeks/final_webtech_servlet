package com.finalproject.util;

import com.finalproject.beans.UserAccount;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 5/15/2017.
 */
public class LogoutUtils {

    public static boolean checkSession(HttpSession session){
        return session.getAttribute("activeUser") != null;
    }
}
