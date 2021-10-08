package com.tomy.rest.service.logic;

import com.tomy.rest.entity.User;
import com.tomy.rest.service.UserService;
import com.tomy.rest.store.UserStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceLogic implements UserService {

    //1. Autowired
    @Autowired
    private UserStore userStore;

    //2. Autowired 안해도 되는 방식(직접 생성자 작성을 통해 UserStore 주입)
//    public UserServiceLogic(UserStore userStore){
//        this.userStore = userStore;
//    }
    
    //3. Lombok의 @RequiredArgsConstructor(생성자 자동생성 어노테이션과 final 선언을 통해 UserStore 주입)
    //private final UserStore userStore; //final은 반드시 초기화가 이루어져야 하므로, 해당 방식으로도 가져올 수 있음

    @Override
    public String register(User newUser) {
        return this.userStore.create(newUser);
    }

    @Override
    public void modify(User newUser) {
        this.userStore.update(newUser);
    }

    @Override
    public void remove(String id) {
        this.userStore.delete(id);
    }

    @Override
    public User find(String id) {
        return this.userStore.retrieve(id);
    }

    @Override
    public List<User> findAll() {
        return this.userStore.retrieveAll();
    }
}
