package org.gisoper.com.utils;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.common.com.constant.ConstantUtils;
import org.common.com.constant.SystemConstant;
import org.common.com.utils.DateUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.gisoper.com.vo.PartnerResultBeanVo;
import org.gisoper.com.vo.RegisterPartnerBeanVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

public class PartnerApiUtil {

    private static Logger logger = LoggerFactory.getLogger(PartnerApiUtil.class) ;

    public static String createXml(String type, RegisterPartnerBeanVo partnerBeanVo,String msids){
        String xmlstr = "" ;

        try{
            Document document = DocumentHelper.createDocument() ;
            document.setXMLEncoding("GB2312");
            Element yhjx_init = document.addElement("yhjx_init") ;
            Element request=yhjx_init.addElement("request") ;
            Element username = request.addElement("username") ;
            username.setText(SystemConstant.getPartnerApiUser());
            Element password = request.addElement("password") ;
            password.setText(SystemConstant.getPartnerApiPwd());
            Element typement = request.addElement("type") ;
            typement.setText(type);
            Element info = request.addElement("info") ;
            if (ConstantUtils.NEW_REGISTER.equals(type)){
                Element msid = info.addElement("msid") ;
                msid.setText(partnerBeanVo.getMsid());
                Element driver_name = info.addElement("driver_name") ;
                driver_name.setText(partnerBeanVo.getDriverName());
                Element idcard = info.addElement("idcard") ;
                idcard.setText(partnerBeanVo.getIdcard());
            }else if (ConstantUtils.DEL_ORG_DRIVER_REL.equals(type)){
                Element msid = info.addElement("msid") ;
                msid.setText(msids);
            }else if (ConstantUtils.GET_ORG_DRIVER_REL.equals(type)){
                Element msid = info.addElement("msid") ;
                msid.setText(msids);
            }else if (ConstantUtils.MUIT_EXACT_LOCATION.equals(type)){
                Element msid = info.addElement("msid") ;
                msid.setText(msids);
                Element datetime = info.addElement("datetime") ;
                datetime.setText(DateUtils.convert(new Date()));
                Element external = info.addElement("external_note") ;
                external.setText("精确定位");
            }
            xmlstr = document.asXML() ;

        }catch (Exception e){
            e.printStackTrace();
            Map<String,String> logMap = new HashMap<String, String>() ;
            logMap.put("msids",msids) ;
            logMap.put("type",type) ;
            logMap.put("partnerBeanVo", JSONObject.fromObject(partnerBeanVo).toString()) ;
            logger.error("创建xml文件失败,{}，{}",e,logMap);
        }
        return xmlstr ;
    }
    public static List<PartnerResultBeanVo> readStringXml(String xmlStr){
        List<PartnerResultBeanVo> resultBeanVos = new ArrayList<PartnerResultBeanVo>() ;

        Document doc = null ;
        try{
            doc = DocumentHelper.parseText(xmlStr) ;
            Element rootElt = doc.getRootElement() ;
            Iterator iter = rootElt.elementIterator("response") ;
            while (iter.hasNext()){
                Element recordEle = (Element) iter.next() ;
                String type = recordEle.elementTextTrim("type") ;
                Iterator iters = recordEle.elementIterator("result") ;
                if (type.equals(ConstantUtils.NEW_REGISTER)){
                    while (iters.hasNext()){
                        PartnerResultBeanVo partnerResultBeanVo = new PartnerResultBeanVo() ;
                        Element itemEle = (Element) iters.next() ;
                        String result_id = itemEle.elementTextTrim("result_id") ;
                        String result_info = itemEle.elementTextTrim("resultInfo") ;
                        String dateTime = itemEle.elementTextTrim("datetime") ;
                        partnerResultBeanVo.setResultId(result_id);
                        partnerResultBeanVo.setResultInfo(result_info);
                        resultBeanVos.add(partnerResultBeanVo) ;
                    }
                }else if (ConstantUtils.DEL_ORG_DRIVER_REL.equals(type)){
                    while (iters.hasNext()){
                        Element itemEle = (Element) iters.next() ;
                    }
                }else if (ConstantUtils.GET_ORG_DRIVER_REL.equals(type)){
                    while (iters.hasNext()){
                        Element itemEle = (Element) iters.next() ;
                    }
                }else if (ConstantUtils.MUIT_EXACT_LOCATION.equals(type)){
                    while (iters.hasNext()){
                        Element itemEle = (Element) iters.next() ;
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            Map<String,String> logMap = new HashMap<String, String>() ;
            logMap.put("xmlstr",xmlStr) ;
            logger.error("解析xml文件失败：{},{}",e,logMap);
        }

        return resultBeanVos ;
    }

    public static String encode(String param) throws Exception{
        String encodeParam = URLEncoder.encode(param,"GB2312") ;
        return encodeParam ;
    }
    public static String decode(String param) throws Exception{
        String decodeParam = URLDecoder.decode(param,"GB2312") ;

        return decodeParam ;
    }
    public static String paramEncode(String type,RegisterPartnerBeanVo registerPartnerBeanVo,String msids){
        String paramStr = "" ;
        try{
            String xmlStr = createXml(type,registerPartnerBeanVo,msids) ;
            if (StringUtils.isNotBlank(xmlStr)){
                paramStr = encode(xmlStr) ;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return paramStr ;
    }

    public static List<PartnerResultBeanVo> resultDecode(String xmlStr){
        List<PartnerResultBeanVo> resultBeanVos = new ArrayList<PartnerResultBeanVo>() ;
        try{
            String xml = decode(xmlStr) ;
            resultBeanVos = readStringXml(xml) ;
        }catch (Exception e){
            e.printStackTrace();
        }

        return resultBeanVos ;
    }

}
