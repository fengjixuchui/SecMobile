package com.wrlus.seciot.history.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.wrlus.seciot.history.model.AndroidHistoryDao;
import com.wrlus.seciot.history.model.AppleiOSHistoryDao;
import com.wrlus.seciot.history.model.HistoryDao;

@Repository
public interface HistoryMapper {
	@Select("select * from history;")
	public List<HistoryDao> getHistoryAll();
	@Select("select * from history where id = #{id};")
	public List<HistoryDao> getHistoryById(@Param("id") String id);
	@Select("select * from history where type = #{type};")
	public List<HistoryDao> getHistoryByType(@Param("type") String type);
	@Select("select * from history_android_static where id = #{id};")
	public List<AndroidHistoryDao> getAndroidHistoryById(@Param("id") String id);
	@Select("select * from history_ios_static where id = #{id};")
	public List<AppleiOSHistoryDao> getAppleiOSHistoryById(@Param("id") String id);
	@Insert("insert into history values (#{id}, #{name}, #{type}, #{target}, #{user}, #{date}, #{detailid});")
	public int addHistory(HistoryDao history);
	@Insert("insert into history_android_static values (#{id}, #{apkinfo}, #{apkpermission}, #{apkplatformrisk});")
	public int addAndroidHistory(AndroidHistoryDao androidHistory);
	@Insert("insert into history_ios_static values (#{id}, #{ipainfo}, #{ipapermission}, #{ipaplatformrisk});")
	public int addAppleiOSHistory(AppleiOSHistoryDao appleiOSHistory);
	@Update("update history set name = #{name} where id = #{id};")
	public int updateHistoryName(@Param("id") String id, @Param("name") String name);
	@Delete("delete from history where id = #{id};")
	public int deleteHistory(@Param("id") String id);
	@Delete("delete from history_fw_static where id = #{id};")
	public int deleteFwHistory(@Param("id") String id);
	@Delete("delete from history_android_static where id = #{id};")
	public int deleteAndroidHistory(@Param("id") String id);
	@Delete("delete from history_ios_static where id = #{id};")
	public int deleteAppleiOSHistory(@Param("id") String id);
}
