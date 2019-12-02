package com.example.credit.entity;

import com.example.credit.beans.CreditForm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "credits")
@NoArgsConstructor
@Getter
@Setter
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    @Column(name = "credit_id")
    private UUID creditID;

    public static Credit createCredit(final CreditForm creditForm, final UUID creditID) {
        final Credit credit = new Credit();
        credit.setName(creditForm.getCreditName());
        credit.setCreditID(creditID);
        return credit;
    }
}

