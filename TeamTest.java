package com.example.demo3;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * Partner 1: Efren Garcia
 * Partner 2: Hera Naeem
 * T08
 */

class TeamTest {

    /**
     * this function is used to print the team name.
     */
    @Test
    void getTeamName() {
        String t = "Real Madrid";
        Team Tname = new Team(t);
        System.out.println(Tname.getName());
    }

    /**
     * this function is used to compare two objects that are the same, and therefore, it should return true.
     */
    @Test
    void testEqualsforSameObjects() {
        try{
            Team obj1 = new Team("Bayern Munich");
            Team obj2 = obj1;
            Assert.assertEquals(obj1, obj2);
            System.out.println("True");
        }
        catch (AssertionError assertionError){
            System.out.println("False");
        }
    }

    /**
     * this function is used to compare two objects that are different, therefore, producing an inequality.
     * So, it will be false.
     */
    @Test
    void testEqualsforDifferentObjects(){
        try{
            Team obj1 = new Team("Bayern Munich");
            Team obj2 = new Team("Liverpool");
            Assert.assertEquals(obj1, obj2);
            System.out.println("True");
        }
        catch (AssertionError assertionError){
            System.out.println("False");
        }
    }

    /**
     * this function is used to compare two objects but one of them is null, therefore, producing an inequality.
     * So it will be false.
     */
    @Test
    void testEqualsforInequalityWithNull(){
        try{
            Team obj1 = new Team("Bayern Munich");
            Team obj2 = new Team(null);
            Assert.assertEquals(obj1, obj2);
            System.out.println("True");
        }
        catch (AssertionError assertionError){
            System.out.println("False");
        }


    }
}
