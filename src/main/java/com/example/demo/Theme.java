package com.example.demo;


import java.util.ArrayList;
import java.util.List;

public class Theme {

    private String name;
    private List<String> comments = new ArrayList<>();

    public Theme(String name,List<String> comments){
        this.name = name;
        this.comments = comments;
    }
    public Theme(String name){
        this.name = name;
        this.comments = new ArrayList<>();
    }

    public String getName(){return name;}
    public List<String> getComments(){return comments;}
    public String getComment(Integer i){return comments.get(i);}


    public void setName(String name){this.name = name;}
    public void setComments(List<String> comments){this.comments = comments;}
    public void setCommentN(String comment, Integer i){this.comments.add(i,comment) ;}
    public void setComment(String comment){ this.comments.add(comment);}

    public void deleteComment(Integer i){this.comments.remove(i);}
    public void updComment(Integer i,String comment){
        this.comments.remove(i);
        this.comments.add(i,comment) ;
    }
    public int commentSize(){
        return this.comments.size();
    }

//    @Override
//    public String toString(){return "(" + getName() + "," + getAge() + ")";}


}
