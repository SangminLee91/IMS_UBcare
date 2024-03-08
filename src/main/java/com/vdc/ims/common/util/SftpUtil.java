package com.vdc.ims.common.util;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Properties;

@Component("sftp")
public class SftpUtil {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${ftp.servermain}")
    private String ftp_server_main;

    @Value("${ftp.serversub}")
    private String ftp_server_sub;

    @Value("${ftp.port}")
    private int ftp_port;

    @Value("${ftp.userid}")
    private String ftp_userid;

    @Value("${ftp.password}")
    private String ftp_password;

    @Value("${ftp.target}")
    private String ftp_target;

    @Value("${tts.temppath}")
    private String tts_temppath;


    public String SftpUp_Main(String fileFullPath) {
        SftpConnect(ftp_server_main, ftp_userid, ftp_password, ftp_port, ftp_target, fileFullPath);
        return tts_temppath;
    }

    public String SftpUp_Sub(String fileFullPath) {
        SftpConnect(ftp_server_sub, ftp_userid, ftp_password, ftp_port, ftp_target, fileFullPath);
        return tts_temppath;
    }


    public void SftpConnect(String sftpHost, String sftpUser, String sftpPass, int sftpPort, String sftpWorkingDir, String fileFullPath) {
        ChannelSftp chSftp = null;
        FileInputStream fs = null;

        Session ses = null;	// 접속계정
        Channel ch = null;	// 접속
        JSch jsch = new JSch();	// jsch 객체를 생성


        try {
            // 세션 객체를 생성(사용자 이름, 접속할 호스트, 포트)
            ses = jsch.getSession(sftpUser, sftpHost, sftpPort);
            // 비밀번호 설정
            ses.setPassword(sftpPass);

            // 세션과 관련된 정보를 설정
            Properties p = new Properties();
            // 호스트 정보를 검사하지 않음
            p.put("StrictHostKeyChecking", "no");
            ses.setConfig(p);

            // 접속
            ses.connect();

            // 채널을 오픈(sftp)
            ch = ses.openChannel("sftp");
            // 채널에 연결(sftp)
            ch.connect();

            // 채널을 FTP용 채널 객체로 개스팅
            chSftp = (ChannelSftp)ch;

            //String filePath = "D:/sftpFileSendTest.txt";
            File file= new File(tts_temppath+fileFullPath); // file 객체 생성 (파일 경로 입력)
            try {
                fs = new FileInputStream(file);
                chSftp.cd(sftpWorkingDir); // 서버의 경로
                chSftp.put(fs, file.getName()); // 서버에 파일 보내기
            } catch(SftpException e) {
                e.printStackTrace();
            } catch(FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    fs.close();
                    chSftp.quit();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("FTP 연결에 실패했습니다.");
        }
    }

}
