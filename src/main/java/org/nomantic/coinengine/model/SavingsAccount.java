package org.nomantic.coinengine.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SAVINGS")
public class SavingsAccount extends Account {

    @Override
    public String getAccountType(){
        return "SavingsAccount";
    }
}
