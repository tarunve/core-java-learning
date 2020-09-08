package com.realworld.example.data.api;

import com.realworld.example.model.api.Client;

/**
 * Data Object for the Client entity.
 */
public interface ClientDO {

    /**
     * Retrieves details of the client.
     * 
     * @param clientId the client id to search for.
     */
    Client getClientDetails(long clientId);

	void saveClient(Client client);
}
