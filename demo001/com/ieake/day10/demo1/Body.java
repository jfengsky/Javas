package com.ieake.day10.demo1;

public class Body {

    public static void main(String[] args) {
        Body body = new Body();
        body.methodBody();
    }

    class Heart {

        public void beat(){
            System.out.println("heart beat");
        }
    }

    public void methodBody(){
        System.out.println("body");
        new Heart().beat();
    }
}
