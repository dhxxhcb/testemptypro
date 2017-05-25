package com.xoa.global.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by eagle on 2017/5/24.
 */
public class DateConvert implements Converter<Date, String> {

    private final SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
    private final SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final SimpleDateFormat HHmmss = new SimpleDateFormat("HH:mm:ss");
    private final int leng_yyyyMMdd = 10;
    private final int leng_yyyyMMddHHmmss = 19;
    private final int leng_HHmmss = 8;
    @Override
    public String convert(Date source) {
        return yyyyMMddHHmmss.format(source);
    }

}
