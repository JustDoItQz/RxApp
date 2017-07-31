package org.gisoper.com.vo;

import java.io.Serializable;
import java.util.Date;

public class BasLocation implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * bas_location.location_id (地区主键)
     * @ibatorgenerated 2015-10-31 14:52:31
     */
    private String locationId;

    /**
     * bas_location.location_name (区域名称)
     * @ibatorgenerated 2015-10-31 14:52:31
     */
    private String locationName;

    /**
     * bas_location.location_fullname (区域全称)
     * @ibatorgenerated 2015-10-31 14:52:31
     */
    private String locationFullname;

    /**
     * bas_location.location_code (区域编码/省简称)
     * @ibatorgenerated 2015-10-31 14:52:31
     */
    private String locationCode;

    /**
     *  区域级别
     * @param
     * @return
     */
    private String locationLevel ;

    /**
     *  城市编码
     * @param
     * @return
     */
    private String locationCityCode ;

    /**
     *  区域经纬度
     * @param
     * @return
     */
    private String locationCenter ;
    /**
     *  区域全称
     * @param
     * @return
     */

    private String locationFullnameSpell ;

    /**
     * bas_location.short_spell (拼写简称)
     * @ibatorgenerated 2015-10-31 14:52:31
     */
    private String shortSpell;

    /**
     * bas_location.full_spell (拼写全称)
     * @ibatorgenerated 2015-10-31 14:52:31
     */
    private String fullSpell;

    /**
     * bas_location.creater_id (创建人)
     * @ibatorgenerated 2015-10-31 14:52:31
     */
    private String createrId;

    /**
     * bas_location.create_time (创建时间)
     * @ibatorgenerated 2015-10-31 14:52:31
     */
    private Date createTime;

    /**
     * bas_location.updater_id (修改人)
     * @ibatorgenerated 2015-10-31 14:52:31
     */
    private String updaterId;

    /**
     * bas_location.update_time (修改时间)
     * @ibatorgenerated 2015-10-31 14:52:31
     */
    private Date updateTime;

    /**
     * bas_location.delete_flg (删除标示，0：未删除；1：已删除)
     * @ibatorgenerated 2015-10-31 14:52:31
     */
    private String deleteFlg;

    /**
     * bas_location.latest_time (最后更新时间)
     * @ibatorgenerated 2015-10-31 14:52:31
     */
    private Date latestTime;

    /**
     *  创建时间
     * @param
     * @return
     */
    private String createTimeStr ;
    /**
     *  更新时间
     * @param
     * @return
     */
    private String updateTimeStr ;
    /**
     *  地址父主键
     * @param
     * @return
     */

    private String parentLocationId ;

    public String getLocationLevel() {
        return locationLevel;
    }

    public void setLocationLevel(String locationLevel) {
        this.locationLevel = locationLevel;
    }

    public String getLocationCityCode() {
        return locationCityCode;
    }

    public void setLocationCityCode(String locationCityCode) {
        this.locationCityCode = locationCityCode;
    }

    public String getLocationCenter() {
        return locationCenter;
    }

    public void setLocationCenter(String locationCenter) {
        this.locationCenter = locationCenter;
    }

    public String getLocationFullnameSpell() {
        return locationFullnameSpell;
    }

    public void setLocationFullnameSpell(String locationFullnameSpell) {
        this.locationFullnameSpell = locationFullnameSpell;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public String getUpdateTimeStr() {
        return updateTimeStr;
    }

    public void setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
    }

    public String getParentLocationId() {
        return parentLocationId;
    }

    public void setParentLocationId(String parentLocationId) {
        this.parentLocationId = parentLocationId;
    }

    public String getParentLocationFullId() {
        return parentLocationFullId;
    }

    public void setParentLocationFullId(String parentLocationFullId) {
        this.parentLocationFullId = parentLocationFullId;
    }

    /**
     * 地址所有父主键
     * @param
     * @return
     */

    private String parentLocationFullId ;

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationFullname() {
        return locationFullname;
    }

    public void setLocationFullname(String locationFullname) {
        this.locationFullname = locationFullname;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getShortSpell() {
        return shortSpell;
    }

    public void setShortSpell(String shortSpell) {
        this.shortSpell = shortSpell;
    }

    public String getFullSpell() {
        return fullSpell;
    }

    public void setFullSpell(String fullSpell) {
        this.fullSpell = fullSpell;
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(String updaterId) {
        this.updaterId = updaterId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDeleteFlg() {
        return deleteFlg;
    }

    public void setDeleteFlg(String deleteFlg) {
        this.deleteFlg = deleteFlg;
    }

    public Date getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(Date latestTime) {
        this.latestTime = latestTime;
    }
}