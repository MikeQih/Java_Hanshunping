package com.hspedu.dao_.test;

import java.util.List;
import org.junit.Test;

import com.hspedu.dao_.dao.ActorDAO;
import com.hspedu.dao_.domain.Actor;


public class TestDAO_ {
    @Test //下面没有小箭头的话，换个名字就有了
    //测试ActorDAO 对actor表的crud操作
    public void testActorDAO(){
        ActorDAO actorDAO = new ActorDAO();
        //1.查询
        List<Actor> actors = actorDAO.queryMulti("select * from actor where id >= ?", Actor.class, 1);
        System.out.println("===查询结果===");
        for(Actor actor: actors){
            System.out.println(actor);
        }

        //2.查询单行记录
        Actor actor = actorDAO.querySingle("select * from actor where id = ?", Actor.class, 2);
        System.out.println("===查询单行结果===");
        System.out.println(actor);

        //3.查询单行单列
        Object o = actorDAO.queryScalar("select name from actor where id = ?", 2);
        System.out.println("===查询单行单列值===");
        System.out.println(o);

        //4.dml操作 insert,update,delete
        int update = actorDAO.update("insert into actor values(null,?,?,?,?)", "david","男","2003-03-04","123");
        System.out.println(update>0 ? "执行成功":"执行没有影响到表");
        

    }

}
