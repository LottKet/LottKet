package lotte.com.lottket.service.product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import lotte.com.lottket.dto.ProductDetailDto;
import lotte.com.lottket.dto.ProductDto;
import lotte.com.lottket.dto.ProductImageDto;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class DBInitialize {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public static String randomRegDate(){

        String year = Integer.toString((int) (Math.random() * 3) + 2020);
        String month = Integer.toString((int) (Math.random() * 12) + 1);
        String day = Integer.toString((int) (Math.random() * 28) + 1);
        String hour = Integer.toString((int) (Math.random() * 24));
        String minute = Integer.toString((int) (Math.random() * 60));
        String second = Integer.toString((int) (Math.random() * 60));

        if(month.length() < 2) month = "0" + month;
        if(day.length() < 2) day = "0" + day;
        if(hour.length() < 2) hour = "0" + hour;
        if(minute.length() < 2) minute = "0" + minute;
        if(second.length() < 2) second = "0" + second;

        String regDate = year + "-" + month + "-" + day + "-" + hour + ":" + minute + ":" + second;
        return regDate;
    }

    public static Map<String, Object> run() throws JSONException, IOException {
        /**
         * 16 items per category
         */
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

        /********************* 과일 Product & ProductImage *******************************/
        map.add("과일", "LM0400134630003_001"); // https://www.lotteon.com/p/product/LM0400134630003?sitmNo=LM0400134630003_001&mall_no=4&dp_infw_cd=CASLM10100002
        map.add("과일", "LM0430000806720_001"); // https://www.lotteon.com/p/product/LM0430000806720?sitmNo=LM0430000806720_001&mall_no=4&dp_infw_cd=CASLM10100002
        map.add("과일", "LM0400361470007_001"); // https://www.lotteon.com/p/product/LM0400361470007?sitmNo=LM0400361470007_001&mall_no=4&dp_infw_cd=CASLM10100002
        map.add("과일", "LM0430000493043_001"); // https://www.lotteon.com/p/product/LM0430000493043?sitmNo=LM0430000493043_001&mall_no=4&dp_infw_cd=CASLM10100002
        map.add("과일", "LM0400545060000_001"); // https://www.lotteon.com/p/product/LM0400545060000?sitmNo=LM0400545060000_001&mall_no=4&dp_infw_cd=CASLM10100002
        map.add("과일", "LM0400550380001_001"); // https://www.lotteon.com/p/product/LM0400550380001?sitmNo=LM0400550380001_001&mall_no=4&dp_infw_cd=CASLM10100002
        map.add("과일", "LM0400395910005_001"); // https://www.lotteon.com/p/product/LM0400395910005?sitmNo=LM0400395910005_001&mall_no=4&dp_infw_cd=CASLM10100002
        map.add("과일", "LM0400626260008_001"); // https://www.lotteon.com/p/product/LM0400626260008?sitmNo=LM0400626260008_001&mall_no=4&dp_infw_cd=CASLM10100002
        map.add("과일", "LM0430000974412_001"); // https://www.lotteon.com/p/product/LM0430000974412?sitmNo=LM0430000974412_001&mall_no=4&dp_infw_cd=CASLM10100002
        map.add("과일", "LM8809597440488_001"); // https://www.lotteon.com/p/product/LM8809597440488?sitmNo=LM8809597440488_001&mall_no=4&dp_infw_cd=CASLM10100002
        map.add("과일", "LM0400142780004_001"); // https://www.lotteon.com/p/product/LM0400142780004?sitmNo=LM0400142780004_001&mall_no=4&dp_infw_cd=CASLM10100002
        map.add("과일", "LM8809541470226_001"); // https://www.lotteon.com/p/product/LM8809541470226?sitmNo=LM8809541470226_001&mall_no=4&dp_infw_cd=CASLM10100002
        map.add("과일", "LM8809597446718_001"); // https://www.lotteon.com/p/product/LM8809597446718?sitmNo=LM8809597446718_001&mall_no=4&dp_infw_cd=CASLM10100002
        map.add("과일", "LM0430001029692_001"); // https://www.lotteon.com/p/product/LM0430001029692?sitmNo=LM0430001029692_001&mall_no=4&dp_infw_cd=CASLM10100002
        map.add("과일", "LM0400632970007_001"); // https://www.lotteon.com/p/product/LM0400632970007?sitmNo=LM0400632970007_001&mall_no=4&dp_infw_cd=CASLM10100002
        map.add("과일", "LM8809045342005_001"); // https://www.lotteon.com/p/product/LM8809045342005?sitmNo=LM8809045342005_001&mall_no=4&list03.add(

        /***************************** 과일 ProductDetail *******************************/
        map.add("LM0400134630003_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001656/20220624140405701_QY915380.jpg");
        map.add("LM0400134630003_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001656/20220624140425293_CJGX57EM.jpg");
        map.add("LM0430000806720_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001346/20210609174654661_3UOJ0PGS.jpg");
        map.add("LM0430000806720_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001346/20210610094819333_OLV63WED.jpg");
        map.add("LM0430000806720_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001346/20210609174739983_7LE65EC7.jpg");
        map.add("LM0430000806720_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001346/20210609174811510_T704GZDQ.jpg");
        map.add("LM0400361470007_001", "https://red.lotteon.com/_m2_/_rsc_/LM0400361470007/?sref=http://image.lottemart.com/lim/static_root/images/namoimg/images/000995/20190709135844608_ROBQKH60.jpeg");
        map.add("LM0400361470007_001", "https://red.lotteon.com/_m2_/_rsc_/LM0400361470007/?sref=http://image.lottemart.com/lim/static_root/images/namoimg/images/000779/20180820163832712_7C1ZXOBG.jpg");
        map.add("LM0430000493043_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001664/20220629173234294_TEW8P5CF.jpg");
        map.add("LM0430000493043_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001664/20220629173246918_FFCDFQ9F.jpg");
        map.add("LM0430000493043_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001664/20220629173257276_LQ5JMOQV.jpg");
        map.add("LM0430000493043_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001664/20220629173321431_OE66XM6D.jpg");
        map.add("LM0400545060000_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001325/20210513150238895_FH94W6IH.jpg");
        map.add("LM0400545060000_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/000788/20180823160121685_WG8LAJIJ.jpeg");
        map.add("LM0400550380001_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001643/20220602150330489_1F8FMKXI.jpg");
        map.add("LM0400395910005_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001537/20220113091356846_KC0PXFXJ.jpg");
        map.add("LM0400395910005_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001537/20220113091417223_R8SA97DT.jpg");
        map.add("LM0400626260008_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001449/20210917162656851_8MWYKBMQ.jpg");
        map.add("LM0400626260008_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001449/20210917162710363_A0GYO66Z.jpg");
        map.add("LM0430000974412_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001605/20220415100100730_SEB6XQC0.jpg");
        map.add("LM0430000974412_001","https://simage.lottemart.com/lim/static_root/images/namoimg/images/001605/20220415091821964_8M7FWNR1.jpg");
        map.add("LM0430000974412_001","https://simage.lottemart.com/lim/static_root/images/namoimg/images/001605/20220415092201410_DLFGQWF2.jpg");
        map.add("LM8809597440488_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001335/20210601095621133_G915XKWN.jpg");
        map.add("LM8809597440488_001","https://simage.lottemart.com/lim/static_root/images/namoimg/images/001335/20210601095817356_QIQ1UMHJ.jpg");
        map.add("LM0400142780004_001", "https://red.lotteon.com/_m2_/_rsc_/LM0400142780004/?sref=http://image.lottemart.com/lim/static_root/images/namoimg/images/001069/20191120112539904_XFJAGDW8.jpeg");
        map.add("LM8809541470226_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001627/20220517094333428_EBRSC7B3.jpg");
        map.add("LM8809541470226_001","https://simage.lottemart.com/lim/static_root/images/namoimg/images/001627/20220517094559258_ML2VKFXX.jpg");
        map.add("LM8809597446718_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001674/20220713093657446_EWJXGBJO.jpg");
        map.add("LM8809597446718_001","https://simage.lottemart.com/lim/static_root/images/namoimg/images/001385/20210716174021152_4RQI41D3.jpg");
        map.add("LM8809597446718_001","https://simage.lottemart.com/lim/static_root/images/namoimg/images/001385/20210716174030871_ZA2Q30EA.jpg");
        map.add("LM0430001029692_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001432/20210830103849993_WT3LJCX3.jpg");
        map.add("LM0430001029692_001","https://simage.lottemart.com/lim/static_root/images/namoimg/images/001432/20210830103909304_NA52UEYV.jpg");
        map.add("LM0400632970007_001", "https://red.lotteon.com/_m2_/_rsc_/LM0400632970007/?sref=http://image.lottemart.com/lim/static_root/images/namoimg/images/000992/20190703140904738_2P32ZQ3O.jpg");
        map.add("LM8809045342005_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001448/20210916162012235_UEZS6C2D.jpg");
        map.add("LM8809045342005_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001448/20210916162036655_UZFXZM7K.jpg");


        /********************* 채소 Product & ProductImage *******************************/
        map.add("채소", "LM2873260000008_001"); // https://www.lotteon.com/p/product/LM2873260000008?sitmNo=LM2873260000008_001&mall_no=4&dp_infw_cd=CASLM10100016
        map.add("채소", "LM8809002360110_001"); // https://www.lotteon.com/p/product/LM8809002360110?sitmNo=LM8809002360110_001&mall_no=4&dp_infw_cd=CASLM10100016
        map.add("채소", "LM8809409755014_001"); // https://www.lotteon.com/p/product/LM8809409755014?sitmNo=LM8809409755014_001&mall_no=4&dp_infw_cd=CASLM10100016
        map.add("채소", "LM8801114120958_001"); // https://www.lotteon.com/p/product/LM8801114120958?sitmNo=LM8801114120958_001&mall_no=4&dp_infw_cd=CASLM10100016
        map.add("채소", "LM0430000459742_001"); // https://www.lotteon.com/p/product/LM0430000459742?sitmNo=LM0430000459742_001&mall_no=4&dp_infw_cd=CASLM10100016
        map.add("채소", "LM2700000045206_001"); // https://www.lotteon.com/p/product/LM2700000045206?sitmNo=LM2700000045206_001&mall_no=4&dp_infw_cd=CASLM10100016
        map.add("채소", "LM8802015112059_001"); // https://www.lotteon.com/p/product/LM8802015112059?sitmNo=LM8802015112059_001&mall_no=4&dp_infw_cd=CASLM10100016
        map.add("채소", "LM8807076200028_001"); // https://www.lotteon.com/p/product/LM8807076200028?sitmNo=LM8807076200028_001&mall_no=4&dp_infw_cd=CASLM10100016
        map.add("채소", "LM8809597441447_001"); // https://www.lotteon.com/p/product/LM8809597441447?sitmNo=LM8809597441447_001&mall_no=4&dp_infw_cd=CASLM10100016
        map.add("채소", "LM0430000015429_001"); // https://www.lotteon.com/p/product/LM0430000015429?sitmNo=LM0430000015429_001&mall_no=4&dp_infw_cd=CASLM10100016
        map.add("채소", "LM0400210660009_001"); // https://www.lotteon.com/p/product/LM0400210660009?sitmNo=LM0400210660009_001&mall_no=4&dp_infw_cd=CASLM10100016
        map.add("채소", "LM8809597440112_001"); // https://www.lotteon.com/p/product/LM8809597440112?sitmNo=LM8809597440112_001&mall_no=4&dp_infw_cd=CASLM10100016
        map.add("채소", "LM8809597440051_001"); // https://www.lotteon.com/p/product/LM8809597440051?sitmNo=LM8809597440051_001&mall_no=4&dp_infw_cd=CASLM10100016
        map.add("채소", "LM8809597442246_001"); // https://www.lotteon.com/p/product/LM8809597442246?sitmNo=LM8809597442246_001&mall_no=4&dp_infw_cd=CASLM10100016
        map.add("채소", "LM8801114102091_001"); // https://www.lotteon.com/p/product/LM8801114102091?sitmNo=LM8801114102091_001&mall_no=4&dp_infw_cd=CASLM10100016
        map.add("채소", "LM8809597441188_001"); // https://www.lotteon.com/p/product/LM8809597441188?sitmNo=LM8809597441188_001&mall_no=4&dp_infw_cd=CASLM10100016

        map.add("LM2873260000008_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001332/20210528105046562_9Y8K6VFT.jpg");
        map.add("LM2873260000008_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001332/20210528111627712_I4PVJ2AR.jpg");
        map.add("LM8809002360110_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001436/20210902093115783_64FM20O4.jpeg");
        map.add("LM8809409755014_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001629/20220519151448833_T7X5OXQO.jpg");
        map.add("LM8801114120958_001", "https://simage.lottemart.com/lim/static_root/images/onlinedescr/images/001095/%EA%B3%B5%ED%86%B5%EB%B0%B0%EB%84%88_%ED%92%80%EB%AC%B4%EC%9B%90%EB%91%90%EB%B6%80_(1).jpg");
        map.add("LM0430000459742_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001332/20210528103442126_SAROY225.jpg");
        map.add("LM0430000459742_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001332/20210528103530133_VFGXEW43.jpg");
        map.add("LM2700000045206_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001343/20210607140910930_JYBPVCEU.jpg");
        map.add("LM2700000045206_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001343/20210607140942176_49WUABHH.jpg");
         map.add("LM8802015112059_001", "https://red.lotteon.com/_m2_/_rsc_/LM8802015112059/?sref=http://image.lottemart.com/lim/static_root/images/namoimg/images/001224/20200831102212669_6WL60LYT.jpeg");
         map.add("LM8807076200028_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001444/20210914165810454_UI0FXPA3.jpg");
        map.add("LM8807076200028_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001614/20220427102753680_MATBL99J.jpg");
        map.add("LM8809597441447_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001334/20210531103210144_2KCJR3YM.jpg");
        map.add("LM8809597441447_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001334/20210531103241985_OI6IT3Q1.jpg");
        map.add("LM0430000015429_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001330/20210527094747870_28HAFUIK.jpeg");
        map.add("LM0400210660009_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001454/20210927164946490_IQC77O99.jpg");
        map.add("LM0400210660009_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001454/20210927165033728_F4CONZ2P.jpg");
        map.add("LM0400210660009_001",  "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001454/20210927165157706_ZLN6DPX5.jpg");
        map.add("LM8809597440112_001", "https://red.lotteon.com/_m2_/_rsc_/LM8809597440112/?sref=http://image.lottemart.com/lim/static_root/images/namoimg/images/001107/20200205144116994_UJA3N4KL.jpeg");
        map.add("LM8809597440051_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001334/20210531105732418_S33UWWR5.jpg");
        map.add("LM8809597440051_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001334/20210531114504789_9DASE574.jpg");
        map.add("LM8809597440051_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001334/20210531110035160_HNC0VQBB.jpg");
        map.add("LM8809597442246_001" ,"https://simage.lottemart.com/lim/static_root/images/namoimg/images/001153/20200506150909653_K8U4TXIG.jpeg");
        map.add("LM8801114102091_001", "https://simage.lottemart.com/lim/static_root/images/onlinedescr/images/001077/%EA%B3%B5%ED%86%B5%EB%B0%B0%EB%84%88_%EA%B5%AD%EC%82%B0%EC%BD%A9%EC%BD%A9%EB%82%98%EB%AC%BC_(2).jpg");
        map.add("LM8809597441188_001", "https://red.lotteon.com/_m2_/_rsc_/LM8809597441188/?sref=http://image.lottemart.com/lim/static_root/images/namoimg/images/000852/20181109160048336_F6HT4MSP.jpg");

        /********************* 잡곡견과 Product & ProductImage *******************************/

        map.add("잡곡견과", "LM8804246045687_001"); // https://www.lotteon.com/p/product/LM8804246045687?sitmNo=LM8804246045687_001&mall_no=4&dp_infw_cd=CASLM10100011
        map.add("잡곡견과", "LM8804595000252_001"); // https://www.lotteon.com/p/product/LM8804595000252?sitmNo=LM8804595000252_001&mall_no=4&dp_infw_cd=CASLM10100011
        map.add("잡곡견과", "LM8808433100029_001"); // https://www.lotteon.com/p/product/LM8808433100029?sitmNo=LM8808433100029_001&mall_no=4&dp_infw_cd=CASLM10100011
        map.add("잡곡견과", "LM8808836975958_001"); // https://www.lotteon.com/p/product/LM8808836975958?sitmNo=LM8808836975958_001&mall_no=4&dp_infw_cd=CASLM10100011
        map.add("잡곡견과", "LM8801619804254_001"); // https://www.lotteon.com/p/product/LM8801619804254?sitmNo=LM8801619804254_001&mall_no=4&dp_infw_cd=CASLM10100011
        map.add("잡곡견과", "LM8808509000697_001"); // https://www.lotteon.com/p/product/LM8808509000697?sitmNo=LM8808509000697_001&mall_no=4&dp_infw_cd=CASLM10100011
        map.add("잡곡견과", "LM8809066230176_001"); // https://www.lotteon.com/p/product/LM8809066230176?sitmNo=LM8809066230176_001&mall_no=4&dp_infw_cd=CASLM10100011
        map.add("잡곡견과", "LM8809191314789_001"); // https://www.lotteon.com/p/product/LM8809191314789?sitmNo=LM8809191314789_001&mall_no=4&dp_infw_cd=CASLM10100011
        map.add("잡곡견과", "LM8801767338915_001"); // https://www.lotteon.com/p/product/LM8801767338915?sitmNo=LM8801767338915_001&mall_no=4&dp_infw_cd=CASLM10100011
        map.add("잡곡견과", "LM8809334061150_001"); // https://www.lotteon.com/p/product/LM8809334061150?sitmNo=LM8809334061150_001&mall_no=4&dp_infw_cd=CASLM10100011
        map.add("잡곡견과", "LM8804595000757_001"); // https://www.lotteon.com/p/product/LM8804595000757?sitmNo=LM8804595000757_001&mall_no=4&dp_infw_cd=CASLM10100011
        map.add("잡곡견과", "LM8801767339561_001"); // https://www.lotteon.com/p/product/LM8801767339561?sitmNo=LM8801767339561_001&mall_no=4&dp_infw_cd=CASLM10100011
        map.add("잡곡견과", "LM8809191314772_001"); // https://www.lotteon.com/p/product/LM8809191314772?sitmNo=LM8809191314772_001&mall_no=4&dp_infw_cd=CASLM10100011
        map.add("잡곡견과", "LM8809276717832_001"); // https://www.lotteon.com/p/product/LM8809276717832?sitmNo=LM8809276717832_001&mall_no=4&dp_infw_cd=CASLM10100011
        map.add("잡곡견과", "LM8801382149637_001"); // https://www.lotteon.com/p/product/LM8801382149637?sitmNo=LM8801382149637_001&mall_no=4&dp_infw_cd=CASLM10100011
        map.add("잡곡견과", "LM8801500151467_001"); // https://www.lotteon.com/p/product/LM8801500151467?sitmNo=LM8801500151467_001&mall_no=4&dp_infw_cd=CASLM10100011

        map.add("LM8804246045687_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001665/20220630145230976_2EV15Z0W.jpg");
        map.add("LM8804595000252_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001461/20211006110956560_FK0JCIFE.jpg");
        map.add("LM8804595000252_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001461/20211006111015802_LBF7URV5.jpg");
      map.add(  "LM8804595000252_001",     "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001461/20211006111057542_4R37Q3DM.jpg");
       map.add( "LM8808433100029_001", "https://red.lotteon.com/_m2_/_rsc_/LM8808433100029/?sref=http://image.lottemart.com/lim/static_root/images/namoimg/images/001259/20201125173511901_U5O64UBU.jpeg");
       map.add( "LM8808836975958_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001332/20210528135720269_65JEANFP.jpg");
       map.add( "LM8801619804254_001", "https://simage.lottemart.com/lim/static_root/images/edidescrimg/images/001680/Lipton_Zero_Sugar_30ST_%EC%83%81%EC%84%B8%ED%8E%98%EC%9D%B4%EC%A7%80_%EC%9D%B4%EB%AF%B8%EC%A7%80%EC%A1%B0%EC%A0%95_1.jpg");
       map.add( "LM8808509000697_001", "https://simage.lottemart.com/lim/static_root/images/onlinedescr/images/001369/20200622102625502_7B80O3FF.jpeg");
       map.add( "LM8809066230176_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001665/20220630144847657_IAUB36BV.jpg");
       map.add( "LM8809066230176_001",   "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001665/20220630144859220_6BBC9VZ0.jpg");
      map.add(  "LM8809191314789_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001594/20220331105313938_4I4L28WO.jpg");
      map.add(  "LM8801767338915_001", "https://simage.lottemart.com/lim/static_root/images/edidescrimg/images/001686/%EC%98%AC%EB%A6%AC%EA%B3%A0%EB%8B%B9-%EB%84%A3%EC%9D%80-%EB%AF%B8%EC%88%AB%EA%B3%A1%EB%AC%BC%EC%B0%A8_%EB%AC%B8%EC%95%88%EC%88%98%EC%A0%95_210813_3%EB%A9%94%EA%B0%80.jpg");
      map.add(  "LM8809334061150_001", "https://red.lotteon.com/_m2_/_rsc_/LM8809334061150/?sref=http://image.lottemart.com/lim/static_root/images/namoimg/images/000630/20180219153151445_72LARDNX.jpeg");
      map.add(  "LM8804595000757_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001478/20211025095539682_S18Z1LE2.jpg");
      map.add(  "LM8804595000757_001","https://simage.lottemart.com/lim/static_root/images/namoimg/images/001478/20211025095512855_XTSHPH5Q.jpg");
      map.add( "LM8804595000757_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001478/20211025095556900_HETDJXO1.jpg");
     map.add(   "LM8801767339561_001", "https://simage.lottemart.com/lim/static_root/images/edidescrimg/images/001686/%EC%98%A4%ED%8A%B8%EB%B0%80%EB%AF%B8%EC%88%AB%EA%B3%A1%EB%AC%BC%EC%B0%A8-%EC%8B%9C%EB%AE%AC(%ED%9B%84%EB%A9%B4)_1.jpg");
     map.add(     "LM8801767339561_001",  "https://simage.lottemart.com/lim/static_root/images/edidescrimg/images/001686/%EC%98%A4%ED%8A%B8%EB%B0%80%EB%AF%B8%EC%88%AB%EA%B3%A1%EB%AC%BC%EC%B0%A8-%EC%A0%95%EB%B3%B4%ED%91%9C%EC%8B%9C%EB%A9%B4.jpg");
      map.add(     "LM8809191314772_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001594/20220331104526961_UBMX3AP0.jpg");
     map.add(   "LM8809191314772_001", "https://simage.lottemart.com/lim/static_root/images/namoimg/images/001594/20220331104600967_WQ2NKUG1.jpg");
     map.add(    "LM8809276717832_001", "https://red.lotteon.com/_m2_/_rsc_/LM8809276717832/?sref=http://image.lottemart.com/lim/static_root/images/namoimg/images/000675/20180417115425168_HUMOPGFQ.jpg");
     map.add(   "LM8801382149637_001", "https://simage.lottemart.com/lim/static_root/images/edidescrimg/images/001654/500_500_%EC%9B%85%EC%A7%84_%ED%95%98%EB%8A%98%EB%B3%B4%EB%A6%AC_1.35L.jpg");
     map.add(   "LM8801382149637_001", "https://simage.lottemart.com/lim/static_root/images/edidescrimg/images/001654/500_%ED%95%98%EB%8A%98%EB%B3%B4%EB%A6%AC_1.35%ED%91%9C%EC%8B%9C%EC%82%AC%ED%95%AD.jpg");
     map.add(   "LM8801500151467_001", "https://red.lotteon.com/_m2_/_rsc_/LM8801500151467/?sref=http://image.lottemart.com/lim/static_root/images/namoimg/images/001190/20200713155634544_ET59ET7B.jpeg");

//        /********************* 수산 Product & ProductImage *******************************/
//
//        map.add("수산", "LM8801133009098_001"); // https://www.lotteon.com/p/product/LM8801133009098?sitmNo=LM8801133009098_001&mall_no=4&dp_infw_cd=CASLM90020000
//        map.add("수산", "LM8801133009081_001"); // https://www.lotteon.com/p/product/LM8801133009081?sitmNo=LM8801133009081_001&mall_no=4&dp_infw_cd=CASLM90020000
//        map.add("수산", "LM8809022209697_001"); // https://www.lotteon.com/p/product/LM8809022209697?sitmNo=LM8809022209697_001&mall_no=4&dp_infw_cd=CASLM90020000
//        map.add("수산", "LM8809019708530_001"); // https://www.lotteon.com/p/product/LM8809019708530?sitmNo=LM8809019708530_001&mall_no=4&dp_infw_cd=CASLM90020000
//        map.add("수산", "LM8801133008466_001"); // https://www.lotteon.com/p/product/LM8801133008466?sitmNo=LM8801133008466_001&mall_no=4&dp_infw_cd=CASLM90020000
//        map.add("수산", "LM8809019711479_001"); // https://www.lotteon.com/p/product/LM8809019711479?sitmNo=LM8809019711479_001&mall_no=4&dp_infw_cd=CASLM90020000
//        map.add("수산", "LM8809019708554_001"); // https://www.lotteon.com/p/product/LM8809019708554?sitmNo=LM8809019708554_001&mall_no=4&dp_infw_cd=CASLM90020000
//        map.add("수산", "LM8809742173582_001"); // https://www.lotteon.com/p/product/LM8809742173582?sitmNo=LM8809742173582_001&mall_no=4&dp_infw_cd=CASLM90020000
//        map.add("수산", "LM8809022201486_001"); // https://www.lotteon.com/p/product/LM8809022201486?sitmNo=LM8809022201486_001&mall_no=4&dp_infw_cd=CASLM90020000
//        map.add("수산", "LM8809617942480_001"); // https://www.lotteon.com/p/product/LM8809617942480?sitmNo=LM8809617942480_001&mall_no=4&dp_infw_cd=CASLM90020000
//        map.add("수산", "LM8809617944958_001"); // https://www.lotteon.com/p/product/LM8809617944958?sitmNo=LM8809617944958_001&mall_no=4&dp_infw_cd=CASLM90020000
//        map.add("수산", "LM8809036729877_001"); // https://www.lotteon.com/p/product/LM8809036729877?sitmNo=LM8809036729877_001&mall_no=4&dp_infw_cd=CASLM90020000
//        map.add("수산", "LM0430001073312_001"); // https://www.lotteon.com/p/product/LM0430001073312?sitmNo=LM0430001073312_001&mall_no=4&dp_infw_cd=CASLM90020000
//        map.add("수산", "LM8936172871372_001"); // https://www.lotteon.com/p/product/LM8936172871372?sitmNo=LM8936172871372_001&mall_no=4&dp_infw_cd=CASLM90020000
//        map.add("수산", "LM8801448335240_001"); // https://www.lotteon.com/p/product/LM8801448335240?sitmNo=LM8801448335240_001&mall_no=4&dp_infw_cd=CASLM90020000
//        map.add("수산", "LM8809019711486_001"); // https://www.lotteon.com/p/product/LM8809019711486?sitmNo=LM8809019711486_001&mall_no=4&dp_infw_cd=CASLM90020000
//
//        map.add("정육계란", "LM8803365750359_001"); // https://www.lotteon.com/p/product/LM8803365750359?sitmNo=LM8803365750359_001&mall_no=4&dp_infw_cd=CASLM10100014
//        map.add("정육계란", "LM2700000000533_001"); // https://www.lotteon.com/p/product/LM2700000000533?sitmNo=LM2700000000533_001&mall_no=4&dp_infw_cd=CASLM10100014
//        map.add("정육계란", "LM2700000015360_001"); // https://www.lotteon.com/p/product/LM2700000015360?sitmNo=LM2700000015360_001&mall_no=4&dp_infw_cd=CASLM10100014
//        map.add("정육계란", "LM2700000027653_001"); // https://www.lotteon.com/p/product/LM2700000027653?sitmNo=LM2700000027653_001&mall_no=4&dp_infw_cd=CASLM10100014
//        map.add("정육계란", "LM2881230000002_001"); // https://www.lotteon.com/p/product/LM2881230000002?sitmNo=LM2881230000002_001&mall_no=4&dp_infw_cd=CASLM10100014
//        map.add("정육계란", "LM2700000027943_001"); // https://www.lotteon.com/p/product/LM2700000027943?sitmNo=LM2700000027943_001&mall_no=4&dp_infw_cd=CASLM10100014
//        map.add("정육계란", "LM2861900000006_001"); // https://www.lotteon.com/p/product/LM2861900000006?sitmNo=LM2861900000006_001&mall_no=4&dp_infw_cd=CASLM10100014
//        map.add("정육계란", "LM2700000015551_001"); // https://www.lotteon.com/p/product/LM2700000015551?sitmNo=LM2700000015551_001&mall_no=4&dp_infw_cd=CASLM10100014
//        map.add("정육계란", "LM2700000015315_001"); // https://www.lotteon.com/p/product/LM2700000015315?sitmNo=LM2700000015315_001&mall_no=4&dp_infw_cd=CASLM10100014
//        map.add("정육계란", "LM8804030000038_001"); // https://www.lotteon.com/p/product/LM8804030000038?sitmNo=LM8804030000038_001&mall_no=4&dp_infw_cd=CASLM10100014
//        map.add("정육계란", "LM8801114141069_001"); // https://www.lotteon.com/p/product/LM8801114141069?sitmNo=LM8801114141069_001&mall_no=4&dp_infw_cd=CASLM10100014
//        map.add("정육계란", "LM2881590000001_001"); // https://www.lotteon.com/p/product/LM2881590000001?sitmNo=LM2881590000001_001&mall_no=4&dp_infw_cd=CASLM10100014
//        map.add("정육계란", "LM8809032697415_001"); // https://www.lotteon.com/p/product/LM8809032697415?sitmNo=LM8809032697415_001&mall_no=4&dp_infw_cd=CASLM10100014
//        map.add("정육계란", "LM2700000027660_001"); // https://www.lotteon.com/p/product/LM2700000027660?sitmNo=LM2700000027660_001&mall_no=4&dp_infw_cd=CASLM10100014
//        map.add("정육계란", "LM8809055510982_001"); // https://www.lotteon.com/p/product/LM8809055510982?sitmNo=LM8809055510982_001&mall_no=4&dp_infw_cd=CASLM10100014
//        map.add("정육계란", "LM8809385948738_001"); // https://www.lotteon.com/p/product/LM8809385948738?sitmNo=LM8809385948738_001&mall_no=4&dp_infw_cd=CASLM10100014
//
//        map.add("유제품", "LM2700000052310_001"); // https://www.lotteon.com/p/product/LM2700000052310?sitmNo=LM2700000052310_001&mall_no=4&dp_infw_cd=CASLM10100009
//        map.add("유제품", "LM2614860000001_001"); // https://www.lotteon.com/p/product/LM2614860000001?sitmNo=LM2614860000001_001&mall_no=4&dp_infw_cd=CASLM10100009
//        map.add("유제품", "LM2700000029770_001"); // https://www.lotteon.com/p/product/LM2700000029770?sitmNo=LM2700000029770_001&mall_no=4&dp_infw_cd=CASLM10100009
//        map.add("유제품", "LM2529500000009_001"); // https://www.lotteon.com/p/product/LM2529500000009?sitmNo=LM2529500000009_001&mall_no=4&dp_infw_cd=CASLM10100009
//        map.add("유제품", "LM2700000046951_001"); // https://www.lotteon.com/p/product/LM2700000046951?sitmNo=LM2700000046951_001&mall_no=4&dp_infw_cd=CASLM10100009
//        map.add("유제품", "LM2700000058350_001"); // https://www.lotteon.com/p/product/LM2700000058350?sitmNo=LM2700000058350_001&mall_no=4&dp_infw_cd=CASLM10100009
//        map.add("유제품", "LM2527680000000_001"); // https://www.lotteon.com/p/product/LM2527680000000?sitmNo=LM2527680000000_001&mall_no=4&dp_infw_cd=CASLM10100009
//        map.add("유제품", "LM2534930000000_001"); // https://www.lotteon.com/p/product/LM2534930000000?sitmNo=LM2534930000000_001&mall_no=4&dp_infw_cd=CASLM10100009
//        map.add("유제품", "LM8809433792962_001"); // https://www.lotteon.com/p/product/LM8809433792962?sitmNo=LM8809433792962_001&mall_no=4&dp_infw_cd=CASLM10100009
//        map.add("유제품", "LM2700000029817_001"); // https://www.lotteon.com/p/product/LM2700000029817?sitmNo=LM2700000029817_001&mall_no=4&dp_infw_cd=CASLM10100009
//        map.add("유제품", "LM2565790000008_001"); // https://www.lotteon.com/p/product/LM2565790000008?sitmNo=LM2565790000008_001&mall_no=4&dp_infw_cd=CASLM10100009
//        map.add("유제품", "LM2830990000005_001"); // https://www.lotteon.com/p/product/LM2830990000005?sitmNo=LM2830990000005_001&mall_no=4&dp_infw_cd=CASLM10100009
//        map.add("유제품", "LM2672790000003_001"); // https://www.lotteon.com/p/product/LM2672790000003?sitmNo=LM2672790000003_001&mall_no=4&dp_infw_cd=CASLM10100009
//        map.add("유제품", "LM2893900000007_001"); // https://www.lotteon.com/p/product/LM2893900000007?sitmNo=LM2893900000007_001&mall_no=4&dp_infw_cd=CASLM10100009
//        map.add("유제품", "LM2584440000007_001"); // https://www.lotteon.com/p/product/LM2584440000007?sitmNo=LM2584440000007_001&mall_no=4&dp_infw_cd=CASLM10100009
//        map.add("유제품", "LM2894660000009_001"); // https://www.lotteon.com/p/product/LM2894660000009?sitmNo=LM2894660000009_001&mall_no=4&dp_infw_cd=CASLM10100009
//
//        map.add("냉장냉동", "LM8801123700653_001"); // https://www.lotteon.com/p/product/LM8801123700653?sitmNo=LM8801123700653_001&mall_no=4&dp_infw_cd=CASLM90040000
//        map.add("냉장냉동", "LM8801123727391_001"); // https://www.lotteon.com/p/product/LM8801123727391?sitmNo=LM8801123727391_001&mall_no=4&dp_infw_cd=CASLM90040000
//        map.add("냉장냉동", "LM8801007883304_001"); // https://www.lotteon.com/p/product/LM8801007883304?sitmNo=LM8801007883304_001&mall_no=4&dp_infw_cd=CASLM90040000
//        map.add("냉장냉동", "LM8801123309856_001"); // https://www.lotteon.com/p/product/LM8801123309856?sitmNo=LM8801123309856_001&mall_no=4&dp_infw_cd=CASLM90040000
//        map.add("냉장냉동", "LM8801007526492_001"); // https://www.lotteon.com/p/product/LM8801007526492?sitmNo=LM8801007526492_001&mall_no=4&dp_infw_cd=CASLM90040000
//        map.add("냉장냉동", "LM8801242045635_001"); // https://www.lotteon.com/p/product/LM8801242045635?sitmNo=LM8801242045635_001&mall_no=4&dp_infw_cd=CASLM90040000
//        map.add("냉장냉동", "LM8801007526225_001"); // https://www.lotteon.com/p/product/LM8801007526225?sitmNo=LM8801007526225_001&mall_no=4&dp_infw_cd=CASLM90040000
//        map.add("냉장냉동", "LM8801007033686_001"); // https://www.lotteon.com/p/product/LM8801007033686?sitmNo=LM8801007033686_001&mall_no=4&dp_infw_cd=CASLM90040000
//        map.add("냉장냉동", "LM8801242001716_001"); // https://www.lotteon.com/p/product/LM8801242001716?sitmNo=LM8801242001716_001&mall_no=4&dp_infw_cd=CASLM90040000
//        map.add("냉장냉동", "LM8801007883281_001"); // https://www.lotteon.com/p/product/LM8801007883281?sitmNo=LM8801007883281_001&mall_no=4&dp_infw_cd=CASLM90040000
//        map.add("냉장냉동", "LM8801007857206_001"); // https://www.lotteon.com/p/product/LM8801007857206?sitmNo=LM8801007857206_001&mall_no=4&dp_infw_cd=CASLM90040000
//        map.add("냉장냉동", "LM8801114101834_001"); // https://www.lotteon.com/p/product/LM8801114101834?sitmNo=LM8801114101834_001&mall_no=4&dp_infw_cd=CASLM90040000
//        map.add("냉장냉동", "LM8809265024712_001"); // https://www.lotteon.com/p/product/LM8809265024712?sitmNo=LM8809265024712_001&mall_no=4&dp_infw_cd=CASLM90040000
//        map.add("냉장냉동", "LM8801007561677_001"); // https://www.lotteon.com/p/product/LM8801007561677?sitmNo=LM8801007561677_001&mall_no=4&dp_infw_cd=CASLM90040000
//        map.add("냉장냉동", "LM8809265020158_001"); // https://www.lotteon.com/p/product/LM8809265020158?sitmNo=LM8809265020158_001&mall_no=4&dp_infw_cd=CASLM90040000
//        map.add("냉장냉동", "LM8809146311528_001"); // https://www.lotteon.com/p/product/LM8809146311528?sitmNo=LM8809146311528_001&mall_no=4&dp_infw_cd=CASLM90040000
//


        /** Table 별 empty List 생성 */
        List<ProductDto> productList = new ArrayList<>();
        List<ProductImageDto> productImageList = new ArrayList<>();
        List<ProductDetailDto> productDetailList = new ArrayList<>();

        String categories[] = {"과일", "채소", "잡곡견과"};

//        String categories[] = {"과일", "채소", "잡곡견과", "수산", "정육계란", "유제품", "냉장냉동"};
        String apiPrefix = "https://pbf.lotteon.com/product/v2/detail/search/base/sitm/";

        /**
         * long pPK 를 10으로 설정해서 Product, ProductImage, ProductDetail table 에서 insert 되는 pPK 값을 일치시켜주고
         * dummy data 가 0개 일 경우 error 뜨는 main.jsp 해결 가능. (product & order PK 값 9이하로 한두개 넣어 놓고 실행 OK )
         *  단, pPK 가 10부터 insert 되기 때문에, productid 값이 10보다 큰 경우 insert 되지 않으며
         *  그럴 경우 alter table product auto_increment = 1; 한번씩 해주고 실행
         *
         */
        long pPK = 1;

        for(int i=0; i< categories.length; i++){

            List<String> items = map.get(categories[i]);

            for(int j=0; j< items.size(); j++){
                String sitmNo = items.get(j);

                JSONObject json = readJsonFromUrl(apiPrefix + sitmNo);
                JSONObject data = json.getJSONObject("data");
                JSONObject basicInfo = data.getJSONObject("basicInfo");
                JSONArray imageList = data.getJSONObject("imgInfo").getJSONArray("imageList");

                String pdSitm = basicInfo.getString("itmNo");
                String pdName = basicInfo.getString("pdNm");

                int pdPrice = data.getJSONObject("priceInfo").getInt("slPrc");
                int pdStock = data.getJSONObject("stckInfo").getInt("stkQty");

//               String regDate = "2020-01-01-00:00:00";
                String regDate = randomRegDate();
                double productTotalRate = 0.0;

                productList.add(new ProductDto(pPK, pdSitm, pdName, categories[i], pdPrice, pdStock, regDate, productTotalRate));

                for(int k=0; k < imageList.length(); k++) {
                    String sideImg =(imageList.getJSONObject(k)).getString("origImgFileNm");
                    productImageList.add(new ProductImageDto( k+1, pPK, sideImg));
                }

                List<String> detailImgList = map.get(pdSitm);
                for(int l = 0; l<detailImgList.size(); l++){
                    productDetailList.add(new ProductDetailDto(pPK, detailImgList.get(l)));
                }

                pPK += 1;   // productId 1증가
            }
        }

        Map<String, Object> outcome = new HashMap<String, Object>();
        outcome.put("productList", productList);
        outcome.put("productImageList", productImageList);
		outcome.put("productDetailList", productDetailList);

		System.out.println(productList.size());
        System.out.println(productImageList.size());
        System.out.println(productDetailList.size());

        return outcome;
    }

    public static void main(String[] args) throws IOException {
        Map<String, Object> m = run();
    }

}