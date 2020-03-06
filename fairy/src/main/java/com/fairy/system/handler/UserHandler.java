package com.fairy.system.handler;

import com.fairy.system.model.User;

/**
 * @author deyong_tong
 */
public class UserHandler {

    private UserHandler() {
    }

    private static final ThreadLocal<User> USER_INFO_THREAD_LOCAL = new ThreadLocal<>();

    public static void clear() {
        USER_INFO_THREAD_LOCAL.remove();
    }

    public static void set(User user) {
        USER_INFO_THREAD_LOCAL.set(user);
    }

    public static User getCurrentUser() {
        return USER_INFO_THREAD_LOCAL.get();
    }
}
