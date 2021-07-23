package com.naichuan;

import com.naichuan.utils.MD5Utils;
import org.junit.Test;

/**
 * @author Naichuan Zhang
 */
public class TestMD5 {

    @Test
    public void test() {
        String s = MD5Utils.md5("123");
        System.out.println(s);
    }
}
