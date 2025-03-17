package kr.co.ch07.repository;

import kr.co.ch07.entity.Child;
import kr.co.ch07.entity.Parent;
import kr.co.ch07.entity.User1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class User1RepositoryTest {

    @Autowired
    private User1Repository user1Repository;

    @Test
    void findUser1ByUid() {
        //given
        String uid = "test";

        //when
       User1 user1= user1Repository.findUser1ByUid(uid);

        //then
        System.out.println(user1);
    }

    @Test
    void findUser1ByName() {

       List<User1> user1List= user1Repository.findUser1ByName("테스트");
        System.out.println(user1List);
    }

    @Test
    void findUser1ByNameNot() {
        List<User1> user1List= user1Repository.findUser1ByNameNot("테스트");
        System.out.println(user1List);
    }

    @Test
    void findUser1ByUidAndName() {
        User1 user1= user1Repository.findUser1ByUidAndName("admin", "홍길동");
        System.out.println(user1);
    }

    @Test
    void findUser1ByUidOrName() {
        List<User1> user1List= user1Repository.findUser1ByUidOrName("admin","홍길동");
        System.out.println(user1List);
    }

    @Test
    void findUser1ByAgeGreaterThan() {
        List<User1> user1List= user1Repository.findUser1ByAgeGreaterThan(21);
        System.out.println(user1List);
    }

    @Test
    void findUser1ByAgeGreaterThanEqual() {
        List<User1> user1List= user1Repository.findUser1ByAgeGreaterThanEqual(21);
        System.out.println(user1List);
    }

    @Test
    void findUser1ByAgeLessThan() {
        List<User1> user1List= user1Repository.findUser1ByAgeLessThan(21);
        System.out.println(user1List);
    }

    @Test
    void findUser1ByAgeLessThanEqual() {
        List<User1> user1List= user1Repository.findUser1ByAgeLessThanEqual(21);
        System.out.println(user1List);
    }

    @Test
    void findUser1ByAgeBetween() {
        List<User1> user1List= user1Repository.findUser1ByAgeBetween(21,22);
        System.out.println(user1List);
    }

    @Test
    void findUser1ByNameLike() {
        List<User1> user1List= user1Repository.findUser1ByNameLike("admin");
        System.out.println(user1List);
    }

    @Test
    void findUser1ByNameContains() {
        List<User1> user1List= user1Repository.findUser1ByNameContains("admin");
        System.out.println(user1List);
    }

    @Test
    void findUser1ByNameStartsWith() {
        List<User1> user1List= user1Repository.findUser1ByNameStartsWith("admin");
        System.out.println(user1List);
    }

    @Test
    void findUser1ByNameEndsWith() {
        List<User1> user1List= user1Repository.findUser1ByNameEndsWith("admin");
        System.out.println(user1List);
    }

    @Test
    void findUser1ByOrderByName() {
        List<User1> user1List= user1Repository.findUser1ByOrderByName();
        System.out.println(user1List);
    }

    @Test
    void findUser1ByNameOrderByUid() {
        List<User1> user1List= user1Repository.findUser1ByNameOrderByUid("admin");
        System.out.println(user1List);
    }

    @Test
    void findUser1ByOrderByAgeAsc() {
        List<User1> user1List= user1Repository.findUser1ByOrderByAgeAsc();
        System.out.println(user1List);
    }

    @Test
    void findUser1ByOrderByAgeDesc() {
        List<User1> user1List= user1Repository.findUser1ByOrderByAgeDesc();
        System.out.println(user1List);
    }

    @Test
    void findUser1ByAgeGreaterThanOrderByAgeDesc() {
        List<User1> user1List= user1Repository.findUser1ByAgeGreaterThanOrderByAgeDesc(21);
        System.out.println(user1List);
    }

    @Test
    void countUser1ByName() {
        long count = user1Repository.countUser1ByName("admin");
        System.out.println(count);
    }

    @Test
    void selectUser1UnderAge30() {

    }

    @Test
    void selectUser1ByName() {
    }

    @Test
    void selectUser1ByNameParam() {
    }

    @Test
    void selectUser1ByUid() {
    }

    @Test
    void selectParentWithChild() {

        //given
        String pid= "p101";


        List<Object[]> list= user1Repository.selectParentWithChild(pid);

        //then
        for(Object[] arr :list){

           Parent parent=(Parent)arr[0];
           Child child=(Child) arr[1];

           System.out.println(parent);
           System.out.println(child);
        }

        System.out.println(list);

    }
}