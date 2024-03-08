package com.vdc.ims.common.util;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import voiceware.libttsapi;

import java.io.*;
import java.util.*;

@Component("tts")
public class TTS {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${tts.server}")
    private String tts_host;

    @Value("${tts.port}")
    private int tts_port;

    @Value("${tts.speakerid}")
    private int tts_speakerid;

    @Value("${tts.voiceformat}")
    private int tts_voiceformat;

    @Value("${tts.volume}")
    private int tts_volume;

    @Value("${tts.speed}")
    private int tts_speed;

    @Value("${tts.pitch}")
    private int tts_pitch;

    @Value("${tts.temppath}")
    private String tts_temppath;

    //미리 듣기
    public Map<String, Object> MakeTts_File(String text) throws IOException, ClassNotFoundException {
        int nReturn = 0;

        libttsapi ttsapi = new libttsapi();
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {
            nReturn = ttsapi.ttsRequestBufferEx(tts_host, tts_port, text, tts_speakerid, tts_voiceformat, 0, tts_volume, tts_speed, tts_pitch, 0, libttsapi.TRUE, libttsapi.TRUE);
        } catch (IOException e) {
            nReturn = -9;
        }

        if (nReturn == libttsapi.TTS_RESULT_SUCCESS) {

            String uuid_filename = StringUtil.getRandomString();
            boolean filewrite = writeByteToFile(uuid_filename+".wav", ttsapi.szVoiceData, ttsapi.nVoiceLength);

            rtn.put("uuid_filename", uuid_filename+".wav");
            rtn.put("filewrite", filewrite);
            rtn.put("success", true);
            rtn.put("msg", "Success (" + nReturn + ")");

        } else {
            rtn.put("success", false);
            rtn.put("msg", "Failed (" + nReturn + ")");
        }

        return rtn;
    }
    
    //음원 파일 생성
    public Map<String, Object> MakeTts_File(String FileName, String text) throws IOException, ClassNotFoundException {
        int nReturn = 0;

        libttsapi ttsapi = new libttsapi();
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {
            nReturn = ttsapi.ttsRequestBufferEx(tts_host, tts_port, text, tts_speakerid, tts_voiceformat, 0, tts_volume, tts_speed, tts_pitch, 0, libttsapi.TRUE, libttsapi.TRUE);
        } catch (IOException e) {
            nReturn = -9;
        }

        if (nReturn == libttsapi.TTS_RESULT_SUCCESS) {

            String uuid_filename = StringUtil.getRandomString();
            boolean filewrite = writeByteToFile(FileName+"_"+uuid_filename+".wav", ttsapi.szVoiceData, ttsapi.nVoiceLength);

            rtn.put("uuid_filename", FileName+"_"+uuid_filename+".wav");
            rtn.put("filewrite", filewrite);
            rtn.put("success", true);
            rtn.put("msg", "Success (" + nReturn + ")");

        } else {
            rtn.put("success", false);
            rtn.put("msg", "Failed (" + nReturn + ")");
        }

        return rtn;
    }

    public boolean writeByteToFile(String filename, byte[] src, int len) {
        File outputFile;
        FileOutputStream out;
        boolean rst = false;
        try {
            outputFile = new File(tts_temppath+filename);
            out = new FileOutputStream(outputFile);
            out.write(src, 0, len);
            out.close();
            rst = true;
        } catch (IOException e) {
            logger.info("file write error!!");
            rst = false;
        }

        return rst;
    }


    //미리듣기 base64로 Converting
/*
    public String wavToBase64(String filename) {
        File file = new File(tts_temppath+filename);



        return encoded;
    }
*/


}