package com.nissum.user.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    private static Pattern  pattern;
    private static Matcher matcher;

    public static String formatDate(Date date){
        String pattern = "dd-MM-yyyy hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dateformat = simpleDateFormat.format(date);
        return dateformat;
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validateMail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }

    private static final String PASSWORD_PATTERN =
            "((?=.*\\d){0,2}(?=.*[a-z]){0,5}(?=.*[A-Z]){0,1}.{0,8})";


    public static boolean validatePassword(final String password){
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();

    }
}
