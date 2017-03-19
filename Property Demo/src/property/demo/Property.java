/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package property.demo;

/**
 *
 * @author kmhasan
 */
public class Property {
    private int propertyId;
    private String ownersName;
    
    public Property(int id, String name) {
        propertyId = id;
        ownersName = name;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public String getOwnersName() {
        return ownersName;
    }
    
    public String toString() {
        //return propertyId + " - " + ownersName;
        return ownersName;
    }
}
