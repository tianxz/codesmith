/***********************************************************************************
 *  __/\\\\\\\\\\\________/\\\\\\\\\_____/\\\\\\\\\\\_______/\\\\\\\\\\\___        *
 *   _\/////\\\///______/\\\////////____/\\\/////////\\\___/\\\/////////\\\_       *
 *    _____\/\\\_______/\\\/____________\//\\\______\///___\//\\\______\///__      *
 *     _____\/\\\______/\\\_______________\////\\\___________\////\\\_________     *
 *      _____\/\\\_____\/\\\__________________\////\\\___________\////\\\______    *
 *       _____\/\\\_____\//\\\____________________\////\\\___________\////\\\___   *
 *        _____\/\\\______\///\\\___________/\\\______\//\\\___/\\\______\//\\\__  *
 *         __/\\\\\\\\\\\____\////\\\\\\\\\_\///\\\\\\\\\\\/___\///\\\\\\\\\\\/___ *
 ***********************************************************************************
 *  此代码自动生成，请不要在此文件上做任何修改。如需扩展，请使用组合或继承方式实现。
 *  此代码自动生成，请不要在此文件上做任何修改。如需扩展，请使用组合或继承方式实现。
 *  此代码自动生成，请不要在此文件上做任何修改。如需扩展，请使用组合或继承方式实现。
 ***********************************************************************************/
package com.icss.ccp.ios.bridge.domain;

import jodd.datetime.JDateTime;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 
 * Created by vinci on 2017-10-27 07:22:40.
 */
public class True {
    
    private String tableCatalog;

    
    private String tableSchema;

    
    private String tableName;

    
    private String tableType;

    
    private String engine;

    
    private long version;

    
    private String rowFormat;

    
    private long tableRows;

    
    private long avgRowLength;

    
    private long dataLength;

    
    private long maxDataLength;

    
    private long indexLength;

    
    private long dataFree;

    
    private long autoIncrement;

    
    @JsonDeserialize(using = JDateTimeDeserializer.class)
    @JsonSerialize(using = JDateTimeSerializer.class)
    private JDateTime createTime;

    
    @JsonDeserialize(using = JDateTimeDeserializer.class)
    @JsonSerialize(using = JDateTimeSerializer.class)
    private JDateTime updateTime;

    
    @JsonDeserialize(using = JDateTimeDeserializer.class)
    @JsonSerialize(using = JDateTimeSerializer.class)
    private JDateTime checkTime;

    
    private String tableCollation;

    
    private long checksum;

    
    private String createOptions;

    
    private String tableComment;

    public String getTableCatalog() {
        return tableCatalog;
    }

    public True setTableCatalog(String tableCatalog) {
        this.tableCatalog = tableCatalog;
        return this;
    }

    public String getTableSchema() {
        return tableSchema;
    }

    public True setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
        return this;
    }

    public String getTableName() {
        return tableName;
    }

    public True setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public String getTableType() {
        return tableType;
    }

    public True setTableType(String tableType) {
        this.tableType = tableType;
        return this;
    }

    public String getEngine() {
        return engine;
    }

    public True setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public long getVersion() {
        return version;
    }

    public True setVersion(long version) {
        this.version = version;
        return this;
    }

    public String getRowFormat() {
        return rowFormat;
    }

    public True setRowFormat(String rowFormat) {
        this.rowFormat = rowFormat;
        return this;
    }

    public long getTableRows() {
        return tableRows;
    }

    public True setTableRows(long tableRows) {
        this.tableRows = tableRows;
        return this;
    }

    public long getAvgRowLength() {
        return avgRowLength;
    }

    public True setAvgRowLength(long avgRowLength) {
        this.avgRowLength = avgRowLength;
        return this;
    }

    public long getDataLength() {
        return dataLength;
    }

    public True setDataLength(long dataLength) {
        this.dataLength = dataLength;
        return this;
    }

    public long getMaxDataLength() {
        return maxDataLength;
    }

    public True setMaxDataLength(long maxDataLength) {
        this.maxDataLength = maxDataLength;
        return this;
    }

    public long getIndexLength() {
        return indexLength;
    }

    public True setIndexLength(long indexLength) {
        this.indexLength = indexLength;
        return this;
    }

    public long getDataFree() {
        return dataFree;
    }

    public True setDataFree(long dataFree) {
        this.dataFree = dataFree;
        return this;
    }

    public long getAutoIncrement() {
        return autoIncrement;
    }

    public True setAutoIncrement(long autoIncrement) {
        this.autoIncrement = autoIncrement;
        return this;
    }

    public JDateTime getCreateTime() {
        return createTime;
    }

    public True setCreateTime(JDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public JDateTime getUpdateTime() {
        return updateTime;
    }

    public True setUpdateTime(JDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public JDateTime getCheckTime() {
        return checkTime;
    }

    public True setCheckTime(JDateTime checkTime) {
        this.checkTime = checkTime;
        return this;
    }

    public String getTableCollation() {
        return tableCollation;
    }

    public True setTableCollation(String tableCollation) {
        this.tableCollation = tableCollation;
        return this;
    }

    public long getChecksum() {
        return checksum;
    }

    public True setChecksum(long checksum) {
        this.checksum = checksum;
        return this;
    }

    public String getCreateOptions() {
        return createOptions;
    }

    public True setCreateOptions(String createOptions) {
        this.createOptions = createOptions;
        return this;
    }

    public String getTableComment() {
        return tableComment;
    }

    public True setTableComment(String tableComment) {
        this.tableComment = tableComment;
        return this;
    }

}