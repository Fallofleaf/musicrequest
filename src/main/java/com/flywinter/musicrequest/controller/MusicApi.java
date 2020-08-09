package com.flywinter.musicrequest.controller;

import com.flywinter.musicrequest.result.ResultFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * User:Xingkun Zhang
 * Date:2020/8/7
 * Description:
 */
@RestController
public class MusicApi {

    @GetMapping("/music/list")
    public Map<String,  List<ResultFormat>> getMusicList(){
        List<ResultFormat> listUrl = new ArrayList();
        listUrl.add(new ResultFormat(200,"豆花之歌","http://192.168.1.3:8585//music/1"));
        listUrl.add(new ResultFormat(200,"泡沫","http://192.168.1.3:8585//music/2"));
        listUrl.add(new ResultFormat(200,"不分手的恋爱","http://192.168.1.3:8585//music/3"));
        listUrl.add(new ResultFormat(200,"杏花弦外雨","http://192.168.1.3:8585//music/4"));
        Map<String,List<ResultFormat>> map = new HashMap();
        map.put("data",listUrl);
        return map;
    }

    @GetMapping("/music/{musicId}")
    public void getMusic(@PathVariable("musicId") String musicId, HttpServletResponse response) throws IOException {
//        String[] split = imageUrl.split("_");
//        Image image = imageDAO.findById(Long.valueOf(split[0])).orElse(null);
        if (musicId.equals("4")){
              musicId = "CRITTY、司夏 - 杏花弦外雨(1).mp3";
        }
        if (musicId.equals("2")){
            musicId = "G.E.M.邓紫棋 - 泡沫.mp3";
        }
        if (musicId.equals("3")){
            musicId = "汪苏泷 - 不分手的恋爱.mp3";
        }
        if (musicId.equals("1")){
            musicId = "douhuazhige.mp3";
        }

            String path = "F:\\KuGou\\" + musicId;
            File file = new File(path);
            FileInputStream fileInputStream = new FileInputStream(file);

            response.setHeader("Content-Type","audio/mp3");

            OutputStream outputStream = response.getOutputStream();
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes,0,len);
            }
            outputStream.flush();
            outputStream.close();
            fileInputStream.close();
    }

}
