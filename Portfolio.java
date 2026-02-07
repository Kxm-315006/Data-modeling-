package com.example.demo.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "portfolio_id")
    private Long portfolioId;

    @Column(name = "portfolio_value")
    private Double portfolioValue;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "portfolio")
    private List<Security> securities;

    // Constructor
    public Portfolio(Double portfolioValue, LocalDate createdDate,
                     Client client, List<Security> securities) {
        this.portfolioValue = portfolioValue;
        this.createdDate = createdDate;
        this.client = client;
        this.securities = securities;
    }

    public Portfolio() {}

    // Getters
    public Long getPortfolioId() { return portfolioId; }
    public Double getPortfolioValue() { return portfolioValue; }
    public LocalDate getCreatedDate() { return createdDate; }
    public Client getClient() { return client; }
    public List<Security> getSecurities() { return securities; }

    // Setters
    public void setPortfolioValue(Double portfolioValue) { this.portfolioValue = portfolioValue; }
    public void setCreatedDate(LocalDate createdDate) { this.createdDate = createdDate; }
    public void setClient(Client client) { this.client = client; }
    public void setSecurities(List<Security> securities) { this.securities = securities; }
}