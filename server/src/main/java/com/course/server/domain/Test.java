package com.course.server.domain;

/**
 * @ClassName : Test
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-20 20:42
 */
public class Test {

    private Long id;
    private String name;

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
