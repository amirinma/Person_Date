/** Person.java
 * This class defines a person with attributes for name and birth/death
 *  dates.
 * As with a real Person, there must always be a date of birth, and if 
 *  the Person has a date of death, then the date of death is equal to 
 *  or later than the date of birth.
 */
public class Person {
    private String name;
    private Date born;
    private Date died; // null indicates still alive.

    /** Argument constructor to create a Person (with no death date).
     * @param initialName
     * @param birthMonth - int
     * @param birthDay - int
     * @param birthYear - int
     */
    public Person(String initialName, int birthMonth, int birthDay, 
          int birthYear) {
       // ITP 220 - complete this constructor
       // implement using the this() constructor
        this.name = initialName;
        this.born = new Date(birthMonth, birthDay, birthYear);
        this.died = null;
    }

    /** Argument constructor to create a Person (with no death date).
     * @param initialName
     * @param birthMonth - String
     * @param birthDay - int
     * @param birthYear - int
     */
    public Person(String initialName, String birthMonth, int birthDay, 
          int birthYear) {
       // ITP 220 - complete this constructor
       // implement using the this() constructor
        this.name = initialName;
        this.born = new Date(birthMonth, birthDay, birthYear);
    }

    /** Argument constructor to create a Person (with a death date).
     * @param initialName
     * @param birthMonth - String
     * @param birthDay - int
     * @param birthYear - int
     * @param deathMonth - String
     * @param deathDay - int
     * @param deathYear - int
     */
    public Person(String initialName, String birthMonth, int birthDay, 
          int birthYear, String deathMonth, int deathDay, int deathYear) {
       // ITP 220 - complete this constructor
        this.name = initialName;
        this.born = new Date(birthMonth, birthDay, birthYear);
        this.died= new Date(deathMonth, deathDay, deathYear);
    }

    /** Argument constructor to create a Person (with a death date).
     * @param initialName
     * @param birthMonth - int
     * @param birthDay - int
     * @param birthYear - int
     * @param deathMonth - int
     * @param deathDay - int
     * @param deathYear - int
     */
    public Person(String initialName, int birthMonth, int birthDay,
          int birthYear, int deathMonth, int deathDay, int deathYear) {
       // ITP 220 - complete this constructor
        this.name = initialName;
        this.born = new Date(birthMonth, birthDay, birthYear);
        this.died = new Date(deathMonth, deathDay, deathYear);
    }

    /** Argument constructor to create a Person.
     * @param initialName
     * @param birthDate
     * @param deathDate
     */
    public Person(String initialName, Date birthDate, Date deathDate) {
       set(initialName, birthDate, deathDate);
    }

    /** Copy constructor.
     * @param original - object (Person) whose attributes will be used
     *  to create this new Person.
     */
    public Person(Person original) {
       if (original != null) {
          set(original.getName(), original.getBirthDate(),
             original.getDeathDate());
       }
    }

    /** Method to set all attributes of this Person from supplied
     * arguments.
     * @param initialName
     * @param birthDate
     * @param deathDate
     */
    public void set(String newName, Date birthDate, Date deathDate) {
       if (consistent(birthDate, deathDate)) {
          name = newName;
          born = new Date(birthDate);
          if(deathDate == null) {
             died = null;
          } else {
             died = new Date(deathDate);
          }
       }
    }

    /** Method to display this Person't attributes in a user-friendly
     *  printout.
     */
    public String toString( ) {
       return name + ", " + born + "-" + died;
    }

    /** Method to determine whether this Person has the same attributes
     *  as the passed Person.
     * @param otherPerson - Person being compared to this
     */
    public boolean equals(Person otherPerson) {
       if (otherPerson == null) {
          return false;
       } else {
          // check NAME
          if((name == null && otherPerson.getName() != null) ||
             (name != null) && !name.equals(otherPerson.getName()) ) {
             return false;
          }
          
          // check Dates
          return 
             datesMatch(getBirthDate(), otherPerson.getBirthDate()) &&
             datesMatch(getDeathDate(), otherPerson.getDeathDate());
       }
    }

    /** Method to match date1 and date2, which must either be the same
     *  dates or both null.
     */
    private boolean datesMatch(Date date1, Date date2) {
       if (date1 == null) {
          return (date2 == null); // true if date2 is also null
       } else if (date2 == null) { // start tests where date1 is not null
          return false;
       } else {
          return(date1.equals(date2));
       }
    }

    /** Method that verifies whether the supplied birth/death dates are
     *   consistent with each other.  Rules are:
     *    1. Birth Date must not be null
     *    2. If death date is not null, birthDate must come before or 
     *       be equal to the deathDate.
     */
    private boolean consistent(Date birthDate, Date deathDate) {
       if (birthDate == null) {
          return false;
       } else if (!birthDate.dateOK(birthDate.getMonth(),
            birthDate.getDay(), birthDate.getYear())) {
       	  return false;
       } else if (deathDate == null) {
          return true; // nothing else to check if it makes it here
       } else if (!deathDate.dateOK(deathDate.getMonth(),
            deathDate.getDay(), deathDate.getYear())) {
          return false;
       }
       return birthDate.compareTo(deathDate) <= 0;
    }

    /** Method to set birth date.  Before setting it to newDate,
     *  checks that it is valid with the existing death date.
     */
    public void setBirthDate(Date newDate) {
       if (consistent(newDate, died)) {
          if (newDate == null) {
          	born = null;
          } else {
          	born = new Date(newDate);
          }
       }
    }

    /** Method to set death date.  Before setting it to newDate,
     *  checks that it is valid with the existing birth date.
     */
    public void setDeathDate(Date newDate) {
       if (consistent(born, newDate)) {
          if (newDate == null) {
          	died = null;
          } else {
          	died = new Date(newDate);
          }
       }
    }

    /** Method to reset only the birth year.
     *  This method does nothing if date of birth is NULL.
     */
    public void setBirthYear(int newYear) {
       if (born == null) {
          return;
       }
       
       // set birth year by creating a new Date and updating its
       //  year, then validate this as a possible birth date before
       //  setting = born
       Date updatedDate = new Date(born);
       updatedDate.setYear(newYear);
       if (consistent(updatedDate, died)) {
          born = updatedDate;
       }
    }

    /** Method to reset only the death year.
     *  This method does nothing if date of death is NULL.
     */
    public void setDeathYear(int newYear) {
       if (died == null) {
          return;
       }

       // set death year by creating a new Date and updating its
       //  year, then validate this as a possible death date before
       //  setting = died       
       Date updatedDate = new Date(died);
       updatedDate.setYear(newYear);
       if (consistent(born, updatedDate)) {
          died = updatedDate;
       }
    }

    public String getName( ) {
       return name;
    }
    public void setName(String newName) {
       name = newName;
    }

    public Date getBirthDate( ) {
       if(born != null) {
          return new Date(born);
       } else {
          return null;
       }
    }

    public Date getDeathDate( ) {
       if(died != null) {
          return new Date(died);
       } else {
          return null;
       }
    }
}