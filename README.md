# School Management System

![uml image for student management system](uml/uml_for_school_management_domain.png)

___

## Q10 <br/>

___

### Flaws in the design of the UML domain <br/>
1. The uml diagram does not clearly indicate the primary-keys of the entities. Only once working through the Uml domain it does the primary-keys become apparent. 
2. All the attributes displayed in the UML diagram are shown as public values. It's important for the values to be private so that it protects them from being accessed directly from other entities. 
3. The Uml diagram is not complete because some cardinalities between relationships are missing. The relationship between 'Name' and 'Student' should be a one-to-one relationship. 'Address' and 'EmployeeAddress'/'StudentAddress' should also be a one-to-one relationship.
4. The entities are tightly coupled, because classes and objects are dependent on one another.
___

### Flaws in the implementation of the domain design <br/>
1. We Believe that it would make more sense for 'Address' to be an entity instead of a complex value object. Making 'Address' an entity and giving it a unique identifier that can be called in the 'StudentAddress' and 'EmployeeAddress' would make for a cleaner database implementation. 
2. The entities are tightly coupled, meaning that they are dependent on each other which reduces flexibility and its re-usability. The classes should be implemented loosely.
3. While working with the "Country", "City" and "Address" classes, we were confused because "City" had 2 parent entities and this is something were we were exposed too previously.