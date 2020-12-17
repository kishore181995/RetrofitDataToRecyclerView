
package com.example.myapplication.models;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example implements Serializable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("valid_from")
    @Expose
    private String validFrom;
    @SerializedName("valid_until")
    @Expose
    private String validUntil;
    @SerializedName("is_active")
    @Expose
    private Boolean isActive;
    @SerializedName("is_deleted")
    @Expose
    private Boolean isDeleted;
    @SerializedName("tags")
    @Expose
    private Tags tags;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("last_updated_at")
    @Expose
    private String lastUpdatedAt;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("bonus_image_front")
    @Expose
    private String bonusImageFront;
    @SerializedName("bonus_image_back")
    @Expose
    private String bonusImageBack;
    @SerializedName("user_redeem_limit")
    @Expose
    private Integer userRedeemLimit;
    @SerializedName("user_limit")
    @Expose
    private Integer userLimit;
    @SerializedName("tab_type")
    @Expose
    private String tabType;
    @SerializedName("ribbon_msg")
    @Expose
    private String ribbonMsg;
    @SerializedName("is_bonus_booster_enabled")
    @Expose
    private Boolean isBonusBoosterEnabled;
    @SerializedName("wager_bonus_expiry")
    @Expose
    private Integer wagerBonusExpiry;
    @SerializedName("wager_to_release_ratio_numerator")
    @Expose
    private Integer wagerToReleaseRatioNumerator;
    @SerializedName("wager_to_release_ratio_denominator")
    @Expose
    private Integer wagerToReleaseRatioDenominator;
    @SerializedName("slabs")
    @Expose
    private List<Slab> slabs = null;
    @SerializedName("user_segmentation_type")
    @Expose
    private String userSegmentationType;
    @SerializedName("eligibility_user_levels")
    @Expose
    private List<Integer> eligibilityUserLevels = null;
    @SerializedName("eligibility_user_segments")
    @Expose
    private List<String> eligibilityUserSegments = null;
    @SerializedName("visibility_user_levels")
    @Expose
    private List<Integer> visibilityUserLevels = null;
    @SerializedName("visibility_user_segments")
    @Expose
    private List<String> visibilityUserSegments = null;
    @SerializedName("days_since_last_purchase_min")
    @Expose
    private Integer daysSinceLastPurchaseMin;
    @SerializedName("_cls")
    @Expose
    private String cls;
    @SerializedName("campaign")
    @Expose
    private String campaign;
    @SerializedName("bonus_booster")
    @Expose
    private Object bonusBooster;

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    private boolean isOpen=false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public String getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(String lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBonusImageFront() {
        return bonusImageFront;
    }

    public void setBonusImageFront(String bonusImageFront) {
        this.bonusImageFront = bonusImageFront;
    }

    public String getBonusImageBack() {
        return bonusImageBack;
    }

    public void setBonusImageBack(String bonusImageBack) {
        this.bonusImageBack = bonusImageBack;
    }

    public Integer getUserRedeemLimit() {
        return userRedeemLimit;
    }

    public void setUserRedeemLimit(Integer userRedeemLimit) {
        this.userRedeemLimit = userRedeemLimit;
    }

    public Integer getUserLimit() {
        return userLimit;
    }

    public void setUserLimit(Integer userLimit) {
        this.userLimit = userLimit;
    }

    public String getTabType() {
        return tabType;
    }

    public void setTabType(String tabType) {
        this.tabType = tabType;
    }

    public String getRibbonMsg() {
        return ribbonMsg;
    }

    public void setRibbonMsg(String ribbonMsg) {
        this.ribbonMsg = ribbonMsg;
    }

    public Boolean getIsBonusBoosterEnabled() {
        return isBonusBoosterEnabled;
    }

    public void setIsBonusBoosterEnabled(Boolean isBonusBoosterEnabled) {
        this.isBonusBoosterEnabled = isBonusBoosterEnabled;
    }

    public Integer getWagerBonusExpiry() {
        return wagerBonusExpiry;
    }

    public void setWagerBonusExpiry(Integer wagerBonusExpiry) {
        this.wagerBonusExpiry = wagerBonusExpiry;
    }

    public Integer getWagerToReleaseRatioNumerator() {
        return wagerToReleaseRatioNumerator;
    }

    public void setWagerToReleaseRatioNumerator(Integer wagerToReleaseRatioNumerator) {
        this.wagerToReleaseRatioNumerator = wagerToReleaseRatioNumerator;
    }

    public Integer getWagerToReleaseRatioDenominator() {
        return wagerToReleaseRatioDenominator;
    }

    public void setWagerToReleaseRatioDenominator(Integer wagerToReleaseRatioDenominator) {
        this.wagerToReleaseRatioDenominator = wagerToReleaseRatioDenominator;
    }

    public List<Slab> getSlabs() {
        return slabs;
    }

    public void setSlabs(List<Slab> slabs) {
        this.slabs = slabs;
    }

    public String getUserSegmentationType() {
        return userSegmentationType;
    }

    public void setUserSegmentationType(String userSegmentationType) {
        this.userSegmentationType = userSegmentationType;
    }

    public List<Integer> getEligibilityUserLevels() {
        return eligibilityUserLevels;
    }

    public void setEligibilityUserLevels(List<Integer> eligibilityUserLevels) {
        this.eligibilityUserLevels = eligibilityUserLevels;
    }

    public List<String> getEligibilityUserSegments() {
        return eligibilityUserSegments;
    }

    public void setEligibilityUserSegments(List<String> eligibilityUserSegments) {
        this.eligibilityUserSegments = eligibilityUserSegments;
    }

    public List<Integer> getVisibilityUserLevels() {
        return visibilityUserLevels;
    }

    public void setVisibilityUserLevels(List<Integer> visibilityUserLevels) {
        this.visibilityUserLevels = visibilityUserLevels;
    }

    public List<String> getVisibilityUserSegments() {
        return visibilityUserSegments;
    }

    public void setVisibilityUserSegments(List<String> visibilityUserSegments) {
        this.visibilityUserSegments = visibilityUserSegments;
    }

    public Integer getDaysSinceLastPurchaseMin() {
        return daysSinceLastPurchaseMin;
    }

    public void setDaysSinceLastPurchaseMin(Integer daysSinceLastPurchaseMin) {
        this.daysSinceLastPurchaseMin = daysSinceLastPurchaseMin;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public Object getBonusBooster() {
        return bonusBooster;
    }

    public void setBonusBooster(Object bonusBooster) {
        this.bonusBooster = bonusBooster;
    }

}
