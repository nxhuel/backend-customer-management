package com.app.gestion_empleados.dto;

import com.app.gestion_empleados.persistence.entity.ClientEntity;

public class ClientRequest
{
    private ClientEntity client;
    private String detail;

    public ClientRequest()
    {
    }

    public ClientRequest(ClientEntity client, String detail)
    {
        this.client = client;
        this.detail = detail;
    }

    public ClientEntity getClient()
    {
        return client;
    }

    public void setClient(ClientEntity client)
    {
        this.client = client;
    }

    public String getDetail()
    {
        return detail;
    }

    public void setDetail(String detail)
    {
        this.detail = detail;
    }
}
