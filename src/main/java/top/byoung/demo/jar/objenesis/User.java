package top.byoung.demo.jar.objenesis;

import java.io.Serializable;

/**
 * @description: user
 * @author: Yang Weixin
 * @create: 2019/12/10
 */
public class User implements Serializable, Cloneable {
    private String name;
    private int age;
    private float weight;

    public User(String name, int age, float weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "-----> User{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", weight=" + weight +
            '}';
    }

    public User copy() throws Exception{
        return (User)this.clone();
    }
}
