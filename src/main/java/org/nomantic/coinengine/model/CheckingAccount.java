package org.nomantic.coinengine.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CHECKING")
public class CheckingAccount extends Account {

    @Override
    public String getAccountType() {
        return "CheckingAccount";
    }
}
