package cn.cloudtop.zone;

/**
 * Created by jackie on 16-4-24
 */
public interface Regex {

    /**
     * 经度验证.
     */
    String Lng_Regex = "^[-]?(\\d|([1-9]\\d)|(1[0-7]\\d)|(180))(\\.\\d*)?$";
    /**
     * 纬度验证.
     */
    String Lat_Regex = "^[-]?(\\d|([1-8]\\d)|(90))(\\.\\d*)?$";
    /**
     * 区号验证.
     */
    String City_Code = "^0\\d{2,3}$";
    /**
     * 邮政编码验证.
     */
    String Zip_Code = "^[1-9][0-9]{5}$";
}
