package com.vdc.ims.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class Authentication {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String userId;
    private String passwd;
    private String url = "LDAP://122.199.153.3";


    public boolean Logon(String Id, String password, String domain){
        boolean flag;
        this.userId = Id;
        this.passwd = password;

        try {
            Hashtable env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, url);
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
            env.put(Context.SECURITY_PRINCIPAL, domain + "\\" +userId);
            //env.put(Context.SECURITY_PRINCIPAL, "cn="+userId+",dc=ubware,dc=com");
            env.put(Context.SECURITY_CREDENTIALS, passwd);

            LdapContext ctx = new InitialLdapContext(env, null);

            if(ctx == null)	{
                flag = false;
            }
            else
            {
                flag = true;
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            flag = false;
        }

        return flag;
    }
}