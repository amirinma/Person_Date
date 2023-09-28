/** TestChp13Pr8.java - Driver for Chapter 13 assignment.
 */
public class TestChp13Pr8 {
   public static void main(String[] args) {
      // ITP 220 - alter this check when you have made Date an inner class of Person
      //  Depending on whether Date is a public or private inner class, the syntax
      //  for checking the inner Dates will be different
      //  You may create new methods within Person if you find that makes more sense
      Date d1 = new Date(2, 2, 1980);
      Date d2 = new Date(3, 2, 1980);
      System.err.println("d1 precedes d2? " + d1.precedes(d2)); // should be TRUE

      Date d3 = new Date(1, 2, 1980);
      System.err.println("d1 precedes d3? " + d1.precedes(d2)); // should be FALSE

      Date d4 = d1.clone();
      System.err.println("d1 precedes d4? " + d1.precedes(d4)); // True or false depending on implementation
      System.err.println("d1 equals d4? " + (d1.compareTo(d4) == 0)); // should be TRUE
      
      Person p = new Person("Peter", 3, 31, 2001);
      System.err.println("Person is: " + p);

      Person p1 = new Person("Mark", "March", 31, 2001);
      System.err.println("p1 is: " + p1);

      Person p2 = new Person("Person p2", 7, 22, 1990, 7, 21, 2001);
      System.err.println("p2 is: " + p2);

      Person p3 = new Person("Person p3", "July", 22, 1990, "July", 21, 2001);
      System.err.println("p3 is: " + p3);

      // test changing the birth year (should not change it)
      p2.setBirthYear(2002);
      System.err.println("p2 is now: " + p2);

      // test changing the birth year (should change it)
      p2.setBirthYear(1983);
      System.err.println("p2 is now: " + p2);

      // test changing the death year (should change it)
      p2.setDeathYear(2020);
      System.err.println("p2 is now: " + p2);

      // test changing the death year
      p2.setDeathYear(1980);
      System.err.println("p2 is now: " + p2);

      // create a copy of Person p3
      Person copy = (Person)p3.clone();
      System.err.println("Clone of p3: " + copy);
   }
}
