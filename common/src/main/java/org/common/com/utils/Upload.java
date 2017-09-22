package org.common.com.utils;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

public class Upload {

    private static String getFileExp(String name,String flag){
        int pos = name.lastIndexOf(flag) ;
        return name.substring(pos) ;
    }

    public static Set<String> removeDeplucate(List list){

        Set set = new HashSet() ;
        for (Iterator iter=list.iterator();iter.hasNext();){
            set.add(iter.next()) ;
        }
        return set ;
    }
    public HashMap<String,String> parperUp(HttpServletRequest request,String name) throws Exception{
        HashMap<String,String> map = new HashMap<String, String>() ;
        String back = null ;
        MultipartHttpServletRequest multipartRequest =(MultipartHttpServletRequest) request ;
        List<MultipartFile> mFiles = multipartRequest.getFiles(name) ;
        Iterator<MultipartFile> item = mFiles.iterator() ;
        while (item.hasNext()){
            MultipartFile mFile = item.next() ;
            if (!mFile.isEmpty()){
                String path = request.getSession().getServletContext().getRealPath("/upload") ;
                File folder = new File(path) ;
                if (!folder.exists()){
                    folder.mkdir() ;
                }
                String dstr = getRandName();
                path = path+"/"+dstr ;
                File ofile = new File(path) ;
                if (!ofile.exists()){
                    ofile.mkdir() ;
                }
                String tran = "/"+new Date().getTime()+getFileExp(mFile.getOriginalFilename(),".") ;
                String newName = path+tran ;
                File file = new File(newName) ;
                try{
                    mFile.transferTo(file);
                }catch (Exception e){
                    e.printStackTrace();
                }
                if (back==null){
                    back = "/upload/"+dstr+tran ;
                }else {
                    back+=" "+"/upload/"+dstr +tran;
                }


            }
        }
        String AllPath = request.getSession().getServletContext().getRealPath(back) ;
        map.put("allPath",AllPath) ;
        map.put("path",back) ;

        return map ;
    }
    private String getRandName(){
        Calendar c = Calendar.getInstance() ;
        int year = c.get(Calendar.YEAR) ;
        int month = c.get(Calendar.MONTH)+1 ;
        int date = c.get(Calendar.DATE) ;
        String dstr = "" ;
        dstr+=year ;
        dstr+=(month<10?"0":"")+month ;

        return dstr ;

    }


}
