package ru.pirateway.sb.entity;

import org.jetbrains.annotations.Nullable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "app_fork")
public class Fork extends AbstractEntity {

    public Fork() {
    }

    public Fork(
            @Nullable final String name,
            @Nullable final String description,
            @Nullable final String type,
            @Nullable final String age,
            @Nullable final String profit
    ) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.age = age;
        this.profit = profit;
    }

    @Nullable
    private String type;

    @Nullable
    private String age;

    @Nullable
    private String profit;

    @Nullable
    private String eventOneBk;

    @Nullable
    private String eventTwoBk;

    @Nullable
    private String eventOneDescription;

    @Nullable
    private String eventTwoDescription;

    @Nullable
    private String eventOneCoefficient;

    @Nullable
    private String eventTwoCoefficient;

    @Nullable
    private String eventOneLink;

    @Nullable
    private String eventTwoLink;

    @Nullable
    private String eventOneTextLink;

    @Nullable
    private String eventTwoTextLink;

    @Nullable
    public String getType() {
        return type;
    }

    public void setType(@Nullable String type) {
        this.type = type;
    }

    @Nullable
    public String getAge() {
        return age;
    }

    public void setAge(@Nullable String age) {
        this.age = age;
    }

    @Nullable
    public String getProfit() {
        return profit;
    }

    public void setProfit(@Nullable String profit) {
        this.profit = profit;
    }

    @Nullable
    public String getEventOneBk() {
        return eventOneBk;
    }

    public void setEventOneBk(@Nullable String eventOneBk) {
        this.eventOneBk = eventOneBk;
    }

    @Nullable
    public String getEventTwoBk() {
        return eventTwoBk;
    }

    public void setEventTwoBk(@Nullable String eventTwoBk) {
        this.eventTwoBk = eventTwoBk;
    }

    @Nullable
    public String getEventOneDescription() {
        return eventOneDescription;
    }

    public void setEventOneDescription(@Nullable String eventOneDescription) {
        this.eventOneDescription = eventOneDescription;
    }

    @Nullable
    public String getEventTwoDescription() {
        return eventTwoDescription;
    }

    public void setEventTwoDescription(@Nullable String eventTwoDescription) {
        this.eventTwoDescription = eventTwoDescription;
    }

    @Nullable
    public String getEventOneCoefficient() {
        return eventOneCoefficient;
    }

    public void setEventOneCoefficient(@Nullable String eventOneCoefficient) {
        this.eventOneCoefficient = eventOneCoefficient;
    }

    @Nullable
    public String getEventTwoCoefficient() {
        return eventTwoCoefficient;
    }

    public void setEventTwoCoefficient(@Nullable String eventTwoCoefficient) {
        this.eventTwoCoefficient = eventTwoCoefficient;
    }

    @Nullable
    public String getEventOneLink() {
        return eventOneLink;
    }

    public void setEventOneLink(@Nullable String eventOneLink) {
        this.eventOneLink = eventOneLink;
    }

    @Nullable
    public String getEventTwoLink() {
        return eventTwoLink;
    }

    public void setEventTwoLink(@Nullable String eventTwoLink) {
        this.eventTwoLink = eventTwoLink;
    }

    @Nullable
    public String getEventOneTextLink() {
        return eventOneTextLink;
    }

    public void setEventOneTextLink(@Nullable String eventOneTextLink) {
        this.eventOneTextLink = eventOneTextLink;
    }

    @Nullable
    public String getEventTwoTextLink() {
        return eventTwoTextLink;
    }

    public void setEventTwoTextLink(@Nullable String eventTwoTextLink) {
        this.eventTwoTextLink = eventTwoTextLink;
    }

    @Override
    public String toString() {
        return "Fork{" +
                "type='" + type + '\'' +
                ", age='" + age + '\'' +
                ", profit='" + profit + '\'' +
                ", eventOneBk='" + eventOneBk + '\'' +
                ", eventTwoBk='" + eventTwoBk + '\'' +
                ", eventOneDescription='" + eventOneDescription + '\'' +
                ", eventTwoDescription='" + eventTwoDescription + '\'' +
                ", eventOneCoefficient='" + eventOneCoefficient + '\'' +
                ", eventTwoCoefficient='" + eventTwoCoefficient + '\'' +
                ", eventOneLink='" + eventOneLink + '\'' +
                ", eventTwoLink='" + eventTwoLink + '\'' +
                ", eventOneTextLink='" + eventOneTextLink + '\'' +
                ", eventTwoTextLink='" + eventTwoTextLink + '\'' +
                '}';
    }

}
