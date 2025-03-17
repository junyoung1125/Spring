package kr.co.ch07.repository;

import kr.co.ch07.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User1Repository extends JpaRepository<User1, String> {

    //쿼리 메서드 실습
    public User1 findUser1ByUid(String uid);
    public List<User1> findUser1ByName(String name);
    public List<User1> findUser1ByNameNot(String name);

    public User1 findUser1ByUidAndName(String uid, String name);
    public List<User1> findUser1ByUidOrName(String uid, String name);

    public List<User1> findUser1ByAgeGreaterThan(int age);
    public List<User1> findUser1ByAgeGreaterThanEqual(int age);
    public List<User1> findUser1ByAgeLessThan(int age);
    public List<User1> findUser1ByAgeLessThanEqual(int age);
    public List<User1> findUser1ByAgeBetween(int low, int high);

    public List<User1> findUser1ByNameLike(String name);
    public List<User1> findUser1ByNameContains(String name);
    public List<User1> findUser1ByNameStartsWith(String name);
    public List<User1> findUser1ByNameEndsWith(String name);

    public List<User1> findUser1ByOrderByName();
    public List<User1> findUser1ByNameOrderByUid(String name);
    public List<User1> findUser1ByOrderByAgeAsc();
    public List<User1> findUser1ByOrderByAgeDesc();
    public List<User1> findUser1ByAgeGreaterThanOrderByAgeDesc(int age);

    public int countUser1ByName(String name);

    // JPQL
    @Query("select u1 from User1  as u1 where u1.age <= 30")
    public List<User1> selectUser1UnderAge30();

    @Query("select u1 from User1 as u1 where u1.name =?1")
    public List<User1> selectUser1ByName(String name);

    @Query("select u1 from User1 as u1 where u1.name =:name")
    public List<User1> selectUser1ByNameParam(@Param("name") String name);

    @Query("select u1.uid, u1.name, u1.age from User1 as u1 where u1.uid =:uid")
    public List<Object[]> selectUser1ByUid(@Param("uid")String uid);


    @Query("select p, c from Parent as p join Child as c on p.pid=c.parent" +
            " where p.pid=:pid")
    public List<Object[]>selectParentWithChild(@Param("pid") String pid);


}
