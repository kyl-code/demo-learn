package org.example.common;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.example.model.dto.AddressAnalyzeDTO;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author adam.guo
 * @date:2020/11/26
 */
public class AddressAnalyzeUtil {

    private static final Pattern mobilePattern = Pattern.compile("((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}");

    private static final List<String> firstNames = Arrays.asList("赵","钱","孙","李","周","吴","郑","王","冯","陈","褚","卫","蒋","沈","韩","杨","朱","秦","尤","许","何","吕","施","张","孔","曹","严","华","金","魏","陶","姜","戚","谢","邹","喻","柏","水","窦","章","云","苏","潘","葛","奚","范","彭","郎","鲁","韦","昌","马","苗","凤","花","方","俞","任","袁","柳","酆","鲍","史","唐","费","廉","岑","薛","雷","贺","倪","汤","滕","殷","罗","毕","郝","邬","安","常","乐","于","时","傅","皮","卞","齐","康","伍","余","元","卜","顾","孟","平","黄","和","穆","萧","尹","姚","邵","湛","汪","祁","毛","禹","狄","米","贝","明","臧","计","伏","成","戴","谈","宋","茅","庞","熊","纪","舒","屈","项","祝","董","粱","杜","阮","蓝","闵","席","季","麻","强","贾","路","娄","危","江","童","颜","郭","梅","盛","林","刁","钟","徐","邱","骆","高","夏","蔡","田","樊","胡","凌","霍","虞","万","支","柯","昝","管","卢","莫","经","房","裘","缪","干","解","应","宗","丁","宣","贲","邓","郁","单","杭","洪","包","诸","左","石","崔","吉","钮","龚","程","嵇","邢","滑","裴","陆","荣","翁","荀","羊","於","惠","甄","麴","家","封","芮","羿","储","靳","汲","邴","糜","松","井","段","富","巫","乌","焦","巴","弓","牧","隗","山","谷","车","侯","宓","蓬","全","郗","班","仰","秋","仲","伊","宫","宁","仇","栾","暴","甘","钭","厉","戎","祖","武","符","刘","景","詹","束","龙","叶","幸","司","韶","郜","黎","蓟","薄","印","宿","白","怀","蒲","邰","从","鄂","索","咸","籍","赖","卓","蔺","屠","蒙","池","乔","阴","欎","胥","能","苍","双","闻","莘","党","翟","谭","贡","劳","逄","姬","申","扶","堵","冉","宰","郦","雍","舄","璩","桑","桂","濮","牛","寿","通","边","扈","燕","冀","郏","浦","尚","农","温","别","庄","晏","柴","瞿","阎","充","慕","连","茹","习","宦","艾","鱼","容","向","古","易","慎","戈","廖","庾","终","暨","居","衡","步","都","耿","满","弘","匡","国","文","寇","广","禄","阙","东","殴","殳","沃","利","蔚","越","夔","隆","师","巩","厍","聂","晁","勾","敖","融","冷","訾","辛","阚","那","简","饶","空","曾","毋","沙","乜","养","鞠","须","丰","巢","关","蒯","相","查","後","荆","红","游","竺","权","逯","盖","益","桓","公","万俟","司马","上官","欧阳","夏侯","诸葛","闻人","东方","赫连","皇甫","尉迟","公羊","澹台","公冶","宗政","濮阳","淳于","单于","太叔","申屠","公孙","仲孙","轩辕","令狐","钟离","宇文","长孙","慕容","鲜于","闾丘","司徒","司空","亓官","司寇","仉","督","子车","颛孙","端木","巫马","公西","漆雕","乐正","壤驷","公良","拓跋","夹谷","宰父","谷梁","晋","楚","闫","法","汝","鄢","涂","钦","段干","百里","东郭","南门","呼延","归","海","羊舌","微生","岳","帅","缑","亢","况","后","有","琴","梁丘","左丘","东门","西门","商","牟","佘","佴","伯","赏","南宫","墨","哈","谯","笪","年","爱","阳","佟");
    private static final List<String> provinces = Arrays.asList("北京","天津","河北","山西","内蒙古","辽宁","吉林","黑龙江","上海","江苏","浙江","安徽","福建","江西","山东","河南","湖北","湖南","广东","广西","海南","重庆","四川","贵州","云南","西藏","陕西","甘肃","青海","宁夏","新疆","香港","澳门","台湾");

    public static AddressAnalyzeDTO analysis(String content) {
        String regEx = "[\n`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）\\-——+|{}【】‘；：”“’。， 、？]";
        String aa = "";
        Pattern p = Pattern.compile(regEx);
        // 这里把想要替换的字符串传进来
        Matcher m = p.matcher(content);
        // 去除地址中的特殊字符
        content = m.replaceAll(aa).trim();
        AddressAnalyzeDTO analyzeDTO = new AddressAnalyzeDTO();
        analyzeDTO.setParticular(content);
        // 匹配手机号
        Matcher matcher = mobilePattern.matcher(content);
        String mobile = "";
        while (matcher.find()) {
            mobile = matcher.group();
        }
        if (StringUtils.isBlank(mobile)) {
            return analyzeDTO;
        }
        try {
            analyzeDTO.setContactsPhone(mobile);
            // 对手机号分隔
            String[] split = content.split(mobile);
            // 手机号在姓名和地址中间
            if (2 == split.length && StringUtils.isNotBlank(split[0]) && StringUtils.isNotBlank(split[1])) {
                if (split[0].length() > split[1].length()) {
                    analyzeDTO.setParticular(split[0]);
                    analyzeDTO.setContacts(split[1]);
                    return analyzeDTO;
                } else {
                    analyzeDTO.setContacts(split[0]);
                    analyzeDTO.setParticular(split[1]);
                    return analyzeDTO;
                }
            }
            // 手机号在两端
            String nameAndAddress = "";
            if (StringUtils.isNotBlank(split[0])) {
                nameAndAddress = split[0];
            } else {
                nameAndAddress = split[1];
            }
            analyzeDTO.setParticular(nameAndAddress);
            // 是否是地址开头
            boolean addressFirst = false;
            for (String province : provinces) {
                if (nameAndAddress.startsWith(province)) {
                    addressFirst = true;
                }
            }
            // 地址开头,取后四个字匹配姓
            if (addressFirst) {
                String lastFourWords = nameAndAddress.substring(nameAndAddress.length() - 4, nameAndAddress.length());
                for (String firstName : firstNames) {
                    int index = lastFourWords.indexOf(firstName);
                    if (index >= 0) {
                        String address = nameAndAddress.substring(0, nameAndAddress.length() + index - 4);
                        String name = nameAndAddress.substring(nameAndAddress.length() + index - 4);
                        analyzeDTO.setParticular(address);
                        analyzeDTO.setContacts(name);
                        return analyzeDTO;
                    }
                }
            } else {
                // 姓名开头
                for (String province : provinces) {
                    int index = nameAndAddress.indexOf(province);
                    if (index > 0) {
                        String name = nameAndAddress.substring(0, index);
                        String address = nameAndAddress.substring(index);
                        analyzeDTO.setContacts(name);
                        analyzeDTO.setParticular(address);
                        return analyzeDTO;
                    }
                }
            }
        } catch (Exception e) {
            return analyzeDTO;
        }
        return analyzeDTO;
    }

    public static void main(String[] args) {
        String content = "-|,李明深圳市宝安区白石洲,5号78栋79013555446699";
        String regEx="[\n`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）\\-——+|{}【】‘；：”“’。， 、？]";
        String aa = "";
        Pattern p = Pattern.compile(regEx);
        //这里把想要替换的字符串传进来
        Matcher m = p.matcher(content);
        content = m.replaceAll(aa).trim();
        System.err.println(content);
        AddressAnalyzeDTO analysis = analysis(content);
        System.err.println(JSONObject.toJSON(analysis));
    }
}
