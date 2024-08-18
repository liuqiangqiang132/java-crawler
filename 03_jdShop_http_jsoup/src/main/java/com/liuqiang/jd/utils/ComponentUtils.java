package com.liuqiang.jd.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liuQiang132
 * @Date: 2024/8/8 14:13 星期四 14:13
 * @Description: 常用的网站地址
 * @version: 1.0
 **/
@Component
public class ComponentUtils {
    //京东商城手机链接
    public  final String JD_URL = "https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&suggest=1.his.0.0&pvid=3a1c2755eae549a78a78840b45bd37b8&isList=0&s=56&click=0&log_id=1723776117896.2801&page=";

    /**
     * 设置网络Cookie
     * @param MAP map
     * @return 存放cookie的数据！！！！！！！
     */
    public Map<String,String> getMap(){
        Map<String,String> MAP = new HashMap<>();
        MAP.put("thor","270FAE00B309BA8AA319F2A93046085F942185351D6E8A329078FC31" +
                "0118B00B76F317344C2D0C34A4472882BE6FFBEDB348F5C4CD212D7E2065079D9D269EDCB13E71" +
                "CAC9382537046C02FA6C584B60F1B8559E0BE4065121790650AC97804E212B4F02E855BBB7B8B07B20BEFBC3145331" +
                "C18B4F6A7DBBC477B9403F91591152D198E8A60A917896A1E608BB140A99DE4D64817DAFEAD00285145F835243FB");

        return MAP;

    }


}
