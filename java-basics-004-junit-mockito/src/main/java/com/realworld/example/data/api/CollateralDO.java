package com.realworld.example.data.api;

import java.util.List;
import com.realworld.example.model.api.Collateral;

/**
 * Data Object for the Client entity.
 */
public interface CollateralDO {

    /**
     * Retrieve collaterals for the client.
     * 
     * @param clientId client id.
     */
    List<Collateral> getAllCollaterals(long clientId);
}
