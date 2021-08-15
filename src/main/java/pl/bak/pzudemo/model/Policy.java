package pl.bak.pzudemo.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "Policy")
@Table(
        name = "policy"
)
public class Policy {
    @Id
    @SequenceGenerator(
            name = "policy_sequence",
            sequenceName = "policy_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "policy_type",
            nullable = false
    )
    private String policyType;

    @Column(
            name = "sum_insured",
            nullable = false
    )
    private BigDecimal sumInsured;

    @Column(
            name = "insured_person_name",
            nullable = false
    )
    private String insuredPersonName;

    @Column(
            name = "insured_person_last_name",
            nullable = false
    )
    private String insuredPersonLastName;

    @Column(
            name = "item_insured"
    )
    private String itemInsured;

    public Policy() {
    }

    public Policy(Long id, String policyType, BigDecimal sumInsured, String insuredPersonName, String insuredPersonLastName, String itemInsured) {
        this.id = id;
        this.policyType = policyType;
        this.sumInsured = sumInsured;
        this.insuredPersonName = insuredPersonName;
        this.insuredPersonLastName = insuredPersonLastName;
        this.itemInsured = itemInsured;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public BigDecimal getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(BigDecimal sumInsured) {
        this.sumInsured = sumInsured;
    }

    public String getInsuredPersonName() {
        return insuredPersonName;
    }

    public void setInsuredPersonName(String insuredPersonName) {
        this.insuredPersonName = insuredPersonName;
    }

    public String getInsuredPersonLastName() {
        return insuredPersonLastName;
    }

    public void setInsuredPersonLastName(String insuredPersonLastName) {
        this.insuredPersonLastName = insuredPersonLastName;
    }

    public String getItemInsured() {
        return itemInsured;
    }

    public void setItemInsured(String itemInsured) {
        this.itemInsured = itemInsured;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "id=" + id +
                ", policyType='" + policyType + '\'' +
                ", sumInsured=" + sumInsured +
                ", insuredPersonName='" + insuredPersonName + '\'' +
                ", insuredPersonLastName='" + insuredPersonLastName + '\'' +
                ", itemInsured='" + itemInsured + '\'' +
                '}';
    }
}
