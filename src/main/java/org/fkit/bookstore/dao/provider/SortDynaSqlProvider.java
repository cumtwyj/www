package org.fkit.bookstore.dao.provider;

import static org.fkit.bookstore.util.common.BookstoreConstants.SORTTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.fkit.bookstore.domain.Sort;
import org.fkit.bookstore.domain.User;

public class SortDynaSqlProvider {
	//分页动态查询
	public String selectWhitParam(Map<String,Object> params){
		String sql = new SQL(){
			{
				SELECT("*");
				FROM(SORTTABLE);
				if(params.get("sort") != null){
					Sort sort =(Sort) params.get("sort");
					if(sort.getSortname() != null && !sort.getSortname().equals("")){
						WHERE("sortname LIKE CONCAT ('%',#{sort.sortname},'%')");
					}
				}
			}
		}.toString();
		if(params.get("pageModel") != null){
			sql += "limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}";
		}
		return sql;
	}
	//动态查询总数量
	public String count (Map<String,Object> params){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(SORTTABLE);
				if (params.get("sort") != null){
					Sort sort =(Sort)params.get("sort");
					if(sort.getSortname() != null && !sort.getSortname().equals("")){
						WHERE("sortname LIKE CONCAT ('%',#{sort.sortname},'%')");
					}
				}
			}
		}.toString();
	}
	//动态插入
	public String insertSort(Sort sort){
		return new SQL(){
			{
				INSERT_INTO(SORTTABLE);
				if(sort.getSortname() != null && !sort.getSortname().equals("")){
					VALUES("sortname", "#{sortname}");
				}
			}
		}.toString();
	}
	//动态更新
	public String updateSort(Sort sort){
		return new SQL(){
			{
				UPDATE(SORTTABLE);
				if(sort.getSortname() != null){
					SET(" sortname = #{sortname} ");
				}
				WHERE("sortID=#{sortID}");
			}
		}.toString();
	}
}
