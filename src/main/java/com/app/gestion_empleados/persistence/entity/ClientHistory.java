package com.app.gestion_empleados.persistence.entity;

import jakarta.persistence.*;

import java.util.Date;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Table
@Entity(name = "client_history")
public class ClientHistory
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "action")
    private String action;

    @Column(name = "detail")
    private String detail;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "client_lastname")
    private String clientLastname;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    public ClientHistory()
    {
    }

    public ClientHistory(Long id, String action, String detail, Date date, String clientName, String clientLastname, ClientEntity client)
    {
        this.id = id;
        this.action = action;
        this.detail = detail;
        this.date = date;
        this.clientName = clientName;
        this.clientLastname = clientLastname;
        this.client = client;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getAction()
    {
        return action;
    }

    public void setAction(String action)
    {
        this.action = action;
    }

    public String getDetail()
    {
        return detail;
    }

    public void setDetail(String detail)
    {
        this.detail = detail;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public ClientEntity getClient()
    {
        return client;
    }

    public void setClient(ClientEntity client)
    {
        this.client = client;
    }

    public String getClientName()
    {
        return clientName;
    }

    public void setClientName(String clientName)
    {
        this.clientName = clientName;
    }

    public String getClientLastname()
    {
        return clientLastname;
    }

    public void setClientLastname(String clientLastname)
    {
        this.clientLastname = clientLastname;
    }
}
