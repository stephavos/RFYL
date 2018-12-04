package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;

/**
 * @author Sutibun
 *
 */
public abstract class AbstractDAO {

    /**
     * @param query
     * @return
     */
    protected static ResultSet executeQuery(final String query) {
        return LorannBDDConnector.getInstance().executeQuery(query);
    }


    /**
     * @param query
     * @return
     */
    protected static int executeUpdate(final String query) {
        return LorannBDDConnector.getInstance().executeUpdate(query);
    }

    /**
     * @param query
     * @return
     */
    protected static CallableStatement prepareCall(final String query) {
        return LorannBDDConnector.getInstance().prepareCall(query);
    }
}