package com.tioanhy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2019/5/4
 **/
@Slf4j
public class ArrayTest {

    public static void main(String[] args) {
        String[] arr = new String[5];
        String[] arr1 = new String[10];

//        for (int i = 0; i < 5; i++) {
//            arr1[i] = String.valueOf(i);
//        }

        for (int i = 0; i < 5; i++) {
            arr1[i] = arr[i];
        }

        arr = arr1;

        log.debug(Arrays.toString(arr));

    }

    @Test
    public void weiyi() {
        System.out.println(1 << 3);
    }

    @Test
    public void testGivenValue(){

    }



}
