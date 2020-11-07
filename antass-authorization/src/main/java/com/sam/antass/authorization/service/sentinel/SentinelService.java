package com.sam.antass.authorization.service.sentinel;


import java.sql.SQLException;

public interface SentinelService {

    String getUserAuths(String id) throws SQLException;

}
