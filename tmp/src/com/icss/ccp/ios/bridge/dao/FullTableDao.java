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
package com.icss.ccp.ios.bridge.dao;

import com.icss.ccp.ios.bridge.domain.*;
import com.icss.ccp.ios.core.mybatis.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FullTableDao {
    long queryTotal(@Param("sqlQueries") List<SqlQuery> sqlQueries);

    List<FullTable> queryAll(@Param("limit") Limit limit);

    List<FullTable> query(@Param("sqlQueries") List<SqlQuery> sqlQueries, @Param("limit") Limit limit);

    FullTable querySingle(@Param("sqlQueries") List<SqlQuery> sqlQueries);

    FullTable queryById(long uuid);

    int insertFullTable(FullTable FullTable);

    int updateFullTable(@Param("uuid") long uuid, @Param("sqlUpdates") List<SqlUpdate> sqlUpdates);

    int deleteFullTable(long uuid);
}
